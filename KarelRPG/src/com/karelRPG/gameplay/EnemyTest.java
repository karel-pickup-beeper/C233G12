package com.karelRPG.gameplay;

import static org.junit.Assert.*; 
import org.junit.Test;

import com.karelRPG.gameplay.Enemy.TileTakenException;

public class EnemyTest { 
	
	public class EnemySub extends Enemy {
		String type;
		int attack;
		
		public EnemySub(int health, int x, int y, String t, int a) {
			super(health, x, y);
			
			if (a > 0 && a < 99 ) this.attack = a;
			
			super.setAttack(attack);
			type = t;
		}
		
		public EnemySub(Enemy c) {
			super(c);
			type = c.getType();
		}
		

		@Override
		public String getType() {
			return this.type;
		}
	
		@Override
		public void enemyAttack(Player target, Maps mapwalk, String direction) {
						
			if (target.getX()==this.getXloc()  &&  target.getY()==this.getYloc()) {
				target.changeHealth(-attack);
			}
		
		}
	}
	
	@Test
	public void test_Constructor() {
		Enemy c = new EnemySub(7, 8, 6, "robot", 3);
		
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing initial health", 7, c.getHealth());
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing xLoc", 8, c.getXloc());
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing yLoc", 6, c.getYloc());
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing title", "robot", c.getType());
	}
	
	@Test
	public void test_CopyConstructor() {
		Enemy c = new EnemySub(7, 8, 6, "zombie", 3);
		Enemy c2 = new EnemySub(c);
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing initial health", 7, c2.getHealth());
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing xLoc", 8, c2.getXloc());
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing yLoc", 6, c2.getYloc());
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing title", "zombie", c2.getType());
	}
	
	//testing the getters & setters
	@Test
	public void test_getHealth() {
		Enemy e = new EnemySub(12, 5, 4, "zombie", 3);
	
		int expected = 12;
		int actual = e.getHealth();
	
		assertEquals("Testing getHealth", expected, actual);
	}
	
	@Test
	public void test_getXloc() {
		Enemy e = new EnemySub(12, 5, 4, "ghost", 3);
		
		int expected = 5;
		int actual = e.getXloc();
			
		assertEquals("Testing getXloc", expected, actual);
	}
	
	@Test
	public void test_getYloc() {
		Enemy e = new EnemySub(12, 5, 4, "robot", 3);
			
		int expected = 4;
		int actual = e.getYloc();
		
		assertEquals("Testing getYloc", expected, actual);
	}
	
	@Test
	public void test_getType() {
		Enemy e = new EnemySub(12, 5, 4, "zombie", 6);
		e.getType();
	
		String expected = "zombie";
		String actual = e.getType();
		
		assertEquals("Testing getType", expected, actual);
	}

	//testing methods that change the instance variables
	@Test
	public void test_loseHealth() {
		Enemy e = new EnemySub(12, 5, 4,"ghost", 6);
		e.getHealth();
		e.loseHealth(4);
	
		int expected = 8;
		int actual = e.getHealth();
		
		assertEquals("Testing loseHealth", expected, actual);
	}

	@Test
	public void test_changeYloc() {
		Enemy e = new EnemySub(12, 5, 4, "robot", 6);
		e.getYloc();
		e.changeYloc(7);
	
		int expected = 11;
		int actual = e.getYloc();
		
		assertEquals("Testing changeYloc", expected, actual);
	}
	
	@Test
	public void test_changeXloc() {
		Enemy e = new EnemySub(12, 5, 4, "ghost", 6);
		e.getXloc();
		e.changeXloc(10);
		
		int expected = 15;
		int actual = e.getXloc();
	
		assertEquals("Testing changeYloc", expected, actual);
	}

	//testing enemyAttack
	@Test
	public void test_enemyAttack() {
		Enemy e = new EnemySub(12, 8, 6, "ghost", 4);
		Player p = new Player(7, 8, 6);
		Maps m = new Maps(2);
		
		e.enemyAttack(p, m, "NORTH");
		e.getAttack();
		
		int expected = 3;
		int actual = p.getHealth();
		
		assertEquals("Testing enemyAttack", expected, actual);
	}
	
