package com.techelevator;

import java.math.BigDecimal;

public class Currency {
    private BigDecimal quarter=BigDecimal.valueOf(0.25);
    private BigDecimal dime=BigDecimal.valueOf(0.10);
    private BigDecimal nickel = BigDecimal.valueOf(0.05);

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











}
