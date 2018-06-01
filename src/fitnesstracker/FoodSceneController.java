/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnesstracker;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;

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

        String mine = Integer.toString(count);
        System.out.println("Breakfast button clicked");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Breakfast Dialog");
        alert.setHeaderText(null);
        alert.setContentText("You just pressed the breakfast button!");
        alert.showAndWait();




    }

    public void lunchButtonClicked(){
        System.out.println("Lunch Button clicked");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Lunch Dialog");
        alert.setHeaderText(null);
        alert.setContentText("You just pressed the lunch button!");
        alert.showAndWait();
    }

    public void dinnerButtonClicked(){
        System.out.println("Dinner button clicked");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Dinner Dialog");
        alert.setHeaderText(null);
        alert.setContentText("You just pressed the dinner button!");
        alert.showAndWait();

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
