package coinanalysis;

import coinanalysis.records.MovingAverage;
import coinanalysis.records.Ticker;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

public class MovingAverageCalculator extends ProcessWindowFunction<Ticker, MovingAverage, String, TimeWindow> {

    @Override
    public void process(
            String key,
            Context context,
            Iterable<Ticker> tickers,
            Collector<MovingAverage> results) {

        double sum = 0;
        int tickerCount = 0;
        Ticker lastTicker = new Ticker();
        for (Ticker ticker : tickers) {
            sum += ticker.getTradePrice();
            tickerCount++;
            lastTicker = ticker;
        }

        double avg = sum / tickerCount;
        long lastTickerTimestamp = lastTicker.getTimestamp();
        MovingAverage movingAverage = new MovingAverage(avg, lastTickerTimestamp);
        results.collect(movingAverage);

    }
}
