package com.techelevator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Transaction {
    private String name;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    private BigDecimal balance = new BigDecimal(0);
    private BigDecimal tDelta = new BigDecimal(0);
    private BigDecimal change = new BigDecimal(0);
    private BigDecimal amountInMachine = new BigDecimal(0);




    public BigDecimal getAmountInMachine(){
        return this.amountInMachine;
    }





    public BigDecimal getAmountFed() {
        return amountInMachine;
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
        this.amountInMachine = amountFed;
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

    public void settDelta( ) {
        this.tDelta = tDelta;
    }

    public void setTime() {
        this.time = LocalTime.now();
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }



    public void feedMoney(){
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter amount to be Fed");
        String amountInput = userInput.nextLine();
        BigDecimal amountToBeFed = null;


        try {
            amountToBeFed = new BigDecimal(amountInput);

            // Ensure that amountToBeFed is positive, you may want to add this check
            if (amountToBeFed.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("Invalid input. Please enter a positive amount.");
                return; // Exit the method if the input is invalid.
            }
            // Update the amountInMachine
            this.amountInMachine = this.amountInMachine.add(amountToBeFed);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid numeric amount.");

        }


        try {
            PrintWriter writer = new PrintWriter(new FileWriter("C:/Users/Student/workspace/java-minicapstonemodule1-team2/capstone/src/main/resources/log.txt", true));
            writer.println(this.getDate() + " " + this.getTime() + " FEED MONEY: " + amountToBeFed + " " + this.getAmountInMachine());
            writer.flush();// testing
        } catch (IOException e) {
            throw new RuntimeException("Do not pass go");

        }


    }
    public void dispense(Items item){
        System.out.println("Dispensing Item");
        System.out.println(item.getReturnMessage());
        item.quantity --;
        this.amountInMachine = this.amountInMachine.subtract(item.getPrice());//
        //writer.println();
        // this is currently working and does out put and dispense item to console as well as update machine balance


    }
    public void giveChange(){


    }

    public void addToActionLog(){



    }













}
