package application;

import java.io.FileInputStream;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
	
	
	public void switchToCalorieCalculatorScene(ActionEvent event) throws IOException{
		String userHeightImperialInch = userHeightInch.getText();
		String userHeightImperialFT = userHeightFT.getText();
		String userWeightImperialLBS = userWeightLBS.getText();
		
		/*
		 * Metric System Conversion
		 * The calculator will only calculate in the metric system
		 * First Convert Inches to Centimeters then Feet to Centimeters and add to get total height in Centimeters
		 * Will also need to convert LBS to KG
		 */
		double heightInCm = (Integer.parseInt(userHeightImperialInch) * 2.54) + (Integer.parseInt(userHeightImperialFT) * 30.48);
		double weightInKg = (Integer.parseInt(userWeightImperialLBS) * 0.454);
		
		String convertedUserHeight = Double.toString(heightInCm);
		String convertedUserWeight = Double.toString(weightInKg);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("CalorieCalculatorView.fxml"));
		applicationRoot = loader.load();
		
		CalorieCalculatorController newUserHeight = loader.getController();
		newUserHeight.userHeightWeight(convertedUserHeight, convertedUserWeight);
		

		applicationStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		applicationScene = new Scene(applicationRoot);
		applicationStage.setScene(applicationScene);
		applicationStage.show();
	}
}
