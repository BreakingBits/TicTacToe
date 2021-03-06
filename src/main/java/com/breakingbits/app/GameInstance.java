package com.breakingbits.app;
import static spark.Spark.*;
import spark.*;

public class GameInstance
{
	private static Player playerOne;
	private static Player playerTwo;
	private static GameBoard board;
	
	//Turns 
	private static int turns;

	//Active player
	private static int activePlayer;

	public GameInstance(Player player1, Player player2) {
		board = new GameBoard();
		playerOne = player1;
		playerTwo = player2;

		activePlayer = 1;
		turns = 0;
	}
	
	//reset game
	public void clearBoard() {
		board.clearGrid();
		activePlayer = 1;
		turns = 0;
	}

	public static void resetScores() {
		playerOne.resetScore();
		playerTwo.resetScore();
	}

	public int playerMakeMove(int cell, int symbol) {
		
		if(board.getGrid(cell) == 0)
		{
			if(turns % 2 == 0)
			{
			activePlayer = 2;
			}
			else
			{
			activePlayer = 1;
			}

			turns++;
			board.setGrid(cell, symbol);
			return 1;
		}

		else
		{
			return 0;
		}		
	}

	public static int gameStatus() {
		if ( board.checkIfWinner(1) ) {
			playerOne.incrementWins();
			return 1;
		}
		else if ( board.checkIfWinner(2) ) {
			playerTwo.incrementWins();
			return 2;
		}
		else if ( board.checkIfTie() ) {
			playerOne.incrementTies();
			playerTwo.incrementTies();
			return 3;
		}
		else {
			return 0;
		}
	}

	public static int getActivePlayer() {

		return activePlayer;
	}

	public static int getTurns() {
		return turns;
	}

}