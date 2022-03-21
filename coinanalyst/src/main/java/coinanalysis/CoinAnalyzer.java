package coinanalysis;

import coinanalysis.records.Ticker;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

public class CoinAnalyzer extends ProcessWindowFunction<Ticker, Float, String, TimeWindow> {

    @Override
    public void process(
            String s,
            ProcessWindowFunction<Ticker, Float, String, TimeWindow>.Context context,
            Iterable<Ticker> iterable,
            Collector<Float> collector) throws Exception {

    }
}
