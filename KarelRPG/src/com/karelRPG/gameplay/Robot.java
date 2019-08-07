package com.karelRPG.gameplay;
import java.util.Random;

import com.karelRPG.gameplay.Enemy.TileTakenException;

public class Robot extends Enemy {
	
	private int buzz = 0;
	private int increasingBuzz = 0;
	private boolean verticalMovement;
	private boolean goingUp;

	/* Random */
	Random rand = new Random();
	
	/* Constructors */
	public Robot(int initialHealth, int initialXLoc, int initialYLoc, int buzz, boolean vertical) {
		super(initialHealth, initialXLoc, initialYLoc);
		if (buzz > 0 && buzz < 99) {
			this.buzz = buzz;
		}
		super.setAttack(increasingBuzz);
		super.setSightRange(0);
		this.verticalMovement = vertical;
		this.goingUp = false;		
	}

	/* Copy Constructor */
	public Robot(Enemy copyEnemy) {
		super(copyEnemy);
		if (copyEnemy instanceof Robot) {
			this.buzz = ((Robot) copyEnemy).buzz;
			this.increasingBuzz = ((Robot) copyEnemy).increasingBuzz;
			this.verticalMovement = ((Robot) copyEnemy).verticalMovement;
			this.goingUp = ((Robot) copyEnemy).goingUp;
		}
	}

	/* Getter Methods */
	
	@Override
	protected String getType() {
		return "Robot";
	}
	
	@Override
	public String toString() {
		return super.toString() + " Bz:{" + increasingBuzz + "}";
	}
	
	/* Setter Methods */
	@Override
	public void enemyAction(Player user, Maps mapgait) {
		/* Because enemyMove is called everytime for moving enemies, we can use this to update a variating amount of enemy threat each timeStep. */
		increasingBuzz +=buzz;
		super.setAttack(increasingBuzz);
		
		/* Run the default enemy action. */
		try
		{
			/* The actual Robot specific code that meant to override the functionality of the enemyAction method. */
			if (verticalMovement) {
				if (goingUp)
					enemyMove(CardinalDirection.NORTH, user, mapgait);
				else
					enemyMove(CardinalDirection.SOUTH, user, mapgait);
			} else {
				if (goingUp)
					enemyMove(CardinalDirection.EAST, user, mapgait);
				else
					enemyMove(CardinalDirection.WEST, user, mapgait);
			}
		}
		catch (TileTakenException tte)
		{
			enemyAttack(user, mapgait, tte.getLocalizedMessage());
		}
		finally
		{
			
		}
	}
	
	/**
	 * This mutator method will call the methods changeXloc or changeYloc in this enemy object.
	 * If there is no collision, the enemy object will successfully move in a specific pattern.
	 * The aim argument must specify an enumeration of CardinalDirection type.
	 * @param aim
	 * @throws TileTakenException
	 */
	@Override
	public void enemyMove(CardinalDirection aim, Player hero, Maps mapgait) throws TileTakenException {
		try {
		super.enemyMove(aim, hero, mapgait);
		} catch (TileTakenException tte){
			if (goingUp)
				goingUp = false;
			else
				goingUp = true;
			
			throw new TileTakenException(tte.getLocalizedMessage());
		}
	}
	@Override
	public void enemyAttack(Player target, Maps mapwalk, String direction) {
		/* Active Attack from Enemy */
		for (int w=-1; w<2; w++) {
			for (int z=-1; z<2; z++) {
				if (target.getX()==this.getXloc()+w  &&  target.getY()==this.getYloc()+z) {
					System.out.print("You just got buzzed by a robot. ");
					target.changeHealth(-increasingBuzz);
				}
			}
		}
		/* Resets Buzz. */
		this.resetRobotCharge();
	}

	public void resetRobotCharge() {
		increasingBuzz = 0;
		super.setAttack(increasingBuzz);
	}
}
