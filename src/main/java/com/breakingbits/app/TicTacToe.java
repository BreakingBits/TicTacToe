package com.breakingbits.app;
import static spark.Spark.*;
import spark.*;
import com.google.gson.*;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.*;


public class TicTacToe
{
    public static void main( String[] args )
    {
        staticFileLocation("/public");

        //Init players
        final Player PlayerOne = new Player();
        final Player PlayerTwo = new Player();  

        //Assign names
        post(new Route("/insertName") {
            @Override
            public Object handle(Request request, Response response) {

                String playerOneName = request.queryParams("p1");
                String playerTwoName = request.queryParams("p2");

                PlayerOne.setName(playerOneName);
                PlayerTwo.setName(playerTwoName);

                //Send the response
                response.status(200); 
                return response;

            }
        });
        

        get(new Route("/hello") {
         @Override
         public Object handle(Request request, Response response) {
            return "Hello World!";
         }
        });      
        
    }

}
