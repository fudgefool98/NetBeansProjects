/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystopwatch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Jordan
 */
public class AnalogStopwatch {
    private double tickTimeInSeconds = 0.01;//change the resolution
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
            
    
    public AnalogStopwatch(){//constructor
        
    }
    public void setupUI(){
        rootContainer = new StackPane();
        dialImageView = new ImageView();
        handImageView = new ImageView();
        
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));
        handImage = new Image(getClass().getResourceAsStream(handImageName));

        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        
        rootContainer.getChildren().addAll(dialImageView, handImageView);
    }
    
}
