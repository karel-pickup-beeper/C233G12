package com.karelRPG.gameplay;

public class Robot extends Enemy {
	
	private int buzz = 0;
	private int increasingBuzz = 0;
	private boolean verticalMovement = false;
	private boolean goingUp = false;

	/* Constructors */
	public Robot(int initialHealth, int initialXLoc, int initialYLoc, int buzz, boolean vertical) {
		super(initialHealth, initialXLoc, initialYLoc);
		if (buzz > 0 && buzz < 99) {
			this.buzz = buzz;
		}
		super.setAttack(increasingBuzz);
		super.setSightRange(0);
		this.verticalMovement = vertical;
		
	}

	/* Copy Constructor */
	public Robot(Robot copyEnemy) {
		super(copyEnemy.getHealth(),copyEnemy.getXloc(),copyEnemy.getYloc());
		super.setAttack(copyEnemy.increasingBuzz);
		super.setSightRange(0);
		this.verticalMovement = copyEnemy.verticalMovement;
	}

	/* Getter Methods */
	protected String getType() {
		return "Robot";
	}
	
	/* Setter Methods */

	public void enemyAction(Player user) {
		/* Because enemyMove is called everytime for moving enemies, we can use this to update a variating amount of enemy threat each timeStep. */
		increasingBuzz +=buzz;
		super.setAttack(increasingBuzz);
		/* Run the default enemy action. */
		super.enemyAction(user);
	}
	
	public void enemyMove(int seen, boolean away, CardinalDirection there) {
		/*
		 * Here we need to get the xCoord & yCoord of player to compare it with
		 * enemy xLoc & yLoc to obtain one of the 8 cardinal direction. Then
		 * simultaneously set the direction to Player variable, Every time the
		 * enemyMove() method is run.
		 */
		/* Then this code would be to actually move towards that direction. */
		
	}
	public void enemyAttack(Player target) {
		/* Active Attack from Enemy */
		target.changeHealth(-increasingBuzz);
		/* Resets Buzz. */
		increasingBuzz = 0;
		super.setAttack(increasingBuzz);
	}

}
