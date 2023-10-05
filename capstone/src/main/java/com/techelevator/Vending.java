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

    public void getMainMenu(){
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        this.getUserInput(); //calls the getUserInput method

    }
    public void getUserInput(){
        Scanner userInput = new Scanner(System.in);
        String mainMenuOption = userInput.nextLine();
        if (mainMenuOption.equals("1")) {
           // outs puts the inventory list to the user
            this.createItems();
            for(Items item: this.items){
                System.out.println(item.position + " " +  item.getName() + " " + item.getPrice() );
            }

        } else if (mainMenuOption.equals("2")) {
            //purchase menu
            System.out.println("You entered 2");

        } else if (mainMenuOption.equals("3")) {
            System.out.println("You entered 3");

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

}
