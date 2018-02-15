/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warfxml;

/**
 *
 * @author Jordan
 */
public class Card implements java.io.Serializable{
    public Rank rank;
    public Suit suit;
    public boolean isInHand = false;
    
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public String printCard(){
    String result = "The ";
            result+=this.rank.toString();
    result+= " of ";
    result+= this.suit.toString();
    return result; 
    }
}