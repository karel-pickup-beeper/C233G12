package com.karelRPG.gameplay;

import java.util.ArrayList;
import java.util.Iterator;

public class Maps {
	private int sizeOfCurrentRoom;
	private String[][] layoutOfCurrentRoom; 
	private ArrayList<PhysicalCollectible> listOfCollectibles = new ArrayList<PhysicalCollectible>();
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	
	/* Simplistic Constructor for initializing maps at the start of the game. This constructor should only be called at the beginning of the game, and no more. */
	public Maps(int room) {
/*
		switch (room)
		{
		case 0:
			layoutOfCurrentRoom = new String[][] {
				{"X","X","X","X","X","X","X","X","X","X"},
				{"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","X","X","X","X","X","X","X","X","X"}};
			    break;
			
			case 1:
				layoutOfCurrentRoom = new String[][] {
				{"X","X","X","X","X","X","X","X","X","X"},
				{"X","_","_","_","_","x","_","_","_","X"},
				{"X","_","_","_","_","x","_","_","_","X"},
				{"X","_","_","_","_","x","_","_","_","X"},
				{"X","x","x","_","_","x","_","_","_","X"},
				{"X","_","_","_","_","_","_","x","x","X"},
				{"X","_","_","_","_","_","x","x","_","_"},
				{"X","_","x","_","_","_","_","_","_","X"},
				{"X","_","x","_","_","_","_","_","_","X"},
				{"X","X","X","X","X","X","X","X","X","X"}};
				break;
			
			case 2:
				layoutOfCurrentRoom = new String[][] {
				{"X","X","X","X","X","X","X","X","X","X"},
				{"X","_","_","_","x","_","_","_","_","X"},
				{"X","_","x","_","_","x","_","_","_","X"},
				{"X","_","x","x","_","_","_","_","_","X"},
				{"X","_","_","_","x","_","_","_","_","X"},
				{"X","x","x","_","x","_","_","x","x","X"},
				{"_","_","_","_","x","_","x","x","_","_"},
				{"X","x","x","x","_","_","x","x","_","X"},
				{"X","_","_","_","_","x","_","_","_","X"},
				{"X","_","X","X","X","X","_","X","_","X"}};
				break;
				
			case 3:
				layoutOfCurrentRoom = new String[][] {
				{"X","_","X","X","X","X","_","X","_","X"},
				{"X","_","x","_","_","x","_","x","_","X"},
				{"X","_","x","_","_","x","_","x","_","X"},
				{"X","_","x","_","_","_","_","x","_","X"},
				{"X","_","x","_","_","_","x","_","_","X"},
				{"X","_","_","_","x","x","_","_","x","X"},
				{"X","x","x","x","_","_","_","x","_","_"},
				{"X","_","x","_","_","x","x","_","_","X"},
				{"X","_","x","_","x","_","_","_","_","X"},
				{"X","X","X","X","X","X","X","X","X","X"}};
				break;
				
			case 4:
				layoutOfCurrentRoom = new String[][] {
				{"X","X","X","X","X","X","X","X","X","X"},
				{"X","_","_","_","x","_","_","_","_","X"},
				{"X","_","x","_","_","x","_","_","_","X"},
				{"X","_","x","x","_","_","_","_","_","X"},
				{"X","_","_","_","x","_","_","_","_","X"},
				{"X","X","X","X","X","X","X","X","X","X"},
				{"_","_","_","_","x","_","x","x","_","X"},
				{"X","x","x","_","_","_","_","x","_","X"},
				{"X","_","_","_","_","x","_","_","_","X"},
				{"X","_","X","X","X","X","X","_","X","X"}};
				break;
				
			case 5:
				layoutOfCurrentRoom = new String[][] {
				{"X","_","X","X","X","X","X","_","X","X"},
				{"X","_","x","_","_","x","_","_","_","X"},
				{"X","_","x","_","_","x","_","_","_","X"},
				{"X","_","x","_","_","x","_","_","_","X"},
				{"X","_","x","_","_","x","_","_","_","X"},
				{"X","x","x","_","_","x","_","_","_","X"},
				{"_","_","x","x","x","x","x","x","_","X"},
				{"X","_","_","_","_","_","_","_","_","X"},
				{"X","_","x","_","_","_","_","_","_","X"},
				{"X","X","X","X","X","X","X","X","X","X"}};
				break;
				
			default:
				break;
		}*/
		switch (room)
		{
		case 0:
			layoutOfCurrentRoom = new String[][] {
				{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"},
				{"X","_","_","_","_","_","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","_","_","_","_","_","X"},
			    {"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"}};
			    break;
			
			case 1:
				layoutOfCurrentRoom = new String[][] {
				{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"},
				{"X","_","_","_","_","x","_","_","_","_","_","_","_","_","X"},
				{"X","_","_","_","_","x","_","_","_","_","_","_","_","_","X"},
				{"X","_","_","_","_","x","_","_","_","_","_","_","_","_","X"},
				{"X","x","x","_","_","x","_","_","_","_","_","x","_","X","X"},
				{"X","x","x","_","_","_","_","_","_","_","_","_","_","X","X"},
				{"X","x","x","_","_","x","_","_","_","_","_","x","x","X","X"},
				{"X","_","_","_","_","_","_","_","x","_","_","_","_","X","X"},
				{"X","_","_","_","_","_","_","_","_","_","_","_","_","_","_"},
				{"X","_","_","_","_","_","_","_","x","_","_","_","X","X","X"},
				{"X","_","_","_","_","_","x","x","x","_","_","_","_","X","X"},
				{"X","_","_","_","_","_","x","x","_","_","_","_","_","_","X"},
				{"X","_","_","_","_","_","x","x","_","_","_","_","_","_","X"},
				{"X","_","_","_","_","_","x","x","_","_","_","_","_","_","X"},
				{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"}};
				break;
			
			case 2:
				layoutOfCurrentRoom = new String[][] {
				{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"},
				{"X","_","_","_","x","_","_","_","_","_","_","_","_","X","X"},
				{"X","_","x","_","_","x","_","_","_","x","_","_","_","X","X"},
				{"X","_","x","x","_","_","_","_","_","_","_","_","_","X","X"},
				{"X","_","_","_","x","_","_","_","_","_","_","_","_","X","X"},
				{"X","_","x","_","x","_","x","x","x","_","_","x","x","X","X"},
				{"X","_","_","_","x","_","x","_","_","_","_","x","_","X","X"},
				{"X","x","x","_","_","_","x","_","_","_","_","_","_","X","X"},
				{"_","_","_","_","_","_","_","_","_","_","x","x","_","X","X"},
				{"X","_","_","x","_","_","x","x","_","_","_","_","_","_","_"},
				{"X","_","_","_","_","_","_","_","_","_","x","x","_","X","X"},
				{"X","_","x","x","_","x","x","_","_","_","_","_","_","X","X"},
				{"X","_","_","_","_","_","_","_","_","x","_","_","_","X","X"},
				{"X","_","_","_","_","_","_","_","_","x","_","_","_","_","X"},
				{"X","_","X","X","X","X","_","X","X","X","X","X","X","_","X"}};
				break;
				
			case 3:
				layoutOfCurrentRoom = new String[][] {
				{"X","_","X","X","X","X","_","X","X","X","X","X","X","_","X"},
				{"X","_","x","_","_","x","_","x","_","x","_","_","_","_","X"},
				{"X","_","x","_","_","x","_","x","_","x","_","x","_","X","X"},
				{"X","_","x","_","_","_","_","x","_","_","_","x","_","X","X"},
				{"X","_","x","_","_","_","x","_","_","_","_","_","_","X","X"},
				{"X","_","_","_","_","x","_","_","x","x","_","_","x","X","X"},
				{"X","_","_","_","_","_","_","x","_","_","_","x","_","_","X"},
				{"X","_","_","_","_","x","_","_","_","_","_","x","_","X","X"},
				{"X","_","_","_","_","_","_","x","_","_","_","x","_","X","X"},
				{"X","_","x","_","_","_","_","x","_","_","_","x","_","X","X"},
				{"X","_","_","_","_","_","_","x","_","x","_","_","_","X","X"},
				{"X","_","x","_","_","_","x","_","_","x","x","_","_","_","_"},
				{"X","_","x","_","x","_","_","_","_","_","_","_","_","X","X"},
				{"X","_","x","_","x","_","_","_","_","_","_","_","_","X","X"},
				{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"}};
				break;
				
			case 4:
				layoutOfCurrentRoom = new String[][] {
				{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"},
				{"X","_","_","_","x","_","_","_","_","_","_","_","_","X","X"},
				{"X","_","x","_","_","x","_","_","_","x","_","_","_","X","X"},
				{"X","_","x","x","_","_","_","_","_","_","_","_","_","X","X"},
				{"X","_","x","_","_","_","_","_","_","_","_","_","_","X","X"},
				{"X","_","_","_","_","_","_","_","_","_","_","_","_","X","X"},
				{"X","_","_","_","_","_","_","_","_","_","_","_","_","X","X"},
				{"X","_","x","x","_","_","_","_","_","_","_","_","_","X","X"},
				{"X","X","_","_","_","_","_","_","_","_","_","_","_","X","X"},
				{"_","_","_","_","_","X","X","X","X","X","X","X","X","X","X"},
				{"X","_","_","_","_","_","_","x","_","_","x","x","_","X","X"},
				{"X","x","x","_","_","_","_","x","_","_","_","x","_","X","X"},
				{"X","_","_","_","_","x","_","_","_","x","_","_","_","X","X"},
				{"X","x","x","_","_","_","_","x","_","_","_","_","_","X","X"},
				{"X","X","X","_","X","X","X","X","X","X","X","_","X","X","X"}};
				break;
				
			case 5:
				layoutOfCurrentRoom = new String[][] {
				{"X","X","X","_","X","X","X","X","X","X","X","_","X","X","X"},
				{"X","_","x","_","_","x","_","_","_","X","_","_","x","X","X"},
				{"X","_","x","_","_","x","_","_","_","X","_","_","x","X","X"},
				{"X","_","x","_","_","x","_","_","_","X","_","_","x","X","X"},
				{"X","_","_","_","_","x","_","_","_","X","_","_","x","X","X"},
				{"X","_","_","_","_","_","_","_","_","X","_","x","x","X","X"},
				{"X","_","_","_","_","_","_","_","_","_","_","_","_","X","X"},
				{"X","x","_","_","_","_","_","_","_","_","_","x","x","X","X"},
				{"X","x","_","_","_","_","_","_","_","_","_","x","x","X","X"},
				{"X","x","_","_","_","-","_","_","_","_","_","x","x","X","X"},
				{"X","x","x","_","_","_","_","_","_","_","_","x","x","X","X"},
				{"_","_","x","x","x","_","x","x","_","_","_","_","x","X","X"},
				{"X","_","_","_","_","_","_","_","_","X","X","_","_","X","X"},
				{"X","_","x","x","x","_","x","x","_","_","_","_","x","X","X"},
				{"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"}};
				break;
				
			default:
				break;
		}
	}
	
	/* Variant of Constructor that requires the parameters of all instances. To be used solely by the copy constructor. */
	public Maps(int room, String[][] layout, ArrayList<PhysicalCollectible> list, ArrayList<Enemy> elist) {
		this.sizeOfCurrentRoom = room;
		this.layoutOfCurrentRoom = layout;
		this.listOfCollectibles = list;
		this.enemyList = elist;
	}
	
	/* Copy Constructor */
	public Maps(Maps m) {
		this(m.sizeOfCurrentRoom, m.layoutOfCurrentRoom, m.listOfCollectibles, m.enemyList);
	}


	/**
	 * This method traverses through an array in order to detect and print out
	 * a string of underscores representing an empty tile. It then returns the 
	 * represented symbol of a tile.
	 * 
	 * @param xThere  the x coordinate of said tile
	 * @param yThere  the y coordinate of said tile
	 * @return n      the string outlining a tile
	 */
	public String detectTile(int xThere, int yThere) 
	{
		String n = "_";
		
		for (int i = 0; i < layoutOfCurrentRoom.length; i++) {
			for(int j = 0; j < layoutOfCurrentRoom[i].length; j++) {
				if (j == xThere && i == yThere) {
					n = layoutOfCurrentRoom[i][j];
				}
			}
		}
		return n;
	}
	
	/**
	 * Returns a layout of the current room initialized in the constructor.
	 * This method returns immediately whether or not the layout of the room exists.
	 * 
	 * @return layoutOfCurrentRoom  a layout of the room specified in the constructor returned 
	 * 								in the form of a 2D String Array
	 */
	public String[][] getLayoutOfCurrentRoom()
	{
		return this.layoutOfCurrentRoom;
	}
	
	/**
	 * Returns a collectible's name in the listOfCollectibles ArrayList at the specified
	 * coordinates.
	 * The method traverses through the ArrayList and once a collectible's x and y
	 * coordinates match, the name of that collectible is returned.
	 * 
	 * 	@return n  	 the name of a collectible in the form of a String
	 */
	public String detectItem(int xHere, int yHere)
	{
		String n = null;
		
		for (PhysicalCollectible k : listOfCollectibles)
		{
			if (k.getX() == xHere && k.getY() == yHere)
			{
				n = k.getTag();
			}
		}
		return n;
		
	}
	
	public void setMapCollectibles(PhysicalCollectible thing)
	{
		this.listOfCollectibles.add(thing);
	}
	
	/**
	 * Returns an inventory of collectible initialized in the constructor.
	 * Retrieve the list of collectibles that exists in physical space.
	 * This method returns immediately whether or not the list is empty.
	 * 
	 * @return listOfCollectibles  an inventory of collectible in the constructor returned 
	 * 								in the form of an ArrayList
	 */
	public ArrayList<PhysicalCollectible> getListOfCollectibles()
	{
		return new ArrayList<PhysicalCollectible>(listOfCollectibles);
	}
	
	/**
	 * This method is responsible for detecting and returning any enemy object at the location
	 * specified by map coordinates. It would iterate through the ArrayList enemyList and identify whether
	 * an enemy object has coordinates that matches with the specified location. If so, then the enemy's 
	 * location is returned; if not, the Enemy object remains null.
	 * 
	 * @param xHere   the y coordinate specified
	 * @param yHere   the x coordinate specified
	 * @return e      the enemy object specified by the map coordinates
	 */
	public Enemy detectEnemy(int xHere, int yHere)
	{
		Enemy e = null;
		
		for (Enemy l : enemyList)
		{
			if (l.getXloc() == xHere && l.getYloc() == yHere)
			{
				 e = l;
			}
		}
		return e;
		
	}
	
	public void setMapEnemies(Enemy monster)
	{
		this.enemyList.add(monster);
	}
	
	/**
	 * This method returns the ArrayList of enemy objects that occupies a location on the map.
	 * 
	 * @return enemyList  an ArrayList of enemy objects
	 */
	public ArrayList<Enemy> getEnemyList()
	{
		return new ArrayList<Enemy>(enemyList);
	}
	

	public void doAllEnemyActions(Player user, boolean run)
	{
		for (Enemy en : enemyList)
		{
			en.flee(run);
			en.enemyAction(user, this);
		}
	}
	public String getEnemyListString() {
		String display = "";
		for(Enemy en : enemyList)
		{
			display += en.toString();
		}
		return display;
	}
	
	public boolean enemiesRemaining() 
	{
		boolean yep = true;
		
		if (this.enemyList.isEmpty()) {
			yep = false;
		}
		
		return yep;
	}
	
	public boolean collectiblesRemaining()
	{
		boolean yep = true;
		
		if (this.listOfCollectibles.isEmpty()) {
			yep = false;
		} else {
			boolean itemToPick = false;
			for (PhysicalCollectible thing : this.listOfCollectibles)
			{
				if (thing.getTag() == "Key" || thing.getTag() == "Star" || thing.getTag() == "Potion")
				{
					itemToPick |= true;
				}
			}
			yep = !itemToPick;
		}
		
		return yep;
	}
	
	/**
	 * This method searches for a collectible at a specified location. If the collectible 
	 * is present in that location it is removed from the arrayList and no longer shown 
	 * on the map.
	 * This is done by iterating through the listOfCollectibles ArrayList with an iterator
	 * until we find a match between the xHere and yHere coordinates
	 * with the x and y coordinates of the iterated PhysicalCollectible object.
	 * 
	 * @param xHere  the y coordinate of a collectible's location
	 * @param yHere  the x coordinate of a collectible's location
	 */
	public void popCollectible(int xHere, int yHere) 
	{
		
		/*
		 * Now we must iterate through the ArrayList of PhysicalCollectible objects
		 * representing the existence of Collectible class objects on the map, until we find a location
		 * match with our passed parameters. And ultimately, to delete them from the ArrayList.
		 */
		
		for (Iterator<PhysicalCollectible> iterator = listOfCollectibles.iterator(); iterator.hasNext();) {
			PhysicalCollectible thing = iterator.next();
			if (thing.getX() == xHere && thing.getY() == yHere) {
				iterator.remove();
			}
		}
	}
	
	/**
	 * This method searches for an enemy at a specified location. If the enemy 
	 * is present in that location it is removed from the ArrayList and no longer shown 
	 * on the map.
	 * This is done by iterating through the enemyList ArrayList with an iterator
	 * until we find a match between the xHere and yHere coordinates
	 * with the x and y coordinates of the iterated Enemy object.
	 * 
	 * @param xHere the specified y coordinate of an enemy's location
	 * @param yHere the specified x coordinate of an enemy's location
	 */
	public void popEnemy (int xHere, int yHere)
	{
		/*
		 * Now we must iterate through the ArrayList of Enemy objects
		 * representing the enemies' existence on the map, until we find a location
		 * match with our passed parameters. And ultimately, to delete them from the ArrayList.
		 */
		for (Iterator<Enemy> iterator = enemyList.iterator(); iterator.hasNext();) {
			Enemy stuff = iterator.next();
			if (stuff.getXloc() == xHere && stuff.getYloc() == yHere) {
			iterator.remove();
			}
		}
	}
	
	/**
	 * This method searches for an enemy object specified by the parameters. If the enemy 
	 * is present it is removed from the ArrayList and no longer shown on the map.
	 * This is done by iterating through the enemyList ArrayList with an iterator
	 * until we find a match between iterated Enemy object and the specified parameter.
	 * 
	 * @param en specified Enemy object to be popped from the ArrayList of Enemy objects.
	 */
	public void popEnemy (Enemy en)
	{
		/*
		 * Now we must iterate through the ArrayList of Enemy objects
		 * representing the enemies' existence on the map, until we find a location
		 * match with our passed parameters. And ultimately, to delete them from the ArrayList.
		 */
		for (Iterator<Enemy> iterator = enemyList.iterator(); iterator.hasNext();) {
			Enemy stuff = iterator.next();
			if (stuff.equals(en)) {
			iterator.remove();
			}
		}
	}
	
}
