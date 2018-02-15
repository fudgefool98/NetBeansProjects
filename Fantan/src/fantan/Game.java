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
//MAKE THIS ABSTRACT!!!!
public class Game {
    //create a deck
    Deck deck = new Deck();
    int i;
    public int numberOfPlayers = 4;
    public boolean gameWon = false;
    private int turns = 0;
    ArrayList<PlayerHand> players = new ArrayList<>();
    
    
    
    public void initializePlayersHands(){
        //takes in nothing (uses numberOfPlayers (initilized by user selection)
        //populates players arrayList of players 0 - numberOfPlayers-1
        for(i=0 ; i < numberOfPlayers; i++){
            players.add(i, new PlayerHand());
            }
        }
    public void playGame(){
    //shuffle & deal the deck in game
        this.deck.shuffle(this.deck);
        this.deck.deal(this);
        //DISPLAY HANDS TO PLAYERSS
        this.printAllHands();
    //play until someone has won
    //while(!gameWon){
        //this for loop is used to itterate through the players
        //and let them make moves until one of them has won the game.
        for(i =0;i<numberOfPlayers;i++){
            this.players.get(i).move();
            if(this.players.get(i).won){
                gameWon = true;
            }
        }
    //CHANGE SCENE TO YOU WON SCREEN FOR PLAYER #
    //}
}
    public void makeBoard(){
        ArrayList<ArrayList> board = new ArrayList<>();
        ArrayList<Card> spades = new ArrayList<>();
        ArrayList<Card> clubs = new ArrayList<>();
        ArrayList<Card> diamonds = new ArrayList<>();
        ArrayList<Card> hearts = new ArrayList<>();
        board.set(0,hearts);
        board.set(1,spades);
        board.set(2,diamonds);
        board.set(3,clubs);
    }
    public void printAllHands(){
        for(int i =0 ; i<this.numberOfPlayers;i++){
            System.out.println(" ");
        this.players.get(i).printHand();
        }
    }
}