	@Test
	public void test_enemyAttack_noAttack() {
		Enemy e = new EnemySub(12, 5, 8, "ghost", 4);
		Player p = new Player(7, 8, 6);
		Maps m = new Maps(2);
		
		e.enemyAttack(p, m, "NORTH");
		e.getAttack();
		
		int expected = 7;
		int actual = p.getHealth();
		
		assertEquals("Testing enemyAttack", expected, actual);
	}
	
	//testing enemyMove
	@Test
	public void test_enemyMove_EAST() {
		Player p = new Player(4, 15, 8);
		Enemy e = new EnemySub(12, 5, 8, "ghost", 4);
		Maps m = new Maps(2);
		
		try {
			e.enemyMove(CardinalDirection.EAST, p, m);
		} catch (TileTakenException e1) {
			e1.printStackTrace();
		}
		
		int actual = e.getXloc();
		int expected = 6;
		assertEquals("Testing enemyMove: east", expected, actual);
	}
	
	@Test
	public void test_enemyMove_WEST() {
		Player p = new Player(4, 15, 8);
		Enemy e = new EnemySub(12, 5, 8, "ghost", 4);
		Maps m = new Maps(2);
		
		try {
			e.enemyMove(CardinalDirection.WEST, p, m);
		} catch (TileTakenException e1) {
			e1.printStackTrace();
		}
		
		int actual = e.getXloc();
		int expected = 4;
		assertEquals("Testing enemyMove: west", expected, actual);
	}
	
	@Test
	public void test_enemyMove_NORTH() {
		Player p = new Player(4, 15, 8);
		Enemy e = new EnemySub(12, 5, 7, "ghost", 4);
		Maps m = new Maps(2);
		
		try {
			e.enemyMove(CardinalDirection.NORTH, p, m);
		} catch (TileTakenException e1) {
			e1.printStackTrace();
		}
		
		int actual = e.getYloc();
		int expected = 6;
		assertEquals("Testing enemyMove: north", expected, actual);
	}
	
	//Testing isSpaceClear for true and false outcomes
	@Test
	public void test_isSpaceClear_TRUE() {
		Enemy e = new EnemySub(12, 5, 8, "ghost", 4);
		Player p = new Player(4, 15, 8);
		Maps m = new Maps(2);
		
		boolean actual = e.isSpaceClear(6, 4, p, m);
		boolean expected = true;
		
		assertEquals("Testing isSpaceClear: true", expected, actual);
	}
	
	@Test
	public void test_isSpaceClear_FALSE() {
		Enemy e = new EnemySub(12, 5, 7, "ghost", 4);
		Player p = new Player(4, 11, 8);
		Maps m = new Maps(2);
		
		boolean actual = e.isSpaceClear(6, 1, p, m);
		boolean expected = false;
		
		assertEquals("Testing isSpaceClear: false", expected, actual);
	}
	
	//testing toString with 3 different enemy types
	@Test
	public void test_toString_1() {
		Enemy e = new EnemySub(12, 5, 4, "ghost", 6);
		e.getType();
		
		String expected =" {ghost(12)}";
		String actual = e.toString();
		
		assertEquals("Testing toString", expected, actual);
	}
	
	@Test
	public void test_toString_2() {
		Enemy e = new EnemySub(12, 5, 4, "zombie", 6);
		e.getType();
		
		String expected = " {zombie(12)}";
		String actual = e.toString();
	
		assertEquals("Testing toString", expected, actual);
	}

	@Test
	public void test_toString_3() {
		Enemy e = new EnemySub(12, 5, 4, "robot", 6);
		e.getType();
		
		String expected = " {robot(12)}";
		String actual = e.toString();
	
		assertEquals("Testing toString", expected, actual);
	}
	
}