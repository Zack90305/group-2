/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnesstracker;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Luis
 */
public class BodySceneController {
    
    @FXML ImageView sexIcon;
    @FXML TextField weightTextField;
    @FXML TextField heightTextField;
    
    
     public void initialize() {
         
       System.out.println("asdfsadfdsa");
       Image boyIcon = new Image("/images/maleIcon.png");
       Image girlIcon = new Image("/images/femaleIcon.png");
       
       String sexOfUser = DataInput.GetWeight()[0];
       String weightOfUser = DataInput.GetWeight()[1];
       String heightOfUser = DataInput.GetWeight()[2];
       
       System.out.println(DataInput.GetWeight()[0]);
       System.out.println(DataInput.GetWeight()[1]);
       System.out.println(DataInput.GetWeight()[2]);
       
       
        if( sexOfUser.equals("no")) {
            
        }
        else if (sexOfUser.equals("M")){
            sexIcon.setImage(boyIcon);
        }
        else if (sexOfUser.equals("F")) {
            sexIcon.setImage(girlIcon);
        }
        
        if (!weightOfUser.equals("no")) {
            weightTextField.setText(weightOfUser);
        }
        
        if (!heightOfUser.equals("no")) {
            heightTextField.setText(heightOfUser);
        }

    }  
}
