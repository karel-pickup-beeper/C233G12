package com.karelRPG.gameplay;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EndGameTest {
	
	@Test
	public void test_Constructor() {
		EndGame e = new EndGame();
		
		assertEquals ("Test constructor, testing game over", true, e.isGameOver());
	}
}
