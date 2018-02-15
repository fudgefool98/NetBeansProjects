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
public interface GameInterface {
    
public void initializePlayersHands();
public PlayerHand getPlayersHand(int i);
public int turn();
public int checkForWin();


}
