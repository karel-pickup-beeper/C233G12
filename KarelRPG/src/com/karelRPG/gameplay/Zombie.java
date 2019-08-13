package com.karelRPG.gameplay;
import java.util.Random;

public class Zombie extends Enemy {

	private int bite;
	Random rand = new Random();
	
	/* Constructors */
	public Zombie(int initialHealth, int initialXLoc, int initialYLoc, int bite) {
		super(initialHealth, initialXLoc, initialYLoc);
		if (bite > 0 && bite < 99)
			this.bite = bite;
		super.setAttack(this.bite);
		super.setSightRange(6);
	}

	/* Copy Constructor */
	public Zombie(Enemy copyEnemy) {
		super(copyEnemy);
		if (copyEnemy instanceof Zombie) {
			this.bite = ((Zombie) copyEnemy).bite;
		}
	}

	/* Getter Methods */
	@Override
	public String getType() {
		return "Zombie";
	}
	
	@Override
	public String toString() {
		return super.toString() + " Bt:{" + bite + "}";
	}
	
	/* Setter Methods */
	@Override
	public void enemyAttack(Player target, Maps mapwalk, String direction) {
		switch (direction)
		{
		case "NORTHEAST":
			if (target.getX()==this.getXloc()+1 && target.getY()==this.getYloc()-1) {
				System.out.print("You got scratched by a zombie. ");
				target.changeHealth(-bite/5);
				if (rand.nextBoolean())
				this.loseHealth(-bite/6);
			}
			break;
		case "SOUTHEAST":
			if (target.getX()==this.getXloc()+1 && target.getY()==this.getYloc()+1) {
				System.out.print("You got scratched by a zombie. ");
				target.changeHealth(-bite/5);
				if (rand.nextBoolean())
				this.loseHealth(-bite/5);
			}
			break;
		case "NORTHWEST":
			if (target.getX()==this.getXloc()-1 && target.getY()==this.getYloc()-1) {
				System.out.print("You got scratched by a zombie. ");
				target.changeHealth(-bite/5);
				if (rand.nextBoolean())
				this.loseHealth(-bite/6);
			}
			break;
		case "SOUTHWEST":
			if (target.getX()==this.getXloc()-1 && target.getY()==this.getYloc()+1) {
				System.out.print("You got scratched by a zombie. ");
				target.changeHealth(-bite/5);
				if (rand.nextBoolean())
				this.loseHealth(-bite/6);
			}
			break;
		case "NORTH":
			if (target.getX()==this.getXloc() && target.getY()==this.getYloc()-1) {
				System.out.print("You got bitten by a zombie. ");
				target.changeHealth(-bite);
				if (rand.nextBoolean())
				this.loseHealth(-bite/3);
			}
			break;
		case "SOUTH":
			if (target.getX()==this.getXloc() && target.getY()==this.getYloc()+1) {
				System.out.print("You got bitten by a zombie. ");
				target.changeHealth(-bite);
				if (rand.nextBoolean())
				this.loseHealth(-bite/3);
			}
			break;
		case "EAST":
			if (target.getX()==this.getXloc()+1 && target.getY()==this.getYloc()) {
				System.out.print("You got bitten by a zombie. ");
				target.changeHealth(-bite);
				if (rand.nextBoolean())
					this.loseHealth(-bite/3);
			}
			break;
		case "WEST":
			if (target.getX()==this.getXloc()-1 && target.getY()==this.getYloc()) {
				System.out.print("You got bitten by a zombie. ");
				target.changeHealth(-bite);
				if (rand.nextBoolean())
				this.loseHealth(-bite/3);
			}
			break;
		default:
			System.out.println("No TileTakenException string message received.");
			break;
		}
		
	}
}
