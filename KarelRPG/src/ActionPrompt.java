import java.util.Scanner;
import java.util.ArrayList;
  
enum CardinalDirection
{
	NORTH,EAST,SOUTH,WEST,NORTHEAST,SOUTHEAST,NORTHWEST,SOUTHWEST;
}
enum CommandType 
{ 
    left,up,right,down,pickup,attack,help; 
} 
  
// Driver class Action Prompt that reads and writes current command and 
// the entire game which runs in main(). 
public class ActionPrompt 
{ 
    private int timeStep;
	private CommandType currentCommand;
	private int roomNumber;
  
    // Constructor 
    public ActionPrompt(int timeStep, CommandType currentCommand, int roomNumber) 
    { 
        this.timeStep = timeStep;
        this.currentCommand = currentCommand;
        this.roomNumber = roomNumber;
    }
    
    public ActionPrompt(ActionPrompt a)
    {
    	this(a.timeStep, a.currentCommand, a.roomNumber);
    }
  
    //Prints a line about Day using switch 
    public void printWorld(String[][] thisWorld, Player player1, ArrayList<PhysicalCollectible> treasures) 
    { 
        for(int i=0;i<thisWorld.length; i++)
        {
        	for(int j=0;j<thisWorld[i].length; j++)
        	{
        		if (true)
        		{
        			
        		}
        	}
        }
    }
    
    public void takeCommand(Player user)
    {
    	switch (this.currentCommand)
    	{
    	case left:
    		user.playerMove(CardinalDirection.WEST);
    		break;
    	case right:
    		user.playerMove(CardinalDirection.EAST);
    		break;
    	case up:
    		user.playerMove(CardinalDirection.NORTH);
    		break;
    	case down:
    		user.playerMove(CardinalDirection.SOUTH);
    		break;
    	case pickup:
    		
    		break;
    	case attack:
    		break;
    	case help:
    		//prints out entire lists of commands
    		System.out.println(	"To input a command: enter a letter key and press the return key. /n" +
    							"WASD tells the player to move up, left, down, right respectively./n" +
    							"p tells the player to pick up a collectible. /n" +
    							"t tells the player to spin attack enemies in each adjacent tiles./n" +
    							"h calls up this help command list again.");
    		break;
    	}
    }
    
    public void writeCommand(String name)
    {
    	switch (name)
    	{
    	case "A":
    	case "a":
    		this.currentCommand = CommandType.left;
    		System.out.println("Moving Left");
    		break;
    	case "D":
    	case "d":
    		this.currentCommand = CommandType.right;
    		System.out.println("Moving Right");
    		break;
    	case "W":
    	case "w":
    		this.currentCommand = CommandType.up;
    		System.out.println("Moving Up");
    		break;
    	case "S":
    	case "s":
    		this.currentCommand = CommandType.down;
    		System.out.println("Moving Down");
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
    	default:
    		System.out.println("That was not a valid command, type h for the list of commands.");
    		break;
    	}
    }


  
    // Driver method 
    public static void main(String[] args) 
    {
    	//This is object-oriented code
        ActionPrompt game = new ActionPrompt(0,CommandType.help,0);
        
        //Create EndGame Object to flash title card.
        EndGame tony = new EndGame();
        tony.newGame();
        //At this point we are at the Title Screen.
        
        //Creating Collectible Objects
        Collectible q = new Collectible("Key", "object", 0);
		Collectible t = new Collectible("Star", "object", 0);
		Collectible s = new Collectible("Sun", "object", 0);

		//Initializing Player's Inventory(ArrayList) with the Collectible types.
		Player play = new Player(100, 5, 5);
		play.getInventory().add(q);
		play.getInventory().add(t);
		play.getInventory().add(s);
		
		
		//Creating the collectible Objects in the physical space of the maps.
		PhysicalCollectible Q1 = new PhysicalCollectible("Key",1,1);
		PhysicalCollectible Q2 = new PhysicalCollectible("Key",8,1);
		PhysicalCollectible Q3 = new PhysicalCollectible("Key",1,8);
		PhysicalCollectible Q4 = new PhysicalCollectible("Key",8,8);
		PhysicalCollectible Q5 = new PhysicalCollectible("Key",8,6);
		
		//Creating map with borders, walls, and empty spaces.
		Maps map0 = new Maps(0);
		//Initializing Map(Object)'s List of Collectibles(ArrayList) with
		//the PhysicalCollectible objects created above.
		map0.getListOfCollectibles().add(Q1);
		map0.getListOfCollectibles().add(Q2);
		map0.getListOfCollectibles().add(Q3);
		map0.getListOfCollectibles().add(Q4);
		map0.getListOfCollectibles().add(Q5);
		
		/*Create enemies
		 * Enemy bob = new Enemy(2, 3, 5);
		 * Enemy blob = new Enemy(5, 1,3);
		 */
		
		/*
		 * We are still in the title screen, so let the user enter game play.
		 * Declare the object and initialize with predefined standard input object
		 */
		Scanner scanner = new Scanner(System.in);
	    String readString = scanner.nextLine();
	    while(readString!=null) {
//	        System.out.println(readString);
	        if (readString.isEmpty())
	        {
	            System.out.println("Starting Game...");
	            scanner.close();
	            game.takeCommand(play);
	            tony.goInTheGame();
	            break;
	        }
	    }
		
		//Entering actual game play, run a loop for every timestep.
		while(!tony.isGameOver())
		{		
			//Prints World.
			game.printWorld(map0.getLayoutOfCurrentRoom(),play,map0.getListOfCollectibles());
			
			//Read command from input stream.
			Scanner key = new Scanner(System.in);
			String name = key.nextLine();
			game.writeCommand(name);
			game.takeCommand(play);
			key.close();
			game.timeStep++;
		}
    }
} 
