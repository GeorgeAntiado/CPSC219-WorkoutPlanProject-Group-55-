package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class netCalories {
int cM;
int cB;
int cE;
int nCalories;

public netCalories(int calorieMaitenance, int caloriesBurnt, int caloriesEaten) {
	cM= calorieMaitenance;
	cB = caloriesBurnt;
	cE = caloriesEaten;
}
public int calcNetCalories() {
	nCalories = cM+cB-cE;
	return nCalories;
}
//Sets the Labels for each day to how many calories the user needs to eat after inputting the amount 
	// of calories burnt from exercising and calories eaten from the different meals throughout the day
	public String setCalorieLabel() {
		
		String requiredCalories = "";
		if (nCalories>0) {
			requiredCalories =  " "+ nCalories + " cal to go!";
		}
		else if (nCalories<0) {
			int showExcessCal = nCalories*-1;
			requiredCalories = showExcessCal + " cals too much :(";
		}
		else {
			requiredCalories = "You met the calorie goal!";
		}
		return requiredCalories;
	}
}
