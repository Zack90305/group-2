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
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


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
    @FXML private Text caloriesLostText;
    
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
        
        //caloriesLostText.setText(DataInput.GetDailyWorkOutCalories());
        
        
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
        
        Image exercisesIcon = new Image("/images/exercisesIcon.png", 62, 62, false, false);
        Button navigateToExercisesSceneButton = new Button();
        navigateToExercisesSceneButton.setPrefSize(62, 62);
        navigateToExercisesSceneButton.setGraphic(new ImageView(exercisesIcon));
        navigateToExercisesSceneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
               mainScene.getChildren().remove(1);
               mainScene.getChildren().add(exercisesScene);
            }
        });
        
        navBar.getChildren().add(navigateToFoodSceneButton);
        navBar.getChildren().add(navigateToBodySceneButton);
        navBar.getChildren().add(navigateToExercisesSceneButton);

        mainScene.getChildren().add(navBar);
        mainScene.getChildren().add(foodScene);
  
        primaryStage.setTitle("Fitness Tracker");
        primaryStage.setScene(new Scene(mainScene, 1450, 720));
        primaryStage.show();
        
        if( DataInput.GetWeight()[0].equals("no")) {
            System.out.println("sdf");
            this.renderUserPopup();
        }
    }
    
        
    public void renderUserPopup() {
        Stage exerciseStage = new Stage();
        HBox sexDataEntry = new HBox(20);
        HBox weightDataEntry = new HBox(20);
        HBox heightDataEntry = new HBox(20);
        VBox dataBox = new VBox(20);
        Label emptySpace = new Label(" ");
        
        dataBox.getChildren().add(emptySpace);
        
        Label questionForSexLabel = new Label("Enter Your Sex (M/F): ");
        Label emptySpace2 = new Label(" ");
        TextField userSexInput = new TextField();
        sexDataEntry.getChildren().add(emptySpace2);
        sexDataEntry.getChildren().add(questionForSexLabel);
        sexDataEntry.getChildren().add(userSexInput);
        
        questionForSexLabel.setPadding(new Insets(0,0,0,10));
        questionForSexLabel.setStyle("-fx-font: 18 arial");
        
        
        Label questionForWeightLabel = new Label("Enter Your Weight: ");
        Label emptySpace4 = new Label(" ");
        TextField userWeightInput = new TextField();
        weightDataEntry.getChildren().add(emptySpace4);
        weightDataEntry.getChildren().add(questionForWeightLabel);
        weightDataEntry.getChildren().add(userWeightInput);
        
        questionForWeightLabel.setPadding(new Insets(0,0,0,10));
        questionForWeightLabel.setStyle("-fx-font: 18 arial");
        
        Label questionForHeightLabel = new Label("Enter Your Height in Centimeters: ");
        Label emptySpace5 = new Label(" ");
        TextField userHeightInput = new TextField();
        heightDataEntry.getChildren().add(emptySpace5);
        heightDataEntry.getChildren().add(questionForHeightLabel);
        heightDataEntry.getChildren().add(userHeightInput);
        
        questionForHeightLabel.setPadding(new Insets(0,0,0,10));
        questionForHeightLabel.setStyle("-fx-font: 18 arial");
        
        
        /*
        caloriesBurned.setPadding(new Insets(0,0,0,10));
        dataEntry.getChildren().add(caloriesBurned);
        caloriesBurned.setStyle("-fx-font: 18 arial");
        */
        
        dataBox.getChildren().add(sexDataEntry);
        dataBox.getChildren().add(weightDataEntry);
        dataBox.getChildren().add(heightDataEntry);
        
        
        HBox enterButton = new HBox(230);
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                DataInput.EnterWeight(userSexInput.getText().charAt(0), 
                        Integer.parseInt(userHeightInput.getText()), 
                        Integer.parseInt(userWeightInput.getText()));
                exerciseStage.close();
            }
        });
        Label emptySpace3 = new Label(" ");
        enterButton.getChildren().add(emptySpace3);
        enterButton.getChildren().add(submitButton);
        
        dataBox.getChildren().add(enterButton);
        
        Scene scene = new Scene(dataBox, 500, 250);
        exerciseStage.setScene(scene);
        exerciseStage.show();
    }

  
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}