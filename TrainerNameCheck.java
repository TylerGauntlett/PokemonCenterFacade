
public class TrainerNameCheck {

	private String trainerName = "Ash Ketchum";
	// Please do not change this value.
	// I will be using this name to test your code.

	public String getTrainerName() {
		return trainerName;
	}

	public boolean trainerActive(String trainerNameToCheck) {
		if (trainerNameToCheck.equals(trainerName))
			return true;

		else
			return false;
	}

}
