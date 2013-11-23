package com.breakingbits.app;
import static spark.Spark.*;
import spark.*;

/* GameBoard.java - 23.11.2013
*  GROUP: Breaking Bits
*  GIT: https://github.com/organizations/BreakingBits
* GameBoard holds all information regarding the Tic Tac Toe board.
* Initializing and resetting the board, getting specific cells in the board and 
* checks to see if a playerh as won or if the game ended in a tie.
* 
*/

public class GameBoard
{
	private static int[] grid;

	//Creates a new int array of nine spots
	public GameBoard() {
		grid = new int[9];
	}

	//Sets player symbol in the slot he clicked
	public void setGrid(int i, int v) {		
			grid[i] = v;		
	}
	
 	//Returns the slot in the array that is asked for
 	public static int getGrid(int slot) {
 		return grid[slot];
 	}

 	//Reset game
 	public static void clearGrid() {
 		for (int i = 0; i < 9; i++) 
 			grid[i] = 0;
 		
 	}
	//Checks for winner
 	public static Boolean checkIfWinner(int symbol) {
 		//In the grid: Zero is empty, One is X, Two is Circle.

 		//-----Horizontal win-----
 		if(((grid[0] == symbol) && (grid[1] == symbol) && (grid[2] == symbol)))
 			return true;
 		
 		if(((grid[3] == symbol) && (grid[4] == symbol) && (grid[5] == symbol)))
 			return true;
 		
 		if(((grid[6] == symbol) && (grid[7] == symbol) && (grid[8] == symbol)))
 			return true;
 		
 		//------------------------

 		//------Diagonal win------
 		if(((grid[0] == symbol) && (grid[4] == symbol) && (grid[8] == symbol)))
 			return true;
 		
 		if(((grid[6] == symbol) && (grid[4] == symbol) && (grid[2] == symbol)))
 			return true;
 		
 		//------------------------

 		//------Vertical win------
 		if(((grid[0] == symbol) && (grid[3] == symbol) && (grid[6] == symbol)))
 			return true;
 		
 		if(((grid[1] == symbol) && (grid[4] == symbol) && (grid[7] == symbol)))
 			return true;
 		
 		if(((grid[2] == symbol) && (grid[5] == symbol) && (grid[8] == symbol)))
 			return true;
 		
 		//------------------------

 		//No winner
 		return false;
 	} 
 	//PRECONDITION: Must be called after checkIfWinner.
 	//This function checks if the grid is full.
 	public static Boolean checkIfTie() {
 		
 		for(int i = 0; i < 9; i++){
 			if(grid[i] == 0) 
 				return false; 			
 		} 
 		return true;
 	}
}