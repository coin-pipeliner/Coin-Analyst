package coinanalysis;

import coinanalysis.records.MovingAverage;
import coinanalysis.records.Ticker;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

import java.util.Calendar;
import java.util.Date;

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

        String code = lastTicker.getCode();
        double avg = sum / tickerCount;
        long lastTickerTimestamp = lastTicker.getTimestamp();

        MovingAverage movingAverage = new MovingAverage(code, avg, lastTickerTimestamp);
        results.collect(movingAverage);

    }
}
