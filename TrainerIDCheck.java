
public class TrainerIDCheck {

	// Leading 0 makes this number octal.
	private int trainerID = 01301;
	// Please do not change this value.
	// I will be using this ID to test your code.

	public int getTrainerID() {
		return trainerID;
	}

	public boolean trainerActive(int trainerIDToCheck) {
		if (trainerIDToCheck == trainerID)
			return true;

		else
			return false;
	}

}