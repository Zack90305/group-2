/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnesstracker;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author david_000
 */
public class DataInput {
    
    private static String exerciseFile;
    private static String bodyWeightFile  = "body_weight.json";
    private static String mealsFile = "meals.json";
   
    
    public DataInput(){
        exerciseFile = getClass().getResource("exercise.json").getPath();
    }
    
    public static void EnterExercise(String exercise, int calories){
        JSONParser parser = new JSONParser();
        
        try (FileReader reader = new FileReader(exerciseFile)){
            //Read JSON file
            Object obj = parser.parse(reader);
            
            LocalDateTime now = LocalDateTime.now();
            int year = now.getYear() - 2000;
            int month = now.getMonthValue();
            int day = now.getDayOfMonth();
            
            JSONObject dateObject = (JSONObject) obj;
            JSONObject exerciseDate = (JSONObject) dateObject.get("" + month + "/" 
                                                                 + day + "/" + year);
            
            JSONObject exerciseData = new JSONObject();
            exerciseData.put("exercise", exercise);
            exerciseDate.put("calories", calories);
            
            exerciseDate.put("exercise", exerciseDate);
            
            dateObject.remove("" + month + "/" + day + "/" + year);
            dateObject.put("" + month + "/" + day + "/" + year, exerciseDate);
            
            FileWriter file = new FileWriter(exerciseFile);

            file.write(dateObject.toJSONString());
            file.flush();
        }
        catch (Exception e){
            System.out.println(e + " FILE : " + exerciseFile);
        }
    }
    
}
