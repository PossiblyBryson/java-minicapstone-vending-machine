package com.techelevator;

import java.math.BigDecimal;

public class Currency {
    private BigDecimal quarter=BigDecimal.valueOf(0.25);
    private BigDecimal dime=BigDecimal.valueOf(0.10);
    private BigDecimal nickel = BigDecimal.valueOf(0.05);
    private BigDecimal oneDollar = BigDecimal.valueOf(1.00);
    private BigDecimal fiveDollar = BigDecimal.valueOf(5.00);

    private BigDecimal total;
    private BigDecimal tDelta;


    public void setTotal(BigDecimal value){
        this.total=value;
    }
    public BigDecimal getTotal(){
        return this.total;
    }

    public void settDelta(BigDecimal value){
        this.tDelta = value;
    }
    public BigDecimal gettDelta(){
        return this.tDelta;
    }

    public BigDecimal getDime() {
        return dime;
    }

    public BigDecimal getFiveDollar() {
        return fiveDollar;
    }

    public BigDecimal getNickel() {
        return nickel;
    }

    public BigDecimal getOneDollar() {
        return oneDollar;
    }

    public BigDecimal getQuarter() {
        return quarter;
    }
}
