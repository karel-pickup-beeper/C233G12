package com.karelRPG.gameplay;

public class Zombie extends Enemy {

	/* Constructors */
	public Zombie(int initialHealth, int initialXLoc, int initialYLoc, int bite) {
		super(initialHealth, initialXLoc, initialYLoc);
	}

	/* Copy Constructor */
	public Zombie(Enemy copyEnemy) {
		super(copyEnemy);
	}

	/* Getter Methods */
	protected String getType() {
		return "Zombie";
	}
	
	/* Setter Methods */

	public void enemyAction() {
		
	}
	
	public void enemyMove() {
		System.out.println("This method only verifies player location for Demo 1.");
		/*
		 * Here we need to get the xCoord & yCoord of player to compare it with
		 * enemy xLoc & yLoc to obtain one of the 8 cardinal direction. Then
		 * simultaneously set the direction to Player variable, Every time the
		 * enemyMove() method is run.
		 */
		/* If it can move, it moves, if it can't, it attacks. */
		
		/* Then the second part of this code would be to actually move towards that direction. */
	}
}
