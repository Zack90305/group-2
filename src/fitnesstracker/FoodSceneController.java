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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Kaomi and Patricia 
 */
public class FoodSceneController {
    int count = 0;
    @FXML
    TextField totalNum; //  numbers to display at top of menu according to users total calories for the day
    @FXML TextField foodNum;
    @FXML TextField exerciseNum;
    @FXML TextField remainingNum;

    TextField breakfastCal;
    TextField lunchCal;
    TextField dinnerCal;
    
    public void initialize() {
       String calories = DataInput.GetDailyMacros("calories");
       foodNum.setText(calories);
       
       String exerciseCalories = DataInput.GetDailyWorkOutCalories();
       exerciseNum.setText(exerciseCalories);
       
       int result = Integer.parseInt(totalNum.getText()) - Integer.parseInt(calories) + Integer.parseInt(exerciseCalories);
       remainingNum.setText(Integer.toString(result));
    }  


    public void breakfastButtonClicked(){
        this.createNewMealPopup('b');
    }

    public void lunchButtonClicked(){
        this.createNewMealPopup('l');
    }

    public void dinnerButtonClicked(){
        this.createNewMealPopup('d');
    }
    
    public void createNewMealPopup(char mealChar) {
        Stage dinnerStage = new Stage();
        
        VBox questionsBox = new VBox(20);
        Label emptySpace = new Label(" ");
        questionsBox.getChildren().add(emptySpace);
        
        HBox foodNameDataEntry = new HBox(20);
        HBox caloriesDataEntry = new HBox(20);
        HBox fatDataEntry = new HBox(20);
        HBox proteinDataEntry = new HBox(20);
        HBox carbsDataEntry = new HBox(20);
        

        
        Label questionForFoodNameLabel = new Label("Name of Food ");
        Label emptySpace2 = new Label(" ");
        TextField userFoodNameInput= new TextField();
        foodNameDataEntry.getChildren().add(emptySpace2);
        foodNameDataEntry.getChildren().add(questionForFoodNameLabel);
        foodNameDataEntry.getChildren().add(userFoodNameInput);
        
        questionForFoodNameLabel.setPadding(new Insets(0,0,0,10));
        questionForFoodNameLabel.setStyle("-fx-font: 18 arial"); 
        
        Label questionForCaloriesLabel = new Label("Calories ");
        Label emptySpace3 = new Label(" ");
        TextField userCaloriesInput= new TextField();
        caloriesDataEntry.getChildren().add(emptySpace3);
        caloriesDataEntry.getChildren().add(questionForCaloriesLabel);
        caloriesDataEntry.getChildren().add(userCaloriesInput);
        
        questionForCaloriesLabel.setPadding(new Insets(0,0,0,10));
        questionForCaloriesLabel.setStyle("-fx-font: 18 arial"); 

        Label questionForFatLabel = new Label("Fat ");
        Label emptySpace4 = new Label(" ");
        TextField userFatInput= new TextField();
        fatDataEntry.getChildren().add(emptySpace4);
        fatDataEntry.getChildren().add(questionForFatLabel);
        fatDataEntry.getChildren().add(userFatInput);
        
        questionForFatLabel.setPadding(new Insets(0,0,0,10));
        questionForFatLabel.setStyle("-fx-font: 18 arial"); 
        
        Label questionForProteinLabel = new Label("Protein ");
        Label emptySpace5 = new Label(" ");
        TextField userProteinInput = new TextField();
        proteinDataEntry.getChildren().add(emptySpace5);
        proteinDataEntry.getChildren().add(questionForProteinLabel);
        proteinDataEntry.getChildren().add(userProteinInput);
        
        questionForProteinLabel.setPadding(new Insets(0,0,0,10));
        questionForProteinLabel.setStyle("-fx-font: 18 arial"); 
        
        Label questionForCarbsLabel = new Label("Carbs ");
        Label emptySpace6 = new Label(" ");
        TextField userCarbsInput = new TextField();
        carbsDataEntry.getChildren().add(emptySpace6);
        carbsDataEntry.getChildren().add(questionForCarbsLabel);
        carbsDataEntry.getChildren().add(userCarbsInput);
        
        questionForCarbsLabel.setPadding(new Insets(0,0,0,10));
        questionForCarbsLabel.setStyle("-fx-font: 18 arial"); 
        
        HBox enterButton = new HBox(150);
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                DataInput.EnterMeal(mealChar,
                                    userFoodNameInput.getText(),
                                    Integer.parseInt(userCaloriesInput.getText()),
                                    Integer.parseInt(userCarbsInput.getText()),
                                    Integer.parseInt(userFatInput.getText()),
                                    Integer.parseInt(userProteinInput.getText()));
                dinnerStage.close();
            }
        });
        Label emptySpace7 = new Label(" ");
        enterButton.getChildren().add(emptySpace7);
        enterButton.getChildren().add(submitButton);
        
        questionsBox.getChildren().addAll(foodNameDataEntry,caloriesDataEntry,fatDataEntry, proteinDataEntry,carbsDataEntry, enterButton );
        Scene scene = new Scene(questionsBox, 400, 350);
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