package com.karelRPG.gameplay;
import java.util.Random;

public class Ghost extends Zombie {

	private int reap;
	
	/* Random */
	Random rand = new Random();
	
	/* Constructors */
	public Ghost(int initialHealth, int initialXLoc, int initialYLoc, int reap) {
		super(initialHealth, initialXLoc, initialYLoc, reap);
		if (reap > 0 && reap < 99)
			this.reap = reap;
		super.setAttack(this.reap);
		super.setSightRange(5);
	}

	/* Copy Constructor */
	public Ghost(Enemy copyEnemy) {
		super(copyEnemy);
	}

	/* Getter Methods */
	@Override
	protected String getType() {
		return "Ghost";
	}

	@Override
	public String toString() {
		return super.toString() + " Rp:{" + reap + "}";
	}
	
	/* Setter Methods */
	@Override
	public boolean isSpaceClear(int deltaX, int deltaY, Player hero, Maps mapgait) {
		boolean canMove = true;
		int toBeX = deltaX + this.getXloc();
		int toBeY = deltaY + this.getYloc();
		if (toBeX == hero.getX() && toBeY == hero.getY()) {
			canMove = false;
		} else if (mapgait.detectEnemy(toBeX, toBeY) != null) {
			canMove = false;
		} else if (toBeX == 9 || toBeX == 0 || toBeY == 9 || toBeY == 0) {
			canMove = false;
		}
		return canMove;
	}
}
