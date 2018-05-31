/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnesstracker;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 *
 * @author Luis
 */
public class FitnessTracker extends Application {
    HBox mainScene = new HBox();
    VBox navBar = new VBox();
    Parent foodScene = null;
    Parent bodyScene = null;
    Parent exercisesScene = null;
    
    @Override
    public void start(Stage primaryStage) {
        
        try {
            bodyScene = FXMLLoader.load(getClass().getResource("bodyScene.fxml"));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            foodScene = FXMLLoader.load(getClass().getResource("foodScene.fxml"));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            exercisesScene = FXMLLoader.load(getClass().getResource("exercisesScene.fxml"));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        navBar.setSpacing(40);
        navBar.setPadding(new Insets(100, 40, 0, 40));
        
        Image foodIcon = new Image("/images/foodIcon.png", 62, 62, false, false);
        Button navigateToFoodSceneButton = new Button();
        navigateToFoodSceneButton.setPrefSize(62, 62);
        navigateToFoodSceneButton.setGraphic(new ImageView(foodIcon));
        navigateToFoodSceneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
               mainScene.getChildren().remove(1);
               mainScene.getChildren().add(foodScene);
            }
        });
     
        Image bodyIcon = new Image("/images/bodyIcon.png", 62, 62, false, false);
        Button navigateToBodySceneButton = new Button();
        navigateToBodySceneButton.setPrefSize(62, 62);
        navigateToBodySceneButton.setGraphic(new ImageView(bodyIcon));
        navigateToBodySceneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
               mainScene.getChildren().remove(1);
               mainScene.getChildren().add(bodyScene);
            }
        });
        
        Image exercisesIcon = new Image("/images/excercisesIcon.png", 62, 62, false, false);
        Button navigateToExercisesSceneButton = new Button();
        navigateToExercisesSceneButton.setPrefSize(62, 62);
        navigateToExercisesSceneButton.setGraphic(new ImageView(exercisesIcon));
        navigateToExercisesSceneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
               mainScene.getChildren().remove(1);
               mainScene.getChildren().add(excercisesScene);
            }
        });
        
        navBar.getChildren().add(navigateToFoodSceneButton);
        navBar.getChildren().add(navigateToBodySceneButton);
        navBar.getChildren().add(navigateToExercisesSceneButton);

        mainScene.getChildren().add(navBar);
        mainScene.getChildren().add(bodyScene);
  
        primaryStage.setTitle("Fitness Tracker");
        primaryStage.setScene(new Scene(mainScene, 1450, 720));
        primaryStage.show();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
