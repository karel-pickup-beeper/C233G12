package com.karelRPG.gameplay;

public class Cactus extends Enemy {

	public Cactus(int initialHealth, int initialXLoc, int initialYLoc) {
		super(initialHealth, initialXLoc, initialYLoc);
	}

	public Cactus(Enemy copyEnemy) {
		super(copyEnemy);
	}

	/**
	 * This mutator method will call changeYLoc and changeXLoc. It will change the actual location of enemy to move 
	 * one step closer to the player.
	 * 
	 * @param playerX
	 * @param playerY
	 */
	public void enemyAction() {
		//do nothing
	}
	
	protected String getType() {
		return "Cactus";
	}

}
