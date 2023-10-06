package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
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

        } else if (mainMenuOption.equals("2")) {
            System.out.println("You entered 2");
            getPurchaseMenu();

        } else if (mainMenuOption.equals("3")) {
            System.out.println("You entered 3");
            System.out.println();
            getWelcomeMenu();

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
        //Current Money Provided displays here
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select Product");
            System.out.println("(3) Finish Transaction");
            getPurchaseMenuUserInput();
    }
    public void getPurchaseMenuUserInput(){

        String purchaseMenuTwo = userInput.nextLine();
                if (purchaseMenuTwo.equals("1")){
                    //Feed money into the machine in whole dollar amounts
                }
                if (purchaseMenuTwo.equals("2")){
                    System.out.println("Please enter your selection:");
                    for(Items item: this.items){
                        System.out.println(item.position + "| " +  item.getName() + " " + item.getPrice() );
                    }
                    String userPurchase = userInput.nextLine();

                        boolean isTargetProduct = false;
                        boolean isSoldOut = false;

                        while (!isTargetProduct) {

                            for (Items item : this.items) {
                                if (item.getPosition().equals(userPurchase.toUpperCase()) && item.quantity != 0 ) {
                                    System.out.println(item.getName()+" "+item.getPosition()+" "+item.getPrice());
                                    isTargetProduct = true;
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
                    getMainMenu();
                }
    }

}
