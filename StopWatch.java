/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitnesstracker;


/**
 *
 * @author beeb
 */
public class StopWatch {
    
    private int seconds;
    private int minutes;
    private int hours;
    
    public StopWatch(){
        seconds=0;
        minutes=0;
        hours=0;
        
    }
    
    public void increaseSeconds(){
        System.out.println("increase");
        if((seconds+1)==60){
            seconds=0;
            if((minutes+1)==60){
                hours++;
                minutes=0;
            }
            else{
                minutes++;
            }
            
        }
        else{
             seconds++;       
        }
    }
    
    public int getSeconds(){
        return seconds;
    }
    
    public String toString(){
        String hoursStr=new String();
        String minutesStr=new String();
        String secondsStr=new String();
        
        if(hours<10)    
            hoursStr= "0" + hours;
        else    
            hoursStr="" + hours;
        
        if(minutes<10)    
            minutesStr= "0" + minutes;
        else    
            minutesStr="" + minutes;
        
        if(seconds<10)    
            secondsStr= "0" + seconds;
        else    
            secondsStr="" + seconds;
        
        return  hoursStr+":"+minutesStr+":"+secondsStr;
    }
    
    
    public void resetTimer(){
        seconds=0;
        minutes=0;
        hours=0;
       
    }
    
    
   
}
