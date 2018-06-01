/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnesstracker;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author david_000
 */
public class DataInput {
    
    private static String systemString = System.getProperty("user.dir") + "\\src\\fitnesstracker\\";
    private static String db = "jdbc:sqlite:";
    
    private static String exerciseFile = db + systemString + "exercise.db";
    private static String bodyWeightFile  = db + systemString + "body_weight.db";
    private static String mealsFile = db + systemString + "meals.db";
    
    public static void CreateExerciseDB(){
        String url = exerciseFile;
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS exercise (\n"
                + "	date TINYTEXT NOT NULL,\n"
                + "	exercise TEXT NOT NULL,\n"
                + "	calories INT NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void CreateWeightDB(){
        String url = bodyWeightFile;
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS weight (\n"
                + "	gender CHAR(1) NOT NULL,\n"
                + "	weight INT NOT NULL,\n"
                + "	height INT NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
    public static void CreateMealDB(){
        String url = mealsFile;
        
        // SQL statement for creating a new table
        
        String sql = "CREATE TABLE meals (\n"
                + "	date TINYTEXT NOT NULL,\n"
                + "	mealTime CHAR(1) NOT NULL,\n"
                + "	food TEXT NOT NULL,\n"
                + "	calories INT NOT NULL,\n"
                + "	carbs INT NOT NULL,\n"
                + "	fat INT NOT NULL,\n"
                + "	protein INT NOT NULL\n"
                + ");";
        
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            
            System.out.println("yes");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void EnterExercise(String exercise, int calories){
       
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear() - 2000;
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        String dateString = "" + month + "/" + day + "/" + year;
        
        String sql = "INSERT INTO exercise(date,exercise,calories) VALUES(?,?,?)";
       
        try (Connection conn = DriverManager.getConnection(exerciseFile)){
            System.out.println("connected");
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dateString);
            pstmt.setString(2, exercise);
            pstmt.setInt(3, calories);
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
    }
    
    private static void DeleteWeight(){
        String sql = "DELETE FROM weight";
       
        try (Connection conn = DriverManager.getConnection(bodyWeightFile)){
            System.out.println("connected");
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public static void EnterWeight(char gender, int height, int weight){
        
        // we only want one record in the weight database
        DeleteWeight();
        
        String sql = "INSERT INTO weight(gender,weight,height) VALUES(?,?,?)";
       
        try (Connection conn = DriverManager.getConnection(bodyWeightFile)){
            System.out.println("connected");
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Character.toString(gender));
            pstmt.setInt(2, height);
            pstmt.setInt(3, weight);
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
    }
    
    public static void EnterMeal(char mealTime, String food, int calories, int carbs,
                                    int fat, int protein){
      
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear() - 2000;
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        String dateString = "" + month + "/" + day + "/" + year;
        
        String sql = "INSERT INTO meals(date,mealTime,food,calories,carbs,fat,protein)"
                + "VALUES(?,?,?,?,?,?,?)";
       
        try (Connection conn = DriverManager.getConnection(mealsFile)){
            System.out.println("connected");
            
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dateString);
            pstmt.setString(2, Character.toString(mealTime));
            pstmt.setString(3, food);
            pstmt.setInt(4, calories);
            pstmt.setInt(5, carbs);
            pstmt.setInt(6, fat);
            pstmt.setInt(7, protein);
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static String GetDailyWorkOutCalories(){
        String calories = "0";
        
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear() - 2000;
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        String dateString = "" + month + "/" + day + "/" + year;
        
        String sql = "SELECT calories FROM exercise WHERE date = ?";
       
        int runningCalories = 0;
        
        try (Connection conn = DriverManager.getConnection(exerciseFile)){
            System.out.println("connected");
            
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, dateString);
            
            ResultSet rs    = pstmt.executeQuery();
            
            while(rs.next()){
                runningCalories += rs.getInt("calories");
            }
            
            return "" + runningCalories;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
        
        return calories;
    }
    
    public static String GetDailyMacros(String macro){
        
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear() - 2000;
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        String dateString = "" + month + "/" + day + "/" + year;
        
        String sql;
        if (macro == "fat"){
             sql = "SELECT fat FROM meals WHERE date = ?";
        } else if (macro == "protein"){
             sql = "SELECT protein FROM meals WHERE date = ?";
        } else if (macro == "carbs"){
             sql = "SELECT carbs FROM meals WHERE date = ?";
        } else if (macro == "calories"){
             sql = "SELECT calories FROM meals WHERE date = ?";
        } else {
            return "-1";
        }
       
        int runningCalories = 0;
        
        try (Connection conn = DriverManager.getConnection(mealsFile)){
            System.out.println("connected");
            
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            //pstmt.setString(1, macro);
            pstmt.setString(1, dateString);
            
            ResultSet rs    = pstmt.executeQuery();
            
            while(rs.next()){
                runningCalories += rs.getInt(macro);
            }
            
            return "" + runningCalories;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
        
        
        return "0";
    }
}
