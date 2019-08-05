package com.karelRPG.gameplay;

public class Ghost extends Enemy {

	public Ghost(int initialHealth, int initialXLoc, int initialYLoc) {
		super(initialHealth, initialXLoc, initialYLoc);
	}

	public Ghost(Enemy copyEnemy) {
		super(copyEnemy);
	}

	/**
	 * This mutator method will call changeYLoc and changeXLoc. It will change the actual location of enemy to move 
	 * one step closer to the player.
	 * 
	 * @param playerX
	 * @param playerY
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
	
	protected String getType() {
		return "Ghost";
	}
}
