/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warfxml;

import java.util.ArrayList;

/**
 *
 * @author Jordan
 */
public abstract class AbstractCardSet {
    //could be extended to a discard pile an InPlayDeck and a playerhand
public ArrayList<Card> hand = new ArrayList<>();
    //printing is good for debugging        
public abstract void printHand();
public abstract void sortHand();
}
