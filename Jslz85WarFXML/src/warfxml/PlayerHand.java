/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warfxml;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author Jordan
 */
public class PlayerHand extends AbstractCardSet implements java.io.Serializable {
    
        public ArrayList<Card> hand = new ArrayList<>();
        public boolean isComputer = false;
        public boolean lost = false;
        
    @Override
    public void printHand(){
        for(Card hand: hand){           
            System.out.println(hand.printCard());
        }
    }
    
    public void checkForWin(){
        if(0==this.hand.size()){
            lost = true;
        }   
    }

    @Override
    public void sortHand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
