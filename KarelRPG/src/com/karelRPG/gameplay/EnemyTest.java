package com.karelRPG.gameplay;

import static org.junit.Assert.*; 
import org.junit.Test;

public class EnemyTest { 
	
	public class EnemySub extends Enemy {
		String type;
		
		public EnemySub(int health, int x, int y, String t) {
			super(health, x, y);
			type = t;
		}
		
		public EnemySub(Enemy c) {
			super(c);
			type = c.getType();
		}
		

		@Override
		protected String getType() {
			return this.type;
		}

		@Override
		public void enemyMove(int seen, boolean away, CardinalDirection there) {
			
		}

		@Override
		public void enemyAttack(Player target) {
			
		}
		
	}
	
	
	
	@Test
	public void test_Constructor() {
		Enemy c = new EnemySub(7, 8, 6, "robot");
		
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
		Enemy c = new EnemySub(7, 8, 6, "zombie");
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
	
	@Test
	public void test_getHealth() {
		Enemy e = new EnemySub(12, 5, 4, "zombie");
		e.getHealth();
	
		assertEquals("Testing getHealth", 12, e.getHealth());
	}
	
	@Test
	public void test_getXloc() {
		Enemy e = new EnemySub(12, 5, 4, "ghost");
		e.getXloc();
	
		assertEquals("Testing getXloc", 5, e.getXloc());
	}
	
	@Test
	public void test_getYloc() {
		Enemy e = new EnemySub(12, 5, 4, "robot");
		e.getYloc();
	
		assertEquals("Testing getYloc", 4, e.getYloc());
	}
	
	@Test
	public void test_getType() {
		Enemy e = new EnemySub(12, 5, 4, "zombie");
		e.getType();
	
		assertEquals("Testing getType", "zombie", e.getType());
	}

	@Test
	public void test_loseHealth() {
		Enemy e = new EnemySub(12, 5, 4,"ghost");
		e.getHealth();
		e.loseHealth(4);
	
		assertEquals("Testing loseHealth", 8, e.getHealth());
	}

	@Test
	public void test_changeYloc() {
		Enemy e = new EnemySub(12, 5, 4, "robot");
		e.getYloc();
		e.changeYloc(7);
	
		assertEquals("Testing changeYloc", 11, e.getYloc());
	}
	
	@Test
	public void test_changeXloc() {
		Enemy e = new EnemySub(12, 5, 4, "ghost");
		e.getXloc();
		e.changeXloc(10);
	
		assertEquals("Testing changeYloc", 15, e.getXloc());
	}

	
	@Test
	public void test_toString_1() {
		Enemy e = new EnemySub(12, 5, 4, "ghost");
		e.getType();
		e.toString();
	
		assertEquals("Testing toString", " {ghost(12)}", e.toString());
	}
	
	@Test
	public void test_toString_2() {
		Enemy e = new EnemySub(12, 5, 4, "zombie");
		e.getType();
		e.toString();
	
		assertEquals("Testing toString", " {zombie(12)}", e.toString());
	}

	@Test
	public void test_toString_3() {
		Enemy e = new EnemySub(12, 5, 4, "robot");
		e.getType();
		e.toString();
	
		assertEquals("Testing toString", " {robot(12)}", e.toString());
	}
	
}