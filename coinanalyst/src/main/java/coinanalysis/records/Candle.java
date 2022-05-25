package coinanalysis.records;

import java.util.Date;

public class Candle {

    private String code;
    private double startPrice;
    private double highPrice;
    private double lowPrice;
    private double endPrice;

    private Date lastTickerDateTime;

    public Candle(String code, double startPrice, double highPrice, double lowPrice, double endPrice, long lastTickerDateTime) {
        this.code = code;
        this.startPrice = startPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.endPrice = endPrice;
        this.lastTickerDateTime = new Date(lastTickerDateTime);
    }

    public Candle() {
    }

    public String getCode() {
        return code;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public double getEndPrice() {
        return endPrice;
    }

    public Date getLastTickerDateTime() {
        return lastTickerDateTime;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public void setEndPrice(double endPrice) {
        this.endPrice = endPrice;
    }

    public void setLastTickerDateTime(Date lastTickerDateTime) {
        this.lastTickerDateTime = lastTickerDateTime;
    }
}
