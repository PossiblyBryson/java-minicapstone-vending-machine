package com.techelevator;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachineCLI {


	public VendingMachineCLI() {

	}

	public void run() {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter("C:/Users/Student/workspace/",true));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		Scanner userInput = new Scanner(System.in);
		Vending ourVending = new Vending();
		ourVending.createItems();
		ourVending.getWelcomeMenu();
		String mainMenuOption = userInput.nextLine();
		//Display vending machine items
		Transaction transaction = new Transaction();





	}





	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}
}
