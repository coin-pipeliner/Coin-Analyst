package coinanalysis.records;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

public class MovingAverage {
    private double average;
    private long lastTickerTimestamp;

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public long getLastTickerTimestamp() {
        return lastTickerTimestamp;
    }

    public void setLastTickerTimestamp(long lastTickerTimestamp) {
        this.lastTickerTimestamp = lastTickerTimestamp;
    }

    public MovingAverage(double average, long lastTickerTimestamp) {
        this.average = average;
        this.lastTickerTimestamp = lastTickerTimestamp;
    }
}
