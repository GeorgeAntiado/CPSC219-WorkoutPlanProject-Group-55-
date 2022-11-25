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
	
	@FXML
	void setDailyCalorie(ActionEvent calorieEvent) {
		monCalCount.setText(dailyCalorieIntake + "to go!");
		tuesCalCount.setText(dailyCalorieIntake + "to go!");
		wedCalCount.setText(dailyCalorieIntake + "to go!");
		thursCalCount.setText(dailyCalorieIntake + "to go!");
		friCalCount.setText(dailyCalorieIntake + "to go!");
		satCalCount.setText(dailyCalorieIntake + "to go!");
		sunCalCount.setText(dailyCalorieIntake + "to go!");
	}
}
