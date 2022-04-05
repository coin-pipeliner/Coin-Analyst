package coinanalysis.util;

import coinanalysis.records.Ticker;
import coinanalysis.records.TickerDeserializationSchema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestMovingAverageCalculator {

    @Test
    void tickerDeserializationTest() throws IOException {
        Ticker expectedTicker = new Ticker(
                /*
                * TODO
                *  Insert expected ticker data
                * */
        );


        TickerDeserializationSchema tickerDeserializationSchema = new TickerDeserializationSchema();

        byte[] tickerData = TestTickerData.TICKERS[0].getBytes();
        Ticker ticker = tickerDeserializationSchema.deserialize(tickerData);


        Assertions.assertEquals(expectedTicker, ticker);

    }
}
