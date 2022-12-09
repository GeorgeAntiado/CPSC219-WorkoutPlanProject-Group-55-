package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class is used by CalorieCalculatorController to get the user's height and weight
 * in imperial measurements and convert to metric measurements.
 * @author CS219-user
 */
public class ImperialSystemController {
	Stage applicationStage;
	Scene applicationScene;
	Parent applicationRoot;

    @FXML
    private TextField userHeightFT;

    @FXML
    private TextField userHeightInch;

    @FXML
    private TextField userWeightLBS;
    
    @FXML
    Label errorLabel2;
	

    /**
     * This method is used to send the information from this scene to the CalorieCalculatorController
     * @param event
     * @throws IOException
     */
	public void switchToCalorieCalculatorScene(ActionEvent event) throws IOException{
		errorLabel2.setText("");
		
		String userHeightImperialInch = userHeightInch.getText();
		String userHeightImperialFT = userHeightFT.getText();
		String userWeightImperialLBS = userWeightLBS.getText();
		
		/*
		 * Metric System Conversion
		 * The calculator will only calculate in the metric system.
		 * First Convert Inches to Centimeters then Feet to Centimeters and add to get total height in Centimeters.
		 * Will also convert LBS to KG.
		 * Try/Catch makes sure user enters an integer. Also validates integer > 0.
		 */
		double heightInCm = 0.0;
		double weightInKg = 0.0;
		
		try {
			heightInCm = (Integer.parseInt(userHeightImperialInch) * 2.54) + (Integer.parseInt(userHeightImperialFT) * 30.48);
			weightInKg = (Integer.parseInt(userWeightImperialLBS) * 0.454);

			String convertedUserHeight = Double.toString(heightInCm);
			String convertedUserWeight = Double.toString(weightInKg);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("CalorieCalculatorView.fxml"));
			applicationRoot = loader.load();
			
			CalorieCalculatorController newUserHeight = loader.getController();
			newUserHeight.userHeightWeight(convertedUserHeight, convertedUserWeight);
			
			if(heightInCm > 0 && weightInKg > 0) {
				applicationStage = (Stage)((Node)event.getSource()).getScene().getWindow();
				applicationScene = new Scene(applicationRoot);
				applicationStage.setScene(applicationScene);
				applicationStage.show();
			} else {
				errorLabel2.setText("Please enter a value greater than zero.");
			}
		} catch (NumberFormatException e) {
			errorLabel2.setText("Please make sure to enter an integer.");
		}
		
	}
}
