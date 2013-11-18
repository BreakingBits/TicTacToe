package com.breakingbits.app;
import static spark.Spark.*;
import spark.*;

public class TicTacToe
{
    public static void main( String[] args )
    {
        staticFileLocation("/public");
        
    	get(new Route("/hello") {
         @Override
         public Object handle(Request request, Response response) {
            return "Hello World!";
         }
        });

        final Player PlayerOne = new Player();
        final Player PlayerTwo = new Player();

        get(new Route("/insertName") {
            @Override
            public Object handle(Request request, Response response) {

                String playerOneName = String.valueOf(request.queryParams("playerOne"));
                String playerTwoName = String.valueOf(request.queryParams("playerTwo"));

                PlayerOne.setName(playerOneName);
                PlayerTwo.setName(playerTwoName);

                return 0;
            }
        });
      
        
    }
}
