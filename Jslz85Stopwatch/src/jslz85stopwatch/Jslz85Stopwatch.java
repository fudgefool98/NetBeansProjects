/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jslz85stopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Jordan
 */
public class Jslz85Stopwatch extends Application {
    public String title = "My Stop Watch";
//  public int width = 300;
    public int height =300;
    double secondsElapsed = 0.0;
    double tickTimeInSeconds = 0.01;
    double angleDelta = 6.0;
    int lapNum = 1;
    //digital vars
    public int s1 = 0;
    public int s0 = 0;
    public int m1 = 0;
    public int m0 = 0;
    public int h1 = 0;
    public int h0 = 0;
    //end digital vars
    public String holdString = "";
    public String clock = m1 + m0 + ":" + s1 + s0 + ":" + h1 + h0 ;
    
    Timeline timeline;
    
    @Override
                                        
    public void start(Stage primaryStage) {
        //set title
        primaryStage.setTitle(title);
        
        //create stack pane
        StackPane root = new StackPane();
        
        // instatiate image views
        ImageView dialImageView = new ImageView();
        ImageView handImageView = new ImageView();
        
        //add imageviews to stack
        root.getChildren().addAll(dialImageView, handImageView);
        
        //get the images
        Image dialImage = new Image(getClass().getResourceAsStream("clockface.png"));
        Image handImage = new Image(getClass().getResourceAsStream("hand.png"));
        
        //set the images
        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        //create hbox
        HBox controlButtons = new HBox();
        HBox labelBox = new HBox();
        VBox boxBox = new VBox();
        //create buttons
        Button start = new Button("start");
        Button stop = new Button("stop");
        Button reset = new Button("reset");
        Button lap = new Button("lap");
        Label digital = new Label(clock);
               
        
        //set the widths
        start.setMaxWidth(Double.MAX_VALUE);
        stop.setMaxWidth(Double.MAX_VALUE);
        reset.setMaxWidth(Double.MAX_VALUE);
        lap.setMaxWidth(Double.MAX_VALUE);      
        digital.setMaxWidth(Double.MAX_VALUE);
        //control button layout
        labelBox.setSpacing(10);
        labelBox.setAlignment(Pos.BOTTOM_CENTER);
        labelBox.setPadding(new Insets(25,25,25,25));
        labelBox.setMaxWidth(Double.MAX_VALUE);

        controlButtons.setSpacing(10);
        controlButtons.setAlignment(Pos.BOTTOM_CENTER);
        controlButtons.setPadding(new Insets(25,25,25,25));
        
        boxBox.setAlignment(Pos.BOTTOM_CENTER);
        //adding it all to the button box then root
        controlButtons.getChildren().addAll(lap,start);
        labelBox.getChildren().add(digital);
        boxBox.getChildren().addAll(labelBox, controlButtons);
        root.getChildren().add(boxBox);
        
        //setting widths
        double width = dialImage.getWidth();
        double height = dialImage.getHeight();
        
        //functions for onclick events
        stop.setOnAction((ActionEvent e)->{
            timeline.pause();
            
            controlButtons.getChildren().setAll(reset,start);
    });
        start.setOnAction((ActionEvent e)->{
            timeline.play();
            controlButtons.getChildren().setAll(lap,stop);
    });
        reset.setOnAction((ActionEvent e)->{
            timeline.stop();
            handImageView.setRotate(0);
            secondsElapsed = 0;
           controlButtons.getChildren().setAll(lap,start);
           lapNum = 1;
           digital.setText("00:00:00");
    s1 = 0;
    s0 = 0;
    m1 = 0;
    m0 = 0;
    h1 = 0;
    h0 = 0;
    });
        lap.setOnAction((ActionEvent e )->{
            // this lap acts as a quick reset 
            // keep the analog and digital clocks running in th UI
            // have the lap # __:__:__ printed to the console = total time - previous total
            if(secondsElapsed == 0){
                return;
            }
            
           handImageView.setRotate(0);
           System.out.println("Lap " + lapNum + " " + secondsElapsed);
           secondsElapsed = 0;
           lapNum++;
           controlButtons.getChildren().setAll(lap,stop); 
           digital.setText("00:00:00");  
    s1 = 0;
    s0 = 0;
    m1 = 0;
    m0 = 0;
    h1 = 0;
    h0 = 0;
        });
        //set scene and show
        Scene scene = new Scene(root,width,height + 100);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //rotation from timeline events
        timeline = new Timeline(new KeyFrame(Duration.millis(10),
                (ActionEvent actionEvent)->{
           secondsElapsed += tickTimeInSeconds;       
        double rotation = secondsElapsed * angleDelta;
        handImageView.setRotate(rotation);
        update(digital);
       }));
        
        
        
        

       
        
        timeline.setCycleCount(Animation.INDEFINITE);   
    }
    public void update(Label digital){
            //here's where we logic the shit out of it
            //increment hundreths
            if(h0==9){
             h1+=1;
             h0 = 0;
            
            }
            else{
                h0++;
            }
            //increment tens of hundreths
            if(h1==9){
             s0+=1;
             h1 = 0;
            
            }
            else if (h1 == 0 && h0==9){
                h1++;
                
            }
            //increment seconds
            if(s0==9){
             s1+=1;
             s0 = 0;
            
            }
            else if (s0 == 0 && h1==9){
                s0++;
            }
            //increment tens of seconds
            if(s1==5){
             m0+=1;
             s1 = 0;
            
            }
            else if (s1 == 0 && s0==9){
                s1++;
            }
            //increment minutes
            if(m0==9){
             m1+=1;
             m0 = 0;
            
            }
            else if (m0 == 0 && s1==9){
                m0++;
            }
            //increment tens of minutes
            if(m1==5){
             h0 = 0;
             h1 =0;
             s0=0;
             s1=0;
             m0=0;
             m1=0;
             
            }
            clock = m1 + m0 + ":" + s1 + s0 + ":" + h1 + h0 ;
            digital.setText( clock);
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}