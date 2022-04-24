package coinanalysis.records;

public class Candle {
    double startPrice;
    double highPrice;
    double lowPrice;
    double endPrice;
    double volume;
    String code;


    @Override
    public String toString() {
        return "Candle{" +
                "startPrice=" + startPrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", endPrice=" + endPrice +
                ", volume=" + volume +
                ", code='" + code + '\'' +
                '}';
    }

    public Candle(double startPrice, double highPrice, double lowPrice, double endPrice, double volume, String code) {
        this.startPrice = startPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.endPrice = endPrice;
        this.volume = volume;
        this.code = code;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(double endPrice) {
        this.endPrice = endPrice;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
