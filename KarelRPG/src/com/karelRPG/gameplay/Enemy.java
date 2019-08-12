package com.karelRPG.gameplay;
import java.util.Random;
import java.lang.Math;

public abstract class Enemy {
	
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
	
	/* Random */
	Random rand = new Random();
	
	/* Constants */
	public static final int MAX_X = 8;
	public static final int MIN_X = 1;
	public static final int MAX_Y = 8;
	public static final int MIN_Y = 1;
	
  	/* Constructors */
	
	/**
	 * Creates a new instance of Enemy with initial health, 
	 * initial x location, and initial y location values
	 * 
	 * @param initialHealth The initial health of the enemy instance.
	 * @param initialXLoc The initial location of the enemy instance relative to the x-axis.
	 * @param initialYLoc The initial location of the enemy instance relative to the y-axis.
	 */
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
		
		this.runFromPlayer = false;
		this.directiontoPlayer = CardinalDirection.STOP;
	}
  
  	/* Copy Constructor */
	public Enemy (Enemy copyEnemy)
	{
		this.health = copyEnemy.health;
		this.xLoc = copyEnemy.xLoc;
		this.yLoc = copyEnemy.yLoc;
		this.attack = copyEnemy.attack;
		this.sightRange = copyEnemy.sightRange;
		this.runFromPlayer = copyEnemy.runFromPlayer;
		this.directiontoPlayer = copyEnemy.directiontoPlayer;
	}
	
	/* Getter Methods */
	
	/**
	 * Gets the value of health
	 * 
	 * @return health The remaining health of the enemy instance.
	 */
	public int getHealth() {
		int health = this.health;
		return health;
	}
	
	/**
	 * Gets the value of xLoc
	 * 
	 * @return xLoc The location of the enemy instance relative to the x-axis.
	 */
	public int getXloc() {
		int xLoc = this.xLoc;
		return xLoc;
	} 
	
	/**
	 * Gets the value of yLoc
	 * 
	 * @return yLoc The location of the enemy instance relative to the y-axis.
	 */
	public int getYloc() {
		int yLoc = this.yLoc;
		return yLoc;
	}
	
	/**
	 * Gets the value of attack
	 * 
	 * @return attack The value of the attack points of the enemy instance.
	 */
	public int getAttack() {
		int attack = this.attack;
		return attack;
	}
	
	public abstract String getType();
	
	/* Returns string of values. */
	public String toString() {
		return" {" + getType() + "(" +health+ ")}";
	}
	
	
	/* Setter Methods */
	
	/**
	 * Sets the value of health by subtracting an integer, ouch
	 * 
	 * @param ouch Either the amount of health points subtracted as a result of a player's attack on the enemy or the amount of health
	 * points added as a result of an enemy's attack on a player.
	 */
	public void loseHealth(int ouch) {
		if (ouch>=0)
			System.out.print("The enemy lost "+ ouch +" health");
		else if (ouch<0)
			System.out.print("The enemy healed itself "+ ouch +" HP from your health. ");
		else
			System.out.print("The enemy received no damage. ");
		this.health -= ouch;
	}
	
    /**
	 * Sets the value of xLoc by a adding an integer jump
	 * 
     * @param jump The integer that specifies the amount of tiles an enemy moves relative to the x-axis.
	 */
	public void changeXloc(int jump){
		this.xLoc += jump;
	}
	
    /**
	 * Sets the value of yLoc by adding an integer jump
	 * 
     * @param jump The integer that specifies the amount of tiles an enemy moves relative to the y-axis.
	 */
	public void changeYloc(int jump){
		this.yLoc += jump;
	}
	
	public void setAttack(int threat) {
		this.attack = threat;
	}
	
	public void setSightRange(int far) {
		this.sightRange = far;
	}

	public void enemyAction(Player user, Maps mapgait)
	{
		/*
		 * Here we need to get the xCoord & yCoord of player to compare it with
		 * enemy xLoc & yLoc to obtain one of the 8 cardinal direction. Then
		 * simultaneously set the direction to Player variable, Every time the
		 * enemyMove() method is run.
		 */
		/* Setting Enemy to aim at Player if in range */
		double xDistance, yDistance;
		if (this.runFromPlayer) {
			xDistance = this.xLoc-user.getX()+0.0;
			yDistance = this.yLoc-user.getY()+0.0;
		} else {
			xDistance = user.getX()-this.xLoc+0.0;
			yDistance = user.getY()-this.yLoc+0.0;
		}
		double hypotenuse = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
		if (hypotenuse <= this.sightRange)
		{
			this.directiontoPlayer = CardinalDirection.STOP;
			if (xDistance > 0) {
				this.directiontoPlayer = CardinalDirection.EAST;
			} else if (xDistance < 0) {
				this.directiontoPlayer = CardinalDirection.WEST;
			}
			if (yDistance > 0) {
				if (this.directiontoPlayer == CardinalDirection.EAST)
					this.directiontoPlayer = CardinalDirection.SOUTHEAST;
				else if (this.directiontoPlayer == CardinalDirection.WEST)
					this.directiontoPlayer = CardinalDirection.SOUTHWEST;
				else
					this.directiontoPlayer = CardinalDirection.SOUTH;
			} else if (yDistance < 0) {
				if (this.directiontoPlayer == CardinalDirection.EAST)
					this.directiontoPlayer = CardinalDirection.NORTHEAST;
				else if (this.directiontoPlayer == CardinalDirection.WEST)
					this.directiontoPlayer = CardinalDirection.NORTHWEST;
				else
					this.directiontoPlayer = CardinalDirection.NORTH;
			}
		}
		try
		{
			enemyMove(this.directiontoPlayer, user, mapgait);
		}
		catch (TileTakenException tte)
		{
			enemyAttack(user, mapgait, tte.getLocalizedMessage());
		}
		finally
		{
			//do nothing.
		}
	}
	
	public boolean isSpaceClear(int deltaX, int deltaY, Player hero, Maps mapgait) {
		boolean canMove = true;
		int toBeX = deltaX + this.xLoc;
		int toBeY = deltaY + this.yLoc;
		if (toBeX == hero.getX() && toBeY == hero.getY()) {
			canMove = false;
		} else if (mapgait.detectEnemy(toBeX, toBeY) != null) {
			canMove = false;
		} else if (mapgait.detectTile(toBeX, toBeY) != "_") {
			canMove = false;
		} else if (toBeX == 9 || toBeX == 0 || toBeY == 9 || toBeY == 0) {
			canMove = false;
		}
		return canMove;
	}
	/**
	 * This mutator method will call the methods changeXloc or changeYloc in this enemy object.
	 * If there is no collision, the enemy object will successfully move in a specific pattern.
	 * The aim argument must specify an enumeration of CardinalDirection type.
	 * @param aim
	 * @throws TileTakenException
	 */
	public void enemyMove(CardinalDirection aim, Player hero, Maps mapgait) throws TileTakenException {
		/* Then this code would be to actually move towards that direction. */
		boolean r = rand.nextBoolean();
		switch (aim)
		{
		case NORTHEAST:
			if (isSpaceClear(0,-1,hero,mapgait) && isSpaceClear(1,0,hero,mapgait)) {
				if (r)
					this.changeYloc(-1);
				else
					this.changeXloc(1);
			} else if (isSpaceClear(0,-1,hero,mapgait)) {
				this.changeYloc(-1);
			} else if (isSpaceClear(1,0,hero,mapgait)) {
				this.changeXloc(1);
			} else {
				throw new TileTakenException("NORTHEAST");
			}
			break;
		case EAST:
			if (isSpaceClear(1,0,hero,mapgait))
				this.changeXloc(1);
			else
				throw new TileTakenException("EAST");
			break;
		case NORTHWEST:
			if (isSpaceClear(0,-1,hero,mapgait) && isSpaceClear(-1,0,hero,mapgait)) {
				if (r)
					this.changeXloc(-1);
				else
					this.changeYloc(-1);
			} else if (isSpaceClear(0,-1,hero,mapgait)) {
				this.changeYloc(-1);
			} else if (isSpaceClear(-1,0,hero,mapgait)) {
				this.changeXloc(-1);
			} else {
				throw new TileTakenException("NORTHWEST");
			}		
			break;
		case NORTH:
			if (isSpaceClear(0,-1,hero,mapgait))
				this.changeYloc(-1);
			else
				throw new TileTakenException("NORTH");
			break;
		case SOUTHEAST:
			if (isSpaceClear(0,1,hero,mapgait) && isSpaceClear(1,0,hero,mapgait)) {
				if (r)
					this.changeXloc(1);
				else
					this.changeYloc(1);
			} else if (isSpaceClear(0,1,hero,mapgait)) {
				this.changeYloc(1);
			} else if (isSpaceClear(1,0,hero,mapgait)) {
				this.changeXloc(1);
			} else {
				throw new TileTakenException("SOUTHEAST");
			}		
			break;
		case SOUTH:
			if (isSpaceClear(0,1,hero,mapgait))
				this.changeYloc(1);
			else
				throw new TileTakenException("SOUTH");
			break;
		case SOUTHWEST:
			if (isSpaceClear(0,1,hero,mapgait) && isSpaceClear(-1,0,hero,mapgait)) {
				if (r)
					this.changeYloc(1);
				else
					this.changeXloc(-1);
			} else if (isSpaceClear(0,1,hero,mapgait)) {
				this.changeYloc(1);
			} else if (isSpaceClear(-1,0,hero,mapgait)) {
				this.changeXloc(-1);
			} else {
				throw new TileTakenException("SOUTHWEST");
			}		
			break;
		case WEST:
			if (isSpaceClear(-1,0,hero,mapgait))
				this.changeXloc(-1);
			else
				throw new TileTakenException("WEST");
			break;
		case STOP:
		default:
			break;
		}
	}
	public abstract void enemyAttack(Player target, Maps mapwalk, String direction);
	
	/* Tile Taken Exception Class */
	class TileTakenException extends Exception
	{
		public TileTakenException() {}
		
		public TileTakenException(String message)
		{
			super(message);
		}
	}
}
