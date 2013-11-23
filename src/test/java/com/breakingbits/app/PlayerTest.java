package com.breakingbits.app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest
{
    // Footest
    Player testPlayer1 = new Player();

    @Test
    public void testGetAndSetForName() {
    	testPlayer1.setName("Bob");
    	assertEquals("Bob", testPlayer1.getName());
    }

    @Test
    public void testIncrementAndGetForWins() {
    	// Wins start at 0. First increment and then check value.
    	// No need to check for Losses and Ties - same functionality.
    	testPlayer1.incrementWins();
    	assertEquals(1, testPlayer1.getWins());
    }



}