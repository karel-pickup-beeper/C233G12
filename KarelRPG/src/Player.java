import java.util.ArrayList;

public class Player {
	
	
	//variables
	private int life; //will be added later.
	private int yCoord;
	private int xCoord;
	private ArrayList<Collectible> inventory = new ArrayList <Collectible>();
	private ArrayList<Integer> stats = new ArrayList <Integer>();
		
	
	//constructors
	public Player(int health1, int x, int y) {//set player with stats
		life=health1;
		xCoord=x;
		yCoord=y;
	}
	
	public Player(Player play) {//copy constructor
		life=play.life;
		inventory=play.inventory;
		stats=play.stats;
	}
	 
	//methods
	public void changeStats(int index, int num) {

				
	}
	public ArrayList <Integer> getStat(){
		return stats;
	}
	public void changeStatus() { 
		
	}
	public void setHealth(int health1) { //set player health
		life=health1;
	}
	public int getHealth() {
		return life;
	}
	public void setItem(Collectible item) { //to preset any inventory collectibles
		inventory.add(item);
	}
	public void pickUpItem(Collectible item) {  //pick up items 
		if (inventory.contains(item)) {
			item.increaseCount(1);
		}else {
			inventory.add(item);
			item.increaseCount(1);
		}
	}
	public static int getSingleItemCount(String name) {
		
		return 0;
	}
	
	
	public ArrayList <Collectible> getInventory() { //get inventory
		return inventory;
	}
	public String stringInven() {
		return inventory.toString(); //get the inventory as a string
	}
	public int getX() {
		return xCoord;
	}
	public int getY() {
		return yCoord;
	}
	
	// change coordinal direction methods

	public void changeX(int x1) { 
		xCoord+=x1;		
	}
	public void changeY(int y1) {
		yCoord+=y1;
	}

	public void playerMove1(CardinalDirection command) {
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
	
