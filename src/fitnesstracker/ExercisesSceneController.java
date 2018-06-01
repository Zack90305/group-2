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
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Luis
 */
public class ExercisesSceneController {
    
    public void test() {
        System.out.println("asdfdsa");
    }
    
    public void handler1(){
        System.out.println("asdfdsa");
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
}
