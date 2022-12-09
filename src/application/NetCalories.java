package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Used by setCalCountLabel() in EatingPlanController
 * @author CS219-user
 */
public class NetCalories {
	
	int calorieMaintenance;
	int caloriesBurnt;
	int caloriesEaten;
	int netCalories;
	
	
	/**
	 * Constructor for NetCalories.
	 * @param cMaintenance
	 * @param cBurnt
	 * @param cEaten
	 */
	public NetCalories(int cMaintenance, int cBurnt, int cEaten) {
		calorieMaintenance = cMaintenance;
		caloriesBurnt = cBurnt;
		caloriesEaten = cEaten;
	}
	
	
	/**
	 * Calculates the calories based on the instance's variables.
	 * @return netCalories: int
	 */
	public int calcNetCalories() {
		
		netCalories = calorieMaintenance+caloriesBurnt-caloriesEaten;
		
		return netCalories;
	}
	
	
	/**
	 * Sets the Labels for how many calories the user needs to eat based on netCalories.
	 * Should be used after calcNetCalories sets the netCalories.
	 * @return requiredCalories: String
	 */
	public String setCalorieLabel() {
		String requiredCalories = "";
		
		if (netCalories>0) {
			requiredCalories =  " "+ netCalories + " cal to go!";
		} else if (netCalories<0) {
			int showExcessCal = netCalories*-1;
			requiredCalories = showExcessCal + " cals too much :(";
		} else {
			requiredCalories = "You met the calorie goal!";
		}
		
		return requiredCalories;
	}
	
}
