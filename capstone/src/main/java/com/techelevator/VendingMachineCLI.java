package com.techelevator;


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
		ourVending.getMainMenu();
		String mainMenuOption = userInput.nextLine();
		//Display vending machine items



	}





	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}
}
