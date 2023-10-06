package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Transaction {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private BigDecimal balance = new BigDecimal(0);
    private BigDecimal tDelta=new BigDecimal(0)  ;
    private BigDecimal change = new BigDecimal(0);
    private BigDecimal amountFed = new BigDecimal(0);




    public BigDecimal getAmountFed() {
        return amountFed;
    }

    public BigDecimal getChange() {
        return change;
    }

    public BigDecimal gettDelta() {
        return tDelta;

    }

    public BigDecimal getBalance() {
        return balance;
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

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }





        PrintWriter writer;






    public void feedMoney(){
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter amount to be Fed");
        String amountInput = userInput.nextLine();
        BigDecimal amountToBeFed = new BigDecimal(amountInput);

        this.amountFed = this.getAmountFed().add(amountToBeFed);
        // writer.println(this.getTime() + " " + this.getDate() + " ");
        System.out.println(getAmountFed());
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("C:/Users/Student/workspace/java-minicapstonemodule1-team2/capstone/src/main/resources/log.txt", true));
            writer.println(this.getDate() + " " + this.getTime() + " FEED MONEY: " + this.amountFed + " " + this.getBalance());
            writer.flush();// testing
        } catch (IOException e) {
            throw new RuntimeException("Do not pass go");

        }

    }
    public void dispense(Items item){
        System.out.println("Dispensing Item");
        System.out.println(item.getReturnMessage());
        item.quantity --;
        //writer.println();

    }
    public void giveChange(){


    }

    public void addToActionLog(){



    }













}
