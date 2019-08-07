package com.karelRPG.gameplay;
import java.util.ArrayList;
  
enum CardinalDirection
{
	NORTH,EAST,SOUTH,WEST,NORTHEAST,SOUTHEAST,NORTHWEST,SOUTHWEST, STOP;
}

enum CommandType 
{ 
    left,up,right,down,pickup,attack,help,no,systemcheck; 
} 
  
/*
 * Driver class Action Prompt that reads and writes current command
 * and the entire game which runs in main().
 */
public class ActionPrompt 
{
	/* instances */
	private int timeStep;
	private CommandType currentCommand;
	private int roomNumber;
	private boolean noMoreGame;
	private ArrayList<Maps> dungeon = new ArrayList<Maps>();
  
	/* Constructor */
	public ActionPrompt(int timeStep, CommandType currentCommand, int roomNumber) 
    	{ 
        	this.timeStep = timeStep;
        	this.currentCommand = currentCommand;
        	this.roomNumber = roomNumber;
    	}

	/* Copy Constructor */
	public ActionPrompt(ActionPrompt a)
	{
    		this(a.timeStep, a.currentCommand, a.roomNumber);
	}
	
	/* Methods */
	
	
	/**
	 * This accessor method will return the room number r, when called.
	 * 
	 * @return r: room number of type integer.
	 * 
	 */
	public int getroomNumber() {
		int r = this.roomNumber;
		return r;
	}
	
	/**
	 *
	 * This mutator method will increment the timeStep by 1, when called.
	 * 
	 */
	public void changeTimeStep() {
		this.timeStep++;
	}
	
	/**
	 * This accessor method will return the timeStep t, when called.
	 * 
	 * @return t: time step of type integer.
	 * 
	 */
	public int getTimeStep() {
		int t = this.timeStep;
		return t;
	}
	
	/**
	 * This accessor method will return noMoreGame n, when called.
	 * 
	 * @return n: noMoreGame of type boolean.
	 * 
	 */
	public boolean getNoMoreGame() {
		boolean n = this.noMoreGame;
		return n;
	}
	
	/**
	 * This mutator method will index Maps into the ArrayList of Maps in the dungeon, when called. 
	 * 
	 * @param map
	 * 
	 */
	/* Preset all possible maps in this dungeon. */
	public void indexDungeon(Maps map) {
		this.dungeon.add(map);
	}
	
	/**
	 * This accessor method will return the list of Maps of this dungeon, when called. 
	 * 
	 * @return dungeon
	 * 
	 */
	/* Dungeon's list of maps. */
	public ArrayList<Maps> getDungeon() {
		return new ArrayList<Maps>(dungeon);
	}
	
	public Maps getCurrentRoomMap() {
		return new Maps(dungeon.get(this.roomNumber));
	}
	
	public void initialiseMap(int num, PhysicalCollectible thing) {
		dungeon.get(num).setMapCollectibles(thing);
	}
	
	public void initialiseMap(int num, Enemy monster) {
		dungeon.get(num).setMapEnemies(monster);
	}
    /**
	 * This method will prints the world screen and all associated objects
	 * when it is called.
	 * 
	 * @Param thisWorld
	 * @Param player 1
	 * @Param mapview
	 */
	/* Printing the entirety of the world map with objects on top, printing pirority goes to
	 * Player > Collectible > Enemy > Map Tile
	 */
    public void printWorld(Player player1)
    {
    	Maps mapview = this.getDungeon().get(this.roomNumber);
    	String[][] thisWorld = mapview.getLayoutOfCurrentRoom();
    	
        for(int j=0;j<thisWorld.length; j++)
        {
        	for(int i=0;i<thisWorld[j].length; i++)
        	{
        		if (i==player1.getX() && j==player1.getY())
        		{
        			System.out.print("U");
        		}
        		else
        		{	if (this.roomNumber==3&&i==5&&j==8) System.out.print("W");
        		else if (mapview.detectEnemy(i, j) != null)
				{	
					System.out.print(mapview.detectEnemy(i, j).getType().substring(0, 1));
				}
        		
        			else
        			{
        				if (mapview.detectItem(i, j) != null)
            			{
            				String s = "";
            				switch (mapview.detectItem(i, j))
            				{
            				case "Key":
            					s = "*";
            					break;
            				case "Star":
            					s = "#";
            					break;
            				case "Sun":
            					s = "@";
            					break;
            				default:
            					break;
            				}
            				System.out.print(s);
            			}
        				else
        				{
        					System.out.print(mapview.detectTile(i, j));
        				}
        			}
        		}
        	}
        	System.out.println();
        }
    }
    
