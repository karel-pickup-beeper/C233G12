package com.karelRPG.gameplay;
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
	private int strengthindex=1;
	private int speedindex=2;
	
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

	
	/**
	 * This accessor method will return the number of collectible items in the player's inventory, when called. 
	 * This is a future feature implementation.
	 * 
	 * @param name
	 * @return 0
	 * 
	 */
	public static int getSingleItemCount(String name) {
		return 0;//fixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixmefixme;
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
		life+=amount;
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
	
