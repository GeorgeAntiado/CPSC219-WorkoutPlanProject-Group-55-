package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class EatingPlanController {
	//Stage to make new scenes to enter the workouts and meals
	Stage applicationStage;
	
	//variables to track calories eaten for each meal
	int monCalfromMeals = 0;
	int tuesCalfromMeals = 0;
	int wedCalfromMeals = 0;
	int thursCalfromMeals = 0;
	int friCalfromMeals = 0;
	int satCalfromMeals = 0;
	int sunCalfromMeals = 0;
	int caloriesBurnt = 0;
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
	
	//try to combine the doMonMeals and do Mon workouts to calculate and then use ifs to handle the null inputs
	public int doMonWorkouts(Scene mainScene, ArrayList<String> allExTypes, ArrayList<String> allExIntensity,
			ArrayList<TextField> allExLengths) {
		caloriesBurnt= 0;
		int b = 0;
		while (b< allExTypes.size()) {
			int lengths = Integer.parseInt(allExLengths.get(b).getText());
			exercise a = new exercise(allExTypes.get(b), allExIntensity.get(b), lengths);
			caloriesBurnt += a.getcaloriesBurnt();
			b++;
		}
		applicationStage.setScene(mainScene);
		return caloriesBurnt;
	}
	
	//Makes a new scene for the user to enter the calories burnt from different workouts on Monday
	@FXML
	void getMonWorkouts(ActionEvent event) {
		
		Scene mainScene = applicationStage.getScene();
		
		int numberOfMeals = mondayworkouts.getValue();
		int rowCounter = 0;
		
		VBox allRows = new VBox();
		ArrayList<String> allExTypes = new ArrayList<String>();
		ArrayList<String> allExIntensity = new ArrayList<String>();
		ArrayList<TextField> allExLengths = new ArrayList<TextField>();
		
		while (rowCounter < numberOfMeals) {
			rowCounter++;
			VBox workoutRow = new VBox();
			
			Label workoutLabel = new Label(" Workout " + rowCounter);
			
			HBox exTypeColumn = new HBox();
			Label exTypeLabel = new Label(" Type of Workout ");
			ChoiceBox<String> exTypeChoiceBox = new ChoiceBox<String>();
			exTypeChoiceBox.getItems().add("Cardio");
			exTypeChoiceBox.getItems().add("WeightLifting");
			exTypeChoiceBox.getItems().add("Sports");
			allExTypes.add(exTypeChoiceBox.getValue());
			exTypeColumn.getChildren().addAll(exTypeLabel, exTypeChoiceBox);
			
			HBox exIntensityColumn = new HBox();
			Label exIntensityLabel = new Label(" Workout Intensity ");
			ChoiceBox<String> exIntensityChoiceBox = new ChoiceBox<String>();
			exIntensityChoiceBox.getItems().add("Light");
			exIntensityChoiceBox.getItems().add("Moderate");
			exIntensityChoiceBox.getItems().add("Hard");
			allExIntensity.add(exTypeChoiceBox.getValue());
			exIntensityColumn.getChildren().addAll(exIntensityLabel, exIntensityChoiceBox);
			
			HBox exLength = new HBox();
			Label exLengthLabel = new Label(" Enter the workout length (in minutes) ");
			TextField exLengthTextField = new TextField();
			allExLengths.add(exLengthTextField);
			exLength.getChildren().addAll(exLengthLabel, exLengthTextField);
			
			workoutRow.getChildren().addAll(workoutLabel, exTypeColumn, exIntensityColumn, exLength);
			allRows.getChildren().add(workoutRow);
		}
		
		Button doneButton = new Button("Done");
		doneButton.setOnAction(doneEvent -> doMonWorkouts(mainScene, allExTypes, allExIntensity,  allExLengths));
		allRows.getChildren().add(doneButton);
		Scene mWorkoutsScene = new Scene(allRows);
		applicationStage.setScene(mWorkoutsScene);
	}


	////gets the sum of calories from all the meals eaten on monday
	public int doMonMeals(Scene mainScene, ArrayList<TextField> allMeals) {
		monCalfromMeals = 0;
		
		for(TextField i : allMeals) {
			monCalfromMeals += Integer.parseInt(i.getText());
		}
		applicationStage.setScene(mainScene);
		return monCalfromMeals;
	}
	
	//Makes a new scene for the user to enter the calories eaten from their meals on monday
	@FXML
	void getMonMeals(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		int numberOfMeals = mondaymeals.getValue();
		int rowCounter = 0;
		
		VBox allRows = new VBox();
		ArrayList<TextField> allMeals = new ArrayList<TextField>();
		while (rowCounter < numberOfMeals) {
			rowCounter++;
			HBox mealRow = new HBox();
			
			Label mealLabel = new Label("Meal " + rowCounter);
			TextField mealTextField = new TextField();
			allMeals.add(mealTextField);
			
			mealRow.getChildren().addAll(mealLabel, mealTextField);
			allRows.getChildren().add(mealRow);
		}
		Button doneButton = new Button("Done");
		doneButton.setOnAction(doneEvent -> doMonMeals(mainScene, allMeals));
		allRows.getChildren().add(doneButton);
		
		Scene mMealsScene = new Scene(allRows);
		applicationStage.setScene(mMealsScene);
	}
	
	//Makes a new scene for the user to enter the calories burnt from different workouts on Tuesday
	@FXML
	void getTuesWorkouts(ActionEvent event) {
		System.out.println("Add tu workouts button was pressed");
	}
	
	//gets the sum of calories from all the meals eaten on tuesday
	void doTuesMeals(Scene mainScene, ArrayList<TextField> allMeals) {
		tuesCalfromMeals = 0;
		
		for(TextField i : allMeals) {
			tuesCalfromMeals += Integer.parseInt(i.getText());
		}
		
		applicationStage.setScene(mainScene);
	}
	
	//Makes a new scene for the user to enter the calories eaten from their meals on tuesday
	@FXML
	void getTuesMeals(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		int numberOfMeals = tuesdaymeals.getValue();
		int rowCounter = 0;
		
		VBox allRows = new VBox();
		ArrayList<TextField> allMeals = new ArrayList<TextField>();
		while (rowCounter < numberOfMeals) {
			rowCounter++;
			HBox mealRow = new HBox();
			
			Label mealLabel = new Label("Meal " + rowCounter);
			TextField mealTextField = new TextField();
			allMeals.add(mealTextField);
			
			mealRow.getChildren().addAll(mealLabel, mealTextField);
			allRows.getChildren().add(mealRow);
		}
		Button doneButton = new Button("Done");
		doneButton.setOnAction(doneEvent -> doTuesMeals(mainScene, allMeals));
		allRows.getChildren().add(doneButton);
		
		Scene mMealsScene = new Scene(allRows);
		applicationStage.setScene(mMealsScene);
	}
	
	//Makes a new scene for the user to enter the calories burnt from different workouts on Wednesday
	@FXML
	void getWedWorkouts(ActionEvent event) {
		System.out.println("Add w workouts button was pressed");
	}
	
	//gets the sum of calories from all the meals eaten on wednesday
	void doWedMeals(Scene mainScene, ArrayList<TextField> allMeals) {
		wedCalfromMeals = 0;
		
		for(TextField i : allMeals) {
			wedCalfromMeals += Integer.parseInt(i.getText());
		}
		
		applicationStage.setScene(mainScene);
	}
	
	//Makes a new scene for the user to enter the calories eaten from their meals on wednesday
	@FXML
	void getWedMeals(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		int numberOfMeals = wednesdaymeals.getValue();
		int rowCounter = 0;
		
		VBox allRows = new VBox();
		ArrayList<TextField> allMeals = new ArrayList<TextField>();
		while (rowCounter < numberOfMeals) {
			rowCounter++;
			HBox mealRow = new HBox();
			
			Label mealLabel = new Label("Meal " + rowCounter);
			TextField mealTextField = new TextField();
			allMeals.add(mealTextField);
			
			mealRow.getChildren().addAll(mealLabel, mealTextField);
			allRows.getChildren().add(mealRow);
		}
		Button doneButton = new Button("Done");
		doneButton.setOnAction(doneEvent -> doWedMeals(mainScene, allMeals));
		allRows.getChildren().add(doneButton);
		
		Scene mMealsScene = new Scene(allRows);
		applicationStage.setScene(mMealsScene);
	}
	
	//Makes a new scene for the user to enter the calories burnt from different workouts on Thursday
	@FXML
	void getThursWorkouts(ActionEvent event) {
		System.out.println("Add th workouts button was pressed");
	}
	
	//gets the sum of calories from all the meals eaten on thursday
	void doThursMeals(Scene mainScene, ArrayList<TextField> allMeals) {
		thursCalfromMeals = 0;
		
		for(TextField i : allMeals) {
			thursCalfromMeals += Integer.parseInt(i.getText());
		}
		
		applicationStage.setScene(mainScene);
	}
	
	//Makes a new scene for the user to enter the calories eaten from their meals on thursday
	@FXML
	void getThursMeals(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		int numberOfMeals = thursdaymeals.getValue();
		int rowCounter = 0;
		
		VBox allRows = new VBox();
		ArrayList<TextField> allMeals = new ArrayList<TextField>();
		while (rowCounter < numberOfMeals) {
			rowCounter++;
			HBox mealRow = new HBox();
			
			Label mealLabel = new Label("Meal " + rowCounter);
			TextField mealTextField = new TextField();
			allMeals.add(mealTextField);
			
			mealRow.getChildren().addAll(mealLabel, mealTextField);
			allRows.getChildren().add(mealRow);
		}
		Button doneButton = new Button("Done");
		doneButton.setOnAction(doneEvent -> doThursMeals(mainScene, allMeals));
		allRows.getChildren().add(doneButton);
		
		Scene mMealsScene = new Scene(allRows);
		applicationStage.setScene(mMealsScene);
	}
	
	//Makes a new scene for the user to enter the calories burnt from different workouts on Friday
	@FXML
	void getFriWorkouts(ActionEvent event) {
		System.out.println("Add f workouts button was pressed");
	}
	
	//gets the sum of calories from all the meals eaten on friday
	void doFriMeals(Scene mainScene, ArrayList<TextField> allMeals) {
		friCalfromMeals = 0;
		
		for(TextField i : allMeals) {
			friCalfromMeals += Integer.parseInt(i.getText());
		}
		
		applicationStage.setScene(mainScene);
	}
	
	//Makes a new scene for the user to enter the calories eaten from their meals on friday
	@FXML
	void getFriMeals(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		int numberOfMeals = fridaymeals.getValue();
		int rowCounter = 0;
		
		VBox allRows = new VBox();
		ArrayList<TextField> allMeals = new ArrayList<TextField>();
		while (rowCounter < numberOfMeals) {
			rowCounter++;
			HBox mealRow = new HBox();
			
			Label mealLabel = new Label("Meal " + rowCounter);
			TextField mealTextField = new TextField();
			allMeals.add(mealTextField);
			
			mealRow.getChildren().addAll(mealLabel, mealTextField);
			allRows.getChildren().add(mealRow);
		}
		Button doneButton = new Button("Done");
		doneButton.setOnAction(doneEvent -> doFriMeals(mainScene, allMeals));
		allRows.getChildren().add(doneButton);
		
		Scene mMealsScene = new Scene(allRows);
		applicationStage.setScene(mMealsScene);
	}
	
	//Makes a new scene for the user to enter the calories burnt from different workouts on Saturday
	@FXML
	void getSatWorkouts(ActionEvent event) {
		System.out.println("Add sa workouts button was pressed");
	}
	
	//gets the sum of calories from all the meals eaten on saturday
	void doSatMeals(Scene mainScene, ArrayList<TextField> allMeals) {
		satCalfromMeals = 0;
		
		for(TextField i : allMeals) {
			satCalfromMeals += Integer.parseInt(i.getText());
		}
		
		applicationStage.setScene(mainScene);
	}
	
	//Makes a new scene for the user to enter the calories eaten from their meals on saturday
	@FXML
	void getSatMeals(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		int numberOfMeals = saturdaymeals.getValue();
		int rowCounter = 0;
		
		VBox allRows = new VBox();
		ArrayList<TextField> allMeals = new ArrayList<TextField>();
		while (rowCounter < numberOfMeals) {
			rowCounter++;
			HBox mealRow = new HBox();
			
			Label mealLabel = new Label("Meal " + rowCounter);
			TextField mealTextField = new TextField();
			allMeals.add(mealTextField);
			
			mealRow.getChildren().addAll(mealLabel, mealTextField);
			allRows.getChildren().add(mealRow);
		}
		Button doneButton = new Button("Done");
		doneButton.setOnAction(doneEvent -> doSatMeals(mainScene, allMeals));
		allRows.getChildren().add(doneButton);
		
		Scene mMealsScene = new Scene(allRows);
		applicationStage.setScene(mMealsScene);
	}
	
	//Makes a new scene for the user to enter the calories burnt from different workouts on Sunday
@FXML
void getSunWorkouts(ActionEvent event) {
	System.out.println("Add sunday workouts button was pressed");
}

//gets the sum of calories from all the meals eaten on sunday
void doSunMeals(Scene mainScene, ArrayList<TextField> allMeals) {
	sunCalfromMeals = 0;
	
	for(TextField i : allMeals) {
		sunCalfromMeals += Integer.parseInt(i.getText());
	}
	
	applicationStage.setScene(mainScene);
}

//Makes a new scene for the user to enter the calories eaten from their meals on sunday
@FXML
void getSunMeals(ActionEvent event) {
	Scene mainScene = applicationStage.getScene();
	
	int numberOfMeals = sundaymeals.getValue();
	int rowCounter = 0;
	
	VBox allRows = new VBox();
	ArrayList<TextField> allMeals = new ArrayList<TextField>();
	while (rowCounter < numberOfMeals) {
		rowCounter++;
		HBox mealRow = new HBox();
		
		Label mealLabel = new Label("Meal " + rowCounter);
		TextField mealTextField = new TextField();
		allMeals.add(mealTextField);
		
		mealRow.getChildren().addAll(mealLabel, mealTextField);
		allRows.getChildren().add(mealRow);
	}
	Button doneButton = new Button("Done");
	doneButton.setOnAction(doneEvent -> doSunMeals(mainScene, allMeals));
	allRows.getChildren().add(doneButton);
	
	Scene mMealsScene = new Scene(allRows);
	applicationStage.setScene(mMealsScene);
}

@FXML
void setCalCountLabels() {
	netCalories mon = new netCalories(dailyCalorieIntake, caloriesBurnt, monCalfromMeals);
	monCalCount.setText(mon.setCalorieLabel());
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