    /**
   	 * This method specifies the command in this ActionPrompt class
	 * that corresponds with the user's input passed as a string, when called.
   	 * 
   	 * @Param name
   	 * 
   	 * 
   	 */
    public void writeCommand(String name)
    {
    	switch (name)
    	{
    	case "A":
    	case "a":
    		this.currentCommand = CommandType.left;
    		System.out.println("Moved Left");
    		break;
    		
    	case "D":
    	case "d":
    		this.currentCommand = CommandType.right;
    		System.out.println("Moved Right");
    		break;
    		
    	case "W":
    	case "w":
    		this.currentCommand = CommandType.up;
    		System.out.println("Moved Up");
    		break;
    		
    	case "S":
    	case "s":
    		this.currentCommand = CommandType.down;
    		System.out.println("Moved Down");
    		break;
    		
    	case "P":
    	case "p":
    		this.currentCommand = CommandType.pickup;
    		System.out.println("Picking Up the Item");
    		break;
    		
    	case "T":
    	case "t":
    		this.currentCommand = CommandType.attack;
    		System.out.println("ATTACK!");
    		break;
    		
    	case "H":
    	case "h":
    		this.currentCommand = CommandType.help;
    		System.out.println("What were the commands again?");
    		break;
    		
    	case "":
    		this.currentCommand = CommandType.systemcheck;
    		break;
    		
    	default:
    		this.currentCommand = CommandType.no;
    		System.out.println("That was not a valid command, type h for the list of commands.");
    		break;
    	}
    }

    public void runEnemiesTurn(Player user)
    {
    	dungeon.get(this.roomNumber).doAllEnemyActions(user);
    }
    
