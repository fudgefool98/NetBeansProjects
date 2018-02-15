/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warfxml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Jordan
 */
public class MenuController implements Initializable {
    private Stage stage;
    private Scene menuScene;

    private Scene warScene;
    private Scene autoWarScene;
    private WarController warController;
    private AutoWarController autoWarController;
    @FXML
    private Label label;
    
    
    
    @FXML
    private void handleAbout(ActionEvent event){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Author: \nJordan Liebman");
        alert.setContentText("To play war manually press: 'Play War!'\nTo play war automatically press: 'Play War Automatic!' ");

        alert.showAndWait();
    }
        //War game start
    @FXML
    private void handleButtonAction1(ActionEvent event) {
        System.out.println("You clicked me!");
//sets stage
        try{  
            System.out.println("Going to Page 2");
            if(warScene == null){
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/GameFXML.fxml"));
            Parent warSceneRoot = loader.load();//???
          
            warController = loader.getController();
          
          //so we can come back from page two.
            warController.menuScene = menuScene;
            warController.controller = this;
            
            warScene = new Scene(warSceneRoot);
    }
    //if page two has been created before we switch to it instead of
    //creating another instance
    //yay no memory leaks!
          stage.setScene(warScene);
          warController.start(stage);
          
        }
        catch(IOException ex){
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    
    //Auto war game start
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        System.out.println("?????!");
try{  
            System.out.println("button 2");
            if(autoWarScene == null){
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/AutoGameFXML.fxml"));
            Parent autoWarSceneRoot = loader.load();
          
            autoWarController = loader.getController();
          
          //so we can come back from page two.
            autoWarController.menuScene = menuScene;
            autoWarController.controller = this;
          //REPLACE WARCONTROLLERS WITH AUTOWARCONTROLLERS
            autoWarScene = new Scene(autoWarSceneRoot);
    }
    //if page two has been created before we switch to it instead of
    //creating another instance
    //yay no memory leaks!
            stage.setScene(autoWarScene);
          
           
          
          autoWarController.start(stage);
          
        }
        catch(IOException ex){
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null,ex);
        }
    
    }
    
     public void start(Stage stage){
        this.stage = stage;
        menuScene = stage.getScene();
        
        System.out.println("I've Started");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

