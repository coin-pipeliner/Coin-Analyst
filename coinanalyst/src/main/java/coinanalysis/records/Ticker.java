package coinanalysis.records;

import java.util.Date;
import java.util.Objects;

/**
 * Upbit기준 ticker 데이터입니다.
 * <p>
 * 아래 문서를 참고하시길 바랍니다.
 * https://docs.upbit.com/docs/upbit-quotation-websocket#%ED%98%84%EC%9E%AC%EA%B0%80ticker-%EC%9D%91%EB%8B%B5
 */
public class Ticker {


    private String type;
    private String code;
    private double openingPrice;
    private double highPrice;
    private double lowPrice;
    private double tradePrice;
    private double prevClosingPrice;
    private String change;
    private double changePrice;
    private double signedChange_price;
    private double changeRate;
    private double signedChange_rate;
    private double tradeVolume;
    private double accTradeVolume;
    private double accTradeVolume_24h;
    private double accTradePrice;
    private double accTradePrice_24h;
    private Date tradeDate;
    private Date tradeTime;
    private long tradeTimestamp;
    private String askBid;
    private double accAskVolume;
    private double accBidVolume;
    private double highest52WeekPrice;
    private Date highest52WeekDate;
    private double lowest52WeekPrice;
    private Date lowest52WeekDate;
    private String marketState;
    private boolean isTradingSuspended;
    private Date delistingDate;
    private String marketWarning;
    private long timestamp;
    private String streamType;


    public Ticker() {
    }

