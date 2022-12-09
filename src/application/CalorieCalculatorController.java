package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalorieCalculatorController extends UserInformation{

	public Stage applicationStage;
	public Scene applicationScene;
	
    String heightString;
    String weightString;
    static int numOfCalories; // is static because it is the same across all instances;
    UserInformation newUser;
	
    @FXML
    private ChoiceBox<String> weightGoalsChoicebox;
	
    @FXML
    private ChoiceBox<String> sexChoicebox;

    @FXML
    private ChoiceBox<String> measurementSystem;
    
    @FXML
    private ChoiceBox<String> pointsChoiceBox;

    @FXML
    private TextField ageTextfield;
    
    @FXML
    private Label conversionLabel;

    @FXML
    private Label heightLabel;
    
    @FXML
    private Label weightLabel;
    
    @FXML
    private Label calculatedCalories;
    
    @FXML
    Label errorLabel;

    
    /**
     * Opens new scene for the user to input their height and weight.
     * The user will be given two options to pass data (metric or imperial).
     * @param event
     * @throws IOException
     */
    @FXML
	public void setMeasurementEnvironment(ActionEvent event) throws IOException {
    	
    	String measurementType = measurementSystem.getValue();
        
    	// Switching to metric scene
    	if (measurementType.equals("Metric")) {
    		
    		FXMLLoader loader = new FXMLLoader();
    		VBox root = loader.load(new FileInputStream("src/application/metricSystemView.fxml"));
    		applicationStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		applicationScene = new Scene(root);
    		applicationStage.setScene(applicationScene);
    		applicationStage.show();
    	}
    	// Switching to imperial scene
    	else if (measurementType.equals("Imperial")) {
    		
       		FXMLLoader loader = new FXMLLoader();
    		VBox root = loader.load(new FileInputStream("src/application/imperialSystemView.fxml"));
    		applicationStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		applicationScene = new Scene(root);
    		applicationStage.setScene(applicationScene);
    		applicationStage.show();
    		
    	}
    	
    	System.out.println("Set Button was pressed");
    	System.out.println("Environment set to " + measurementType);
	}

    
    /**
     * Method used to receive data from the Metric/Imperial systems controllers.
     * Updates the instance variables that have been initiated in the class and.
     * Tells the user what their height and weight has been set to.
     * @param newHeight
     * @param newWeight
     */
    void userHeightWeight(String newHeight, String newWeight) {
    	heightString = newHeight;
    	weightString = newWeight;
    	
        heightLabel.setText(String.format("Height is set to: " + heightString + "cm"));
        weightLabel.setText(String.format("Weight is set to: " + weightString + "kg"));
    }
    
    
    /**
     * Collects data from user input. 
     * Manipulates data to show recommended daily base calorie intakes.
     * @param event
     */
    @FXML
    public void calculateCalories(ActionEvent event){
    	errorLabel.setText("");
    	
    	double pointsAchieved = 0.0;
    	double basalMetabolicRate = 0.0;
    	numOfCalories = 0;
    	
    	// Retrieving user input.
    	String activeType = pointsChoiceBox.getValue();
    	int weightGoalsNum = 0;
    	String weightGoals = weightGoalsChoicebox.getValue();
    	String sexEntered = sexChoicebox.getValue();
    	
    	
    	/*
    	 * Creates a UserInformaiton object and validates.
    	 * Calculates the Basal Metabolic Rate to be used in calorie calculations.
    	 */
    	try {
    		UserInformation userInfo = new UserInformation(weightString, heightString, ageTextfield.getText(), sexChoicebox.getValue());
    		newUser = new UserInformation(userInfo);
    		basalMetabolicRate = newUser.calculateBMR();
    	} catch (InvalidNumberException e) {
    		errorLabel.setText(""+e);
    		UserInformation userInfo = new UserInformation(0.0, 0.0, 0, "Male");
    		newUser = new UserInformation(userInfo);
    	}
    
    	/*
    	 * Must find out how often the user work outs.
    	 * To be used in calorie intake calculation.
    	 */
    	if (activeType.equals("1-3 Days of the Week")) {
    		pointsAchieved = 1.375;
    	}else if (activeType.equals("3-5 Days of the Week")) {
    		pointsAchieved = 1.55;
    	}else if (activeType.equals("6-7 Days of the Week")) {
    		pointsAchieved = 1.725;
    	}else if (activeType.equals("Everyday")) {
    		pointsAchieved = 1.9;
    	}else {
    		pointsAchieved = 1.2;
    	}
  
    	/*
    	 * User has three options for weight goals: Bulk, cut, or maintain.
    	 * Depending on their choice, the estimated daily calories needed to consume
    	 * are altered.
    	 */
    	if (weightGoals.equals("Bulk")) {
    		weightGoalsNum = 500;
    	}else if (weightGoals.equals("Cut")) {
    		weightGoalsNum = -500;
    	}else {
    		weightGoalsNum = 0;
    	}
    	
    	System.out.println("CalorieCalculator: BMR = " + basalMetabolicRate + "; points = " + pointsAchieved + "; weight goals = " + weightGoalsNum);
    	
    	// Using UserInformation class to calculate the number of calories.
    	numOfCalories = newUser.calculateNumCalories(pointsAchieved, weightGoalsNum);
    	System.out.println("Calorie Calculator: Number of calories = " + numOfCalories);
    	
    	calculatedCalories.setText("Estimated Daily Calories: " + numOfCalories);
    	
    	System.out.println("Calculate Button was pressed.");
    }

    
    /**
     * This method is used to return into the  "Main menu" Scene.
     * Source: Bro Code Video - JavaFX switch scenes (https://www.youtube.com/watch?v=hcM-R-YOKkQ).
	 * This source was used for the methods to allow us to switch into different scenes.
     * @param event
     * @throws IOException
     */
	public void switchToMainMenu(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/application/WorkoutPlanView1.fxml"));
		applicationStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		applicationScene = new Scene(root);
		applicationStage.setScene(applicationScene);
		applicationStage.show();
	}
	
}
