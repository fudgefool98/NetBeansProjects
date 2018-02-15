/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jslz85mvcstopwatchfxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import javafx.util.Duration;

/**
 *
 * @author Jordan
 */
public class FXMLDocumentController implements Initializable {
    
    
    AnalogModel analogModel;
    DigitalModel digitalModel;
    public String title = "My Stop Watch";
//  public int width = 300;
    public int height =300;
    
    
    public String holdString = "";
    
    
    
    //end initialized variables
    
    
    //set title
        //primaryStage.setTitle(title);
        
        //create stack pane
        @FXML
        public StackPane root;
        
        // instatiate image views
        @FXML
        public ImageView dialImageView;
        @FXML
        public ImageView handImageView;
        
        //create buttons the fxml can see at a level that functions can grab
        @FXML
        public Button start;
        @FXML
        public Button stop;
        @FXML
        public Button reset;
        @FXML
        public Button lap;
        //create hbox
        @FXML
        public HBox controlButtons;
//      HBox labelBox = new HBox();
//        VBox boxBox = new VBox();
        //create buttons
//        Button start = new Button("start");
//        Button stop = new Button("stop");
//        Button reset = new Button("reset");
//        Button lap = new Button("lap");
        @FXML
        public Label digital;
//               
//        
//        
//
//      
//        //setting widths is this how we set the width of the whole scene??
//        double width = dialImage.getWidth();
//        double height = dialImage.getHeight();
//        
        //functions for onclick events
        //EXAMPLE FUNCTION FOR ACTION EVENT
        //    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
        
        @FXML
        private void start(ActionEvent event){
            analogModel.start();
           // digitalModel.start();
//            timeline.play();
//            
//            reset.setVisible(false);
//            reset.setManaged(false);
//            
//            stop.setVisible(true);
//            stop.setManaged(true);
//            
//            start.setVisible(false);
//            start.setManaged(false);
//            
//            lap.setVisible(true);
//            lap.setManaged(true);
        }
        
        @FXML
        public  void stop(ActionEvent event){
            //digitalModel.stop();
            analogModel.stop();
//            timeline.pause();
//            
//            start.setVisible(true);
//            start.setManaged(true);
//            
//            reset.setVisible(true);
//            reset.setManaged(true);
//            
//            lap.setVisible(false);
//            lap.setManaged(false);
//        
//            stop.setVisible(false);
//            stop.setManaged(false);
//        
        }
        
        @FXML
        public  void reset(ActionEvent event){
            digitalModel.reset();
            analogModel.reset();
//            timeline.stop();
//            handImageView.setRotate(0);
//            secondsElapsed = 0;
//           //controlButtons.getChildren().setAll(lap,start);
//           
//            stop.setVisible(false);
//            stop.setManaged(false);
//        
//            reset.setVisible(false);
//            reset.setManaged(false);
//        
//            lap.setVisible(true);
//            lap.setManaged(true);
//        
//            start.setVisible(true);
//            start.setManaged(true);
//            
//           lapNum = 1;
//           digital.setText("00:00:00");
//    s1 = 0;
//    s0 = 0;
//    m1 = 0;
//    m0 = 0;
//    h1 = 0;
//    h0 = 0;
    }
        @FXML
        public void lap(ActionEvent event){
            analogModel.lap();
            digitalModel.lap();
//            // this lap acts as a quick reset 
//            // keep the analog and digital clocks running in th UI
//            // have the lap # __:__:__ printed to the console = total time - previous total
//            if(secondsElapsed == 0){
//                return;
//            }
//            
//           handImageView.setRotate(0);
//           System.out.println("Lap " + lapNum + " " + secondsElapsed);
//           secondsElapsed = 0;
//           lapNum++;
//           //controlButtons.getChildren().setAll(lap,stop);
//           //set visible and managed to false when i don't want to show button
//           
//           digital.setText("00:00:00");  
//    s1 = 0;
//    s0 = 0;
//    m1 = 0;
//    m0 = 0;
//    h1 = 0;
//    h0 = 0;
        }
        
        //rotation from timeline events
        
        
        
        
        

       @Override
       public void initialize(URL url, ResourceBundle rb){
//        stop.setVisible(false);
//        stop.setManaged(false);
//        
//        reset.setVisible(false);
//        reset.setManaged(false);
//        
//           //initialize the timeline in here for some reason.
//        timeline = new Timeline(new KeyFrame(Duration.millis(10),
//                (ActionEvent actionEvent)->{
//           secondsElapsed += tickTimeInSeconds;       
//        double rotation = secondsElapsed * angleDelta;
//        handImageView.setRotate(rotation);
//        
//        update(digital);
//       }));
//           
//        timeline.setCycleCount(Animation.INDEFINITE);   

            analogModel = new AnalogModel(this);
            digitalModel = new DigitalModel(this);
       }
//    @FXML
//    private Label label;
//    
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
//    }
//    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
    public void update(double secondsElapsed){
        digitalModel.update( secondsElapsed);
//            //here's where we logic the shit out of it
//            //increment hundreths
//            if(h0==9){
//             h1+=1;
//             h0 = 0;
//            
//            }
//            else{
//                h0++;
//            }
//            //increment tens of hundreths
//            if(h1==9){
//             s0+=1;
//             h1 = 0;
//            
//            }
//            else if (h1 == 0 && h0==9){
//                h1++;
//                
//            }
//            //increment seconds
//            if(s0==9){
//             s1+=1;
//             s0 = 0;
//            
//            }
//            else if (s0 == 0 && h1==9){
//                s0++;
//            }
//            //increment tens of seconds
//            if(s1==5){
//             m0+=1;
//             s1 = 0;
//            
//            }
//            else if (s1 == 0 && s0==9){
//                s1++;
//            }
//            //increment minutes
//            if(m0==9){
//             m1+=1;
//             m0 = 0;
//            
//            }
//            else if (m0 == 0 && s1==9){
//                m0++;
//            }
//            //increment tens of minutes
//            if(m1==5){
//             h0 = 0;
//             h1 =0;
//             s0=0;
//             s1=0;
//             m0=0;
//             m1=0;
//             
//            }
//            clock = m1 + m0 + ":" + s1 + s0 + ":" + h1 + h0 ;
//            digital.setText( clock);
        }
}


