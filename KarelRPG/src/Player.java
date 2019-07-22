import java.util.ArrayList;

enum HealthCondition
{
	GOOD,POISON,STUN;
}

public class Player {
	
	
	/* instances */
	private int life;
	private int yCoord;
	private int xCoord;
	private ArrayList<Collectible> inventory = new ArrayList <Collectible>();
	private ArrayList<Integer> stats = new ArrayList <Integer>();
	private HealthCondition status;
	
	/* Constructors */
	public Player(int health1, int x, int y) {
		life=health1;
		xCoord=x;
		yCoord=y;
	}
	
	/* Copy Constructors */
	public Player(Player play) {
		life=play.life;
		inventory=play.inventory;
		stats=play.stats;
	}
	 
	/*
	 * Methods
	 */
	public void changeStats(int index, int num) {

				
	}
	public ArrayList <Integer> getStat(){
		return stats;
	}
	
	public void changeStatus(HealthCondition change) { 
		this.status = change;
	}
	public HealthCondition getStatus() {
		return this.status;
	}
	
	/* Sets Player Health */
	public void setHealth(int health1) {
		life=health1;
	}
	public int getHealth() {
		return life;
	}

	/* Preset inventory Collectibles */
	public void setItem(Collectible item) {
		inventory.add(item);
	}
	
	/* To add the abstract items in Player's inventory space. */
	public void pickUpItem(String name) {
		for (Collectible item : inventory) {
			if (item.getName() == name)
			item.increaseCount(1);
		}
	}
	public static int getSingleItemCount(String name) {
		
		return 0;
	}
	
	/* Inventory */
	public ArrayList <Collectible> getInventory() {
		return inventory;
	}

	/* Get Inventory as a String */
	public String stringInven() {
		return inventory.toString();
	}
	public int getX() {
		return xCoord;
	}
	public int getY() {
		return yCoord;
	}
	
	/* Mutator Methods for Player Coordinates */
	public void changeX(int x1) { 
		xCoord+=x1;		
	}
	public void changeY(int y1) {
		yCoord+=y1;
	}

	public void playerMove(CardinalDirection command) {
		switch (command) {
		case NORTH:
			changeY(-1);
			break;
		case SOUTH:
			changeY(1);
			break;
		case EAST:
			changeX(1);
			break;
		case WEST:
			changeX(-1);
			break;
		default:
			System.out.println("What have you done D:");
			break;
		}
	}
}
	
