package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class EatingPlanController {
	Stage applicationStage;
	//Control for the  change in scenes
			private Stage stage;
			private Scene scene;
	
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
	void getMonWorkouts(ActionEvent event) {
		Scene mWorkoutsScene = new Scene(new Label("add widgets later"));
		applicationStage.setScene(mWorkoutsScene);
	}
	@FXML
	void getMonMeals(ActionEvent event) {
		System.out.println("Add m meals button was pressed");
	}
	
	@FXML
	void getTuesWorkouts(ActionEvent event) {
		System.out.println("Add tu workouts button was pressed");
	}
	@FXML
	void getTuesMeals(ActionEvent event) {
		System.out.println("Add tu meals button was pressed");
	}
	
	@FXML
	void getWedWorkouts(ActionEvent event) {
		System.out.println("Add w workouts button was pressed");
	}
	@FXML
	void getWedMeals(ActionEvent event) {
		System.out.println("Add w meals button was pressed");
	}
	
	@FXML
	void getThursWorkouts(ActionEvent event) {
		System.out.println("Add th workouts button was pressed");
	}
	@FXML
	void getThursMeals(ActionEvent event) {
		System.out.println("Add th meals button was pressed");
	}
	
	@FXML
	void getFriWorkouts(ActionEvent event) {
		System.out.println("Add f workouts button was pressed");
	}
	@FXML
	void getFriMeals(ActionEvent event) {
		System.out.println("Add fri Meals button was pressed");
	}
	
	@FXML
	void getSatWorkouts(ActionEvent event) {
		System.out.println("Add sa workouts button was pressed");
	}
	@FXML
	void getSatMeals(ActionEvent event) {
		System.out.println("Add sa meals button was pressed");
	}
	
@FXML
void getSunWorkouts(ActionEvent event) {
	System.out.println("Add sunday workouts button was pressed");
}
@FXML
void getSunMeals(ActionEvent event) {
	System.out.println("Add su meals button was pressed");
}

@FXML
	void addexercise(ActionEvent burn) {
		int exercise= 0;
		dailyCalorieIntake = dailyCalorieIntake + exercise;
	}
	
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
	//This method is used to change into the "Main Menu" Scene
		public void switchToMainMenu(ActionEvent event) throws IOException {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/WorkoutPlanView1.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
}
