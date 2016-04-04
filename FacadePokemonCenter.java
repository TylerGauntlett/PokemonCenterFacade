
public class FacadePokemonCenter {
	// Declare a private int and a private String up here for the trainer's ID
	// and name.

	private int trainerID;
	private String trainerName;

	// Also, be sure to declare variables of the following type:
	// - TrainerIDCheck
	// - TrainerNameCheck
	// - HealAndPC
	// - Welcome
	// Don't instantiate them yet - that can happen in the constructor.

	TrainerIDCheck idCheck;
	TrainerNameCheck nameCheck;
	HealAndPC healPC;
	Welcome welcome;

	public FacadePokemonCenter(int newID, String newName) {
		// Here in the constructor, set the variables based on the input.
		trainerID = newID;
		trainerName = newName;

		// Also, instantiate the four classes here.
		idCheck = new TrainerIDCheck();
		nameCheck = new TrainerNameCheck();
		healPC = new HealAndPC();
		welcome = new Welcome();
	}

	public int getTrainerID() {
		return trainerID;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void healPokemon() {
		// This should have a few steps.
		// - Check that the ID is valid with your instance of TrainerIDCheck.
		// - Check that the name is valid with your instance of
		// TrainerNameCheck.
		// - Check if the team has at least one Pokemon.
		// If every case is true, call the heal function in your instance of
		// HealAndPC.
		// In addition, print that the healing was successful.
		// Otherwise, do nothing, and say why the healing was not done.
		// Make sure you print out a statement on whether healing was successful
		// or not!
		// This is crucial to how we will grade your assignment

		String unsuccesfulHeal = null;

		if (trainerID == idCheck.getTrainerID()) {
			if (trainerName.equals(nameCheck.getTrainerName())) {
				if (!healPC.isTeamEmpty()) {
					healPC.healPokemon();
					System.out.println("Healing was successful.");
				}
				else
					unsuccesfulHeal = "Healing unsuccessful because party is empty.";
			}
			else
			{
				unsuccesfulHeal = "Healing unsuccessful because trainer name is invalid";
				
				if(healPC.isTeamEmpty())
					unsuccesfulHeal = unsuccesfulHeal + " and party is empty.";
				
				
					unsuccesfulHeal = unsuccesfulHeal + ".";
			}
		}
		else
		{
			unsuccesfulHeal = "Healing unsuccessful because trainer ID is invalid";
			
			if (!trainerName.equals(nameCheck.getTrainerName()))
				unsuccesfulHeal = unsuccesfulHeal + " and trainer name is invalid";
			
			if(healPC.isTeamEmpty())
				unsuccesfulHeal = unsuccesfulHeal + " and party is empty.";
			
			
				unsuccesfulHeal = unsuccesfulHeal + ".";
		}
	
		if(unsuccesfulHeal != null)
			System.out.println(unsuccesfulHeal);

	}

	public void depositPokemon(int dexNum) {
		// This should have a few steps.
		// - Check that the ID is valid with your instance of TrainerIDCheck.
		// - Check that the name is valid with your instance of
		// TrainerNameCheck.
		// - Check if the team has at least one Pokemon.
		// - Check if the Pokedex number is valid (that is to say, < 722).
		// - Check if the team contains the given Pokemon.
		// If every case is true, call the deposit function in your instance of
		// HealAndPC.
		// In addition, print that the deposit was successful.
		// Otherwise, do nothing, and say why the deposit was not made.
		// Make sure you print out a statement on whether the deposit was
		// successful or not!
		// This is crucial to how we will grade your assignment
		
		String unsuccesfulDeposit = null;

		if (trainerID == idCheck.getTrainerID()) {
			if (trainerName.equals(nameCheck.getTrainerName())) {
				if (!healPC.isTeamEmpty()) {
					if(dexNum < 722)
					{
						if(healPC.containsPokemon(dexNum))
						{
							healPC.depositPokemon(dexNum);
							System.out.println("Deposit was successful.");
						}
						else
						{
							unsuccesfulDeposit = "Depositing unsuccessful because the pokemon is not currently in the party.";
						}
					}
					else
					{
						unsuccesfulDeposit = "Depositing unsuccessful because the pokemon number is invalid";

						if(!healPC.containsPokemon(dexNum))
							unsuccesfulDeposit = unsuccesfulDeposit + " and the pokemon is not currently in the party";
						
						
							unsuccesfulDeposit = unsuccesfulDeposit + ".";	
					}
				}
				else
				{
					unsuccesfulDeposit = "Depositing unsuccessful because party is empty";
					
					if(dexNum > 722)
						unsuccesfulDeposit = unsuccesfulDeposit + " and the pokemon number is invalid";
					
					if(!healPC.containsPokemon(dexNum))
						unsuccesfulDeposit = unsuccesfulDeposit + " and the pokemon is not currently in the party";
					
					
						unsuccesfulDeposit = unsuccesfulDeposit + ".";	
				}
				
			}
			else
			{
				unsuccesfulDeposit = "Depositing unsuccessful because trainer name is invalid";
				
				if(healPC.isTeamEmpty())
					unsuccesfulDeposit = unsuccesfulDeposit + " and party is empty.";
				
				if(dexNum > 722)
					unsuccesfulDeposit = unsuccesfulDeposit + " and the pokemon number is invalid";
				
				if(!healPC.containsPokemon(dexNum))
					unsuccesfulDeposit = unsuccesfulDeposit + " and the pokemon is not currently in the party";
				
				
					unsuccesfulDeposit = unsuccesfulDeposit + ".";
			}
		}
		else
		{
			unsuccesfulDeposit = "Depositing unsuccessful because trainer ID is invalid";
			
			if (!trainerName.equals(nameCheck.getTrainerName()))
				unsuccesfulDeposit = unsuccesfulDeposit + " and trainer name is invalid";
			
			if(healPC.isTeamEmpty())
				unsuccesfulDeposit = unsuccesfulDeposit + " and party is empty.";
			
			if(dexNum > 722)
				unsuccesfulDeposit = unsuccesfulDeposit + " and the pokemon number is invalid";
			
			if(!healPC.containsPokemon(dexNum))
				unsuccesfulDeposit = unsuccesfulDeposit + " and the pokemon is not currently in the party";
			
			
				unsuccesfulDeposit = unsuccesfulDeposit + ".";
		}
	
		if(unsuccesfulDeposit != null)
			System.out.println(unsuccesfulDeposit);
		
	}
	
	public void withdrawPokemon(int dexNum) {
		// This should have a few steps.
		// - Check that the ID is valid with your instance of TrainerIDCheck.
		// - Check that the name is valid with your instance of
		// TrainerNameCheck.
		// - Check if the team has space for another Pokemon.
		// - Check if the Pokedex number is valid (that is to say, < 722).
		// If every case is true, call the withdrawal function in your instance
		// of HealAndPC.
		// In addition, print that the withdrawal was successful.
		// Otherwise, do nothing, and say why the withdrawal was not made.
		// Make sure you print out a statement on whether withdrawing was
		// successful or not!
		// This is crucial to how we will grade your assignment
		
		String unsuccesfulWithdraw = null;

		if (trainerID == idCheck.getTrainerID()) {
			if (trainerName.equals(nameCheck.getTrainerName())) {
				if (!healPC.isTeamFull()) {
					if(dexNum < 722)
					{
						healPC.withdrawPokemon(dexNum);
						System.out.println("Withdrawl was successful.");
					
					}
					else
					{
						unsuccesfulWithdraw = "Withdrawing unsuccessful because the pokemon number is invalid.";
					}
				}
				else
				{
					unsuccesfulWithdraw = "Withdrawing unsuccessful because party is full";
					
					if(dexNum > 722)
						unsuccesfulWithdraw = unsuccesfulWithdraw + " and the pokemon number is invalid";
					
					
						unsuccesfulWithdraw = unsuccesfulWithdraw + ".";	
				}
				
			}
			else
			{
				unsuccesfulWithdraw = "Withdrawing unsuccessful because trainer name is invalid";
				
				if(healPC.isTeamFull())
					unsuccesfulWithdraw = unsuccesfulWithdraw + " and party is full";
				
				if(dexNum > 722)
					unsuccesfulWithdraw = unsuccesfulWithdraw + " and the pokemon number is invalid";
				
				
					unsuccesfulWithdraw = unsuccesfulWithdraw + ".";
			}
		}
		else
		{
			unsuccesfulWithdraw = "Withdrawing unsuccessful because trainer ID is invalid";
			
			if (!trainerName.equals(nameCheck.getTrainerName()))
				unsuccesfulWithdraw = unsuccesfulWithdraw + " and trainer name is invalid";
			
			if(healPC.isTeamFull())
				unsuccesfulWithdraw = unsuccesfulWithdraw + " and party is full";
			
			if(dexNum > 722)
				unsuccesfulWithdraw = unsuccesfulWithdraw + " and the pokemon number is invalid";
			
			
				unsuccesfulWithdraw = unsuccesfulWithdraw + ".";
		}
	
		if(unsuccesfulWithdraw != null)
			System.out.println(unsuccesfulWithdraw);
		
		
	}

	public void printTeamAndHealth() {
		healPC.printTeamAndHealth();
	}

}
