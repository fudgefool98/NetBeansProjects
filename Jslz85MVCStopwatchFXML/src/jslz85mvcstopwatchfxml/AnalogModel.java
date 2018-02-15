/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jslz85mvcstopwatchfxml;

//import static java.lang.ProcessImpl.start;
//import static java.util.zip.CRC32.update;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 *
 * @author Jordan
 */
public class AnalogModel {
    
    
        FXMLDocumentController controller;
        public double digitalSeconds;
        public double result = 0.0;
        public double secondsElapsed = 0.0;
        public double previousTotal = 0.0;
        public double totalTime = 0.0;
        public double tickTimeInSeconds = 0.01;
        public double angleDelta = 6.0;
        public int lapNum = 1;
        Timeline timeline;
    public  AnalogModel(FXMLDocumentController controller){
        
        
        this.controller = controller;
        
        
        controller.stop.setVisible(false);
        controller.stop.setManaged(false);
        
        controller.reset.setVisible(false);
        controller.reset.setManaged(false);
        
           //initialize the timeline in here for some reason.
        timeline = new Timeline(new KeyFrame(Duration.millis(10),
                (ActionEvent actionEvent)->{
           secondsElapsed += tickTimeInSeconds;
           digitalSeconds += tickTimeInSeconds;
           totalTime += tickTimeInSeconds;
           
        double rotation = digitalSeconds * angleDelta;
        controller.handImageView.setRotate(rotation);
        controller.update(digitalSeconds);
       }));
           
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    
    public void start(){
        timeline.play();
            
            controller.reset.setVisible(false);
            controller.reset.setManaged(false);
            
            controller.stop.setVisible(true);
            controller.stop.setManaged(true);
            
            controller.start.setVisible(false);
            controller.start.setManaged(false);
            
            controller.lap.setVisible(true);
            controller.lap.setManaged(true);
    }
    public void stop(){
        timeline.pause();
            
            controller.start.setVisible(true);
            controller.start.setManaged(true);
            
            controller.reset.setVisible(true);
            controller.reset.setManaged(true);
            
            controller.lap.setVisible(false);
            controller.lap.setManaged(false);
        
            controller.stop.setVisible(false);
            controller.stop.setManaged(false);
        
    }
    public void reset(){
        timeline.stop();
            controller.handImageView.setRotate(0);
            secondsElapsed = 0;
            totalTime = 0;
            previousTotal = 0;
           //controlButtons.getChildren().setAll(lap,start);
           
            controller.stop.setVisible(false);
            controller.stop.setManaged(false);
        
            controller.reset.setVisible(false);
            controller.reset.setManaged(false);
        
            controller.lap.setVisible(true);
            controller.lap.setManaged(true);
        
            controller.start.setVisible(true);
            controller.start.setManaged(true);
            
           lapNum = 1;
           
    }
    public void lap(){
        // this lap acts as a quick reset 
            // keep the analog and digital clocks running in th UI
            // have the lap # __:__:__ printed to the console = total time - previous total
            if(secondsElapsed == 0){
                return;
            }
            
           //controller.handImageView.setRotate(0);
           result = totalTime - previousTotal;
           System.out.printf("Lap %d     %.2f \n" , lapNum ,result);
           previousTotal = totalTime;
           
           secondsElapsed = 0;
           lapNum++;
           //controlButtons.getChildren().setAll(lap,stop);
           //set visible and managed to false when i don't want to show button
           
           
    }
//    private void initialize(){
//        controller.stop.setVisible(false);
//        controller.stop.setManaged(false);
//        
//        controller.reset.setVisible(false);
//        controller.reset.setManaged(false);
//        
//           //initialize the timeline in here for some reason.
//        timeline = new Timeline(new KeyFrame(Duration.millis(10),
//                (ActionEvent actionEvent)->{
//           secondsElapsed += tickTimeInSeconds;       
//        double rotation = secondsElapsed * angleDelta;
//        controller.handImageView.setRotate(rotation);
//        
//        update(digital);
//       }));
//           
//        timeline.setCycleCount(Animation.INDEFINITE);
//    }
}
