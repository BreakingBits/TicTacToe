package com.breakingbits.app;
import static spark.Spark.*;
import spark.*;

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

    public void flipSymbol() {
        if (symbol == 1) {
            symbol = 2;
        }
        else {
            symbol = 1;
        }
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

}