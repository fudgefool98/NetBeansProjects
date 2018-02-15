/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warfxml;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Jordan
 */
public class AutoWarController implements Initializable {
    //labels
    @FXML 
    public Label yourCard;    
    @FXML 
    public Label computerCard;
    @FXML 
    public Label youWin;    
    @FXML 
    public Label compWin;
    @FXML
    public Label war;
    @FXML
    public Label whoWon;
    @FXML 
    public Button button;
            
    public Scene menuScene;
    public MenuController controller;
    private Stage stage;
    private AutoGameModel autoGame;
    
    public void start(Stage stage) {
        this.stage = stage;
        
    }
@FXML
    private void goBackToPage1(ActionEvent event) {
       
        
        stage.setScene(menuScene);
       
    }
   @FXML
    private void handleAbout(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Author: \nJordan Liebman");
        alert.setContentText("Press 'Determine Winner' to continue.\n"
                + "You may quit to main menu with the option in the File menu");

        alert.showAndWait();
    }
    @FXML
    private void move(ActionEvent event) {
// variable stores which player won the turn.
        int playerWonTurn;
        //check to see if game is won first
        //currently playing on auto
        while(autoGame.checkForWin() == 0){
            //while 0 keep playing
           if(autoGame.checkForWin() != 0){
               //1 you won
               if(autoGame.checkForWin()== 1){
                whoWon.setText("You Won!");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
            }
               //2 computer 1
            else if(autoGame.checkForWin() == 2){
                whoWon.setText("Computer Won :(");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
            }
           }
        //get the turn cards
        Card p1 = autoGame.players.get(0).hand.get(0);
        Card p2 = autoGame.players.get(1).hand.get(0);
        //display the turn cards
       yourCard.setText(p1.printCard());
       computerCard.setText(p2.printCard());
       //play the turn
       playerWonTurn = autoGame.turn();
        //check who won the turn and display their happy label
        //hide the other happy label
        if(playerWonTurn == 1){
            youWin.setVisible(true);
            compWin.setVisible(false);
            war.setVisible(false);  
            System.out.println("youWin");
               
            //check if game is won after the game.turn()
            // the check is performed before and after to ensure it is caught
        if(autoGame.checkForWin()==1){
                //you won
                whoWon.setText("You Won!");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
            }
            else if(autoGame.checkForWin() == 2){
                //comp won
                whoWon.setText("Computer Won :(");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
                
            }
            else if(autoGame.checkForWin() == 0){
                //still playing
            }
        }
        
        else if(playerWonTurn == 2){
            youWin.setVisible(false);
            compWin.setVisible(true);
            war.setVisible(false);
            System.out.println("ComputerWin");
               
                        //check if game is won
        if(autoGame.checkForWin()==1){
                //you won
                whoWon.setText("You Won!");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
            }
            else if(autoGame.checkForWin() == 2){
                //comp won
                whoWon.setText("Computer Won :(");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
                
            }
            else if(autoGame.checkForWin() == 0){
                //still playing
                
            }
        }
        else if(playerWonTurn == 3){
            youWin.setVisible(true);
            compWin.setVisible(true);
            war.setVisible(true);
            System.out.println("ComputerWin");
               
                        //check if game is won
            if(autoGame.checkForWin()==1){
                //you won
                whoWon.setText("You Won!");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
            }
            else if(autoGame.checkForWin() == 2){
                //comp won
                whoWon.setText("Computer Won :(");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
                
            }
            else if(autoGame.checkForWin() == 0){
                //still playing
                
            }
        }
    }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//todo
        autoGame = new AutoGameModel();
        autoGame.initializeGame();
    }
    
}
