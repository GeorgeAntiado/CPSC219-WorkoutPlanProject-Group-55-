package application;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This class is used by CalorieCalculatorController to get the user's height and weight
 * in in metric measurements.
 * @author CS219-user
 */
public class MetricSystemController {
	Stage applicationStage;
	Scene applicationScene;
	Parent applicationRoot;

    @FXML
    private TextField userWeight;

    @FXML
    private TextField userHeight;
    
    /**
     * This method is used to send the information from this scene to 
     * the CalorieCalculatorController.
     * Source: Bro Code Video - JavaFX communication between controllers (https://www.youtube.com/watch?v=wxhGKR3PQpo&t=55s)
     * @param event
     * @throws IOException
     */
	public void switchToCalorieCalculatorScene(ActionEvent event) throws IOException{
		
		String userHeightMetric = userHeight.getText();
		String userWeightMetric = userWeight.getText();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("CalorieCalculatorView.fxml"));
		applicationRoot = loader.load();
		
		CalorieCalculatorController newUserHeight = loader.getController();
		newUserHeight.userHeightWeight(userHeightMetric, userWeightMetric);
		

		applicationStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		applicationScene = new Scene(applicationRoot);
		applicationStage.setScene(applicationScene);
		applicationStage.show();
	}
}

