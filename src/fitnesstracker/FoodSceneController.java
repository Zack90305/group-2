/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnesstracker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author Luis
 */
public class FoodSceneController {
    int count = 0;
    @FXML
    TextField totalNum; //  numbers to display at top of menu according to users total calories for the day
    TextField foodNum;
    TextField exerciseNum;
    TextField remainingNum;

    TextField breakfastCal;
    TextField lunchCal;
    TextField dinnerCal;


    public void breakfastButtonClicked(){

        Stage breakfastStage = new Stage();
        
        VBox questions = new VBox();
        
        HBox nameBox = new HBox();
        Text name = new Text("Name ");
        TextField foodName = new TextField();
        nameBox.getChildren().addAll(name, foodName);
        
        HBox caloriesBox = new HBox();
        Text calories = new Text("calories ");
        TextField foodCalories = new TextField();
        caloriesBox.getChildren().addAll(calories, foodCalories);
        
        HBox fatBox = new HBox();
        Text fat = new Text("Fat ");
        TextField foodFat = new TextField();
        fatBox.getChildren().addAll(fat, foodFat);
        
        HBox proteinBox = new HBox();
        Text protein = new Text("Protein ");
        TextField foodProtein = new TextField();
        proteinBox.getChildren().addAll(protein, foodProtein);
        
        HBox carbBox = new HBox();
        Text carbs = new Text("Carbs ");
        TextField foodCarbs = new TextField();
        carbBox.getChildren().addAll(carbs, foodCarbs);
        
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                DataInput.EnterMeal('b',
                                    name.getText(),
                                    Integer.parseInt(foodCalories.getText()),
                                    Integer.parseInt(foodCarbs.getText()),
                                    Integer.parseInt(foodFat.getText()),
                                    Integer.parseInt(foodProtein.getText()));
                breakfastStage.close();
            }
        });
        
        questions.getChildren().addAll(nameBox, caloriesBox, fatBox, proteinBox, carbBox, submitButton);
        
        
        Scene scene = new Scene(questions, 500, 170);
        breakfastStage.setScene(scene);
        breakfastStage.show();


    }

    public void lunchButtonClicked(){
        Stage lunchStage = new Stage();
        
        VBox questions = new VBox();
        
        HBox nameBox = new HBox();
        Text name = new Text("Name ");
        TextField foodName = new TextField();
        nameBox.getChildren().addAll(name, foodName);
        
        HBox caloriesBox = new HBox();
        Text calories = new Text("calories ");
        TextField foodCalories = new TextField();
        caloriesBox.getChildren().addAll(calories, foodCalories);
        
        HBox fatBox = new HBox();
        Text fat = new Text("Fat ");
        TextField foodFat = new TextField();
        fatBox.getChildren().addAll(fat, foodFat);
        
        HBox proteinBox = new HBox();
        Text protein = new Text("Protein ");
        TextField foodProtein = new TextField();
        proteinBox.getChildren().addAll(protein, foodProtein);
        
        HBox carbBox = new HBox();
        Text carbs = new Text("Carbs ");
        TextField foodCarbs = new TextField();
        carbBox.getChildren().addAll(carbs, foodCarbs);
        
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                DataInput.EnterMeal('b',
                                    name.getText(),
                                    Integer.parseInt(foodCalories.getText()),
                                    Integer.parseInt(foodCarbs.getText()),
                                    Integer.parseInt(foodFat.getText()),
                                    Integer.parseInt(foodProtein.getText()));
                lunchStage.close();
            }
        });
        
        questions.getChildren().addAll(nameBox, caloriesBox, fatBox, proteinBox, carbBox, submitButton);
        
        
        Scene scene = new Scene(questions, 500, 170);
        lunchStage.setScene(scene);
        lunchStage.show();
    }

    public void dinnerButtonClicked(){
        Stage dinnerStage = new Stage();
        
        VBox questions = new VBox();
        
        HBox nameBox = new HBox();
        Text name = new Text("Name ");
        TextField foodName = new TextField();
        nameBox.getChildren().addAll(name, foodName);
        
        HBox caloriesBox = new HBox();
        Text calories = new Text("calories ");
        TextField foodCalories = new TextField();
        caloriesBox.getChildren().addAll(calories, foodCalories);
        
        HBox fatBox = new HBox();
        Text fat = new Text("Fat ");
        TextField foodFat = new TextField();
        fatBox.getChildren().addAll(fat, foodFat);
        
        HBox proteinBox = new HBox();
        Text protein = new Text("Protein ");
        TextField foodProtein = new TextField();
        proteinBox.getChildren().addAll(protein, foodProtein);
        
        HBox carbBox = new HBox();
        Text carbs = new Text("Carbs ");
        TextField foodCarbs = new TextField();
        carbBox.getChildren().addAll(carbs, foodCarbs);
        
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                DataInput.EnterMeal('d',
                                    name.getText(),
                                    Integer.parseInt(foodCalories.getText()),
                                    Integer.parseInt(foodCarbs.getText()),
                                    Integer.parseInt(foodFat.getText()),
                                    Integer.parseInt(foodProtein.getText()));
                dinnerStage.close();
            }
        });
        
        questions.getChildren().addAll(nameBox, caloriesBox, fatBox, proteinBox, carbBox, submitButton);
        
        
        Scene scene = new Scene(questions, 500, 170);
        dinnerStage.setScene(scene);
        dinnerStage.show();

    }


    public void recipeButtonClicked(){
        Stage recipePageStage = new Stage();
        Image recipePageImage = null;
        
        HBox recipePageBox = new HBox();
        
        try {
            recipePageImage = new Image("/images/Healthy Recipes.png");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        ImageView recipePage = new ImageView(recipePageImage);
        recipePageBox.getChildren().add(recipePage);
        
        Scene recipePageScene = new Scene(recipePageBox, 939, 516);
        recipePageStage.setScene(recipePageScene);
        recipePageStage.show();
    }
}
