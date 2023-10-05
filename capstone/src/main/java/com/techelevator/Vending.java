package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Vending {
    private List<Items> Items;
    private List<Currency> Currency;

    public Vending(List<Items>items,List<Currency>currency){
        this.Items = items;
        this.Currency = currency;
    }
}
