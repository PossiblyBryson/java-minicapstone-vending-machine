package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Transaction {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private BigDecimal total;
    private BigDecimal tDelta;
    private BigDecimal change;
    private BigDecimal amountFed;

    public BigDecimal getAmountFed() {
        return amountFed;
    }

    public BigDecimal getChange() {
        return change;
    }

    public BigDecimal gettDelta() {
        return tDelta;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setAmountFed(BigDecimal amountFed) {
        this.amountFed = amountFed;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public void setDate() {
        this.date = LocalDate.now();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void settDelta(BigDecimal tDelta) {
        this.tDelta = tDelta;
    }

    public void setTime() {
        this.time = LocalTime.now();
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public void feedMoney(BigDecimal amountFed){
        this.amountFed.add(amountFed);

    }
    public void dispense(Items item){
        System.out.println("Dispensing Item");
        System.out.println(item.getReturnMessage());
        item.quantity --;

    }
    public void giveChange(){


    }
    public void addToActionLog(){


    }













}
