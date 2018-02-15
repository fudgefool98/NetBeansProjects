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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;



/**
 *
 * @author Jordan
 */
public class MyStopWatch extends Application {
    public String title = "My Stop Watch";
//    public int width = 300;
    public int height =300;
            
            double secondsElapsed = 0.0;
            double tickTimeInSeconds = 1;
            double angleDelta = 6.0;
            
    Timeline timeline;
    
    @Override
                    
                    
    public void start(Stage primaryStage) {
        primaryStage.setTitle(title);
        
        StackPane root = new StackPane();
        
        
        ImageView dialImageView = new ImageView();
        ImageView handImageView = new ImageView();
        
        root.getChildren().addAll(dialImageView, handImageView);
        
        //Image test = new Image(getClass().getResourceAsStream("shateIt.gif"));
        Image dialImage = new Image(getClass().getResourceAsStream("clockface.png"));
        Image handImage = new Image(getClass().getResourceAsStream("hand.png"));
        
        //dialImageView.setImage(test);
        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        HBox controlButtons = new HBox();
        Button start = new Button("start");
        Button stop = new Button("stop");
        Button reset = new Button("reset");
        
        start.setMaxWidth(Double.MAX_VALUE);
        stop.setMaxWidth(Double.MAX_VALUE);
        reset.setMaxWidth(Double.MAX_VALUE);

        
        
        controlButtons.setSpacing(10);
        controlButtons.setAlignment(Pos.BOTTOM_CENTER);
        controlButtons.setPadding(new Insets(25,25,25,25));
        
        controlButtons.getChildren().addAll(stop,start,reset);
        root.getChildren().add(controlButtons);
        
        double width = dialImage.getWidth();
        double height = dialImage.getHeight();
        
        
        stop.setOnAction((ActionEvent e)->{
            timeline.stop();
            //^above is slightly slower
            timeline.pause();
            //slightly faster 
            //doesn't matter we have a variable of seconds elapsed to really the 
            //"time" is the same
    });
        start.setOnAction((ActionEvent e)->{
            timeline.play();
    });
        reset.setOnAction((ActionEvent e)->{
            timeline.stop();
            handImageView.setRotate(0);
            secondsElapsed = 0;
    });
        
        Scene scene = new Scene(root,width,height + 100);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        
        timeline = new Timeline(new KeyFrame(Duration.millis(1000),
                (ActionEvent actionEvent)->{
           secondsElapsed += tickTimeInSeconds;
        
        double rotation = secondsElapsed * angleDelta;
        handImageView.setRotate(rotation);
        
            System.out.println("TimeLine Event!");
        }));
        
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
