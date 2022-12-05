package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class netCalories {
int cM;
int cB;
int cE;

public netCalories(int calorieMaitenance, int caloriesBurnt, int caloriesEaten) {
	cM= calorieMaitenance;
	cB = caloriesBurnt;
	cE = caloriesEaten;
}
public int calcNetCalories() {
	int nCalories = cM+cB-cE;
	return nCalories;
}
//Sets the Labels for each day to how many calories the user needs to eat after inputting the amount 
	// of calories burnt from exercising and calories eaten from the different meals throughout the day
	public String setCalorieLabel() {
		int remainingCalories = cM+cB-cE;
		String requiredCalories = "";
		if (remainingCalories>0) {
			requiredCalories =  " "+ remainingCalories + " cal to go!";
		}
		else if (remainingCalories<0) {
			requiredCalories = -1*remainingCalories + " cal more than needed :(";
		}
		else {
			requiredCalories = "You met the calorie goal!";
		}
		return requiredCalories;
	}
}
