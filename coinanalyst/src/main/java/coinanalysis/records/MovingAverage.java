package coinanalysis.records;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MovingAverage {

    private String code;
    private double average;
    private Date lastTickerDateTime;

    public Date getLastTickerDateTime() {
        return lastTickerDateTime;
    }

    public void setLastTickerDateTime(Date lastTickerDateTime) {
        this.lastTickerDateTime = lastTickerDateTime;
    }

    private long lastTickerTimestamp;
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


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

    public MovingAverage(String code, double average, long lastTickerTimestamp) {
        this.code = code;
        this.average = average;
        this.lastTickerDateTime = new Date(lastTickerTimestamp);
        this.lastTickerTimestamp = lastTickerTimestamp;
    }

}
