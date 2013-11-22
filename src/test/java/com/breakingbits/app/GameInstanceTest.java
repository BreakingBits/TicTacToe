package com.breakingbits.app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameInstanceTest
{
    Player testPlayerOne;
    Player testPlayerTwo;
    GameInstance testGame;

    public void initilizeTestVariables() {
    	testPlayerOne = new Player();
    	testPlayerTwo = new Player();
	    testPlayerOne.setSymbol(1);
    	testPlayerTwo.setSymbol(2);
    	testGame = new GameInstance(testPlayerOne, testPlayerTwo);
    }

	/* NOTE: Test X through Y
	   We've already tested very thoroughly all win and tie scenarios.
	   The following tests are therefore built on already tested code.
	   
	   The values below correspond to a certain "game status":
	   0 = No win or tie - ongoing game
	   1 = testPlayerOne wins
	   2 = testPlayerTwo wins
	   3 = Tie
	*/

	@Test
    public void testGameStatusWhenNeitherWinNorTie() {
        // In the following scenario, the game should be ongoing (no win/tie).
        // The gameStatus() function should return 0.
        /* 1 0 2
           0 2 1
           0 1 0 */

    	initilizeTestVariables();
    	testGame.playerMakeMove(0, 1);
    	testGame.playerMakeMove(2, 2);
    	testGame.playerMakeMove(5, 1);
    	testGame.playerMakeMove(4, 2);
    	testGame.playerMakeMove(7, 1);
    	assertEquals(0, testGame.gameStatus());
    	testGame.clearBoard();
    }

	@Test
    public void testGameStatusWhenPlayerOneWins() {
        // In the following scenario, testPlayerOne should win.
        // The gameStatus() function should return 1.
        /* 1 1 1
           0 0 0
           0 0 0 */

    	initilizeTestVariables();
    	testGame.playerMakeMove(0, 1);
    	testGame.playerMakeMove(1, 1);
    	testGame.playerMakeMove(2, 1);
    	assertEquals(1, testGame.gameStatus());
    	testGame.clearBoard();
    }

	@Test
    public void testGameStatusWhenPlayerTwoWins() {
        // In the following scenario, testPlayerTwo should win.
        // The gameStatus() function should return 2.
        /* 2 0 0
           0 2 0
           0 0 2 */

    	initilizeTestVariables();
    	testGame.playerMakeMove(0, 2);
    	testGame.playerMakeMove(4, 2);
    	testGame.playerMakeMove(8, 2);
    	assertEquals(2, testGame.gameStatus());
    	testGame.clearBoard();
    }

	@Test
    public void testGameStatusWhenTie() {
        // In the following scenario, there should be a tie.
        // The gameStatus() function should return 3.
        /* 1 2 1
           2 2 1
           1 1 2 */

    	initilizeTestVariables();
    	testGame.playerMakeMove(0, 1);
    	testGame.playerMakeMove(1, 2);
    	testGame.playerMakeMove(2, 1);
    	testGame.playerMakeMove(3, 2);
    	testGame.playerMakeMove(6, 1);
    	testGame.playerMakeMove(8, 2);
    	testGame.playerMakeMove(7, 1);
    	testGame.playerMakeMove(4, 2);
    	testGame.playerMakeMove(5, 1);
    	assertEquals(3, testGame.gameStatus());
    	testGame.clearBoard();
    }

}