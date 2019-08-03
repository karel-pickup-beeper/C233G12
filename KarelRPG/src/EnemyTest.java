
import static org.junit.Assert.*; 
import org.junit.Test;

public class EnemyTest { 

	EnemyType robot;
	EnemyType zombie;
	EnemyType ghost;
	
	@Test
	public void test_Constructor() {
		Enemy c = new Enemy(7, 8, 6, robot);
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing initial health", 7, c.getHealth());
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing xLoc", 8, c.getXloc());
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing yLoc", 6, c.getYloc());
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing title", robot, c.getType());
	}
	
	@Test
	public void test_CopyConstructor() {
		Enemy c = new Enemy(7, 8, 6, robot);
		Enemy c2 = new Enemy(c);
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing initial health", 7, c2.getHealth());
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing xLoc", 8, c2.getXloc());
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing yLoc", 6, c2.getYloc());
		assertEquals("Testing Copy Constructor, copying initial health 7, xLoc 8, yLoc 6 and Enemy type"
				+ " - testing title", robot, c2.getType());
	}
	
	@Test
	public void test_getHealth() {
		Enemy e = new Enemy(12, 5, 9, robot);
		e.getHealth();
	
		assertEquals("Testing getHealth", 12, e.getHealth());
	}
	
	@Test
	public void test_getXloc() {
		Enemy e = new Enemy(12, 5, 9, ghost);
		e.getXloc();
	
		assertEquals("Testing getXloc", 5, e.getXloc());
	}
	
	@Test
	public void test_getYloc() {
		Enemy e = new Enemy(12, 5, 9, robot);
		e.getYloc();
	
		assertEquals("Testing getYloc", 9, e.getYloc());
	}
	
	@Test
	public void test_getType() {
		Enemy e = new Enemy(12, 5, 9, zombie);
		e.getType();
	
		assertEquals("Testing getType", zombie, e.getType());
	}

	@Test
	public void test_loseHealth() {
		Enemy e = new Enemy(12, 5, 9, ghost);
		e.getHealth();
		e.loseHealth(4);
	
		assertEquals("Testing loseHealth", 8, e.getHealth());
	}

	@Test
	public void test_changeYloc() {
		Enemy e = new Enemy(12, 5, 9, zombie);
		e.getYloc();
		e.changeYloc(7);
	
		assertEquals("Testing changeYloc", 16, e.getYloc());
	}
	
	@Test
	public void test_changeXloc() {
		Enemy e = new Enemy(12, 5, 9, robot);
		e.getXloc();
		e.changeXloc(10);
	
		assertEquals("Testing changeYloc", 15, e.getXloc());
	}

// FIX CODE FOR TEST OR CLASS	
/*
	@Test
	public void test_toString() {
		Enemy e = new Enemy(12, 5, 9, ghost);
		e.getType();
		e.toString();
	
		assertEquals("Testing toString", " ghost(12)", e.toString());
	}
*/

	
}