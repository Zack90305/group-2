/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnestracker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 *
 * @author jesus
 */
public class BodySceneController implements Initializable {
    
    private Label label;
    @FXML
    private Button BodyFat;
    @FXML
    private Button BMRBtn;
    @FXML
    private Button BMIBtn;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void BodyFatCalculator() {
        Pane root= new Pane();
       TextField tfName = new TextField();
       TextField tfAge = new TextField();
       TextField tfHeight = new TextField();
       TextField tfWeight = new TextField();
       TextField tfBodyFat = new TextField();
       Button btCalculate = new Button("Calculate");
        Stage stage = new Stage();
        stage.setTitle("BodyFat%Calculator");
        stage.setScene(new Scene(root, 450, 450));
       
     GridPane gridPane = new GridPane();
         gridPane.setHgap(5);
         gridPane.setVgap(5);
        
         gridPane.add(new Label("Name:"), 0, 0);
         gridPane.add(tfName, 1, 0);
         gridPane.add(new Label("Age:"), 0, 1);
         gridPane.add(tfAge, 1, 1);
         gridPane.add(new Label("Height:"), 0, 2);
         gridPane.add(tfHeight, 1, 2);
         gridPane.add(new Label("Weight:"), 0, 3);
         gridPane.add(tfWeight, 1, 3);
         gridPane.add(new Label("BodyFat:"), 0, 4);
         gridPane.add(tfBodyFat, 1, 4);
         gridPane.add(btCalculate, 1, 5);
         gridPane.setAlignment(Pos.CENTER);
         
          tfName.setAlignment(Pos.BOTTOM_RIGHT);
          tfAge.setAlignment(Pos.BOTTOM_RIGHT);
          tfHeight.setAlignment(Pos.BOTTOM_RIGHT);
          tfWeight.setAlignment(Pos.BOTTOM_RIGHT);
          tfBodyFat.setAlignment(Pos.BOTTOM_RIGHT);
          tfBodyFat.setEditable(false);
         
          GridPane.setHalignment(btCalculate, HPos.RIGHT);

        
        
        
         root.getChildren().add(gridPane);
      
       stage.show();
        //System.out.println("This is a BodyFat% Calculator");
    }
    


    @FXML
    private void BMICalaculator() {
       Pane root= new Pane();
       TextField tfName = new TextField();
       TextField tfAge = new TextField();
       TextField tfHeight = new TextField();
       TextField tfWeight = new TextField();
       TextField tfBMI = new TextField();
       Button btCalculate = new Button("Calculate");
      // Button btClear = new Button("Clear");
        Stage stage = new Stage();
        stage.setTitle("BMICalculator");
        stage.setScene(new Scene(root, 450, 450));
         GridPane gridPane = new GridPane();
         gridPane.setHgap(5);
         gridPane.setVgap(5);
        
         gridPane.add(new Label("Name:"), 0, 0);
         gridPane.add(tfName, 1, 0);
         gridPane.add(new Label("Age:"), 0, 1);
         gridPane.add(tfAge, 1, 1);
         gridPane.add(new Label("Height:"), 0, 2);
         gridPane.add(tfHeight, 1, 2);
         gridPane.add(new Label("Weight:"), 0, 3);
         gridPane.add(tfWeight, 1, 3);
         gridPane.add(new Label("BMI:"), 0, 4);
         gridPane.add(tfBMI, 1, 4);
         gridPane.add(btCalculate, 1, 5);
        // gridPane.add(btClear, 1, 6);
         gridPane.setAlignment(Pos.CENTER);
          tfName.setAlignment(Pos.BOTTOM_RIGHT);
          tfAge.setAlignment(Pos.BOTTOM_RIGHT);
          tfHeight.setAlignment(Pos.BOTTOM_RIGHT);
          tfWeight.setAlignment(Pos.BOTTOM_RIGHT);
          tfBMI.setAlignment(Pos.BOTTOM_RIGHT);
          tfBMI.setEditable(false);
         
          
          
         
          GridPane.setHalignment(btCalculate, HPos.RIGHT);
         // GridPane.setHalignment(btClear, HPos.LEFT);
        
        
         root.getChildren().add(gridPane);
      
         //double Weight = Double.parseDouble(tfWeight.getText());
         
        // double Height = Double.parseDouble(tfHeight.getText());
         
        
        stage.show();
       // System.out.println("This is a BMI Calculator!");
        
        
    }
    
    @FXML
    private void BMRCalculator() {
        Pane root= new Pane();
        TextField tfName = new TextField();
        TextField tfAge = new TextField();
        TextField tfHeight = new TextField();
        TextField tfWeight = new TextField();
        TextField tfBMR = new TextField();
        Button btCalculate = new Button("Calculate");
      
        Stage stage = new Stage();
        stage.setTitle("BMRCalculator");
        
         GridPane gridPane = new GridPane();
         gridPane.setHgap(5);
         gridPane.setVgap(5);
        //did not like how this style looked 
         //gridPane.setStyle("-fx-background-color: WHITE; -fx-grid-lines-visible: true");
         gridPane.add(new Label("Name:"), 0, 0);
         gridPane.add(tfName, 1, 0);
         gridPane.add(new Label("Age"), 0, 1);
         gridPane.add(tfAge, 1, 1);
         gridPane.add(new Label("Height:"), 0, 2);
         gridPane.add(tfHeight, 1, 2);
         gridPane.add(new Label("Weight:"), 0, 3);
         gridPane.add(tfWeight, 1, 3);
         gridPane.add(new Label("BMR:"), 0, 4);
         gridPane.add(tfBMR, 1, 4);
         gridPane.add(btCalculate, 1, 5);
         
         gridPane.setAlignment(Pos.CENTER);
       
          tfName.setAlignment(Pos.BOTTOM_RIGHT);
          tfAge.setAlignment(Pos.BOTTOM_RIGHT);
          tfHeight.setAlignment(Pos.BOTTOM_RIGHT);
          tfWeight.setAlignment(Pos.BOTTOM_RIGHT);
          tfBMR.setAlignment(Pos.BOTTOM_RIGHT);
          tfBMR.setEditable(false);
         
          
         
          GridPane.setHalignment(btCalculate, HPos.RIGHT);

           root.getChildren().add(gridPane);
        stage.setScene(new Scene(root, 450, 450));
        stage.show(); 
        
        
        
        
        
       // System.out.println("This is a BMR Calculator!");
       
    }

  

}