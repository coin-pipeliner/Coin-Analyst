package coinanalysis.records;

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("opening_price")
    private double openingPrice;
    @JsonProperty("high_price")
    private double highPrice;
    @JsonProperty("low_price")
    private double lowPrice;
    @JsonProperty("trade_price")
    private double tradePrice;
    @JsonProperty("prev_closing_price")
    private double prevClosingPrice;
    private String change;
    @JsonProperty("change_price")
    private double changePrice;
    @JsonProperty("signed_change_price")
    private double signedChangePrice;
    @JsonProperty("change_rate")
    private double changeRate;
    @JsonProperty("signed_change_rate")
    private double signedChangeRate;
    @JsonProperty("trade_volume")
    private double tradeVolume;
    @JsonProperty("acc_trade_volume")
    private double accTradeVolume;
    @JsonProperty("acc_trade_volume_24h")
    private double accTradeVolume24H;
    @JsonProperty("acc_trade_price")
    private double accTradePrice;
    @JsonProperty("acc_trade_price_24h")
    private double accTradePrice24H;
    @JsonProperty("trade_date")
    private Date tradeDate;
    @JsonProperty("trade_time")
    private Date tradeTime;
    @JsonProperty("trade_timestamp")
    private long tradeTimestamp;
    @JsonProperty("ask_bid")
    private String askBid;
    @JsonProperty("acc_ask_volume")
    private double accAskVolume;
    @JsonProperty("acc_bid_volume")
    private double accBidVolume;
    @JsonProperty("highest_52_week_price")
    private double highest52WeekPrice;
    @JsonProperty("highest_52_week_date")
    private Date highest52WeekDate;
    @JsonProperty("lowest_52_week_price")
    private double lowest52WeekPrice;
    @JsonProperty("lowest_52_week_date")
    private Date lowest52WeekDate;
    @JsonProperty("market_state")
    private String marketState;
    @JsonProperty("is_trading_suspended")
    private boolean isTradingSuspended;
    @JsonProperty("delisting_date")
    private Date delistingDate;
    @JsonProperty("market_warning")
    private String marketWarning;
    private long timestamp;
    @JsonProperty("stream_type")
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
        this.signedChangePrice = signedChange_price;
        this.changeRate = changeRate;
        this.signedChangeRate = signedChange_rate;
        this.tradeVolume = tradeVolume;
        this.accTradeVolume = accTradeVolume;
        this.accTradeVolume24H = accTradeVolume_24h;
        this.accTradePrice = accTradePrice;
        this.accTradePrice24H = accTradePrice_24h;
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

    public double getSignedChangePrice() {
        return signedChangePrice;
    }

    public double getChangeRate() {
        return changeRate;
    }

    public double getSignedChangeRate() {
        return signedChangeRate;
    }

    public double getTradeVolume() {
        return tradeVolume;
    }

    public double getAccTradeVolume() {
        return accTradeVolume;
    }

    public double getAccTradeVolume24H() {
        return accTradeVolume24H;
    }

    public double getAccTradePrice() {
        return accTradePrice;
    }

    public double getAccTradePrice24H() {
        return accTradePrice24H;
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

    public void setSignedChangePrice(double signedChangePrice) {
        this.signedChangePrice = signedChangePrice;
    }

    public void setChangeRate(double changeRate) {
        this.changeRate = changeRate;
    }

    public void setSignedChangeRate(double signedChangeRate) {
        this.signedChangeRate = signedChangeRate;
    }

    public void setTradeVolume(double tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public void setAccTradeVolume(double accTradeVolume) {
        this.accTradeVolume = accTradeVolume;
    }

    public void setAccTradeVolume24H(double accTradeVolume24H) {
        this.accTradeVolume24H = accTradeVolume24H;
    }

    public void setAccTradePrice(double accTradePrice) {
        this.accTradePrice = accTradePrice;
    }

    public void setAccTradePrice24H(double accTradePrice24H) {
        this.accTradePrice24H = accTradePrice24H;
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
        return Double.compare(ticker.getOpeningPrice(), getOpeningPrice()) == 0 && Double.compare(ticker.getHighPrice(), getHighPrice()) == 0 && Double.compare(ticker.getLowPrice(), getLowPrice()) == 0 && Double.compare(ticker.getTradePrice(), getTradePrice()) == 0 && Double.compare(ticker.getPrevClosingPrice(), getPrevClosingPrice()) == 0 && Double.compare(ticker.getChangePrice(), getChangePrice()) == 0 && Double.compare(ticker.getSignedChangePrice(), getSignedChangePrice()) == 0 && Double.compare(ticker.getChangeRate(), getChangeRate()) == 0 && Double.compare(ticker.getSignedChangeRate(), getSignedChangeRate()) == 0 && Double.compare(ticker.getTradeVolume(), getTradeVolume()) == 0 && Double.compare(ticker.getAccTradeVolume(), getAccTradeVolume()) == 0 && Double.compare(ticker.getAccTradeVolume24H(), getAccTradeVolume24H()) == 0 && Double.compare(ticker.getAccTradePrice(), getAccTradePrice()) == 0 && Double.compare(ticker.getAccTradePrice24H(), getAccTradePrice24H()) == 0 && getTradeTimestamp() == ticker.getTradeTimestamp() && Double.compare(ticker.getAccAskVolume(), getAccAskVolume()) == 0 && Double.compare(ticker.getAccBidVolume(), getAccBidVolume()) == 0 && Double.compare(ticker.getHighest52WeekPrice(), getHighest52WeekPrice()) == 0 && Double.compare(ticker.getLowest52WeekPrice(), getLowest52WeekPrice()) == 0 && isTradingSuspended() == ticker.isTradingSuspended() && getTimestamp() == ticker.getTimestamp() && Objects.equals(getType(), ticker.getType()) && Objects.equals(getCode(), ticker.getCode()) && Objects.equals(getChange(), ticker.getChange()) && Objects.equals(getTradeDate(), ticker.getTradeDate()) && Objects.equals(getTradeTime(), ticker.getTradeTime()) && Objects.equals(getAskBid(), ticker.getAskBid()) && Objects.equals(getHighest52WeekDate(), ticker.getHighest52WeekDate()) && Objects.equals(getLowest52WeekDate(), ticker.getLowest52WeekDate()) && Objects.equals(getMarketState(), ticker.getMarketState()) && Objects.equals(getDelistingDate(), ticker.getDelistingDate()) && Objects.equals(getMarketWarning(), ticker.getMarketWarning()) && Objects.equals(getStreamType(), ticker.getStreamType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getCode(), getOpeningPrice(), getHighPrice(), getLowPrice(), getTradePrice(), getPrevClosingPrice(), getChange(), getChangePrice(), getSignedChangePrice(), getChangeRate(), getSignedChangeRate(), getTradeVolume(), getAccTradeVolume(), getAccTradeVolume24H(), getAccTradePrice(), getAccTradePrice24H(), getTradeDate(), getTradeTime(), getTradeTimestamp(), getAskBid(), getAccAskVolume(), getAccBidVolume(), getHighest52WeekPrice(), getHighest52WeekDate(), getLowest52WeekPrice(), getLowest52WeekDate(), getMarketState(), isTradingSuspended(), getDelistingDate(), getMarketWarning(), getTimestamp(), getStreamType());
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
                ", signedChange_price=" + signedChangePrice +
                ", changeRate=" + changeRate +
                ", signedChange_rate=" + signedChangeRate +
                ", tradeVolume=" + tradeVolume +
                ", accTradeVolume=" + accTradeVolume +
                ", accTradeVolume_24h=" + accTradeVolume24H +
                ", accTradePrice=" + accTradePrice +
                ", accTradePrice_24h=" + accTradePrice24H +
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
