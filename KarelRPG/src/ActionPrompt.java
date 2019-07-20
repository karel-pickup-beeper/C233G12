import java.util.Scanner; 
  
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
  
    // Prints a line about Day using switch 
    public void printWorld() 
    { 
        //Some Really Complicated Stuff Goes here.
    }
    
    public void takeCommand()
    {
    	//do stuff
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
    		//prints out entire lists of commands
    		System.out.println("");
    		break;
    	default:
    		System.out.println("That was not a valid command, type h for the list of commands.");
    		break;
    	}
    }

    public int getRoomNumber()
    {
    	return this.roomNumber;
    }
  
    // Driver method 
    public static void main(String[] args) 
    {
    	//This is object-oriented code
        ActionPrompt game = new ActionPrompt(0,CommandType.help,0);
        
        Collectible q = new Collectible("Key", "object", 0);
		Collectible n = new Collectible("Star", "object", 0);
		Collectible k = new Collectible("Sun", "object", 0);

		//Initializing Collectibles in Player Inventory.
		Player play = new Player(100, 5,6);
		play.getInventory().add(q);
		play.getInventory().add(n);
		play.getInventory().add(k);
		
     // Declare the object and initialize with 
        // predefined standard input object 
    	Scanner key = new Scanner(System.in);
    	
    	//String input
    	String name = key.nextLine();
    	
    	game.writeCommand(name);
        game.takeCommand();
        key.close();
    }
    
} 
