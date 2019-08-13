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
	
	public void flee(boolean yes) {
		this.runFromPlayer = yes;
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
			System.out.print("The enemy lost "+ ouch +" health.");
		else if (ouch<0)
			System.out.print("The enemy healed itself "+ ouch +" HP from your health. ");
		else
			System.out.print("The enemy received no damage. ");
		this.health -= ouch;
	}
	
    /**
	 * Sets the value of xLoc by a adding an integer, jump
	 * 
     * @param jump The integer that specifies the amount of tiles an enemy moves relative to the x-axis.
	 */
	public void changeXloc(int jump){
		this.xLoc += jump;
	}
	
    /**
	 * Sets the value of yLoc by adding an integer, jump
	 * 
     * @param jump The integer that specifies the amount of tiles an enemy moves relative to the y-axis.
	 */
	public void changeYloc(int jump){
		this.yLoc += jump;
	}
	
	/**
	 * Sets the value of attack to an integer, threat
	 * 
	 * @param threat The integer that specifies the attack points of an enemy.
	 */
	public void setAttack(int threat) {
		this.attack = threat;
	}
	
	/**
	 * Sets the value of sightRange to an integer, far
	 * 
	 * @param far The integer that specifies the sightRange of an enemy.
	 */
	public void setSightRange(int far) {
		this.sightRange = far;
	}

	/**
	 * Calls enemyMove method, if exception is caught, it will call enemyAttack method instead
	 * 
	 * 
	 * @param user An object of class player that provides the position of the player relative to the x and y axis.
	 * @param mapgait An object of class Maps that provides information for the validity of enemyMove and enemyAttack methods.
	 */
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
	
	/**
	 *  Determines whether the space is clear for the enemy to move in.
	 *  
	 * @param deltaX The change to be represented in the checked location relative to the x axis.
	 * @param deltaY The change to be represented in the checked location relative to the y axis.
	 * @param hero An object of class Player that provides the position of the player relative to the x and y axis.
	 * @param mapgait An object of class Maps that provides information for the validity of enemyMove and enemyAttack methods.
	 * @return true if the space is not occupied by a player or a collectible.
	 */
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
		} else if (toBeX == 14 || toBeX == 0 || toBeY == 14 || toBeY == 0) {
			canMove = false;
		}
		return canMove;
	}
	
	/**
	 *  Determines whether the space is clear for the enemy to move in.
	 *  
	 * @param deltaX The change to be represented in the checked location relative to the x axis.
	 * @param deltaY The change to be represented in the checked location relative to the y axis.
	 * @param hero An object of class Player that provides the position of the player relative to the x and y axis.
	 * @param mapgait An object of class Maps that provides information for the validity of enemyMove and enemyAttack methods.
	 * @return true if the space is not occupied by a player or a collectible.
	 */
	public boolean isSpaceClear(int deltaX, int deltaY, Maps mapgait) {
		boolean canMove = true;
		int toBeX = deltaX + this.xLoc;
		int toBeY = deltaY + this.yLoc;
		if (mapgait.detectEnemy(toBeX, toBeY) != null) {
			canMove = false;
		} else if (mapgait.detectTile(toBeX, toBeY) != "_") {
			canMove = false;
		} else if (toBeX == 9 || toBeX == 0 || toBeY == 9 || toBeY == 0) {
			canMove = false;
		}
		return canMove;
	}
	
	/**
	 * Sets the xLoc and yLoc to value that is closer to the player position relative to the x and y axis via the changeXloc 
	 * or changeYloc methods, if isSpaceClear method returns true
	 * 
	 * @param aim An object of class CardinalDirection that provides the argument for the switch statement under this method.
	 * @throws TileTakenException to pass to the enemyAction method which catches this exception to call enemyAttack, instead 
	 */
	public void enemyMove(CardinalDirection aim, Player hero, Maps mapgait) throws TileTakenException {
		/* This tells the enemy where to move. */
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
	/**
	 * Abstract method to be implemented differently in each subclass of Enemy.
	 * @param target Calling Player mutator methods to change its health variable.
	 * @param mapwalk Calling detection accessor methods in Maps for attacking relative position.
	 * @param direction Specifies the directional case of where the attack is from.
	 */
	public abstract void enemyAttack(Player target, Maps mapwalk, String direction);
	
	public void enemyKnockBack(CardinalDirection aim, Maps mapgait) {
		switch (aim)
		{
		case NORTHEAST:
			while (isSpaceClear(0,-1,mapgait) && isSpaceClear(1,0,mapgait)) {
					this.changeYloc(-1);
					this.changeXloc(1);
			} while (isSpaceClear(0,-1,mapgait)) {
				this.changeYloc(-1);
			} while (isSpaceClear(1,0,mapgait)) {
				this.changeXloc(1);
			}
			break;
		case EAST:
			while (isSpaceClear(1,0,mapgait))
				this.changeXloc(1);
			break;
		case NORTHWEST:
			while (isSpaceClear(0,-1,mapgait) && isSpaceClear(-1,0,mapgait)) {
					this.changeXloc(-1);
					this.changeYloc(-1);
			} while (isSpaceClear(0,-1,mapgait)) {
				this.changeYloc(-1);
			} while (isSpaceClear(-1,0,mapgait)) {
				this.changeXloc(-1);
			}		
			break;
		case NORTH:
			while (isSpaceClear(0,-1,mapgait))
				this.changeYloc(-1);
			break;
		case SOUTHEAST:
			while (isSpaceClear(0,1,mapgait) && isSpaceClear(1,0,mapgait)) {
					this.changeXloc(1);
					this.changeYloc(1);
			} while (isSpaceClear(0,1,mapgait)) {
				this.changeYloc(1);
			} while (isSpaceClear(1,0,mapgait)) {
				this.changeXloc(1);
			}		
			break;
		case SOUTH:
			while (isSpaceClear(0,1,mapgait))
				this.changeYloc(1);
			break;
		case SOUTHWEST:
			while (isSpaceClear(0,1,mapgait) && isSpaceClear(-1,0,mapgait)) {
					this.changeYloc(1);
					this.changeXloc(-1);
			} while (isSpaceClear(0,1,mapgait)) {
				this.changeYloc(1);
			} while (isSpaceClear(-1,0,mapgait)) {
				this.changeXloc(-1);
			}		
			break;
		case WEST:
			while (isSpaceClear(-1,0,mapgait))
				this.changeXloc(-1);
			break;
		case STOP:
		default:
			break;
		}
	}
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
