package com.karelRPG.gameplay;
import java.util.ArrayList;
  
enum CardinalDirection
{
	NORTH,EAST,SOUTH,WEST,NORTHEAST,SOUTHEAST,NORTHWEST,SOUTHWEST, STOP;
}

enum CommandType 
{ 
    left,up,right,down,pickup,use,help,no,systemcheck; 
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
	private int roomNumber = 1;
	private boolean noMoreGame;
	private ArrayList<Maps> dungeon = new ArrayList<Maps>();
	private ItemSelection itemSelected = ItemSelection.normalsword;
	private boolean doEnemiesRun = false;
	private int countdown = 0;
  
	/* Constructor */
	public ActionPrompt(int timeStep, CommandType currentCommand) 
    	{ 
        	this.timeStep = timeStep;
        	this.currentCommand = currentCommand;
    	}

	/* Copy Constructor */
	public ActionPrompt(ActionPrompt a)
	{
    		this(a.timeStep, a.currentCommand);
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
	public String getCommandType() {
		return currentCommand.toString();
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
            				case "Potion":
            					s = "@";
            					break;
            				case "NormalSword":
            					s = "s";
            					break;
            				case "BigSword":
            					s = "S";
            					break;
            				case "WhackSword":
            					s = "~";
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
    	switch (name.toUpperCase())
    	{
    	case "A":
    		this.currentCommand = CommandType.left;
    		System.out.println("Moved Left");
    		break;
    		
    	case "D":
    		this.currentCommand = CommandType.right;
    		System.out.println("Moved Right");
    		break;
    		
    	case "W":
    		this.currentCommand = CommandType.up;
    		System.out.println("Moved Up");
    		break;
    		
    	case "S":
    		this.currentCommand = CommandType.down;
    		System.out.println("Moved Down");
    		break;
    		
    	case "P":
    		this.currentCommand = CommandType.pickup;
    		System.out.println("Picking Up the Item");
    		break;
    		//These cases should never be run by GUI implicitly, GUI must have a separate command that changes ItemSelection without taking a turn!!!!
						    	case "0":
						    		this.itemSelected = ItemSelection.normalsword;
						    		System.out.println("You have unequipped all special equipment.");
						    		this.currentCommand = CommandType.no;
						    		break;
						    	case "1":
						    		this.itemSelected = ItemSelection.potion;
						    		System.out.println("You have equipped potion.");
						    		this.currentCommand = CommandType.no;
						    		break;
						    	case "2":
						    		this.itemSelected = ItemSelection.bigsword;
						    		System.out.println("You have equipped bigsword.");
						    		this.currentCommand = CommandType.no;
						    		break;
						    	case "3":
						    		this.itemSelected = ItemSelection.whacksword;
						    		System.out.println("You have equipped whacksword.");
						    		this.currentCommand = CommandType.no;
						    		break;
						    	case "4":
						    		this.itemSelected = ItemSelection.repel;
						    		System.out.println("You are prepared to use star.");
						    		this.currentCommand = CommandType.no;
						    		break;
    		//End of equipping cases!!!!
    	case "U":
    		this.currentCommand = CommandType.use;
    		if (this.itemSelected != ItemSelection.potion)
    			System.out.println("ATTACK!");
    		break;
    	case "H":
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
    	if (this.countdown>0) {
    		this.countdown--;
    	} else {
    		this.doEnemiesRun = false;
    	}
    	dungeon.get(this.roomNumber).doAllEnemyActions(user, doEnemiesRun);
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
			monster.loseHealth(-monster.getAttack()/6);
			break;
			
		case "Ghost":
			System.out.print("The ghost took a bit of your soul as you charged into it. ");
			user.changeHealth(-monster.getAttack());
			monster.loseHealth(-monster.getAttack()/5);
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
		user.changeEquip(this.itemSelected);
		
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
    		System.out.println(this.currentCommand.toString());

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
    			this.enemyPassiveAttack(user, mapwalk.detectEnemy(x, y+1));
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
    		
    	case use:
    		if (this.itemSelected == ItemSelection.repel) {
    			if (user.countSingleItem("Star") > 0) {
    				user.useUpItem("Star");
    				this.countdown = 6;
    				this.doEnemiesRun = true;
    			} else {
    				System.out.print("You don't have any stars to use. ");
    			}
    		} else if (this.itemSelected == ItemSelection.potion) {
    			if (user.countSingleItem("Potion") > 0) {
    				user.useUpItem("Potion");
    				user.changeHealth(15);
    			} else {
    				System.out.print("You've got no potions to use. ");
    			}
    		} else {
    			int v = 0;
    			for (int w=-1; w<2; w++) {
    				for (int z=-1; z<2; z++) {
    					Enemy a = mapwalk.detectEnemy(x+w, y+z);
    					if (a != null) {
    						if (this.itemSelected == ItemSelection.normalsword) {
    							a.loseHealth(1);
    						} else if (this.itemSelected == ItemSelection.bigsword) {
    							a.loseHealth(2);
    						} else if (this.itemSelected == ItemSelection.whacksword) {
    							a.loseHealth(1);
    							int xDistance = a.getXloc()-user.getX();
    							int yDistance = a.getYloc()-user.getY();
    							CardinalDirection tempAim = CardinalDirection.STOP;
    							if (xDistance > 0) {
    								tempAim = CardinalDirection.EAST;
    							} else if (xDistance < 0) {
    								tempAim = CardinalDirection.WEST;
    							}
    							if (yDistance > 0) {
    								if (tempAim == CardinalDirection.EAST)
    									tempAim = CardinalDirection.SOUTHEAST;
    								else if (tempAim == CardinalDirection.WEST)
    									tempAim = CardinalDirection.SOUTHWEST;
    								else
    									tempAim = CardinalDirection.SOUTH;
    							} else if (yDistance < 0) {
    								if (tempAim == CardinalDirection.EAST)
    									tempAim = CardinalDirection.NORTHEAST;
    								else if (tempAim == CardinalDirection.WEST)
    									tempAim = CardinalDirection.NORTHWEST;
    								else
    									tempAim = CardinalDirection.NORTH;
    							}
    							a.enemyKnockBack(tempAim, mapwalk);
    						}
    						if (a.getHealth() == 0) {
    							System.out.println("You've killed an Enemy! " + "Yay!");
    							mapwalk.popEnemy(a);
    						} else {
    							System.out.println("The enemy now has " + a.getHealth() + " health left!");
    						}
    						v++;
    					}
    				}
    			}
    			if (v == 0)
         			System.out.println("But there are no enemies nearby to attack?");
    		}
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
    			else 
    				System.out.println("You have completed conquering this dungeon. Now Find the position marked by 'W' on Map 3.");
    		}
    		if(this.roomNumber == 3 && user.getX() == 5 && user.getY() == 8)
			{
				if (user.haveAllKeys()) {
					//End the game.
					noMoreGame = true;
				} else {
					System.out.println("You have to at least collect all "+7+" keys to win.");
				}
			}
    		break;
    	case no:
    		System.out.println("Command_Type = no");
    		break;
    	default:
    		System.out.println("You wasted a turn");
    		break;
    	}
    }
    
} 
