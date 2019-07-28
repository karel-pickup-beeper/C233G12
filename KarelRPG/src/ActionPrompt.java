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
    
    
    
    //Feifei's changes 
	/*
	 * Driver method
	 */
    public static void main(String[] args) 
    {
		/* This is object-oriented code */
        ActionPrompt game = new ActionPrompt(0,CommandType.help,1); 
        
		/* Create EndGame Object to flash title card. */
        EndGame tony = new EndGame();
        tony.newGame();
		/* At this point we are at the Title Screen. */
        
		/* Creating Collectible Objects */
        Collectible q = new Collectible("Key", "object", 0);
		Collectible t = new Collectible("Star", "object", 0);
		Collectible s = new Collectible("Sun", "object", 0);

		/* Initializing Player's Inventory(ArrayList) with the Collectible types. */
		Player play = new Player(100, 5, 5);
		play.getInventory().add(q);
		play.getInventory().add(t);
		play.getInventory().add(s);
		
		
		/* Creating the collectible Objects in the physical space of the maps. */
		PhysicalCollectible Q1 = new PhysicalCollectible("Key",1,1);
		PhysicalCollectible Q2 = new PhysicalCollectible("Key",8,1);
		PhysicalCollectible Q3 = new PhysicalCollectible("Key",1,8);
		PhysicalCollectible Q4 = new PhysicalCollectible("Key",8,8);
		PhysicalCollectible Q5 = new PhysicalCollectible("Key",8,6);
		
		/* Creating map with borders, walls, and empty spaces. */
		Maps map1 = new Maps(1);
		Maps map2 = new Maps(2);
		Maps map3 = new Maps(3);
		Maps map4 = new Maps(4);
		Maps map5 = new Maps(5);
		
		/*
		 * Initializing Map(Object)'s List of Collectibles(ArrayList) with the
		 * PhysicalCollectible objects created above.
		 */
		map1.getListOfCollectibles().add(Q1);
		map1.getListOfCollectibles().add(Q2);
		map1.getListOfCollectibles().add(Q3);
		map1.getListOfCollectibles().add(Q4);
		map1.getListOfCollectibles().add(Q5);
		
		
		/* Create enemies */
		Enemy bob = new Enemy(2, 3, 5, EnemyType.robot);
		Enemy blob = new Enemy(5, 1,3, EnemyType.robot);
		Enemy mega = new Enemy(10, 4,1,EnemyType.robot);

		/*
		 * Initializing Map(Object)'s enemy list(ArrayList) with the enemyList objects
		 * created above.
		 */
		map1.getEnemyList().add(bob);
		map1.getEnemyList().add(blob);
		map1.getEnemyList().add(mega);
		
		/*
		 * We are still in the title screen, so let the user enter game play.
		 * Declare the object and initialize with predefined standard input object
		 */
		Scanner com = new Scanner(System.in);
		String readString = com.nextLine();
		do {
			System.out.println(readString);
	        if (readString.isEmpty())
	        {
				/* Printing the list of commands in the beginning. */
	            System.out.println("Starting Game...");
	            game.takeCommand(play,map1);
	            
				/* Prints 0th timestep and all initial variables.*/
	            System.out.println(0);			
	            System.out.println("Inventory :  " + play.getInventory().toString());
	            System.out.println("WANTED-->\t" + map1.getEnemyList().toString());
	            tony.goInTheGame();
	            break;
	        }
	        readString = com.nextLine();
		} while(readString!=null);
		
		/* Entering actual game play, run a loop for every time-step. */
		while(!tony.isGameOver())
		{		
			/* Prints World and spaces with empty lines after it. */
			game.printWorld(map1.getLayoutOfCurrentRoom(),play,map1);
			System.out.println("\n\n\n\n\n");
			
			/* Read command from input stream. */
			while(true){
				if(com.hasNextLine()) {
				String name = com.nextLine();
				game.writeCommand(name);
				game.takeCommand(play,map1);
				if (game.noMoreGame == true) {
					tony.finishTheGame();
				}
				break;
				}
			}
			
			game.timeStep++;
			System.out.println(game.timeStep);	//Prints nth timestep.
			System.out.println("Inventory:\t" + play.getInventory().toString());
			System.out.println("WANTED-->\t" + map1.getEnemyList().toString());
		}
		com.close();
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
