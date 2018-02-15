/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 *
 * @author Professor Wergeles
 */
public class MyStopWatch extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("StopWatch"); 
        
        StackPane root = new StackPane(); 
        ImageView dialImageView = new ImageView(); 
        ImageView handImageView = new ImageView(); 
        root.getChildren().addAll(dialImageView, handImageView); 
        //Image test = new Image(getClass().getResourceAsStream("shakeIt.gif"));
        Image dialImage = new Image(getClass().getResourceAsStream("clockface.png"));
        Image handImage = new Image(getClass().getResourceAsStream("hand.png"));
        
        //dialImageView.setImage(test);
        dialImageView.setImage(dialImage); 
        handImageView.setImage(handImage);
        
        Scene scene = new Scene(root, 300, 300); 
        primaryStage.setScene(scene);
        
        primaryStage.show(); 
        
        Timeline timeLine = new Timeline(new KeyFrame(Duration.millis(1000), 
            (ActionEvent actionEvent) -> {
                
                System.out.println("TimeLine Event!"); 
                
        }));
        
        timeLine.setCycleCount(Animation.INDEFINITE); 
        timeLine.play(); 
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
