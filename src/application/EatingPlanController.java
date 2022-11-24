package application;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
	void someEvent(ActionEvent something) {
		
	}
}
