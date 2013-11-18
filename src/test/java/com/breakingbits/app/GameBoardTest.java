package com.breakingbits.app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameBoardTest
{
    @Test
    public void testIfHorizontalWinIsTrueFirstRow(){
 		//In the grid: Zero is empty, One is X, Two is Circle.

    	int[] grid1 = {1, 1, 1,
    			 	   0, 0, 0,
    			       0, 0, 0};
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(grid1, symbolX));
    }

    @Test
    public void testIfHorizontalWinIsTrueSecondRow(){
 		//In the grid: Zero is empty, One is X, Two is Circle.

    	int[] grid1 = {0, 0, 0,
    			 	   1, 1, 1,
    			       0, 0, 0};
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(grid1, symbolX));
    }

    @Test
    public void testIfHorizontalWinIsTrueThirdRow(){
 		//In the grid: Zero is empty, One is X, Two is Circle.

    	int[] grid1 = {0, 0, 0,
    			 	   0, 0, 0,
    			       1, 1, 1};
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(grid1, symbolX));
    }

    @Test
    public void testIfDiagonalWinIsTrueRight(){
    	//In the grid: Zero is empty, One is X, Two is Circle.

    	int[] grid1 = {1, 0, 0,
    			 	   0, 1, 0,
    			       0, 0, 1};
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(grid1, symbolX));
    }

    @Test
    public void testIfDiagonalWinIsTrueLeft(){
    	//In the grid: Zero is empty, One is X, Two is Circle.

    	int[] grid1 = {0, 0, 1,
    			 	   0, 1, 0,
    			       1, 0, 0};
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(grid1, symbolX));
    }

    @Test
    public void testIfWinIsFalse(){
 		//In the grid: Zero is empty, One is X, Two is Circle.

    	int[] grid2 = {0, 0, 0,
    			 	   0, 0, 0,
    				   0, 0, 0};
    	int symbolX = 1;
    	assertEquals(false, GameBoard.checkIfWinner(grid2, symbolX));
    }
}