package coinanalysis;

import coinanalysis.records.Candle;
import coinanalysis.records.Ticker;
import coinanalysis.records.TickerDeserializationSchema;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.SlidingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;

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
                .setValueOnlyDeserializer(new TickerDeserializationSchema())
                .setProperties(kafkaProps)
                .build();

        WatermarkStrategy<Ticker> watermarkStrategy = WatermarkStrategy
                .<Ticker>forBoundedOutOfOrderness(Duration.ofMillis(200))
                .withTimestampAssigner((ticker, l) -> ticker.getTimestamp());

        DataStream<Ticker> tickers = env.fromSource(source, watermarkStrategy, "Ticker Source");

        DataStream<Double> movingAveragePrices = tickers
                .keyBy(Ticker::getCode)
                .window(SlidingEventTimeWindows.of(Time.minutes(1), Time.seconds(1)))
                .process(new MovingAverageCalculator())
                .name("1 minutes average");

        DataStream<Double> min10MovingAveragePrices = tickers
                .keyBy(Ticker::getCode)
                .window(SlidingEventTimeWindows.of(Time.minutes(10), Time.seconds(1)))
                .process(new MovingAverageCalculator())
                .name("10 minutes average");


        DataStream<Double> hourMovingAveragePrices = tickers
                .keyBy(Ticker::getCode)
                .window(SlidingEventTimeWindows.of(Time.hours(1), Time.minutes(1)))
                .process(new MovingAverageCalculator())
                .name("1 hours average");

        DataStream<Candle> minuteCandlePrices = tickers
                .keyBy(Ticker::getCode)
                .window(SlidingEventTimeWindows.of(Time.minutes(1), Time.seconds(1)))
                .process(new CandleChartCalculator())
                .name("1 minutes candle");




        minuteCandlePrices.print("1 minutes candle");
        movingAveragePrices.print("1 minutes average");
        min10MovingAveragePrices.print("10 minutes average");
        hourMovingAveragePrices.print("1 hours average");
        env.execute("Coin Data Analysis");

    }
}
