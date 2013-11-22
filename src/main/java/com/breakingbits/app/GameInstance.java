package com.breakingbits.app;
import static spark.Spark.*;
import spark.*;

public class GameInstance
{
	private static Player playerOne;
	private static Player playerTwo;
	private static GameBoard board;

	public GameInstance(Player player1, Player player2) {
		board = new GameBoard();
		playerOne = player1;
		playerTwo = player2;
	}

	public int[] getGameBoard() {
		return board.getGrid();
	}
	
	//reset game
	public void clearBoard() {
		board.clearGrid();
	}

	public void playerMakeMove(int cell, int symbol) {
		board.setGrid(cell, symbol);
	}

	public static int gameStatus() {
		if ( board.checkIfWinner(playerOne.getSymbol()) ) {
			return 1;
		}
		else if ( board.checkIfWinner(playerTwo.getSymbol()) ) {
			return 2;
		}
		else if ( board.checkIfTie() ) {
			return 3;
		}
		else {
			return 0;
		}
	}
}