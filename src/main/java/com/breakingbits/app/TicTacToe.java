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

        post(new Route("/clickField") {
            @Override
            public Object handle(Request request, Response response) {
                String cellStr = request.queryParams("idOfCell");
                int cell = Integer.parseInt(cellStr);
                //String playerStr = request.queryParams("player");
                //int player = Integer.parseInt(playerStr);
                game.playerMakeMove(cell, 1);

                int gameStatus = game.gameStatus();

                JSONObject cellObject = new JSONObject();
                cellObject.put("gameStatus", gameStatus);
                return cellObject;
            }
        });

        post(new Route("/resetGame") {
            @Override
            public Object handle(Request request, Response response) {
                
                game.clearBoard();                
                return "ok";
            }
        });


    }

}
