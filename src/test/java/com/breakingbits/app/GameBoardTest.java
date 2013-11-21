package com.breakingbits.app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameBoardTest
{
    GameBoard testGrid1 = new GameBoard();

    @Test
    public void testIfHorizontalWinIsTrueFirstRow(){
        /* 1 1 1
           0 0 0
           0 0 0 */

        testGrid1.setGrid(0, 1);
        testGrid1.setGrid(1, 1);
        testGrid1.setGrid(2, 1);
            	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(symbolX));
        testGrid1.clearGrid();
    }

    @Test
    public void testIfHorizontalWinIsTrueSecondRow(){
        /* 0 0 0
           1 1 1
           0 0 0 */

        testGrid1.setGrid(3, 1);
        testGrid1.setGrid(4, 1);
        testGrid1.setGrid(5, 1);
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(symbolX));
        testGrid1.clearGrid();
    }

    @Test
    public void testIfHorizontalWinIsTrueThirdRow(){
        /* 0 0 0
           0 0 0
           1 1 1 */

        testGrid1.setGrid(6, 1);
        testGrid1.setGrid(7, 1);
        testGrid1.setGrid(8, 1);
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(symbolX));
        testGrid1.clearGrid();
    }

    @Test
    public void testIfDiagonalWinIsTrueLeft(){
        /* 1 0 0
           0 1 0
           0 0 1 */

        testGrid1.setGrid(0, 1);
        testGrid1.setGrid(4, 1);
        testGrid1.setGrid(8, 1);
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(symbolX));
        testGrid1.clearGrid();
    }

    @Test
    public void testIfDiagonalWinIsTrueRight(){
        /* 0 0 1
           0 1 0
           1 0 0 */

        testGrid1.setGrid(2, 1);
        testGrid1.setGrid(4, 1);
        testGrid1.setGrid(6, 1);
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(symbolX));
        testGrid1.clearGrid();
    }

    @Test
    public void testIVerticalWinIsTrueFirstColumn(){
        /* 1 0 0
           1 0 0
           1 0 0 */

        testGrid1.setGrid(0, 1);
        testGrid1.setGrid(3, 1);
        testGrid1.setGrid(6, 1);
    	
    	int symbolX = 1;
    	assertEquals(true, GameBoard.checkIfWinner(symbolX));
        testGrid1.clearGrid();
    }	

    @Test
    public void testIfVerticalWinIsTrueSecondColumn(){
        /* 0 1 0
           0 1 0
           0 1 0 */

        testGrid1.setGrid(1, 1);
        testGrid1.setGrid(4, 1);
        testGrid1.setGrid(7, 1);
        
        int symbolX = 1;
        assertEquals(true, GameBoard.checkIfWinner(symbolX));
        testGrid1.clearGrid();
    }

    @Test
    public void testIfVerticalWinIsTrueThirdColumn(){
        /* 0 0 1
           0 0 1
           0 0 1 */

        testGrid1.setGrid(2, 1);
        testGrid1.setGrid(5, 1);
        testGrid1.setGrid(8, 1);
        
        int symbolX = 1;
        assertEquals(true, GameBoard.checkIfWinner(symbolX));
        testGrid1.clearGrid();
    }

    @Test
    public void testIfWinIsFalse(){
    	//NOTE: With this test case, one could test different 
    	//permutations of the false state.

        int symbolX = 1;
        assertEquals(false, GameBoard.checkIfWinner(symbolX));
        testGrid1.clearGrid();
    }

    @Test
    public void testIfTie(){
        /* 1 1 1
           1 1 1
           1 1 1 */

        testGrid1.setGrid(0, 1);
        testGrid1.setGrid(1, 1);
        testGrid1.setGrid(2, 1);
        testGrid1.setGrid(3, 1);
        testGrid1.setGrid(4, 1);
        testGrid1.setGrid(5, 1);
        testGrid1.setGrid(6, 1);
        testGrid1.setGrid(7, 1);
        testGrid1.setGrid(8, 1);

    	assertEquals(true, GameBoard.checkIfTie());
        testGrid1.clearGrid();
    }
    /*
    @Test
    public void testConstructor() {
        GameBoard testGrid2 = new GameBoard();

        assertEquals(null, testGrid2);
    }
    */
    
}