/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiovisual;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Professor Wergeles
 */
public class PlayerController implements Initializable {
    
    private static final Duration TRANSLATE_DURATION = Duration.seconds(0.25);
    
    @FXML
    private Text magText1;
    
    @FXML
    private Text magText2;
    
    @FXML
    private Text magText3;
    
    @FXML
    private Text magText4;
    
    @FXML
    private Text phaseText1;
    
    @FXML
    private Text phaseText2;
    
    @FXML
    private Text phaseText3;
    
    @FXML
    private Text phaseText4;
    
    @FXML
    private Ellipse ellipse1;
    
    @FXML
    private Ellipse ellipse2;
    
    @FXML
    private Ellipse ellipse3;
    
    @FXML
    private Ellipse ellipse4;
    
    @FXML
    private ImageView c; 
    
    @FXML
    private ImageView o1;
    
    @FXML
    private ImageView o2;
    
    @FXML
    private ImageView l;
    

    
    String[] songs = {  "Sublime - Scarlet Begonias.mp3",
                        "Audio Adrenaline - Beautiful.mp3",
                        "Slightly Stoopid - Closer to the Sun.mp3",
                        "James Hersey - Miss You.mp3",
                        "Are You In.mp3",
                        "Flake - Jack Johnson.mp3", 
                        "bensound-scifi.mp3"
    };

    private int x = 0;
    
    private Media media;
    
    private MediaPlayer mediaPlayer;
    
    private Double phaseMulti = 360.0;
    private Double phaseMulti2 = 50.3;
    private Double magnitudeOffset = 70.0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setupUI(songs[x]);
    } 
    private void setupUI(String song){
        media = new Media(this.getClass().getResource(song).toExternalForm());
        
        mediaPlayer = new MediaPlayer(media);
        
        mediaPlayer.setAutoPlay(true);
        
        mediaPlayer.setAudioSpectrumNumBands(4);
        
        mediaPlayer.setAudioSpectrumListener(
                (double timestamp, double duration, float[] magnitudes, float[] phases)->{
            
                    if(magnitudes.length >= 4 && phases.length >= 4){
                        System.out.println("Timestamp: " + timestamp);
                        System.out.println("Duration: " + duration);
                        System.out.println("Magnitudes: " + magnitudes);
                        System.out.println("Phases: " + phases);
                        
                        magText1.setText(Float.toString(magnitudes[0]));
                        magText2.setText(Float.toString(magnitudes[1]));
                        magText3.setText(Float.toString(magnitudes[2]));
                        magText4.setText(Float.toString(magnitudes[3]));
                        
                        phaseText1.setText(Float.toString(phases[0]));
                        phaseText2.setText(Float.toString(phases[1]));
                        phaseText3.setText(Float.toString(phases[2]));
                        phaseText4.setText(Float.toString(phases[3]));
                        
                        ellipse1.setCenterY(Math.abs(magnitudes[0]*5)- 300);
                        ellipse2.setCenterY(Math.abs(magnitudes[1]*5)- 300);
                        ellipse3.setCenterY(Math.abs(magnitudes[2]*5)- 300);
                        ellipse4.setCenterY(Math.abs(magnitudes[3]*5)- 300);

                            ellipse1.setRadiusX(Math.abs(magnitudeOffset + magnitudes[0]));
                            ellipse1.setRadiusY(Math.abs(magnitudeOffset + magnitudes[0]));
                            
                            ellipse2.setRadiusX(Math.abs(magnitudeOffset + magnitudes[1]));
                            ellipse2.setRadiusY(Math.abs(magnitudeOffset + magnitudes[1]));
                            
                            ellipse3.setRadiusX(Math.abs(magnitudeOffset + magnitudes[2]));
                            ellipse3.setRadiusY(Math.abs(magnitudeOffset + magnitudes[2]));
                            
                            ellipse4.setRadiusX(Math.abs(magnitudeOffset + magnitudes[3]));
                            ellipse4.setRadiusY(Math.abs(magnitudeOffset + magnitudes[3]));
                            
                            
                    }
            
                });
    }
    @FXML
    private void handlePlay() {
        System.out.println("You clicked me! 1");
        
        mediaPlayer.play();
    }
    
    @FXML
    private void handlePause() {
        System.out.println("You clicked me! 2");
        
        mediaPlayer.pause();

    }
    
    @FXML
    private void handleStop() {
        System.out.println("You clicked me! 3");
        
        mediaPlayer.stop();

    }
    
    @FXML
    private void handleNext(){
        System.out.println("You clicked me! 4");
        
        if(isRunning()){
            mediaPlayer.stop();
        }
        //below loops through songs instead of running off the end of the list
            if(x++ == songs.length -1){
                x = 0;
            }
            setupUI(songs[x]);
            mediaPlayer.play();
        
    }
    public boolean isRunning(){
        if(mediaPlayer.getAudioSpectrumListener() != null){
            if(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
                return true;
            }
        }
        return false;
    }
}