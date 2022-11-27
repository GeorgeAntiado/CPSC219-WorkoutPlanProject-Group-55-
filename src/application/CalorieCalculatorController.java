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
	Stage applicationStage;
	Scene applicationScene;

	/**
	 * Calorie Calculator Controller
	 */
	
    @FXML
    private ChoiceBox<String> calorieIntakePurpose;
	
    @FXML
    private ChoiceBox<String> genderChoicebox;

    @FXML
    private TextField ageTextfield;

    @FXML
    private ChoiceBox<String> measurementSystem;

    /*
     * Opens new scene for user to input their height and weight
     */
    @FXML
    void setMeasurementEnvironment(ActionEvent enterMeasurementSystemStage){

    	
//    	String measurementType = measurementSystem.getValue();
//    	
//    	if (measurementType == "Metric") {
//    		//Add elements for Metric System
//    		VBox elementContainer = new VBox();
//    		HBox heightContainer = new HBox();
//    		HBox weightContainer = new HBox();
//    		Label systemTypeLabel = new Label("metric");
//    		Label heightLabel = new Label("Height");
//    		Label weightLabel = new Label("Weight");
//    		Label cmLabel = new Label("cm");
//    		Label kgLabel = new Label("kg");
//    		TextField heightTextField = new TextField();
//    		TextField weightTextField = new TextField();
//    		
//    		heightContainer.getChildren().addAll(heightLabel, heightTextField, cmLabel);
//    		weightContainer.getChildren().addAll(weightLabel, weightTextField, kgLabel);
//    		
//    		elementContainer.getChildren().addAll(systemTypeLabel, heightContainer, weightContainer);
    		Label myLabel = new Label("this works"); 
    		Scene metricSystemScene = new Scene(myLabel);
    		applicationStage.setScene(metricSystemScene);
    		
    		System.out.println("Metric System Set");
    		
//    	}
//    	if (measurementType == "Imperial") {
//    		//Add elements for Imperial System
//    		VBox elementContainer = new VBox();
//    		HBox heightContainer = new HBox();
//    		HBox weightContainer = new HBox();
//    		Label systemTypeLabel = new Label(measurementType);
//    		Label heightLabel = new Label("Height");
//    		Label weightLabel = new Label("Weight");
//    		Label feetLabel = new Label("feet");
//    		Label inchLabel = new Label("inch");
//    		Label poundsLabel = new Label("lbs");
//    		TextField heightFeetTextField = new TextField();
//    		TextField heightInchTextField = new TextField();
//    		TextField weightTextField = new TextField();
//    		
//    		heightContainer.getChildren().addAll(heightLabel, heightFeetTextField, feetLabel, heightInchTextField, inchLabel );
//    		weightContainer.getChildren().addAll(weightLabel, weightTextField, poundsLabel);
//    		
//    		elementContainer.getChildren().addAll(systemTypeLabel, heightContainer, weightContainer);
//    		
//    		Scene imperialSystemScene = new Scene(elementContainer);
//    		applicationStage.setScene(imperialSystemScene);
//    		
//    		System.out.println("Imperial System Set");
//    		
//    	}
//
//		
//		
//    	System.out.println("Set button was pressed");
    	
    }
    
   /*
    * Once the user inputs the data required. It is manipulated
    * to show their recommended calorie intakes.
    */
    @FXML
    void calculateCalories(ActionEvent event) {
    	double basalMetabolicRate = 0.0;
    	int numOfCalories = 0;
    	
    	
    	
    	
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
