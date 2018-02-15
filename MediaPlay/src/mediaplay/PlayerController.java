/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaplay;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Professor Wergeles
 * 
 * http://stackoverflow.com/questions/20787450/javafx-mediaplayer-stops-before-end-of-video-without-throwing-an-event-when-comp
 * 
 * 
 * Comment about the use of Runnable instead of EventHandlers in Media:
 * http://stackoverflow.com/questions/11598486/status-listener-on-mediaplayer-object-in-javafx-2
 */
public class PlayerController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
