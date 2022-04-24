package coinanalysis;

import coinanalysis.records.Candle;
import coinanalysis.records.Ticker;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

public class CandleChartCalculator extends ProcessWindowFunction<Ticker, Candle, String, TimeWindow> {


    @Override
    public void process(
            String key,
            Context context,
            Iterable<Ticker> tickers,
            Collector<Candle> results) {

        double startPrice = 0;
        double highPrice = 0;
        double lowPrice = Double.MAX_VALUE;
        double endPrice = 0;
        long volume = 0;

        double curPrice = 0;


        for (Ticker ticker : tickers) {
            curPrice = ticker.getTradePrice();
            if(volume==0){
                startPrice = curPrice;
            }
            highPrice = Math.max(curPrice,highPrice);
            lowPrice = Math.min(curPrice,lowPrice);
            volume+=ticker.getTradeVolume();
        }
        endPrice = curPrice;


        results.collect(new Candle(startPrice,highPrice,lowPrice,endPrice,volume,key));

    }
}
