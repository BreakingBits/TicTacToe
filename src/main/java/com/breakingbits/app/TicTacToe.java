package com.breakingbits.app;
import static spark.Spark.*;
import spark.*;
import java.util.*;
import org.json.simple.JSONObject;

/* TicTacToe.java - 23.11.2013
*  GROUP: Breaking Bits
*  GIT: https://github.com/organizations/BreakingBits
*  TicTacToe is the runtime class and handles communication
*  between players on the web interface and the server.
*  Routes for creating players with names from input, clicks by players
*  making moves, resetting the game and a small function to get wins of players.
*/

public class TicTacToe
{
    public static void main( String[] args )
    {
        staticFileLocation("/public");
        setPort(Integer.valueOf(System.getenv("PORT")));

        //Init players and game        
        final Player playerOne = new Player();
        final Player playerTwo = new Player(); 
        playerOne.setSymbol(1);
        playerTwo.setSymbol(2); 
        final GameInstance game = new GameInstance(playerOne, playerTwo); 

        //Assign names
        post(new Route("/insertName") {
            @Override
            public Object handle(Request request, Response response) {
                game.clearBoard();
                game.resetScores();

                String playerOneName = request.queryParams("player1");
                String playerTwoName = request.queryParams("player2");
                playerOne.setName(playerOneName);
                playerTwo.setName(playerTwoName);
                JSONObject playerObject = new JSONObject();  
                playerObject.put("player1", playerOneName);
                playerObject.put("player2", playerTwoName);

                return playerObject;
            }
        });

              
        //Cellid & number of player making a move
        post(new Route("/clickField") {
            @Override
            public Object handle(Request request, Response response) {
                String cellStr = request.queryParams("idOfCell");
                String actPlr = request.queryParams("player");
                int activePlayer = Integer.parseInt(actPlr);
                int cell = Integer.parseInt(cellStr);
                String playerName = "";

                int legal = game.playerMakeMove(cell, activePlayer );

                int gameStatus = game.gameStatus();

                if(activePlayer == 2)
                        playerName = playerOne.getName();
                    
                if(activePlayer == 1)
                        playerName = playerTwo.getName();
                    
                JSONObject cellObject = new JSONObject();
                cellObject.put("gameStatus", gameStatus);
                cellObject.put("activePlayer", game.getActivePlayer());
                cellObject.put("playerName", playerName);
                cellObject.put("turn", game.getTurns());
                cellObject.put("legal", legal);

                return cellObject;
            }
        });
        
        //Resets the board
        post(new Route("/resetGame") {
            @Override
            public Object handle(Request request, Response response) {
                JSONObject cellObject = new JSONObject();
                game.clearBoard();
                cellObject.put("activePlayer", game.getActivePlayer()); 
                cellObject.put("turn", game.getTurns());

                return cellObject;
            }
        });

        //Returns the wins and ties of players
        get(new Route("/getWins"){
            @Override
            public Object handle(Request request, Response response) {
                JSONObject cellObject = new JSONObject();
                cellObject.put("player1wins", playerOne.getWins());
                cellObject.put("player2wins", playerTwo.getWins());
                cellObject.put("ties", playerTwo.getTies());

                return cellObject;
            }
        });
        
    }
}
