package coinanalysis.records;

import java.util.Date;

public class Indicator {

    private String code;
    private double ma;
    private double ema;
    private double momentum;
    private Date lastTickerDateTime;

    public Indicator(String code, double ma, double ema, double momentum, Date lastTickerDateTime) {
        this.code = code;
        this.ma = ma;
        this.ema = ema;
        this.momentum = momentum;
        this.lastTickerDateTime = lastTickerDateTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getMa() {
        return ma;
    }

    public void setMa(double ma) {
        this.ma = ma;
    }

    public double getMomentum() {
        return momentum;
    }

    public void setMomentum(double momentum) {
        this.momentum = momentum;
    }

    public double getEma() {
        return ema;
    }

    public void setEma(double ema) {
        this.ema = ema;
    }

    public Date getLastTickerDateTime() {
        return lastTickerDateTime;
    }

    public void setLastTickerDateTime(Date lastTickerDateTime) {
        this.lastTickerDateTime = lastTickerDateTime;
    }
}
