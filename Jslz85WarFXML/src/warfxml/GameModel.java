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
//MAKE THIS ABSTRACT!!!!
public class GameModel implements GameInterface, java.io.Serializable{
    //create a deck
    public Deck deck = new Deck();
    public int i;
    public int numberOfPlayers = 2;
    //if gameWon = 1 p1 won
    //if gameWon = 2 p2 won
    //while gameWon = 0 game isn't won
    public int gameWon = 0;
    ArrayList<PlayerHand> players = new ArrayList<>();
    @Override
    public PlayerHand getPlayersHand(int i){
        return this.players.get(i);
    }
    @Override
    public void initializePlayersHands(){
        //takes in nothing (uses numberOfPlayers (initilized by user selection)
        //populates players arrayList of players 0 - numberOfPlayers-1
        for(i=0 ; i < numberOfPlayers; i++){
            players.add(i, new PlayerHand());
            }
    }
    
    @Override
    public int turn(){
        //if your card > computer card
        if(players.get(0).hand.get(0).rank.ordinal() > players.get(1).hand.get(0).rank.ordinal() ){
            players.get(0).hand.add(players.get(1).hand.get(0));
            players.get(0).hand.add(players.get(0).hand.get(0));
            players.get(0).hand.remove(0);
            players.get(1).hand.remove(0);
            
            return 1;
            
        }
        //if your card < computer card
        else if(players.get(0).hand.get(0).rank.ordinal() < players.get(1).hand.get(0).rank.ordinal() ){//0<1
            players.get(1).hand.add(players.get(0).hand.get(0));
            players.get(1).hand.add(players.get(1).hand.get(0));
            players.get(0).hand.remove(0);
            players.get(1).hand.remove(0);
            return 2;
        }
        else{
            //for now a tie means that you look at the next card and check again
            
            //if you only have one card left in hand you can't enter the loop, 
            //you forfeit your last card.
            if(players.get(0).hand.size()==1){
                players.get(1).hand.add(players.get(0).hand.get(0));
                players.get(0).hand.remove(0);
            }
            else if (players.get(1).hand.size()==1){
                players.get(0).hand.add(players.get(1).hand.get(0));
                players.get(1).hand.remove(0);
            }
            Boolean atWar = true;
            while(atWar){
            int i = 1;
            System.out.println("war");
            //if your card > computer card
                if(players.get(0).hand.get(i).rank.ordinal() > players.get(1).hand.get(i).rank.ordinal() ){
                    players.get(0).hand.add(players.get(1).hand.get(i));
                    players.get(0).hand.add(players.get(0).hand.get(i));
                    players.get(0).hand.add(players.get(1).hand.get(0));
                    players.get(0).hand.add(players.get(0).hand.get(0));
            
                    players.get(0).hand.remove(i);
                    players.get(1).hand.remove(i);
                    players.get(0).hand.remove(0);
                    players.get(1).hand.remove(0);
                    
                    return 1;
                }
                //if your card < computer card
           else if(players.get(0).hand.get(i).rank.ordinal() < players.get(1).hand.get(i).rank.ordinal() ){//0<1
                    players.get(1).hand.add(players.get(0).hand.get(i));
                    players.get(1).hand.add(players.get(1).hand.get(i));
                    players.get(1).hand.add(players.get(0).hand.get(0));
                    players.get(1).hand.add(players.get(1).hand.get(0));
                    players.get(0).hand.remove(i);
                    players.get(1).hand.remove(i);
                    players.get(0).hand.remove(0);
                    players.get(1).hand.remove(0);
                    
                    return 2;
                    }
        players.get(0).hand.add(players.get(0).hand.get(0));
        players.get(0).hand.remove(players.get(0).hand.get(0));
        players.get(1).hand.add(players.get(1).hand.get(0));
        players.get(1).hand.remove(players.get(1).hand.get(0));
            return 3;
            }
        }
        return 0;
    }
    @Override
    public int checkForWin(){
        if(players.get(0).hand.isEmpty()){
            gameWon = 2;
            return gameWon;
        }
        else if(players.get(1).hand.isEmpty()){
            gameWon = 1;
            return gameWon;
        }
        else{
            return gameWon;
        }
    }
    public void initializeGame(){
    //shuffle & deal the deck in game
        this.deck.shuffle(this.deck);
        this.deck.deal(this);
        players.get(0).isComputer = false;
    }

}
//for debug
//    public void printAllHands(){
//        for(int i =0 ; i<this.numberOfPlayers;i++){
//            System.out.println(" ");
//        this.players.get(i).printHand();
//        }
//    }
//}
