// Name: Tyler Gauntlett
// Date 3/31/2016
// Course: COP3503C-16Spring 0001
// Assingment: Pokemon Center
// Project Description: Create a Pokemon Center that based on user input, will match
// with predefined input. If name and id are the same, the user can then heal, deposit
// or withdraw Pokemon from the Center. 

import java.util.*;

public class TestPokemonCenter {
	public static void main(String[] args) throws Exception {
		Scanner userInput = new Scanner(System.in);
		boolean quit = false;

		String menuSelection;

		System.out.println("Please enter your name");

		String newName = userInput.nextLine();

		System.out.println("Please enter your ID.");

		
		// Try/catch and do/while block set up in case they enter letters instead of numbers
		// before parsing string for int value.
		String newIDString;
		int newIDInt = 0;
		do
		{
			try{
				newIDString = userInput.nextLine();
				newIDInt = Integer.parseInt(newIDString, 8);
				quit = true;
			}
			catch(Exception e)
			{
				System.out.println("Please enter a numarical value.");
			}
			
		} while(!quit);
		quit = false;

		// Call main object in facade class.
		FacadePokemonCenter pokemonCenter = new FacadePokemonCenter(newIDInt, newName);

		do {
			// Print menu.
			System.out.println("Please enter a value 1-4 inclusively.");
			System.out.println("1: Heal");
			System.out.println("2: Deposit");
			System.out.println("3: Withdrawl");
			System.out.println("4: Exit");

			// Take in menu selection.
			menuSelection = userInput.next();

			
			switch (menuSelection) {
			case "1":
				// Display team before calling heal function.
				System.out.println("Before attempting heal:\n");
				pokemonCenter.printTeamAndHealth();
	
				// Display team after calling heal function.
				System.out.println("\nAfter attempting heal:\n");
				pokemonCenter.healPokemon();
				pokemonCenter.printTeamAndHealth();
				break;

			case "2":
				System.out.println("Before attempting deposit:\n");
				pokemonCenter.printTeamAndHealth();
				System.out.println("\nWhat Pokemon would you like to deposit?");
				
				
				
				pokemonCenter.depositPokemon(userInput.nextInt());
				System.out.println("After attempting deposit:\n");
				pokemonCenter.printTeamAndHealth();
				
				break;

			case "3":
				System.out.println("Before attempting withdraw:\n");
				pokemonCenter.printTeamAndHealth();
				System.out.println("\nWhat Pokemon would you like to withdrawl?");
				
				
				
				pokemonCenter.withdrawPokemon(userInput.nextInt());
				System.out.println("After attempting withdraw:\n");
				pokemonCenter.printTeamAndHealth();
				
				break;

			case "4":
				System.out.println("Thank you for visiting the Pokemon Center!");
				quit = true;
				break;

			default:
				System.out.println("Please enter a valid number 1-4");
				break;

			}

		} while (!quit);

	}

	static String GetNameAndPID() {
		return ("Gauntlett, Tyler, ty340586");
	}
}
