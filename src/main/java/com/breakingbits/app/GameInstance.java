package com.breakingbits.app;
import static spark.Spark.*;
import spark.*;

public class GameInstance
{
	private Player playerOne;
	private Player playerTwo;
	private GameBoard board;

	public GameInstance(Player player1, Player player2) {
		board = new GameBoard();
		playerOne = player1;
		playerTwo = player2;
	}

}