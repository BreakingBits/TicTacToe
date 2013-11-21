package com.breakingbits.app;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameInstanceTest
{
	Player p1 = new Player();
	Player p2 = new Player();
	GameInstance game = new GameInstance(p1, p2);
}