package com.breakingbits.app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameBoardTest
{
    @Test
    public void testIfWinnerIsTrue(){
    	assertEquals(true, GameBoard.checkIfWinner(true));
    }
}