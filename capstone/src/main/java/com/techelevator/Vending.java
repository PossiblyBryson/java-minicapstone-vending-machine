package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Vending {
    private List<Items> items = new ArrayList<>();
    private List<Currency> Currency = new ArrayList<>();
    Scanner userInput = new Scanner(System.in);


    public void setItems(Items item) {
        items.add(item);
    }
    public List<Items> getItems(){
        return this.items;
    }

    public Vending(List<Items>items, List<Currency>currency){
        this.items = items;
        this.Currency = currency;
    }
    public Vending(){}
    public void getWelcomeMenu(){
        System.out.println("Welcome to the Vendo-Matic 800!");
        System.out.println("Press E to enter");
        String welcomeMenuOption = userInput.nextLine();
        if(welcomeMenuOption.toLowerCase().equals("e")){
            this.getMainMenu();
        }else{
            System.out.println("Try again");
            getWelcomeMenu();
        }
    }
    public void getMainMenu(){;
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        this.getMainMenuUserInput(); //calls the getUserInput method

    }
    public void getMainMenuUserInput(){
        String mainMenuOption = userInput.nextLine();
        if (mainMenuOption.equals("1")) {
           // outs puts the inventory list to the user
            for(Items item: this.items){
                System.out.println(item.position + "| " +  item.getName() + " " + item.getPrice() );
            }
            getMainMenu();

        } else if (mainMenuOption.equals("2")) {
            System.out.println("You entered 2");
            getPurchaseMenu();

        } else if (mainMenuOption.equals("3")) {
            System.out.println("You entered 3");
            System.out.println();
            transaction.giveChange();

        } else if (mainMenuOption.equals("4")) {
            System.out.println("You entered 4");
        }
        else{
            System.out.println("Invalid input, please enter: 1, 2, 3");
            System.out.println();
            this.getMainMenu(); // If an invalid input is given,
            // then getMainMenu executes and when getMainMenu executes; so does getUserInput, creating a loop
        }

    }
    public void createItems(){
        File inputFile = new File("C:\\Users\\Student\\workspace\\java-minicapstonemodule1-team2\\capstone\\vendingmachine.csv");
        try(Scanner fileScanner = new Scanner(inputFile)) {
            int duckCount = 0;
            int penguinCount = 0;
            while (fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] fields = line.split("\\|");

                if(fields[3].equals("Duck")){
                    String priceString = fields[2];
                    BigDecimal price = new BigDecimal(priceString);
                    Duck newDuck = new Duck(fields[1],price,fields[0]);
                    this.setItems(newDuck);

                }else if(fields[3].equals("Penguin")) {
                    String priceString = fields[2];
                    BigDecimal price = new BigDecimal(priceString);
                    Penguin newPenguin = new Penguin(fields[1], price, fields[0]);
                    this.setItems(newPenguin);
                }else if(fields[3].equals("Cat")) {
                    String priceString = fields[2];
                    BigDecimal price = new BigDecimal(priceString);
                    Cat newCat = new Cat(fields[1], price, fields[0]);
                    this.setItems(newCat);
                }else if(fields[3].equals("Pony")) {
                    String priceString = fields[2];
                    BigDecimal price = new BigDecimal(priceString);
                    Pony newPony = new Pony(fields[1], price, fields[0]);
                    this.setItems(newPony);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void getPurchaseMenu(){
        System.out.println("Current money provided: " + transaction.getAmountInMachine());
        System.out.println();
        //Current Money Provided displays here
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            getPurchaseMenuUserInput();
    }
    Transaction transaction = new Transaction();


    public void getPurchaseMenuUserInput(){

        String purchaseMenuTwo = userInput.nextLine();
                if (purchaseMenuTwo.equals("1")){
                    //Feed money into the machine in whole dollar amounts
                    transaction.feedMoney();
                    this.getPurchaseMenu();

                }
                if (purchaseMenuTwo.equals("2")){

                    for(Items item: this.items){
                        System.out.println(item.position + "| " +  item.getName() + " " + item.getPrice() + " " + "Quanity in stock: " + item.getQuantity() );
                    }
                    System.out.println("Please enter your selection:");
                    String userPurchase = userInput.nextLine();

                        boolean isTargetProduct = false;
                        boolean isSoldOut = false;

                        while (!isTargetProduct) {

                            for (Items item : this.items) {
                                if (item.getPosition().equals(userPurchase.toUpperCase()) && item.quantity != 0 ) {
                                    System.out.println(item.getPosition()+ " " + item.getName()+" " + item.getPrice());
                                    isTargetProduct = true;
                                    System.out.println();

                                    //this compares the amount of money in the machine to the items price if they have enough it dispenses the item
                                    int comparisonResult = transaction.getAmountInMachine().compareTo(item.getPrice());
                                    if(comparisonResult >= 0){
                                        transaction.dispense(item);// dispenses Item and updates balance in machine
                                        getPurchaseMenu();
                                    }else {// if they dont have enough in the machine it lets them know and kicks them back to the purchase menu
                                        System.out.println("Please add more money");
                                        getPurchaseMenu();
                                    }



                                    //Sell them the toy
                                } else if(item.getPosition().equals(userPurchase.toUpperCase()) && item.quantity == 0 ){
                                    System.out.println("The item is sold out.");
                                    System.out.println("Please select another item!");
                                    getPurchaseMenu();
                                }
                            }
                            if (!isTargetProduct) {
                                System.out.println("Not a valid input, please try again!");
                                getPurchaseMenu();
                            }
                            getPurchaseMenu();
                        }
                }
                if (purchaseMenuTwo.equals("3")){
                    //Selecting "(3) Finish Transaction" allows the customer to complete the
                    //transaction and receive any remaining change.
                    //
                    //The machine returns the customer's money using nickels, dimes, and quarters
                    //(using the smallest amount of coins possible).
                    //The machine's current balance updates to $0 remaining.
                    transaction.giveChange();
                    System.exit(0);
                }
                if(purchaseMenuTwo.equals("4")){
                    BigDecimal itemsTotal = new BigDecimal(0);

                    for(Items item: items){
                        if(item.getQuantity() < 5){
                            BigDecimal itemsSoldCost = item.getPrice().multiply(new BigDecimal(5-item.quantity));
                            itemsTotal= itemsTotal.add(itemsSoldCost);
                            try {
                                PrintWriter writer = new PrintWriter(new FileWriter("C:/Users/Student/workspace/java-minicapstonemodule1-team2/capstone/src/main/resources/SalesLog.txt", true));
                                writer.println(item.getName() + " | " + item.getQuantity());
                                writer.flush();// testing
                            } catch (IOException e) {
                                throw new RuntimeException("Do not pass go");

                            }

                        }
                    }
                    try {
                        PrintWriter writer = new PrintWriter(new FileWriter("C:/Users/Student/workspace/java-minicapstonemodule1-team2/capstone/src/main/resources/SalesLog.txt", true));
                        writer.println();
                        writer.println("Total Sales: " + itemsTotal);
                        writer.println("Transaction for " + LocalTime.now().truncatedTo(ChronoUnit.SECONDS) + " " + LocalDate.now());
                        writer.println();
                        writer.flush();// testing
                    } catch (IOException e) {
                        throw new RuntimeException("Do not pass go");

                    }

                }
    }

}
