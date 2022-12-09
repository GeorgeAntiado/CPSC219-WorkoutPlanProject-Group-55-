package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WorkoutplanController {
	
	//Control for the change in scenes
	Stage stage;
	Scene scene;
	
	//This method is used to change into the "Calorie Calculator" Scene
	public void switchToCalorieCalculatorScene(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/application/CalorieCalculatorView.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	//This method is used to change into the "Eating Plan" Scene
	public void switchToWeeklyEatingPlan(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		VBox root = loader.load(new FileInputStream("src/application/WeeklyEatingPlanView.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		EatingPlanController controller = (EatingPlanController)loader.getController();
		controller.applicationStage = stage;
		
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    
	}

}
