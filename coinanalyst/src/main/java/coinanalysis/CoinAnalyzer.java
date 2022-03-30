package coinanalysis;

import coinanalysis.records.Ticker;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

public class CoinAnalyzer extends ProcessWindowFunction<Ticker, Double, String, TimeWindow> {

    @Override
    public void process(
            String key,
            Context context,
            Iterable<Ticker> tickers,
            Collector<Double> results) {

        double sum = 0;
        int tickerCount = 0;
        for (Ticker ticker : tickers) {
            sum += ticker.getTradePrice();
            tickerCount++;
        }

        double avg = sum / tickerCount;
        results.collect(avg);

    }
}
