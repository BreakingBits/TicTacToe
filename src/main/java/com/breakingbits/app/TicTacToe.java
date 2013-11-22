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

        post(new Route("/clickField") {
            @Override
            public Object handle(Request request, Response response) {
                String cellStr = request.queryParams("idOfCell");
                JSONObject cellObject = new JSONObject();
                cellObject.put("idOfCell", cellStr);
                return cellObject;
            }
        });
        
    }

}
