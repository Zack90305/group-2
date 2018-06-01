/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnesstracker;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


/**
 *
 * @author Luis
 */
public class ExercisesSceneController {
    
    @FXML private Text caloriesLostText;
    
    public void initialize() {
        caloriesLostText.setText(DataInput.GetDailyWorkOutCalories());
    }
    
    public void handler1(){
        Stage timerStage = new Stage();
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        
        StopWatch watch = new StopWatch();
        //watch.increaseSeconds();
        
        Label label = new Label(watch.toString());
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        
        
        Thread timerThread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            while(true){
                               
                                //sleep for 1 seconds
                                Thread.sleep(1000);
                                
                                 //increase seconds
                                watch.increaseSeconds();
                                
                                //update the pane in the Platform class
                                Platform.runLater(new Runnable(){
                                    @Override
                                    public void run(){
                                        label.setText(watch.toString());
                                    }
                                });
                            }
                        }
                        catch(InterruptedException ex){
                            
                        }
                    } //override
                });
		//End of the Thread
                
                Button startbtn = new Button("Start");
                startbtn.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                Button stopbtn = new Button("Stop");
                stopbtn.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                //Boolean firstTime = true;
                startbtn.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent e){
                        if(startbtn.getText().equals("Start")){
                            
                                try{
                                    timerThread.start();
                                }
                                catch(Exception ex){
                                    timerThread.resume();
                                }
                                
                            
                            startbtn.setText("Restart");
                        }
                        else{
                            watch.resetTimer();
                            label.setText(watch.toString());
                            timerThread.suspend();
                            startbtn.setText("Start");
                        }
                        
                        
                            
                    }
                });
                stopbtn.setOnAction(new EventHandler<ActionEvent>(){
                    public void handle(ActionEvent e){
                        if(stopbtn.getText().equals("Stop")){
                           timerThread.suspend();
                            stopbtn.setText("Resume");
                        }
                        else{
                            timerThread.resume();
                            stopbtn.setText("Stop");
                        }
                        
                    }
                });
                HBox timerControlhbox = new HBox();
                timerControlhbox.setSpacing(10);
                timerControlhbox.setAlignment(Pos.CENTER);
                timerControlhbox.getChildren().addAll(startbtn, stopbtn);
                
                vbox.getChildren().addAll(label, timerControlhbox);
                
                
            Scene scene = new Scene(vbox, 300, 250);
            
            timerStage.setTitle("Stopwatch!");
            timerStage.setScene(scene);
            timerStage.show();
    }
    
    
    @FXML
    public void addSquatsExerciseButton() {      
        this.renderUserInputPopup();
    }
    
    public void addDeadliftsExerciseButton() {
        this.renderUserInputPopup();
    }
    public void addBenchExerciseButton() {
        this.renderUserInputPopup();
    }
    public void addRowExerciseButton() {
        this.renderUserInputPopup();
    }
    public void addRunningExerciseButton() {
        this.renderUserInputPopup();
    }
    public void addCyclingExerciseButton() {
        this.renderUserInputPopup();
    }
    public void addSwimmingExerciseButton() {
        this.renderUserInputPopup();
    }
    public void addJumpropeExerciseButton() {
        this.renderUserInputPopup();
    }
    
    public void renderUserInputPopup() {
        Stage exerciseStage = new Stage();
        HBox dataEntry = new HBox(20);
        VBox dataBox = new VBox(20);
        Label emptySpace = new Label(" ");
        
        dataBox.getChildren().add(emptySpace);
        
        Label caloriesBurned = new Label("How many calories did you burn?");
        Label emptySpace2 = new Label(" ");
        dataEntry.getChildren().add(emptySpace2);
        
        caloriesBurned.setPadding(new Insets(0,0,0,10));
        dataEntry.getChildren().add(caloriesBurned);
        caloriesBurned.setStyle("-fx-font: 18 arial");
        
        TextField userCalorieInput = new TextField();
        
        dataEntry.getChildren().add(userCalorieInput);
        dataBox.getChildren().add(dataEntry);
        
        HBox enterButton = new HBox(230);
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                DataInput.EnterExercise("exercise", Integer.parseInt(userCalorieInput.getText()));
                System.out.println(userCalorieInput.getText());
                caloriesLostText.setText(DataInput.GetDailyWorkOutCalories()); 
                exerciseStage.close();
            }
        });
        Label emptySpace3 = new Label(" ");
        enterButton.getChildren().add(emptySpace3);
        enterButton.getChildren().add(submitButton);
        
        dataBox.getChildren().add(enterButton);
        
        Scene scene = new Scene(dataBox, 500, 170);
        exerciseStage.setScene(scene);
        exerciseStage.show();
    }
}
