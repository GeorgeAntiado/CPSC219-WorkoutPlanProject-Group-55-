package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class NetCalories {
int calorieMaintenance;
int caloriesBurnt;
int caloriesEaten;
int netCalories;

public NetCalories(int cMaintenance, int cBurnt, int cEaten) {
	calorieMaintenance = cMaintenance;
	caloriesBurnt = cBurnt;
	caloriesEaten = cEaten;
}
public int calcNetCalories() {
	netCalories = calorieMaintenance+caloriesBurnt-caloriesEaten;
	return netCalories;
}
//Sets the Labels for each day to how many calories the user needs to eat after inputting the amount 
	// of calories burnt from exercising and calories eaten from the different meals throughout the day
	public String setCalorieLabel() {
		
		String requiredCalories = "";
		if (netCalories>0) {
			requiredCalories =  " "+ netCalories + " cal to go!";
		}
		else if (netCalories<0) {
			int showExcessCal = netCalories*-1;
			requiredCalories = showExcessCal + " cals too much :(";
		}
		else {
			requiredCalories = "You met the calorie goal!";
		}
		return requiredCalories;
	}
}
