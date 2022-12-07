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
	
	//variables to track calories eaten from all meals
	int calfromMeals = 0;
	
	//variable to track calories eaten from all workouts
	int caloriesBurnt = 0;
	
	//Control for the  change in scenes
			private Stage stage;
			private Scene scene;
	
	@FXML
	ChoiceBox<Integer> meals;
	
	@FXML
	ChoiceBox<Integer> workouts;
	
	@FXML
	Label calCount;
	
	@FXML
	Label errorLabel;
	
	//variable to store the maitenance calories 
	int originalCalorieMaitenance = 2200;
	
	//variable that changes that tells the amount of calories that the user needs to eat with the calfromMeals 
	//and caloriesBurnt variables into account
	int manipulatedCalorieMaintenance = originalCalorieMaitenance;
	
	
	//collects the input from the workouts scene and calculates the calories burnt 
	public int doWorkouts(Scene mainScene, ArrayList<String> allExTypes, ArrayList<String> allExIntensity,
			ArrayList<TextField> allExLengths) throws InvalidNumberException {
		
		caloriesBurnt= 0;
		int b = 0;
		
			while (b< allExTypes.size()) {
				String lengths = "";
				if (allExLengths != null) {
				lengths = allExLengths.get(b).getText();
				}
				else {
					lengths = "";
				}
				exercise a = new exercise(allExTypes.get(b), allExIntensity.get(b), lengths);
				
				caloriesBurnt += a.getcaloriesBurnt();
				b++;
			}
		
		
		
		applicationStage.setScene(mainScene);
		return caloriesBurnt;
	}
	
	
	//Makes a new scene for the user to enter the calories burnt from different workouts
	@FXML
	void getWorkouts(ActionEvent event) {
		
		Scene mainScene = applicationStage.getScene();
		
		int numberOfWorkouts = workouts.getValue();
		int rowCounter = 0;
		ArrayList<String> allExTypes = new ArrayList<String>();
		ArrayList<String> allExIntensity = new ArrayList<String>();
		ArrayList<TextField> allExLengths = new ArrayList<TextField>();
		
		VBox allRows = new VBox();
		
		if (numberOfWorkouts == 0) {
			allExTypes.add("Cardio");
			allExIntensity.add("Light");
			TextField g = new TextField("0");
			allExLengths.add(g);
		}
		else if (numberOfWorkouts !=0) {
		
		
		Label intensityAdvice = new Label("Tips about intensity: "
				+ " Light is as difficult as walking."
				+ " Moderate is as arduous as jogging."
				+ " Intense is as hard as sprinting.");
		allRows.getChildren().add(intensityAdvice);
		
		while (rowCounter < numberOfWorkouts) {
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
			exIntensityChoiceBox.getItems().add("Intense");
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
		}
		
		Label errorLabel = new Label("");
		Button doneButton = new Button("Done");
		
		doneButton.setOnAction(doneEvent -> {
			try {
				doWorkouts(mainScene, allExTypes, allExIntensity,  allExLengths);
			} catch (InvalidNumberException e) {
				// TODO Auto-generated catch block
				errorLabel.setText(""+e);
			}
		});
		allRows.getChildren().add(errorLabel);
		allRows.getChildren().add(doneButton);
		
		Scene mWorkoutsScene = new Scene(allRows);
		applicationStage.setScene(mWorkoutsScene);
		
	}


	////gets the sum of calories from all the meals eaten on monday
	public int doMeals(Scene mainScene, ArrayList<TextField> allMeals) throws InvalidNumberException{
		calfromMeals = 0;
		
		for(TextField i : allMeals) {
			if (i!= null) {
				String str = i.getText();
				for (char j : str.toCharArray()) {
					   // Check if character is a digit. 
					   if (!Character.isDigit(j)) {
						   throw new InvalidNumberException("Don't use " + j + " in your age. Make sure to enter an integer.");
					   }
				}
						
				calfromMeals += Integer.parseInt(i.getText());
				if(calfromMeals<0) {
					throw new InvalidNumberException("You entered a negative number. Please make sure all numbers are greater than 0.");
				}
			}
		}
		applicationStage.setScene(mainScene);
		return calfromMeals;
	}
	
	//Makes a new scene for the user to enter the calories eaten from their meals 
	@FXML
	void getMeals(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		int numberOfMeals = meals.getValue();
		int rowCounter = 0;
		
		VBox allRows = new VBox();
		
		Label userPrompt = new Label("Please enter the amount of calories consumed per meal.");
		allRows.getChildren().add(userPrompt);
		
		Label mealAdvice = new Label("");
		if (numberOfMeals ==1) {
			mealAdvice.setText("This meal should be about " + manipulatedCalorieMaintenance + " calories");
		}else if (numberOfMeals == 2) {
			mealAdvice.setText("Each meal should be around" + manipulatedCalorieMaintenance/2 + " calories. "
					+ "One meal should be consumed in the morning and the other in the evening.");
		}else if (numberOfMeals == 3) {
			mealAdvice.setText("Each meal should be around" + manipulatedCalorieMaintenance/3 + " calories. "
					+ "Can be eaten like the conventional three square meals breakfast, lunch, and dinner.");
		}else if (numberOfMeals == 4) {
			mealAdvice.setText("Each meal should be around" + manipulatedCalorieMaintenance/4 + " calories. "
					+ "Each meal can be eaten around every 4.5 hours.");
		}else if (numberOfMeals == 5) {
			mealAdvice.setText("Each meal should be around" + manipulatedCalorieMaintenance/5 + " calories. "
					+ "Each meal can be eaten around every  3.5 hours.");
		}else if (numberOfMeals == 6) {
			mealAdvice.setText("Each meal should be around" + manipulatedCalorieMaintenance/6 + " calories. "
					+ "Each meal can be eaten around every  3 hours.");
		}else if (numberOfMeals == 7) {
			mealAdvice.setText("Each meal should be around" + manipulatedCalorieMaintenance/7 + " calories. "
					+ "Each meal can be eaten around every  2.5 hours.");
		}else if (numberOfMeals == 8) {
			mealAdvice.setText("Each meal should be around" + manipulatedCalorieMaintenance/8 + " calories. "
					+ "Each meal can be eaten around every  2 hours.");
		}
		allRows.getChildren().add(mealAdvice);
		
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
		Label errorLabel2 = new Label("");
		Button doneButton = new Button("Done");
		doneButton.setOnAction(doneEvent -> {
			try {
				doMeals(mainScene, allMeals);
			} catch (InvalidNumberException e) {
				// TODO Auto-generated catch block
				errorLabel2.setText(""+e);
			}
		});
		allRows.getChildren().add(errorLabel2);
		allRows.getChildren().add(doneButton);
		
		Scene mMealsScene = new Scene(allRows);
		applicationStage.setScene(mMealsScene);
	}

//sets the calcount label to tell the user how many calories they need to eat in comparison to their calorie goal
@FXML
void setCalCountLabel() {
	netCalories now = new netCalories(manipulatedCalorieMaintenance, caloriesBurnt, calfromMeals);
	manipulatedCalorieMaintenance = now.calcNetCalories();
	calCount.setText(now.setCalorieLabel());
	caloriesBurnt = 0;
	calfromMeals =0;
}

//resets values to calculate the calories for a new day
public void newDay(ActionEvent event) {
	manipulatedCalorieMaintenance = originalCalorieMaitenance;
	caloriesBurnt = 0;
	calfromMeals = 0;
	calCount.setText("");
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
