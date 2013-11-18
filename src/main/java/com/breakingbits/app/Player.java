package com.breakingbits.app;
import static spark.Spark.*;
import spark.*;

public class Player
{
    private String name;
    private String symbol;
    private int wins;
    private int losses;
    private int ties;

    public Player() {
    	name = "";
    	symbol = "";
    	wins = 0;
    	losses = 0;
    	ties = 0;
    }

    public void setName (String nm) {
    	name = nm;
    }

}