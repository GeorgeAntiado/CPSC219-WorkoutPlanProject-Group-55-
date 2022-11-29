package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalorieCalculatorController {
	public Stage applicationStage;
	public Scene applicationScene;
	
    double heightEntered;
    double weightEntered;
	
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

    /*
     * Opens new scene for the user to input their height and weight.
     * The user will be given two options to pass data
     * Either Metric or Imperial.
     */
    @FXML
	public void setMeasurementEnvironment(ActionEvent event) throws IOException {
    	
    	String measurementType = measurementSystem.getValue();
        
    	
    	if (measurementType.equals("Metric")) {
    		
    		FXMLLoader loader = new FXMLLoader();
    		VBox root = loader.load(new FileInputStream("src/application/metricSystemView.fxml"));
    		applicationStage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		applicationScene = new Scene(root);
    		applicationStage.setScene(applicationScene);
    		applicationStage.show();
    	}
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
      * Method used to receive data from the Metric/Imperial systems controllers to the CalorieCalculatorContrillers.
      * It updates the instance variables that have been initiated in the class and
      * will also prompt the user what their height and weight has been set to
      * @param newHeight
      * @param newWeight
      */
    void userHeightWeight(String newHeight, String newWeight) {
    	heightEntered = Double.parseDouble(newHeight);
    	weightEntered = Double.parseDouble(newWeight);
    	
        heightLabel.setText(String.format("Height is set to: %.1f Cm", heightEntered ));
        weightLabel.setText(String.format("Weight is set to: %.1f Kg", weightEntered ));
    }
    
   /*
    * Once the user inputs the data required. It is manipulated
    * to show their recommended calorie intakes.
    */
    @FXML
    public void calculateCalories(ActionEvent event){
    	double pointsAchieved = 0.0;
    	double basalMetabolicRate = 0.0;
    	double numOfCalories = 0.0;
    	
    	int ageEntered = Integer.parseInt(ageTextfield.getText());
    	int weightGoalsNum = 0;
    	String activeType = pointsChoiceBox.getValue();
    	String sexEntered = sexChoicebox.getValue();
    	String weightGoals = weightGoalsChoicebox.getValue();
    	
    	
    	//Calculate BMR (Different Calculations for male and female)
    	if (sexEntered.equals("Male")) {
    		basalMetabolicRate = (88.362 + (13.397 * weightEntered) + (4.799 * heightEntered)) - (5.677 * ageEntered);
    	}
    	else if (sexEntered.equals("Female")) {
    		basalMetabolicRate = (447.593 + (9.247 * weightEntered) + (3.098 * heightEntered)) - (4.33 * ageEntered);
    	}
    	
    	/*
    	 * Must find out how often the user work outs
    	 * This will later be multiplied by the BMR that was calculated previously
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
    	 * Depending on what goals the user has with their diet,
    	 * they will be given the option to either bulk, cut or maintain which will alter
    	 * the estimated daily calories needed to consume
    	 */
    	if (weightGoals.equals("Bulk")) {
    		weightGoalsNum = 500;
    	}else if (weightGoals.equals("Cut")) {
    		weightGoalsNum = -500;
    	}else {
    		weightGoalsNum = 0;
    	}
    	
    	numOfCalories = basalMetabolicRate * pointsAchieved + weightGoalsNum;
    	
    	calculatedCalories.setText(String.format("Estimated Daily Calories: %.0f", numOfCalories));
    	System.out.println(numOfCalories);
    	System.out.println("Calculate Button was pressed.");
    }
    
	//This method is used to return into the "Main Menu" or "Home Page"Scene
	public void switchToMainMenu(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/application/WorkoutPlanView1.fxml"));
		applicationStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		applicationScene = new Scene(root);
		applicationStage.setScene(applicationScene);
		applicationStage.show();
	}
	
}
