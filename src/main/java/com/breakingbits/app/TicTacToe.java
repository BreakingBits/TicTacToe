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
    }
}
