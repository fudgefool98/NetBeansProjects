/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warfxml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Jordan
 */
public class WarController implements Initializable {
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
    // need variables to switch stages
    public Scene menuScene;
    public MenuController controller;
    private Stage stage;
    private GameModel game;
    
    public Card p1; 
    public Card p2;
    
    public void start(Stage stage) {
        this.stage = stage;
        
    }
    @FXML
    private void move(ActionEvent event) {
// variable stores which player won the turn.
        int playerWonTurn;
        //check to see if game is won first
        //currently playing on auto
            //while 0 keep playing
           if(game.checkForWin() != 0){
               //1 you won
               if(game.checkForWin()== 1){
                whoWon.setText("You Won!");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
            }
               //2 computer 1
            else if(game.checkForWin() == 2){
                whoWon.setText("Computer Won :(");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
            }
           }
        //get the turn cards
        p1 = game.players.get(0).hand.get(0);
        p2 = game.players.get(1).hand.get(0);
        //display the turn cards
       yourCard.setText(p1.printCard());
       computerCard.setText(p2.printCard());
       //play the turn
       playerWonTurn = game.turn();
        //check who won the turn and display their happy label
        //hide the other happy label
        if(playerWonTurn == 1){
            youWin.setVisible(true);
            compWin.setVisible(false);
            war.setVisible(false);  
            System.out.println("youWin");
               
            //check if game is won after the game.turn()
            // the check is performed before and after to ensure it is caught
        if(game.checkForWin()==1){
                //you won
                whoWon.setText("You Won!");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
            }
            else if(game.checkForWin() == 2){
                //comp won
                whoWon.setText("Computer Won :(");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
                
            }
            else if(game.checkForWin() == 0){
                //still playing
            }
        }
        
        else if(playerWonTurn == 2){
            youWin.setVisible(false);
            compWin.setVisible(true);
            war.setVisible(false);
            System.out.println("ComputerWin");
               
                        //check if game is won
        if(game.checkForWin()==1){
                //you won
                whoWon.setText("You Won!");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
            }
            else if(game.checkForWin() == 2){
                //comp won
                whoWon.setText("Computer Won :(");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
                
            }
            else if(game.checkForWin() == 0){
                //still playing
                
            }
        }
        else if(playerWonTurn == 3){
            youWin.setVisible(true);
            compWin.setVisible(true);
            war.setVisible(true);
            System.out.println("ComputerWin");
               
                        //check if game is won
            if(game.checkForWin()==1){
                //you won
                whoWon.setText("You Won!");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
            }
            else if(game.checkForWin() == 2){
                //comp won
                whoWon.setText("Computer Won :(");
                whoWon.setVisible(true);
                button.setVisible(false);
                button.setManaged(false);
                
            }
            else if(game.checkForWin() == 0){
                //still playing
                
            }
        }
    }
    
    //everything below is not relevant to the game 
    //It's for the UI and other requirements
@FXML
    private void goBackToPage1(ActionEvent event) {
       
        
        stage.setScene(menuScene);
       
    }
    @FXML 
    private void handleOpen(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                FileInputStream fileIn = new FileInputStream(file.getPath());
                ObjectInputStream in = new ObjectInputStream(fileIn);
                
                game = (GameModel) in.readObject();
                
                in.close();
                fileIn.close();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(WarController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(WarController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(WarController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @FXML
    public void handleSave(ActionEvent event) {
       //game = createPersonFromFormData();
       
       if(game == null){
           showMessageDialog(null, "Can't save no game");

           return;
       }
        
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try {
                FileOutputStream fileOut = new FileOutputStream(file.getPath());
                        
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                
                out.writeObject(game);
                
                out.close();
                fileOut.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(WarController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(WarController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }        
    }
    @FXML
    private void handleAbout(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Author: \nJordan Liebman");
        alert.setContentText("Press 'Next Turn' to continue.\n"
                + "You may save, open, or quit to main menu, with the options in the File menu");

        alert.showAndWait();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//todo
        game = new GameModel();
        game.initializeGame();
        war.setVisible(false);
        whoWon.setVisible(false);
    }
    
}
