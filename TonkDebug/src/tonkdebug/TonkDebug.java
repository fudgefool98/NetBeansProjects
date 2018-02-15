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
public class TonkDebug {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        //deck.shuffle(deck);
        //deck.sort(deck);
        deck.print(deck);
    }
    
}
