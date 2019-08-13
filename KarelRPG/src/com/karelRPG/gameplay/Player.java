package com.karelRPG.gameplay;
import java.util.ArrayList;

enum HealthCondition
{
	GOOD,POISON,STUN;
}

enum ItemSelection
{
	potion,normalsword,bigsword,whacksword,repel;
	public String toString() {
		String n = "";
		switch (this)
		{
		case potion:
			n += "Potion";
			break;
		case normalsword:
			n += "(default sword)";
			break;
		case bigsword:
			n += "Big Sword";
			break;
		case whacksword:
			n += "Whack Sword";
			break;
		default:
			break;
		}
		return n;
	}
}

public class Player {
	
	
	/* instances */
	private int life;
	private int yCoord;
	private int xCoord;
	private ArrayList<Collectible> inventory = new ArrayList <Collectible>();
	private ArrayList<Integer> stats = new ArrayList <Integer>();
	private HealthCondition status;
	private int strengthindex=1;
	private ItemSelection itemSelected = ItemSelection.normalsword; 
	
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
	
	/**
	 * This mutator method will change the statistics of the player to 
	 * values , when called. This is a future feature implementation.
	 * 
	 * @param index
	 * @param num
	 */
	public void changeStats(int index, int num) {

				
	}
	
	/**
	 * This mutator method will change the statistics of the player to 
	 * values , when called. This is a future feature implementation.
	 * 
	 * @param index
	 * @param num
	 */
	public void changeEquip(ItemSelection something) {
		this.itemSelected = something;
	}
	
	/**
	 * This accessor method will return the statistics of the player, when called. 
	 * 
	 * @return stats
	 * 
	 */
	public ArrayList <Integer> getStatList(){
		return stats;
	}
	
	/**
	 * This mutator method will change the health condition of the player, when called. 
	 * This is a future feature implementation.
	 * 
	 * @param change
	 */
	public void changeStatus(HealthCondition change) { 
		this.status = change;
	}
	
	/**
	 * This accessor method will return the health condition of the player, when called. 
	 * 
	 * @return status
	 * 
	 */
	public HealthCondition getStatus() {
		return this.status;
	}
	
	/**
	 * This mutator method will set the initial health condition of the player, when called. 
	 * 
	 * @param health1
	 * 
	 */
	/* Sets Player Health */
	public void setHealth(int health1) {
		life=health1;
	}
	
	/**
	 * This accessor method will return the current health condition of the player, when called. 
	 * 
	 * @return life
	 * 
	 */
	public void setLocation(int x, int y) {
		xCoord=x;
		yCoord=y;
	}
	public int getHealth() {
		return life;
	}
	
	/**
	 * This mutator method will set the initial collectible items of the player, when called. 
	 * 
	 * @param item
	 * 
	 */
	/* Preset inventory Collectibles */
	public void setInventory(Collectible item) {
		this.inventory.add(item);
	}
	
	
	/**
	 * This mutator method will add or remove collectible items from the player's inventory, 
	 * when called. 
	 * 
	 * @param name
	 * 
	 */
	/* To add the abstract items in Player's inventory space. */
	public void pickUpItem(String name) {
		for (Collectible item : inventory) {
			if (item.getName() == name)
			item.increaseCount(1);
		}
	}
	
	public void useUpItem(String name) {
	for (Collectible item : inventory) {
		if (item.getName() == name)
			item.increaseCount(-1);
	}
}

	/**
	 * This accessor method will return a list of collectible items in the player's inventory, when called. 
	 * 
	 * @return inventory
	 * 
	 */
	/* Inventory */
	public ArrayList<Collectible> getInventory() {
		return new ArrayList<Collectible>(inventory);
	}
	
	/**
	 * This accessor method will return a list of collectible items in the player's inventory
	 * as a display string.
	 * @return inventory
	 * 
	 */
	/* Inventory Display Text */
	public String getInventoryString() {
		String text = "";
		for (Collectible item : inventory) {
			if (item.getClassification() == "object")
				text += item.toString() + "  ";
		}
		text += "  Equipped with: " + this.itemSelected.toString();
		return text;
	}
	
	/**
	 * This accessor method will return the x-coordinate of the player, when called. 
	 * 
	 * @return xCoord
	 * 
	 */
	public int getX() {
		int xCoord = this.xCoord;
		return xCoord;
	}
	
	/**
	 * This accessor method will return the y-coordinate of the player, when called. 
	 * 
	 * @return yCoord
	 * 
	 */
	public int getY() {
		int yCoord = this.yCoord;
		return yCoord;
	}
	
	/**
	 * This mutator method will change the x-coordinate of the player, when called. 
	 * 
	 * @param x1
	 * 
	 */
	/* Mutator Methods for Player Coordinates */
	public int changeX(int x1) { 
		return xCoord+=x1;		
	}
	
	/**
	 * This mutator method will change the y-coordinate of the player, when called. 
	 * 
	 * @param y1
	 * 
	 */
	public int changeY(int y1) {
		return yCoord+=y1;
	}
	
	/**
	 * This method will determine the directional change of the player, when called. 
	 * 
	 * @param command
	 * 
	 */
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
	public void changeHealth(int amount) {
		if (amount+this.life<=0) {
			this.life = 0;
		} else if (amount+this.life<=100) {
			life+=amount;
			System.out.print("You've just ");
			if (amount <= 0)
				System.out.print("Lost ");
			else
				System.out.print("Gained ");
			
			System.out.println(amount+" Health");
		} else {
			this.life = 100;
			System.out.println("Maximum Vitality Reached, health cannot go higher.");
		}
	}
	
	public int countSingleItem(String name) {
		int i=0;
		for (Collectible item : inventory) {
			if (item.getName() == name)
				i = item.getCount();
		}
		return i;
	}
	public boolean haveAllKeys() {
		boolean yep = false;
		for (Collectible item : inventory) {
			if (item.getName() == "Key" && item.getCount() == 7)
				yep = true;
		}
		return yep;
	}
	
	public void useCollectible(Collectible c) {
		
		if (c.getName() == "Sun") {
			changeStats(strengthindex, 5);
			
		}
	}
	
	public int getStrength() {
		return getStatList().get(strengthindex);
		}
}
	
