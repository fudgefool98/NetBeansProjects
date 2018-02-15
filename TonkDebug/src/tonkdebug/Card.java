/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tonkdebug;

/**
 *
 * @author Jordan
 */
public class Card{
    public Integer id;
    public Rank rank;
    public Suit suit;
    public boolean isInHand = false;
    
    public Card(int id, Suit suit, Rank rank){
        this.id = id;
        this.suit = suit;
        this.rank = rank;

    }

    
    public Card compareTo(Card a,Card b) {
        if(a.id < b.id){
            return a;
                    } else {
            return b;
                    }
    }

    
    
}