package com.breakingbits.app;
import static spark.Spark.*;
import spark.*;

public class GameBoard
{
	private static int[] grid;

	public GameBoard() {
		grid = new int[9];
	}

	public void setGrid(int i, int v) {
		grid[i] = v;
	}

 	public static int[] getGrid() {
 		return grid;
 	}

 	public static int getGrid(int slot) {
 		return grid[slot];
 	}

 	public static void clearGrid() {
 		for (int i = 0; i < 9; i++) {
 			grid[i] = 0;
 		}
 	}
	
 	public static Boolean checkIfWinner(int symbol) {
 		//In the grid: Zero is empty, One is X, Two is Circle.
 		//-----Horizontal win-----
 		if(((grid[0] == symbol) && 
 			(grid[1] == symbol) && 
 			(grid[2] == symbol))){
 			return true;
 		}
 		if(((grid[3] == symbol) && 
 		    (grid[4] == symbol) && 
 		    (grid[5] == symbol))){
 			return true;
 		}
 		if(((grid[6] == symbol) && 
    	    (grid[7] == symbol) && 
 		    (grid[8] == symbol))){
 			return true;
 		}
 		//------------------------

 		//------Diagonal win------
 		if(((grid[0] == symbol) && 
    	    (grid[4] == symbol) && 
 		    (grid[8] == symbol))){
 			return true;
 		}
 		if(((grid[6] == symbol) && 
    	    (grid[4] == symbol) && 
 		    (grid[2] == symbol))){
 			return true;
 		}
 		//------------------------

 		//------Vertical win------
 		if(((grid[0] == symbol) && 
 			(grid[3] == symbol) && 
 			(grid[6] == symbol))){
 			return true;
 		}
 		if(((grid[1] == symbol) && 
 		    (grid[4] == symbol) && 
 		    (grid[7] == symbol))){
 			return true;
 		}
 		if(((grid[2] == symbol) && 
    	    (grid[5] == symbol) && 
 		    (grid[8] == symbol))){
 			return true;
 		}
 		//------------------------

 		return false;
 	} 

 	public static Boolean checkIfTie() {
 		//PRECONDITION: Must be called after checkIfWinner.
 		//This function checks if the grid is full.
 		for(int i = 0; i < 9; i++){
 			if(grid[i] == 0) {
 				return false;
 			}
 		} 
 		return true;
 	}
}