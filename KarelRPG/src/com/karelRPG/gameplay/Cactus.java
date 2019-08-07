package com.karelRPG.gameplay;

public class Cactus extends Enemy {

	private int spike;
	private boolean on;
	
	/* Constructors */
	public Cactus(int initialHealth, int initialXLoc, int initialYLoc, int spike, boolean on) {
		super(initialHealth, initialXLoc, initialYLoc);
		if (spike > 0 && spike < 99)
			this.spike = spike;
		this.on = on;
		if (on)
			super.setAttack(spike);
		else
			super.setAttack(0);
		super.setSightRange(0);
	}

	/* Copy Constructor */
	public Cactus(Enemy copyEnemy) {
		super(copyEnemy);
		if (copyEnemy instanceof Cactus) {
			this.spike = ((Cactus) copyEnemy).spike;
			this.on = ((Cactus) copyEnemy).on;
		}
	}

	/* Getter Methods */
	
	@Override
	public String getType() {
		return "Cactus";
	}

	@Override
	public String toString() {
		return super.toString() + " Spk:{" + spike + "}";
	}
	
	/* Setter Methods */
	@Override
	public void enemyAction(Player user, Maps mapgait) {
		if (this.on) {
			this.on = false;
			super.setAttack(0);
		} else {
			this.on = true;
			super.setAttack(spike);
		}
	}
	
	@Override
	public void enemyAttack(Player target, Maps mapwalk, String direction) {
		// do nothing
	}

}
