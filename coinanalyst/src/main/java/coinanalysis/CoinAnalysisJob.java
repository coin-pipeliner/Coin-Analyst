package coinanalysis;

import coinanalysis.records.Post;
import coinanalysis.records.PostDeserializationSchema;
import coinanalysis.records.Ticker;
import coinanalysis.records.TickerDeserializationSchema;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.time.Duration;
import java.util.Properties;

public class CoinAnalysisJob {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        String inputTopic = "prod.dcwitter.additional-post.baseball_new10.aggregation";
        String brokers = "192.168.0.12:9094";
        String groupId = "coin-analyst";

        Properties kafkaProps = new Properties();
        kafkaProps.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
        kafkaProps.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);

        KafkaSource<Post> source = KafkaSource.<Post>builder()
                .setTopics(inputTopic)
                .setGroupId(groupId)
                .setValueOnlyDeserializer(new PostDeserializationSchema())
                .setProperties(kafkaProps)
                .build();

        KafkaSource<String> strSource = KafkaSource.<String>builder()
                .setTopics(inputTopic)
                .setGroupId(groupId)
                .setValueOnlyDeserializer(new SimpleStringSchema())
                .setProperties(kafkaProps)
                .build();

        DataStream<Post> tickers = env.fromSource(source, WatermarkStrategy.noWatermarks()
                , "Ticker Source");

        DataStream<String> strs = env.fromSource(strSource, WatermarkStrategy.noWatermarks()
                , "strs Source");


        // Just print source data
        tickers.print();
        strs.print();

        env.execute("Coin Data Analysis");

    }
}
