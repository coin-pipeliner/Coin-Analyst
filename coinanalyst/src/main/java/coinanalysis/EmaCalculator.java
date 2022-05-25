package coinanalysis;

import coinanalysis.records.Candle;
import org.apache.flink.shaded.curator4.com.google.common.collect.Iterators;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

public class EmaCalculator extends ProcessWindowFunction<Candle, Double, String, TimeWindow> {

    @Override
    public void process(String s,
                        Context context,
                        Iterable<Candle> candles,
                        Collector<Double> results) throws Exception {

        double k = 2/((double) Iterators.size(candles.iterator()) +1);

        boolean first = true;
        double firstPrice = 0;
        double curPrice = 0;
        for(Candle candle : candles){
            if(first){
                curPrice = candle.getEndPrice();
                first = false;
            }
            else{
                curPrice = (candle.getEndPrice() - curPrice)*k + curPrice;
            }
        }

        results.collect(curPrice);

    }
}
