/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcexampleproject;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 *
 * @author Michael
 */
public class Model {
    
     int i = 0;
    Timeline timeline;
    FXMLDocumentController controller;
    //constructor below is used to initialize the app
    //not a seperate initialize function
    public Model(FXMLDocumentController controller){
        this.controller = controller;  
    }
    
    public void run(){
        timeline = new Timeline(new KeyFrame(Duration.millis(500), (ActionEvent) -> {
            i++;
            this.controller.notify("I is now " + i);
            if(i == 10){
                this.timeline.stop();
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
