/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mynewstopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author jasminetan
 */
public class AnalogStopwatch {
    private double tickTimeInSeconds = 0.01; //change resolution
    private double angleDeltaPerSeconds = 6.0;
       
    private double secondsElapsed;
    
    private Timeline timeline;
    private KeyFrame keyFrame;
    
    private StackPane rootContainer;
    private ImageView dialImageView;
    private ImageView handImageView;
    private Image dialImage;
    private Image handImage;
    private String dialImageName = "clockface.png";
    private String handImageName = "hand.png";
    
    private boolean tickButtonPressed = false;
    
    
    public AnalogStopwatch(){
        setupUI();
        setupTimer();
              
        
    }
    public void setupUI(){
        rootContainer = new StackPane();
        dialImageView = new ImageView();
        handImageView = new ImageView();
        
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));
        handImage = new Image(getClass().getResourceAsStream(handImageName));
        
        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER);
        //Button tickButton = new Button("Tick");
        Button tickButton = new Button("Start");
        buttonBox.getChildren().add(tickButton);
        
        rootContainer.getChildren().addAll(buttonBox, dialImageView, handImageView);
        //be careful of ordering. alternatively the statment below will put the button on top of the stack
        buttonBox.toFront();
        
        tickButton.setOnAction((ActionEvent event)->{
           
//             if (tickTimeInSeconds==0.01){
//                 setTickTimeInSeconds(1.0);
//             }
//             else if (tickTimeInSeconds == 1.0){
//                 setTickTimeInSeconds(0.01);
//             }
//             else{
//                 setTickTimeInSeconds(1.0);
//             }
                if(isRunning()){
                    timeline.stop();
                }
                else{
                    timeline.play();
                }
        });
    }
    public boolean isRunning(){
       if(timeline != null){
           if(timeline.getStatus()==Animation.Status.RUNNING){
               return true;
           }
       }
       return false;
    }
//    public void start(){
//        
//    }
//    public void restart(){
//        
//    }
//    public void stop(){
//        
//    }        
    public void setupTimer(){
        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000), (ActionEvent) ->{
            update();
        });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    private void update(){
        secondsElapsed += tickTimeInSeconds;
        double rotation = secondsElapsed * angleDeltaPerSeconds;
        handImageView.setRotate(rotation);
        
    }
    public void start(){
        timeline.play();
    }
    public Parent getRootContainer(){
        return rootContainer;
    }
     public Double getWidth(){
        if(dialImage != null){
            return dialImage.getWidth();
        }
        else{
            return 0.0;    
        }
        
    }
    public Double getHeight(){
        if(dialImage != null)return dialImage.getHeight();
        else return 0.0;
    }
    public void setTickTimeInSeconds(Double tickTimeInSeoncds){
        this.tickTimeInSeconds = tickTimeInSeoncds;
        setupTimer();
    }
        
    
}
