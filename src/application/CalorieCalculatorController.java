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
	


	/**
	 * Calorie Calculator Controller
	 */
	
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
     * Opens new scene for user to input their height and weight
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
    double heightEntered;
    double weightEntered;
    
    //Method used to receive data from the Metric/Imperial systems scenes
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
    	int weightGoalsNum = 500;
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
    	
    	//Must find out how often the user work outs
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
    	
    	numOfCalories = basalMetabolicRate * pointsAchieved;
    	
    	if (weightGoals.equals("Bulk")) {
    		numOfCalories = numOfCalories + weightGoalsNum;
    	}else if (weightGoals.equals("Cut")) {
    		numOfCalories = numOfCalories - weightGoalsNum;
    	}else {
    		numOfCalories = numOfCalories + 0;
    	}
    	
    	calculatedCalories.setText(String.format("Estimated Daily Calories: %.0f", numOfCalories));
    	System.out.println(numOfCalories);
    	System.out.println("Calculate Button was pressed.");
    }
    
	//This method is used to change into the "Main Menu" Scene
	public void switchToMainMenu(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/application/WorkoutPlanView1.fxml"));
		applicationStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		applicationScene = new Scene(root);
		applicationStage.setScene(applicationScene);
		applicationStage.show();
	}
	
}
