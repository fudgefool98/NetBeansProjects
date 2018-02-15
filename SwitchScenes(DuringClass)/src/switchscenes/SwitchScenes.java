/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package switchscenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Professor Wergeles
 */
public class SwitchScenes extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("Page1.fxml"));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Page1.fxml"));
        Parent root = loader.load();
        Page1Controller controller = loader.getController();
        //added three lines above
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show(); 
        //added last line
        controller.start(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
