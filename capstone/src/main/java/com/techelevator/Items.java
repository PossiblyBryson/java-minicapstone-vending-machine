package com.techelevator;

import java.math.BigDecimal;

public class Items {
private String name;
private BigDecimal price;
public String position;
public int quantity = 5;
public String returnMessage;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }
    public String getName(){
        return this.name;
    }
    public BigDecimal getPrice(){
        return this.price;
    }
    public String getPosition(){
        return this.position;
    }
    public int getQuantity(){
        return  this.quantity;
    }
    public String getReturnMessage(){
        return  this.returnMessage;
    }
    public Items (String name,BigDecimal price, String position, String returnMessage){
        this.name = name;
        this.price = price;
        this.position = position;
        this.returnMessage = returnMessage;
    }


}
