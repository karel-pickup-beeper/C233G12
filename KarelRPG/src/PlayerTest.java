
import static org.junit.Assert.*;

import org.junit.Test;


public class PlayerTest { 

	// for constructor: integer health, integer x, integer y
	@Test
	public void test_Constructor() {
		Player c = new Player(4, 13, 16);
		
		assertEquals("Testing Copy Constructor, copying initial health 4, x 13, y 16 - testing initial health", 4, c.getHealth());
		assertEquals("Testing Copy Constructor, copying initial health 4, x 13, y 16 - testing x", 13, c.getX());
		assertEquals("Testing Copy Constructor, copying initial health 4, x 13, y 16 - testing y", 16, c.getY());
	}
	
	//Testing setters and getters
	@Test
	public void test_getHealth() {
		Player p = new Player(7, 8, 6);
		p.getHealth();
	
		assertEquals("Testing getHealth", 7, p.getHealth());
	}
	
	@Test
	public void test_getX() {
		Player e= new Player(7, 8, 6);
		e.getX();
	
		assertEquals("Testing getX", 8, e.getX());
	}
	
	@Test
	public void test_getY() {
		Player p = new Player(10, 21, 19);
		p.getY();
	
		assertEquals("Testing getY", 19, p.getY());
	}
	
	@Test 
	public void test_setLocation() {
		Player p  = new Player (13, 21, 47);
		p.setLocation(21, 47);
	
		assertEquals("Testing setLocation", 21, p.getX());
		assertEquals("Testing setLocation", 47, p.getY());
	}
	
	// Testing change methods.
	@Test
	public void test_changeStatus_Good() {
		Player p = new Player(10, 21, 19);
		p.changeStatus(HealthCondition.GOOD);
		p.getStatus();
		
		assertEquals("Testing changeStatus", HealthCondition.GOOD, p.getStatus());
	}
	
	@Test
	public void test_changeStatus_Poison() {
		Player p = new Player(10, 21, 19);
		p.changeStatus(HealthCondition.POISON);
		p.getStatus();
		
		assertEquals("Testing changeStatus", HealthCondition.POISON, p.getStatus());
	}
	
	@Test
	public void test_changeStatus_Stun() {
		Player p = new Player(10, 21, 19);
		p.changeStatus(HealthCondition.STUN);
		p.getStatus();
		
		assertEquals("Testing changeStatus", HealthCondition.STUN, p.getStatus());
	}
	
	@Test
	public void test_changeX() {
		Player p = new Player(12, 5, 9);
		p.getX();
		p.changeX(6);
	
		assertEquals("Testing changeY", 11, p.getX());
	}
	
	@Test
	public void test_changeY() {
		Player p = new Player(12, 5, 9);
		p.getY();
		p.changeY(9);
	
		assertEquals("Testing changeY", 18, p.getY());
	}
	
	//Testing player moves
	@Test
	public void test_playerMoveNORTH() {
		Player p = new Player(4, 15, 8);
		p.playerMove(CardinalDirection.NORTH);
		int actual = p.getY();
		int expected = 7;
		assertEquals("Testing playerMover", expected, actual);
	}
	
	@Test
	public void test_playerMoveSOUTH() {
		Player p = new Player(4, 15, 8);
		p.playerMove(CardinalDirection.SOUTH);
		int actual = p.getY();
		int expected = 9;
		assertEquals("Testing playerMover", expected, actual);
	}

	@Test
	public void test_playerMoveEAST() {
		Player p = new Player(4, 15, 8);
		p.playerMove(CardinalDirection.EAST);
		int actual = p.getX();
		int expected = 16;
		assertEquals("Testing playerMover", expected, actual);
	}

	@Test
	public void test_playerMoveWEST() {
		Player p = new Player(4, 15, 8);
		p.playerMove(CardinalDirection.WEST);
		int actual = p.getX();
		int expected = 14;
		assertEquals("Testing playerMover", expected, actual);
	}

}