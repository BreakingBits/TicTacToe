package com.breakingbits.app;
import static spark.Spark.*;
import spark.*;

/* Player.java - 23.11.2013
*  GROUP: Breaking Bits
*  GIT: https://github.com/organizations/BreakingBits
*  Player holds all information regarding individual players in Tic Tac Toe
*  Variables for name, player symbol and total wins/losses/ties
*  Getter and setter functions and functions to increment wins/losses/ties.
* 
*/

public class Player
{
    private String name;
    private int symbol;
    private int wins;
    private int losses;
    private int ties;

    public Player() {
    	symbol = 0;
    	wins = 0;
    	losses = 0;
    	ties = 0;
    }
   
    public String getName()
    {
        return name;
    }

    public void setName (String nm) {
    	name = nm;
    }

    public int getSymbol()
    {
        return symbol;
    }

    public void setSymbol (int sym) {
        symbol = sym;
    }

    public int getWins()
    {
        return wins;
    }

    public void incrementWins() {
        wins = wins + 1;
    }

    public int getLosses()
    {
        return losses;
    }

    public void incrementLosses() {
        losses = losses + 1;
    }

    public int getTies()
    {
        return ties;
    }

    public void incrementTies() {
        ties = ties + 1;
    }

    public void resetScore() {
        wins = 0;
        losses = 0;
        ties = 0;
    }

}