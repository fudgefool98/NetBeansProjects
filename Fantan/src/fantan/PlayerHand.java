/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantan;

import java.util.ArrayList;

/**
 *
 * @author Jordan
 */
public class PlayerHand {
        ArrayList<Card> hand = new ArrayList<>();
        boolean won = false;
        
    public PlayerHand(){
    }
    public void addCardToHand(Card card){
        
        hand.add(card);
    }
    public void printHand(){
        for(Card hand: hand){
            System.out.println(hand.printCard(hand));
        }
    }
    public void move(){
        //makes an ideal move based on the game board
        
        
        
        this.checkForWin();
    }
    public void checkForWin(){
        if(0==this.hand.size()){
            won = true;
        }
    
    }
}
