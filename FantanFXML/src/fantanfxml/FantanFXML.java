/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantanfxml;

import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Jordan
 */
public class FantanFXML extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("TitleFXML.fxml"));
        
        Scene scene = new Scene(root);
        Parent boot = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene2 = new Scene(boot);
        
        
        stage.setScene(scene2);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
