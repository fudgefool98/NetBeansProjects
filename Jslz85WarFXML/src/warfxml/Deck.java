/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warfxml;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jordan
 */
public class Deck implements java.io.Serializable{
    
public ArrayList<Card> cards = new ArrayList<>();
//private int playerDealt

    public Deck(){
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                    cards.add(new Card(suit,rank));
                    
            }
        }     
    }
    
    
    public void shuffle(Deck deck){
        Collections.shuffle(cards);
    }
    
    public void deal(GameInterface game){
        game.initializePlayersHands();
        while(!cards.isEmpty()){
            for(int i=0;i<2;i++){
                    PlayerHand player = game.getPlayersHand(i);
                    if(cards.isEmpty()){
                        break;}
                    player.hand.add(cards.get(0)); 
                        cards.get(0).isInHand = true;
                        cards.remove(0);   
                }
            }
        }
    // for debugging
    public void print(Deck deck){
        for(Card card : cards)
            System.out.println( "" + card.rank + " of " + card.suit);
    }
}
