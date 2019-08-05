package com.karelRPG.gameplay;
public class Enemy {
	
	/* Instance variables that are passed as parameters from ActionPrompt class's driver method. */
	private int health;
	private int xLoc;
	private int yLoc;
	
	/* The attack dealt by enemy to player. */
	private int attack;
	
	/* sightRange = The Euclidean Distance between player and enemy. */
	private int sightRange;
	
	/* Future implementation */
	private boolean runFromPlayer;
	
	/* The 8 Cardinal Direction the player can be compared to each enemy. */
	private CardinalDirection directiontoPlayer;
	
	/* Constants */
	public static final int MAX_X = 8;
	public static final int MIN_X = 1;
	public static final int MAX_Y = 8;
	public static final int MIN_Y = 1;
	
  	/* Constructors */
	public Enemy (int initialHealth, int initialXLoc, int initialYLoc)
	{
		if (initialHealth > 0) {
			health = initialHealth;
		} else {
			System.out.println("Error in Enemy constructor. Initial health cannot be 0 or below.");
			health = 5;
		}
		if ((initialXLoc <= MAX_X) && (initialXLoc >= MIN_X)) {
			xLoc = initialXLoc;
		} else {
			System.out.println("Error in Enemy constructor. X Location must be between 1 to 8 in any map.");
			xLoc = 8;
		}
		if ((initialYLoc <= MAX_Y) && (initialYLoc >= MIN_X)) {
			yLoc = initialYLoc;
		} else {
			System.out.println("Error in Enemy constructor. Y Location must be between 1 to 8 in any map.");
			yLoc = 1;
		}
	}
  
  	/* Copy Constructor */
	public Enemy (Enemy copyEnemy)
	{
		health = copyEnemy.health;
		xLoc = copyEnemy.xLoc;
		yLoc = copyEnemy.yLoc;
	}
	
	/* Methods */
	
	public void loseHealth(int ouch) {
		this.health -= ouch;
	}
    	/**
	 * This mutator method will change the x-coordinate of the enemy to a random location, when called.
	 * 
	 * @return xLoc
	 */
	public void changeXloc(int jump) {
		this.xLoc += jump;
	}
    	/**
	 * This mutator method will change the y-coordinate of the enemy to a random location, when called.
	 * 
	 * @return yLoc
	 */
	public void changeYloc(int jump) {
		this.yLoc += jump;
	}
	
	/* Enemy's remaining health before it should be despawned. */
	public int getHealth() {
		return this.health;
	}
	
	/**
	 * This accessor method will return the xLoc variable of this enemy when called.
	 * 
	 * @return xLoc
	 */
	/* Enemy's X-Coordinate relative to the map they are on.*/
	public int getXloc() {
		int xLoc = this.xLoc;
		return xLoc;
	} 
	
	/**
	 * This accessor method will return the yLoc variable of this enemy when called.
	 * 
	 * @return yLoc
	 */
	/* Enemy's Y-Coordinate relative to the map they are on. */
	public int getYloc() {
		int yLoc = this.yLoc;
		return yLoc;
	}
	
	/* Returns string of values. */
	public String toString() {
		return" {" + type+ "(" +health+ ")}";
	}

}
