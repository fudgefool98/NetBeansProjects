/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tonk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jordan
 */
public class Tonk extends Application {
/*
    
    card{
    
        suit
        rank
        isInHand bool
    
        
        
    
    
    deck
        instantiates 52 cards in an arrayList
    
       
    
    
    
    suit
        
        hearts 
        clubs
        spades
        diamonds
    
    
    
    
    rank
        etc self expalined enum
    
    
    game
    
     two player
        shuffles and deals cards
    names winner
    has rules
    
    
    
    
    
    
    
    
    
    */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
