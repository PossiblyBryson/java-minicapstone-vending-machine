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

		Scanner userInput = new Scanner(System.in);
		Vending ourVending = new Vending();
		ourVending.createItems();
		ourVending.getWelcomeMenu();
		String mainMenuOption = userInput.nextLine();
		//Display vending machine items






	}





	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}
}
