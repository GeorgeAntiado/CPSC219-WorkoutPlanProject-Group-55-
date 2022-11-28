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
    private ChoiceBox<String> calorieIntakePurpose;
	
    @FXML
    private ChoiceBox<String> sexChoicebox;

    @FXML
    private ChoiceBox<String> measurementSystem;
    
    @FXML
    private ChoiceBox<String> pointsChoiceBox;

    @FXML
    private TextField ageTextfield;
    
    @FXML
    private Label measurementEnvironmentLabel;

    @FXML
    private Label heightLabel;
    
    @FXML
    private Label weightLabel;

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
    
    
    void userHeightWeight(String newHeight, String newWeight) {
    	double heightEntered = Double.parseDouble(newHeight);
    	double weightEntered = Double.parseDouble(newWeight);
    	
//    	//Calculate BMR (Different Calculations for male and female)
//    	if (sexEntered.equals("Male")) {
//    		basalMetabolicRate = (88.362 + (13.397 * weightEntered) + (4.799 * heightEntered)) - (5.677 * ageEntered);
//    	}
//    	else if (sexEntered.equals("Female")) {
//    		basalMetabolicRate = (447.593 + (9.247 * weightEntered) + (3.098 * heightEntered)) - (4.33 *ageEntered);
//    	}
    	
    	//Must find out how often the user work outs
    	
    	heightLabel.setText("Height is set to: " + newHeight);
      	weightLabel.setText("Weight is set to: " + newWeight); 
    }
    
    
    
   /*
    * Once the user inputs the data required. It is manipulated
    * to show their recommended calorie intakes.
    */
    @FXML
    public void calculateCalories(ActionEvent event){
    	String activeType = pointsChoiceBox.getValue();
    	double pointsAchieved = 0.0;
    	
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
