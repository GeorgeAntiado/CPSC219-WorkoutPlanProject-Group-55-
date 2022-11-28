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

public class MetricSystemController {
	Stage applicationStage;
	Scene applicationScene;
	Parent applicationRoot;

    @FXML
    private TextField userWeight;

    @FXML
    private TextField userHeight;
    
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
