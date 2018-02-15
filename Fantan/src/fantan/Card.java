/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fantan;

/**
 *
 * @author Jordan
 */
public class Card{
    public Integer id;//for use in sort
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

    public String printCard(Card card){
    String result = "The ";
            result+=rank.toString();
    result+= " of ";
    result+= suit.toString();
        if(card.isInHand = true){
            result+= " is in hand";
        }
    return result; 
}
}