
public class Enemy {
	//Passed in from main
	private int health;
	private int xLoc;
	private int yLoc;
	

	//Initialized to 0. Only for Demo 1.
	private int attack = 0;
	
	
	// sightRange = The Euclidean Distance between player and enemy.
	private int sightRange;
	

	//Future implementation
	private boolean runFromPlayer;
	
	//The 8 Cardinal Direction the player can be compared to each enemy.
	private CardinalDirection directiontoPlayer;
	
	

	//Constants
	public static final int MAX_X = 10;
	public static final int MIN_X = 0;
	public static final int MAX_Y = 10;
	public static final int MIN_Y = 0;
	

	// Constructor
	public Enemy (int initialHealth, int initialXLoc, int initialYLoc) {
		if (initialHealth > 0) {
			health = initialHealth;
		} else {
			System.out.println("Error in public Enemy constructor. Initial health cannot be 0 or below.");
			health = 5;
		}
		
		if ((initialXLoc <= MAX_X) && (initialXLoc >= MIN_X)) {
			xLoc = initialXLoc;
		} else {
			System.out.println("Error in public Enemy constructor. X Location cannot be beyond 0 and 10.");
			xLoc = 5;
		}
		
		if ((initialYLoc <= MAX_Y) && (initialYLoc >= MIN_X)) {
			yLoc = initialYLoc;
		} else {
			System.out.println("Error in public Enemy constructor. Y Location cannot be beyond 0 and 10.");
			yLoc = 5;
		}
	}

	
	
	// Copy Constructor
	public Enemy (Enemy copyEnemy) {
		health = copyEnemy.health;
		xLoc = copyEnemy.xLoc;
		yLoc = copyEnemy.yLoc;
	}
  
  public void changeXLoc (int jump)
  {
    this.xLoc += jump;
  }
  public void changeYLoc (int jump)
  {
    this.yLoc += jump;
  }
  
	// Need to fix privacy leak here.	
	public int getXLocation() {
		return xLoc;
	} 
	
	// Need to fix privacy leak here.
	public int getYLocation() {
		return yLoc;
	}
	
	// This method will call change YLoc and change XLoc. It will change the actual location of enemy to move 
	// one step.
	public void enemyMove () {
		System.out.println("This method only verifies player location for Demo 1.");


		//Here we need to get the xCoord & yCoord of player to compare it with
		//enemy xLoc & yLoc to obtain one of the 8 cardinal direction.
		//Then simultaneously set the direction to Player variable,
		//Every time the enemyMove() method is run.
		
		//Then the second part of this code would be to actually move towards that direction.
	
	
	}
	
}