    public void enemyPassiveAttack(Player user, Enemy monster)
    {
    	switch (monster.getType())
		{
		case "Cactus":
			if (monster.getAttack() == 0) {
				System.out.print(" You've charged straight into a dormant cacti, the spikes didn't hurt you. ");
			} else {
				System.out.print(" The active cacti spiked you. ");
				user.changeHealth(-monster.getAttack());
			}
			System.out.println(" Cacti get prickly when active, better not walk into them.");
			break;
			
		case "Robot":
			System.out.print("The robot buzzled with electricity, touching them gives off a shock. ");
			user.changeHealth(-monster.getAttack());
			((Robot) monster).resetRobotCharge();
			break;
			
		case "Zombie":
			System.out.print("You flinched while charging at the zombie. ");
			user.changeHealth(-monster.getAttack());
			monster.loseHealth(-monster.getAttack()/3);
			break;
			
		case "Ghost":
			System.out.print("The ghost took a bit of your soul as you charged into it. ");
			user.changeHealth(-monster.getAttack());
			monster.loseHealth(-monster.getAttack()/3);
			break;
		
		default:
			System.out.println("The enemy type is undefined.");
			user.changeHealth(0);
		}
    }
    /**
	 * This method executes a specific command based on ActionPrompt(this class), Player, and Maps classes,
	 * when called.
	 *
	 * @Param user
	 * 
	 */
    public void takeCommand(Player user)
    {
    	Maps mapwalk = this.getDungeon().get(this.roomNumber);
    	int x = user.getX();
		int y = user.getY();
		
    	switch (this.currentCommand)
    	{
    	case left:
    		/* Room Change Handlers */
    		if (this.roomNumber==2 && x==0) {
    			user.changeX(9);
    			this.roomNumber = 1;
    		} else if (this.roomNumber==4 && x==0) {
    			user.changeX(9);
    			this.roomNumber = 2;
    		} else if (this.roomNumber==5 && x==0) {
    			user.changeX(9);
    			this.roomNumber = 3;
    		}
    		
    		/* Collision Checks */
    		else if (mapwalk.detectEnemy(x-1, y) != null) {
    			System.out.print("That tile is occupied by an enemy!!!");
    			this.enemyPassiveAttack(user, mapwalk.detectEnemy(x-1, y));
    		} else if (mapwalk.detectTile(x-1, y) == "_")
    			user.playerMove(CardinalDirection.WEST);
    		else
    			System.out.println("Bump! Whoops, can't pass through walls yet.");
    		break;
    		
    	case right:
    		/* Room Change Handlers */
    		if (this.roomNumber==1 && x==9) {
    			user.changeX(-9);
    			this.roomNumber = 2;
    		} else if (this.roomNumber==2 && x==9) {
    			user.changeX(-9);
    			this.roomNumber = 4;
    		} else if (this.roomNumber==3 && x==9) {
    			user.changeX(-9);
    			this.roomNumber = 5;
    		}
    		
    		/* Collision Checks */
    		else if (mapwalk.detectEnemy(x+1, y) != null) {
    			System.out.println("That tile is occupied by an enemy!!!");
    			this.enemyPassiveAttack(user, mapwalk.detectEnemy(x+1, y));
    		} else if (mapwalk.detectTile(x+1, y) == "_")
    			user.playerMove(CardinalDirection.EAST);
    		else
    			System.out.println("Bump! Whoops, can't pass through walls yet.");
    		break;
    		
    	case up:
    		/* Room Change Handlers */
    		if (this.roomNumber==3 && y==0) {
    			user.changeY(9);
    			this.roomNumber = 2;
    		} else if (this.roomNumber==5 && y==0) {
    			user.changeY(9);
    			this.roomNumber = 4;
    		}
    		
    		/* Collision Checks */
    		else if (mapwalk.detectEnemy(x, y-1) != null) {
    			System.out.println("That tile is occupied by an enemy!!!");
    			this.enemyPassiveAttack(user, mapwalk.detectEnemy(x, y-1));
    		} else if (mapwalk.detectTile(x, y-1) == "_")
    			user.playerMove(CardinalDirection.NORTH);
    		else
    			System.out.println("Bump! Whoops, can't pass through walls yet.");
    		break;
    		
    	case down:
    		/* Room Change Handlers */
    		if (this.roomNumber==2 && y==9) {
    			user.changeY(-9);
    			this.roomNumber = 3;
    		} else if (this.roomNumber==4 && y==9) {
    			user.changeY(-9);
    			this.roomNumber = 5;
    		}
    		
    		/* Collision Checks */
    		else if (mapwalk.detectEnemy(x, y+1) != null) {
    			System.out.println("That tile is occupied by an enemy!!!");
    			this.enemyPassiveAttack(user, mapwalk.detectEnemy(x-1, y));
    		} else if (mapwalk.detectTile(x, y+1) == "_")
    			user.playerMove(CardinalDirection.SOUTH);
    		else
    			System.out.println("Bump! Whoops, can't pass through walls yet.");
    		break;
    		
    	case pickup:
    		String p = mapwalk.detectItem(x, y);
    		if (p != null)
    		{
    			mapwalk.popCollectible(x, y);
    			user.pickUpItem(p);
    		}
    		else
    			System.out.println("There is no item to be picked up.");
    		break;
    		
    	case attack:
    		int v = 0;
    		for (int w=-1; w<2; w++) {
    			for (int z=-1; z<2; z++) {
    				Enemy a = mapwalk.detectEnemy(x+w, y+z);
    				if (a != null) {
    					mapwalk.detectEnemy(x+w, y+z).loseHealth(1);
    					if (mapwalk.detectEnemy(x+w, y+z).getHealth() == 0) {
    						System.out.println("You've killed an Enemy! " + "Yay!");
    						mapwalk.popEnemy(x+w, y+z);
    					} else {
    	     			System.out.println("The enemy now has " + mapwalk.detectEnemy(x+w, y+z).getHealth() + " health left!");
    					}
    					v++;
    				}
    			}
    		}
    		if (v == 0)
     			System.out.println("But there are no enemies nearby to attack?");
    		break;
    		
    	case help:
			/* prints out entire lists of commands */
    		System.out.println(	"To input a command: enter a letter key and press the return key. \n" +
    							"WASD tells the player to move up, left, down, right respectively.\n" +
    							"p tells the player to pick up a collectible. \n" +
    							"t tells the player to spin attack enemies in each adjacent tiles.\n" +
    							"h calls up this help command list again.");
    		break;
    		
    	case systemcheck:
			/* This action checks for win status */
    		if (mapwalk.enemiesRemaining()) {
    			System.out.println("There are still enemies nearby you in this room !!");
    		}
    		else if (mapwalk.collectiblesRemaining()) {
    			System.out.println("There are still collectibles on this room Map !");
    		}
    		else {
    			boolean unfinishedEnemies = false;
    			boolean unfinishedCollectibles = false;
    			for (Maps eachMap : this.getDungeon()) {
    				unfinishedEnemies |= eachMap.enemiesRemaining();
    				unfinishedCollectibles |= eachMap.collectiblesRemaining();
    			}
    			if (unfinishedEnemies)
    				System.out.println("Enemies are still roaming elsewhere in this dungeon.");
    			else if (unfinishedCollectibles)
    				System.out.println("You have yet to collect every treasure in this dungeon.");
    			else if(this.roomNumber == 3 && user.getX() == 5 && user.getY() == 8)
    				{
    					//End the game.
    					noMoreGame = true;
    				}
    			else
    				System.out.println("Find the position marked by 'W' on Map 3.");
    		}
    		break;
    	default:
    		System.out.println("You wasted a turn");
    		break;
    	}
    }
    
} 
