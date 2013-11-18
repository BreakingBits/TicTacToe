package com.breakingbits.app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameBoardTest
{
    @Test
    public void testIfHorizontalWinIsTrueFirstRow(){
    	int[] grid1 = {1, 1, 1,
    			 	   0, 0, 0,
    			       0, 0, 0};
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(grid1, symbolX));
    }

    @Test
    public void testIfHorizontalWinIsTrueSecondRow(){
    	int[] grid1 = {0, 0, 0,
    			 	   1, 1, 1,
    			       0, 0, 0};
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(grid1, symbolX));
    }

    @Test
    public void testIfHorizontalWinIsTrueThirdRow(){
    	int[] grid1 = {0, 0, 0,
    			 	   0, 0, 0,
    			       1, 1, 1};
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(grid1, symbolX));
    }

    @Test
    public void testIfDiagonalWinIsTrueRight(){
    	int[] grid1 = {1, 0, 0,
    			 	   0, 1, 0,
    			       0, 0, 1};
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(grid1, symbolX));
    }

    @Test
    public void testIfDiagonalWinIsTrueLeft(){
    	int[] grid1 = {0, 0, 1,
    			 	   0, 1, 0,
    			       1, 0, 0};
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(grid1, symbolX));
    }

    @Test
    public void testIVerticalWinIsTrueFirstColumn(){
    	int[] grid1 = {1, 0, 0,
    			 	   1, 0, 0,
    			       1, 0, 0};
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(grid1, symbolX));
    }	

    @Test
    public void testIfVerticalWinIsTrueSecondColumn(){
    	int[] grid1 = {0, 1, 0,
    			 	   0, 1, 0,
    			       0, 1, 0};
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(grid1, symbolX));
    }

    @Test
    public void testIfVerticalWinIsTrueThirdColumn(){
    	int[] grid1 = {0, 0, 1,
    			 	   0, 0, 1,
    			       0, 0, 1};
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(grid1, symbolX));
    }

    @Test
    public void testIfWinIsFalse(){
    	//NOTE: With this test case, one could test different 
    	//permutations of the false state.
    	int[] grid2 = {0, 0, 0,
    			 	   0, 0, 0,
    				   0, 0, 0};
    	int symbolX = 1;
    	assertEquals(false, GameBoard.checkIfWinner(grid2, symbolX));
    }

    @Test
    public void testIfTie(){
    	int[] grid = {1, 1, 1,
    				  1, 1, 1,
    				  1, 1, 1};

    	assertEquals(true, GameBoard.checkIfTie(grid));
    }

}