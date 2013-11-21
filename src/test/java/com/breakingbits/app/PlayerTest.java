package com.breakingbits.app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest
{
    Player testPlayer1 = new Player();

    @Test
    public void testGetAndSetForName() {
    	testPlayer1.setName("Bob");

    	assertEquals("Bob", testPlayer1.getName());
    }

    @Test
    public void testGetAndSetForSymbol() {
    	testPlayer1.setSymbol(1);

    	assertEquals(1, testPlayer1.getSymbol());
    }

    @Test
    public void testFlipSymbol() {
    	testPlayer1.setSymbol(1);
    	testPlayer1.flipSymbol();
    	assertEquals(2, testPlayer1.getSymbol());
    }

}