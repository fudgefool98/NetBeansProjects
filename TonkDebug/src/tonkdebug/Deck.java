/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tonkdebug;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jordan
 */
public class Deck {
    
public ArrayList<Card> cards = new ArrayList<>();
Integer i=0;



    public Deck(){
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                    cards.add(new Card(i,suit,rank));
                    i++;
            }
        }
        
    }
    
    
    public void shuffle(Deck deck){
        Collections.shuffle(cards);
    }
    public void sort(Deck deck){
        
    }
    public void deal(Deck deck){
        
    }
    public void print(Deck deck){
        for(Card card : cards)
            System.out.println( "" + card.rank + " of " + card.suit + " ID# " + card.id );
        
    }

}
