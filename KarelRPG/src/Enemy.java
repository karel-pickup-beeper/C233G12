enum EnemyType
{
	robot, zombie, ghost;
}
public class Enemy {
	/* Instance variables that are passed as parameters from ActionPrompt class's driver method. */
	private int health;
	private int xLoc;
	private int yLoc;
	private EnemyType type;
	
	/* Initalized to 0. Only for Demo 1. */
	private int attack = 0;
	
	
	/* sightRange = The Euclidean Distance between player and enemy. */
	private int sightRange;
	
	/* Future implementation */
	private boolean runFromPlayer;
	
	/* The 8 Cardinal Direction the player can be compared to each enemy. */
	private CardinalDirection directiontoPlayer;
	
	
	/* Constants */
	public static final int MAX_X = 9;
	public static final int MIN_X = 0;
	public static final int MAX_Y = 9;
	public static final int MIN_Y = 0;
	

	public Enemy (int initialHealth, int initialXLoc, int initialYLoc, EnemyType type) {
		if (initialHealth > 0) {
			health = initialHealth;
		} else {
			System.out.println("Error in Enemy constructor. Initial health cannot be 0 or below.");
			health = 5;
		}
		
		if ((initialXLoc <= MAX_X) && (initialXLoc >= MIN_X)) {
			xLoc = initialXLoc;
		} else {
			System.out.println("Error in Enemy constructor. X Location cannot be beyond 0 and 9.");
			xLoc = 5;
		}
		
		if ((initialYLoc <= MAX_Y) && (initialYLoc >= MIN_X)) {
			yLoc = initialYLoc;
		} else {
			System.out.println("Error in Enemy constructor. Y Location cannot be beyond 0 and 9.");
			yLoc = 5;
		}
		this.type = type;
	}

	public void loseHealth(int ouch) {
		this.health -= ouch;
	}
	
	public void changeXloc(int jump) {
		
	}
	
	public void changeYloc(int jump) {
		
	}
	
	/* Returns health. */
	public int getHealth() {
		return this.health;
	}
	
	/* Need to fix privacy leak here. */
	public int getXloc() {
		return xLoc;
	} 
	
	/* Need to fix privacy leak here. */
	public int getYloc() {
		return yLoc;
	}
	
	/* Returns Enemy's type */
	public EnemyType getType() {
		return this.type;
	}
	
	/* Returns string of values. */
	public String toString() {
		return" {" + type+ "(" +health+ ")}";
	}

	/*
	 * This method will call change YLoc and change XLoc. It will change the actual
	 * location of enemy to move one step.
	 */
	public void enemyMove() {
		System.out.println("This method only verifies player location for Demo 1.");
		/*
		 * Here we need to get the xCoord & yCoord of player to compare it with
		 * enemy xLoc & yLoc to obtain one of the 8 cardinal direction. Then
		 * simultaneously set the direction to Player variable, Every time the
		 * enemyMove() method is run.
		 */
		
		/* Then the second part of this code would be to actually move towards that direction. */
	}
	
}
