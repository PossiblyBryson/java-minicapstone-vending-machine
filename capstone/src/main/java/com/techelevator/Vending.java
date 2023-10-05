package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vending {
    private List<Items> items;
    private List<Currency> Currency;

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
            System.out.println("You entered 1");
            this.createItems();
            System.out.println(this.items);

        } else if (mainMenuOption.equals("2")) {
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
                    duckCount++;
                    Duck newDuck = new Duck(fields[1],new BigDecimal(fields[2]),fields[0]);
                    this.setItems(newDuck);

                }



            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
