package com.breakingbits.app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameInstanceTest
{
    Player testPlayerOne = new Player();
    Player testPlayerTwo = new Player(); 
    //testPlayerOne.setSymbol(1);
    //testPlayerTwo.setSymbol(2);
	GameInstance testGame = new GameInstance(testPlayerOne, testPlayerTwo);

	/* NOTE: Test X through Y
	   We've already tested very thoroughly all win and tie scenarios.
	   The following tests are therefore built on already tested code.
	   
	   The values below correspond to a certain "game status":
	   0 = No win or tie - game keeps on
	   1 = testPlayerOne wins
	   2 = testPlayerTwo wins
	   3 = Tie
	*/

    @Test
    public void testGameStatusWhenPlayerOneWins() {
        // This win scenario should return 1, as testPlayerOne has won.
        /* 1 1 1
           0 0 0
           0 0 0 */

        testGame.playerMakeMove(0, 1);
		testGame.playerMakeMove(1, 1);
		testGame.playerMakeMove(2, 1);

    	assertEquals(1, GameInstance.gameStatus());
    }
}