    public Ticker(String type, String code, double openingPrice, double highPrice, double lowPrice, double tradePrice, double prevClosingPrice, String change, double changePrice, double signedChange_price, double changeRate, double signedChange_rate, double tradeVolume, double accTradeVolume, double accTradeVolume_24h, double accTradePrice, double accTradePrice_24h, Date tradeDate, Date tradeTime, long tradeTimestamp, String askBid, double accAskVolume, double accBidVolume, double highest52WeekPrice, Date highest52WeekDate, double lowest52WeekPrice, Date lowest52WeekDate, String marketState, boolean isTradingSuspended, Date delistingDate, String marketWarning, long timestamp, String streamType) {
        this.type = type;
        this.code = code;
        this.openingPrice = openingPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.tradePrice = tradePrice;
        this.prevClosingPrice = prevClosingPrice;
        this.change = change;
        this.changePrice = changePrice;
        this.signedChange_price = signedChange_price;
        this.changeRate = changeRate;
        this.signedChange_rate = signedChange_rate;
        this.tradeVolume = tradeVolume;
        this.accTradeVolume = accTradeVolume;
        this.accTradeVolume_24h = accTradeVolume_24h;
        this.accTradePrice = accTradePrice;
        this.accTradePrice_24h = accTradePrice_24h;
        this.tradeDate = tradeDate;
        this.tradeTime = tradeTime;
        this.tradeTimestamp = tradeTimestamp;
        this.askBid = askBid;
        this.accAskVolume = accAskVolume;
        this.accBidVolume = accBidVolume;
        this.highest52WeekPrice = highest52WeekPrice;
        this.highest52WeekDate = highest52WeekDate;
        this.lowest52WeekPrice = lowest52WeekPrice;
        this.lowest52WeekDate = lowest52WeekDate;
        this.marketState = marketState;
        this.isTradingSuspended = isTradingSuspended;
        this.delistingDate = delistingDate;
        this.marketWarning = marketWarning;
        this.timestamp = timestamp;
        this.streamType = streamType;
    }


    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public double getOpeningPrice() {
        return openingPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public double getTradePrice() {
        return tradePrice;
    }

    public double getPrevClosingPrice() {
        return prevClosingPrice;
    }

    public String getChange() {
        return change;
    }

    public double getChangePrice() {
        return changePrice;
    }

    public double getSignedChange_price() {
        return signedChange_price;
    }

    public double getChangeRate() {
        return changeRate;
    }

    public double getSignedChange_rate() {
        return signedChange_rate;
    }

    public double getTradeVolume() {
        return tradeVolume;
    }

    public double getAccTradeVolume() {
        return accTradeVolume;
    }

    public double getAccTradeVolume_24h() {
        return accTradeVolume_24h;
    }

    public double getAccTradePrice() {
        return accTradePrice;
    }

    public double getAccTradePrice_24h() {
        return accTradePrice_24h;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public long getTradeTimestamp() {
        return tradeTimestamp;
    }

    public String getAskBid() {
        return askBid;
    }

    public double getAccAskVolume() {
        return accAskVolume;
    }

    public double getAccBidVolume() {
        return accBidVolume;
    }

    public double getHighest52WeekPrice() {
        return highest52WeekPrice;
    }

    public Date getHighest52WeekDate() {
        return highest52WeekDate;
    }

    public double getLowest52WeekPrice() {
        return lowest52WeekPrice;
    }

    public Date getLowest52WeekDate() {
        return lowest52WeekDate;
    }

    public String getMarketState() {
        return marketState;
    }

    public boolean isTradingSuspended() {
        return isTradingSuspended;
    }

    public Date getDelistingDate() {
        return delistingDate;
    }

    public String getMarketWarning() {
        return marketWarning;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getStreamType() {
        return streamType;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setOpeningPrice(double openingPrice) {
        this.openingPrice = openingPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public void setTradePrice(double tradePrice) {
        this.tradePrice = tradePrice;
    }

    public void setPrevClosingPrice(double prevClosingPrice) {
        this.prevClosingPrice = prevClosingPrice;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public void setChangePrice(double changePrice) {
        this.changePrice = changePrice;
    }

    public void setSignedChange_price(double signedChange_price) {
        this.signedChange_price = signedChange_price;
    }

    public void setChangeRate(double changeRate) {
        this.changeRate = changeRate;
    }

    public void setSignedChange_rate(double signedChange_rate) {
        this.signedChange_rate = signedChange_rate;
    }

    public void setTradeVolume(double tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public void setAccTradeVolume(double accTradeVolume) {
        this.accTradeVolume = accTradeVolume;
    }

    public void setAccTradeVolume_24h(double accTradeVolume_24h) {
        this.accTradeVolume_24h = accTradeVolume_24h;
    }

    public void setAccTradePrice(double accTradePrice) {
        this.accTradePrice = accTradePrice;
    }

    public void setAccTradePrice_24h(double accTradePrice_24h) {
        this.accTradePrice_24h = accTradePrice_24h;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public void setTradeTimestamp(long tradeTimestamp) {
        this.tradeTimestamp = tradeTimestamp;
    }

    public void setAskBid(String askBid) {
        this.askBid = askBid;
    }

    public void setAccAskVolume(double accAskVolume) {
        this.accAskVolume = accAskVolume;
    }

    public void setAccBidVolume(double accBidVolume) {
        this.accBidVolume = accBidVolume;
    }

    public void setHighest52WeekPrice(double highest52WeekPrice) {
        this.highest52WeekPrice = highest52WeekPrice;
    }

    public void setHighest52WeekDate(Date highest52WeekDate) {
        this.highest52WeekDate = highest52WeekDate;
    }

    public void setLowest52WeekPrice(double lowest52WeekPrice) {
        this.lowest52WeekPrice = lowest52WeekPrice;
    }

    public void setLowest52WeekDate(Date lowest52WeekDate) {
        this.lowest52WeekDate = lowest52WeekDate;
    }

    public void setMarketState(String marketState) {
        this.marketState = marketState;
    }

    public void setTradingSuspended(boolean tradingSuspended) {
        isTradingSuspended = tradingSuspended;
    }

    public void setDelistingDate(Date delistingDate) {
        this.delistingDate = delistingDate;
    }

    public void setMarketWarning(String marketWarning) {
        this.marketWarning = marketWarning;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setStreamType(String streamType) {
        this.streamType = streamType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticker)) return false;
        Ticker ticker = (Ticker) o;
        return Double.compare(ticker.getOpeningPrice(), getOpeningPrice()) == 0 && Double.compare(ticker.getHighPrice(), getHighPrice()) == 0 && Double.compare(ticker.getLowPrice(), getLowPrice()) == 0 && Double.compare(ticker.getTradePrice(), getTradePrice()) == 0 && Double.compare(ticker.getPrevClosingPrice(), getPrevClosingPrice()) == 0 && Double.compare(ticker.getChangePrice(), getChangePrice()) == 0 && Double.compare(ticker.getSignedChange_price(), getSignedChange_price()) == 0 && Double.compare(ticker.getChangeRate(), getChangeRate()) == 0 && Double.compare(ticker.getSignedChange_rate(), getSignedChange_rate()) == 0 && Double.compare(ticker.getTradeVolume(), getTradeVolume()) == 0 && Double.compare(ticker.getAccTradeVolume(), getAccTradeVolume()) == 0 && Double.compare(ticker.getAccTradeVolume_24h(), getAccTradeVolume_24h()) == 0 && Double.compare(ticker.getAccTradePrice(), getAccTradePrice()) == 0 && Double.compare(ticker.getAccTradePrice_24h(), getAccTradePrice_24h()) == 0 && getTradeTimestamp() == ticker.getTradeTimestamp() && Double.compare(ticker.getAccAskVolume(), getAccAskVolume()) == 0 && Double.compare(ticker.getAccBidVolume(), getAccBidVolume()) == 0 && Double.compare(ticker.getHighest52WeekPrice(), getHighest52WeekPrice()) == 0 && Double.compare(ticker.getLowest52WeekPrice(), getLowest52WeekPrice()) == 0 && isTradingSuspended() == ticker.isTradingSuspended() && getTimestamp() == ticker.getTimestamp() && Objects.equals(getType(), ticker.getType()) && Objects.equals(getCode(), ticker.getCode()) && Objects.equals(getChange(), ticker.getChange()) && Objects.equals(getTradeDate(), ticker.getTradeDate()) && Objects.equals(getTradeTime(), ticker.getTradeTime()) && Objects.equals(getAskBid(), ticker.getAskBid()) && Objects.equals(getHighest52WeekDate(), ticker.getHighest52WeekDate()) && Objects.equals(getLowest52WeekDate(), ticker.getLowest52WeekDate()) && Objects.equals(getMarketState(), ticker.getMarketState()) && Objects.equals(getDelistingDate(), ticker.getDelistingDate()) && Objects.equals(getMarketWarning(), ticker.getMarketWarning()) && Objects.equals(getStreamType(), ticker.getStreamType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getCode(), getOpeningPrice(), getHighPrice(), getLowPrice(), getTradePrice(), getPrevClosingPrice(), getChange(), getChangePrice(), getSignedChange_price(), getChangeRate(), getSignedChange_rate(), getTradeVolume(), getAccTradeVolume(), getAccTradeVolume_24h(), getAccTradePrice(), getAccTradePrice_24h(), getTradeDate(), getTradeTime(), getTradeTimestamp(), getAskBid(), getAccAskVolume(), getAccBidVolume(), getHighest52WeekPrice(), getHighest52WeekDate(), getLowest52WeekPrice(), getLowest52WeekDate(), getMarketState(), isTradingSuspended(), getDelistingDate(), getMarketWarning(), getTimestamp(), getStreamType());
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", openingPrice=" + openingPrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", tradePrice=" + tradePrice +
                ", prevClosingPrice=" + prevClosingPrice +
                ", change='" + change + '\'' +
                ", changePrice=" + changePrice +
                ", signedChange_price=" + signedChange_price +
                ", changeRate=" + changeRate +
                ", signedChange_rate=" + signedChange_rate +
                ", tradeVolume=" + tradeVolume +
                ", accTradeVolume=" + accTradeVolume +
                ", accTradeVolume_24h=" + accTradeVolume_24h +
                ", accTradePrice=" + accTradePrice +
                ", accTradePrice_24h=" + accTradePrice_24h +
                ", tradeDate=" + tradeDate +
                ", tradeTime=" + tradeTime +
                ", tradeTimestamp=" + tradeTimestamp +
                ", askBid='" + askBid + '\'' +
                ", accAskVolume=" + accAskVolume +
                ", accBidVolume=" + accBidVolume +
                ", highest52WeekPrice=" + highest52WeekPrice +
                ", highest52WeekDate=" + highest52WeekDate +
                ", lowest52WeekPrice=" + lowest52WeekPrice +
                ", lowest52WeekDate=" + lowest52WeekDate +
                ", marketState='" + marketState + '\'' +
                ", isTradingSuspended=" + isTradingSuspended +
                ", delistingDate=" + delistingDate +
                ", marketWarning='" + marketWarning + '\'' +
                ", timestamp=" + timestamp +
                ", streamType='" + streamType + '\'' +
                '}';
    }
}
