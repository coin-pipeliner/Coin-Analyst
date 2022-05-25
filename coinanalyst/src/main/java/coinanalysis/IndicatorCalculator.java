package coinanalysis;

import coinanalysis.records.Candle;
import coinanalysis.records.Indicator;
import org.apache.flink.shaded.curator4.com.google.common.collect.Iterators;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

public class IndicatorCalculator extends ProcessWindowFunction<Candle, Indicator, String, TimeWindow> {

    @Override
    public void process(String key,
                        Context context,
                        Iterable<Candle> candles,
                        Collector<Indicator> results) throws Exception {

        double k = 2 / ((double) Iterators.size(candles.iterator()) + 1);

        boolean first = true;
        double firstPrice = 0;
        double curEma = 0;
        double sum = 0;
        int tickerCount = 0;
        Candle curCandle = new Candle();

        for (Candle candle : candles) {
            curCandle = candle;
            sum += candle.getEndPrice();
            tickerCount++;
            if (first) {
                curEma = candle.getEndPrice();
                firstPrice = candle.getEndPrice();
                first = false;
            } else {
                curEma = (candle.getEndPrice() - curEma) * k + curEma;
            }

        }
        double momentum = curCandle.getEndPrice() / firstPrice * 100;
        double ma = sum / tickerCount;

        results.collect(new Indicator(key,ma , curEma,momentum,curCandle.getLastTickerDateTime()));

    }
}
