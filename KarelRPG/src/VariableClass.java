import java.util.Scanner;

public class VariableClass {
    ActionPrompt game = new ActionPrompt(0, CommandType.help, 1);
	
	/* Create EndGame Object to flash title card. */
    EndGame tony = new EndGame();
    /* At this point we are at the Title Screen. */
    
    /* Creating Collectible Objects */
    Collectible q = new Collectible("Key", "object", 0);
 	Collectible t = new Collectible("Star", "object", 0);
 	Collectible s = new Collectible("Sun", "object", 0);
 	Collectible sword = new Collectible("sword", "weapon", 0);
 	
 	/* Initializing Player's Inventory(ArrayList) with the Collectible types. */
 	Player play = new Player(100,5,5);
 	
 	/* Creating the collectible Objects in the physical space of the maps. */
 	PhysicalCollectible Q1 = new PhysicalCollectible("Key",1,1);
	PhysicalCollectible Q2 = new PhysicalCollectible("Key",8,1);
	PhysicalCollectible Q3 = new PhysicalCollectible("Key",1,8);
	PhysicalCollectible Q4 = new PhysicalCollectible("Key",8,8);
	PhysicalCollectible Q5 = new PhysicalCollectible("Sun",8,6);
	
	/* Creating map with borders, walls, and empty spaces. */
	Maps map0 = new Maps(0);
	Maps map1 = new Maps(1);
	Maps map2 = new Maps(2);
	Maps map3 = new Maps(3);
	Maps map4 = new Maps(4);
	Maps map5 = new Maps(5);
	
	/* Create enemies */
	Enemy bob = new Enemy(2, 3, 5, EnemyType.robot);
	Enemy blob = new Enemy(5, 1,3, EnemyType.robot);
	Enemy mega = new Enemy(10, 4, 1, EnemyType.robot);
   
    public VariableClass() {
    }
    


 	public void start() {
 		/* Create EndGame Object to flash title card. */
        tony.newGame();
        
        /* Initializing Player's Inventory(ArrayList) with the Collectible types. */
 		play.setInventory(q);
 		play.setInventory(t);
 		play.setInventory(s);
 		play.setInventory(sword);
 		
 		/*
		 * Initializing Map(Object)'s List of Collectibles(ArrayList) with the
		 * PhysicalCollectible objects created above.
		 */
		map1.setMapCollectibles(Q1);
		map1.setMapCollectibles(Q2);
		map1.setMapCollectibles(Q3);
		map1.setMapCollectibles(Q4);
		map1.setMapCollectibles(Q5);
		
		
		/*
		 * Initializing Map(Object)'s enemy list(ArrayList) with the enemyList objects
		 * created above.
		 */
		map1.setMapEnemies(bob);
		map1.setMapEnemies(blob);
		map1.setMapEnemies(mega);
		
 	}
	public void play() {
 		Scanner com = new Scanner(System.in);
		String readString = com.nextLine();
		do {
			System.out.println(readString);
	        if (readString.isEmpty())
	        {
				/* Printing the list of commands in the beginning. */
	            System.out.println("Starting Game...");
	            game.takeCommand(play,map1
	            		);
	            
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
			if(com.hasNextLine())
			{
			String name = com.nextLine();
			game.writeCommand(name);
			game.takeCommand(play,map1);
			if (game.getNoMoreGame()) {
				tony.finishTheGame();
				}
			}
			
			game.changeTimeStep();
			System.out.println(game.getTimeStep());	//Prints nth timestep.
			System.out.println("Inventory:\t" + play.getInventory().toString());
			System.out.println("WANTED-->\t" + map1.getEnemyList().toString());
		}
		com.close();
    }
	
/*	
    public static void main(String[] args) {
    	VariableClass game = new VariableClass();
    	game.start();
    	game.play();
    	
    	
    }*/

 	
 }

