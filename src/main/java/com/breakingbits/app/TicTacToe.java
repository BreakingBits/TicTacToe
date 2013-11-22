package com.breakingbits.app;
import static spark.Spark.*;
import spark.*;
import java.util.*;
import org.json.simple.JSONObject;

public class TicTacToe
{
    public static void main( String[] args )
    {
        staticFileLocation("/public");

        setPort(Integer.valueOf(System.getenv("PORT")));

        //Init players
        final Player playerOne = new Player();
        final Player playerTwo = new Player(); 
        playerOne.setSymbol(1);
        playerTwo.setSymbol(2); 

        //Assign names
        post(new Route("/insertName") {
            @Override
            public Object handle(Request request, Response response) {
                String playerOneName = request.queryParams("player1");
                String playerTwoName = request.queryParams("player2");

                playerOne.setName(playerOneName);
                playerTwo.setName(playerTwoName);

                //Send the response as JSON Object
                JSONObject playerObject = new JSONObject();  
                playerObject.put("player1", playerOneName);
                playerObject.put("player2", playerTwoName);
                return playerObject;
            }
        });

        final GameInstance game = new GameInstance(playerOne, playerTwo);       
        //Cellid & number of player making a move
        post(new Route("/clickField") {
            @Override
            public Object handle(Request request, Response response) {
                String cellStr = request.queryParams("idOfCell");
                String actPlr = request.queryParams("player");
                int activePlayer = Integer.parseInt(actPlr);
                int cell = Integer.parseInt(cellStr);
                //String playerStr = request.queryParams("player");
                //int player = Integer.parseInt(playerStr);
                int legal = game.playerMakeMove(cell, activePlayer );

                int gameStatus = game.gameStatus();

                JSONObject cellObject = new JSONObject();
                cellObject.put("gameStatus", gameStatus);
                cellObject.put("activePlayer", game.getActivePlayer());
                cellObject.put("turn", game.getTurns());
                cellObject.put("legal", legal);
                return cellObject;
            }
        });

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
