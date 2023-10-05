package com.techelevator;

import java.math.BigDecimal;

public class Duck extends Items {
    public Duck(String name, BigDecimal price, String position) {
        super(name, price, position, "Quack, Quack, Splash!");
    }

}