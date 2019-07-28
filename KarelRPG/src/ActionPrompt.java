import java.util.Scanner;
import java.util.ArrayList;
  
enum CardinalDirection
{
	NORTH,EAST,SOUTH,WEST,NORTHEAST,SOUTHEAST,NORTHWEST,SOUTHWEST;
}

enum CommandType 
{ 
    left,up,right,down,pickup,attack,help,no,wincheck; 
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
	public int getroomNumber() {
		return roomNumber;
	}
	public int changeTimeStep() {
		return timeStep++;
	}
	public int getTimeStep() {
		return timeStep;
	}
	public boolean getNoMoreGame() {
		return noMoreGame;
	}
    public void printWorld(String[][] thisWorld, Player player1, Maps mapview)
    { 
        for(int j=0;j<thisWorld.length; j++)
        {
        	for(int i=0;i<thisWorld[j].length; i++)
        	{
        		if (i==player1.getX() && j==player1.getY())
        		{
        			System.out.print("U");
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
        				if(mapview.detectEnemy(i, j) != null)
        				{
        					String e = "";
        					switch (mapview.detectEnemy(i, j).getType())
        					{
        					case robot:
        						e = "E";
        					default:
        						break;
        					}
        					System.out.print(e);
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
	 * This method executes a specific command based on ActionPrompt(this class), Player, and Maps classes,
	 * when called.
	 *
	 * @Param user
	 * @Param mapwalk
	 * 
	 */
    public void takeCommand(Player user, Maps mapwalk)
    {
    	int x = user.getX();
		int y = user.getY();
    	switch (this.currentCommand)
    	{
    	case left:
    		if (mapwalk.detectEnemy(x-1, y) != null)
    			System.out.println("That tile is occupied by an enemy!!!");
    		else if (mapwalk.detectTile(x-1, y) == "_")
    			user.playerMove(CardinalDirection.WEST);
    		else
    			System.out.println("Bump! Whoops, can't pass through walls yet.");
    		break;
    		
    	case right:
    		if (mapwalk.detectEnemy(x+1, y) != null)
    			System.out.println("That tile is occupied by an enemy!!!");
    		else if (mapwalk.detectTile(x+1, y) == "_")
    			user.playerMove(CardinalDirection.EAST);
    		else
    			System.out.println("Bump! Whoops, can't pass through walls yet.");
    		break;
    		
    	case up:
    		if (mapwalk.detectEnemy(x, y-1) != null)
    			System.out.println("That tile is occupied by an enemy!!!");
    		else if (mapwalk.detectTile(x, y-1) == "_")
    			user.playerMove(CardinalDirection.NORTH);
    		else
    			System.out.println("Bump! Whoops, can't pass through walls yet.");
    		break;
    		
    	case down:
    		if (mapwalk.detectEnemy(x, y+1) != null)
    			System.out.println("That tile is occupied by an enemy!!!");
    		else if (mapwalk.detectTile(x, y+1) == "_")
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
    		
    	case wincheck:
			/* This action checks for win status */
    		if (mapwalk.areWeDoneYet()) {
    			if(user.getX() == 5 && user.getY() == 5) {
    				//End the game.
    				noMoreGame = true;
    			}
    			else {
    				System.out.println("Remember to return to the starting position to exit dungeon.");
    			}
    		}
    		break;
    		
    	default:
    		System.out.println("You wasted a turn");
    		break;
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
    		this.currentCommand = CommandType.wincheck;
    		break;
    		
    	default:
    		this.currentCommand = CommandType.no;
    		System.out.println("That was not a valid command, type h for the list of commands.");
    		break;
    	}
    }
} 
