package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class EatingPlanController {
	
	@FXML
	ChoiceBox<Integer> mondaymeals;
	
	@FXML
	ChoiceBox<Integer> tuesdaymeals;
	
	@FXML
	ChoiceBox<Integer> wednesdaymeals;
	
	@FXML
	ChoiceBox<Integer> thursdaymeals;
	
	@FXML
	ChoiceBox<Integer> fridaymeals;
	
	@FXML
	ChoiceBox<Integer> saturdaymeals;
	
	@FXML
	ChoiceBox<Integer> sundaymeals;
	
	@FXML
	ChoiceBox<Integer> mondayworkouts;
	
	@FXML
	ChoiceBox<Integer> tuesdayworkouts;
	
	@FXML
	ChoiceBox<Integer> wednesdayworkouts;
	
	@FXML
	ChoiceBox<Integer> thursdayworkouts;
	
	@FXML
	ChoiceBox<Integer> fridayworkouts;
	
	@FXML
	ChoiceBox<Integer> saturdayworkouts;
	
	@FXML
	ChoiceBox<Integer> sundayworkouts;
	
	@FXML
	Label monCalCount;
	
	@FXML
	Label tuesCalCount;
	
	@FXML
	Label wedCalCount;
	
	@FXML
	Label thursCalCount;
	
	@FXML
	Label friCalCount;
	
	@FXML
	Label satCalCount;
	
	@FXML
	Label sunCalCount;
	
	int dailyCalorieIntake = 2200;
	int caloriesfromMeals = 0;
	
	@FXML 
	void setCalorieIntake(ActionEvent intake) {
		int remainingCalories = dailyCalorieIntake - caloriesfromMeals;
		if (remainingCalories>0) {
			String requiredCalories = "You need to eat " + remainingCalories + " more for today";
		}
		else if (remainingCalories<0) {
			String requiredCalories = "You ate " + remainingCalories + " more than needed :(";
		}
		else {
			String requiredCalories = "You met the calorie intake goal!";
		}
	}
}
