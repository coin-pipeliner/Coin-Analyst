package coinanalysis;

import coinanalysis.records.Candle;
import coinanalysis.records.Ticker;
import org.apache.flink.streaming.api.functions.windowing.ProcessAllWindowFunction;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

public class MomentumCalculator extends ProcessWindowFunction<Candle, Double, String, TimeWindow> {

    @Override
    public void process(String s,
                        Context context,
                        Iterable<Candle> candles,
                        Collector<Double> results) throws Exception {

        boolean first = true;
        double firstPrice = 0;
        double curPrice = 0;
        for(Candle candle : candles){
            curPrice = candle.getEndPrice();
            if(first){
                firstPrice = curPrice;
                first = false;
            }
        }

        double momentum = curPrice/firstPrice * 100;
        results.collect(momentum);

    }
}
