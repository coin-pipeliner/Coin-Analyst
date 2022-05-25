package coinanalysis;

import coinanalysis.records.Ticker;
import coinanalysis.records.TickerDeserializationSchema;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.CoMapFunction;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction;
import org.apache.flink.streaming.api.windowing.assigners.SlidingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.streaming.connectors.elasticsearch.ElasticsearchSinkFunction;
import org.apache.flink.streaming.connectors.elasticsearch.RequestIndexer;
import org.apache.flink.streaming.connectors.elasticsearch7.ElasticsearchSink;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Requests;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;
import java.util.*;
import java.time.Duration;
import java.util.Properties;

public class CoinAnalysisJob {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        String inputTopic = "dev.coin-pipeliner.KRW-BTC";
        String brokers = "kafka1:19091,kafka2:19092,kafka3:19093";
        String groupId = "coin-analyst";

        Properties kafkaProps = new Properties();
        kafkaProps.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        kafkaProps.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);

        KafkaSource<Ticker> source = KafkaSource.<Ticker>builder()
                .setTopics(inputTopic)
                .setGroupId(groupId)
                .setStartingOffsets(OffsetsInitializer.latest())
                .setValueOnlyDeserializer(new TickerDeserializationSchema())
                .setProperties(kafkaProps)
                .build();

        WatermarkStrategy<Ticker> watermarkStrategy = WatermarkStrategy
                .<Ticker>forBoundedOutOfOrderness(Duration.ofMillis(200))
                .withTimestampAssigner((ticker, l) -> ticker.getTimestamp());

        DataStream<Ticker> tickers = env.fromSource(source, watermarkStrategy, "Ticker Source");


        DataStream<MovingAverage> hourMovingAveragePrices = tickers
                .keyBy(Ticker::getCode)
                .window(SlidingEventTimeWindows.of(Time.hours(1), Time.minutes(1)))
                .process(new MovingAverageCalculator())
                .name("1 hours average");

        List<HttpHost> httpHosts = new ArrayList<>();
        httpHosts.add(new HttpHost("elasticsearch", 9200, "http"));

        ElasticsearchSink.Builder<MovingAverage> esSinkBuilder = new ElasticsearchSink.Builder<>(
                httpHosts,
                new ElasticsearchSinkFunction<MovingAverage>() {
                    public IndexRequest createIndexRequest(MovingAverage element) {
        DataStream<Candle> minuteCandlePrices = tickers
                .keyBy(Ticker::getCode)
                .window(SlidingEventTimeWindows.of(Time.minutes(1), Time.seconds(1)))
                .process(new CandleChartCalculator())
                .name("1 minutes candle");


        DataStream<Double> hourMomentumPrices = minuteCandlePrices
                .keyBy(Candle::getCode)
                .window(SlidingEventTimeWindows.of(Time.hours(1), Time.minutes(1)))
                .process(new MomentumCalculator())
                .name("1 hours momentum");

        DataStream<Double> shortMinuteEma = minuteCandlePrices
                .keyBy(Candle::getCode)
                .window(SlidingEventTimeWindows.of(Time.minutes(12), Time.minutes(1)))
                .process(new EmaCalculator())
                .name("12 minutes EMA");

        DataStream<Double> longMinuteEma = minuteCandlePrices
                .keyBy(Candle::getCode)
                .window(SlidingEventTimeWindows.of(Time.minutes(26), Time.minutes(1)))
                .process(new EmaCalculator())
                .name("26 minutes EMA");

                        ObjectMapper mapper = new ObjectMapper();

                        try {
                            return Requests.indexRequest()
                                    .index("hour-moving-average")
                                    .source(XContentFactory.jsonBuilder().startObject()
                                            .field("code", element.getCode())
                                            .field("average", element.getAverage())
                                            .field("lastTickerDateTime", element.getLastTickerDateTime())
                                            .field("lastTickerTimestamp", element.getLastTickerTimestamp())
                                        .endObject()
                                    );
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }

                    @Override
                    public void process(MovingAverage element, RuntimeContext ctx, RequestIndexer indexer) {
                        indexer.add(createIndexRequest(element));
                    }
                }
        );

// configuration for the bulk requests; this instructs the sink to emit after every element, otherwise they would be buffered
//        esSinkBuilder.setBulkFlushMaxActions(1);

        esSinkBuilder.setRestClientFactory(
                restClientBuilder -> restClientBuilder.setHttpClientConfigCallback(httpClientBuilder -> {

                    // elasticsearch username and password
                    CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
                    credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "changeme"));

                    return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                })
        );

// finally, build and add the sink to the job's pipeline
        hourMovingAveragePrices.addSink(esSinkBuilder.build());
        DataStream<Double> minuteMACD = shortMinuteEma.join(longMinuteEma).where(aDouble -> true).equalTo(aDouble -> true).window(TumblingEventTimeWindows.of(Time.minutes(1)))
                .apply((first, second) -> first - second);


        minuteMACD.print("1 minutes MACD");
        hourMomentumPrices.print("1 hours momentum");
        minuteCandlePrices.print("1 minutes candle");
        movingAveragePrices.print("1 minutes average");
        min10MovingAveragePrices.print("10 minutes average");
        hourMovingAveragePrices.print("1 hours average");
        shortMinuteEma.print("12 minutes EMA");
        env.execute("Coin Data Analysis");

    }
}
