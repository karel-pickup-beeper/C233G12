package com.karelRPG.gameplay;
import java.util.Scanner;

public class VariableClass {
	
    public ActionPrompt game = new ActionPrompt(0, CommandType.help);
	
	/* Create EndGame Object to flash title card. */
    public EndGame tony = new EndGame();
    
 	/* Initializing Player's Inventory(ArrayList) with the Collectible types. */
 	public Player play = new Player(100,5,5);
   
 	public void start() {
 		/* Create EndGame Object to flash title card. */
 		tony.newGame();
        /* At this point we are at the Title Screen. */
        
        /* Initializing Player's Inventory(ArrayList) with recently created Collectible objects of all possible types. */
 		play.setInventory(new Collectible("Key", "object", 5));
 		play.setInventory(new Collectible("Star", "object", 5));
 		play.setInventory(new Collectible("Potion", "object", 5));
 		play.setInventory(new Collectible("BigSword", "weapon", 0));
 		play.setInventory(new Collectible("WhackSword", "weapon", 0));
 		
 		/* Creating map with borders, walls, and empty spaces. And indexing them in the ArrayList 'dungeon' in ActionPrompt. */
 		game.indexDungeon(new Maps(0));
 		game.indexDungeon(new Maps(1));
 		game.indexDungeon(new Maps(2));
 		game.indexDungeon(new Maps(3));
 		game.indexDungeon(new Maps(4));
 		game.indexDungeon(new Maps(5));
 		
 		/* Using Polymorphism to differentiate methods by their parameter's object type. */
 		
 		/*
		 * Initializing Map(Object)'s List of Collectibles(ArrayList) with recently created PhysicalCollectible objects.
		 */
 		/* Map 1 */
		game.initialiseMap(1, new PhysicalCollectible("Key",1,1));
		game.initialiseMap(1, new PhysicalCollectible("Key",8,1));
		game.initialiseMap(1, new PhysicalCollectible("Key",1,8));
		game.initialiseMap(1, new PhysicalCollectible("Key",8,8));
		game.initialiseMap(1, new PhysicalCollectible("Key",8,6));
		/* Map 2 */
		game.initialiseMap(2, new PhysicalCollectible("Star",3,6));
		game.initialiseMap(2, new PhysicalCollectible("Star",3,4));
		game.initialiseMap(2, new PhysicalCollectible("Star",3,2));
		game.initialiseMap(2, new PhysicalCollectible("Star",8,1));
		game.initialiseMap(2, new PhysicalCollectible("Star",8,6));
		game.initialiseMap(2, new PhysicalCollectible("Key" ,5,1));
		game.initialiseMap(2, new PhysicalCollectible("Key" ,6,8));
		/* Map 3 */
		game.initialiseMap(3, new PhysicalCollectible("Potion" ,3,1));
		game.initialiseMap(3, new PhysicalCollectible("Potion" ,8,0));
		/* Map 4 */
		game.initialiseMap(4, new PhysicalCollectible("Potion" ,4,8));
		game.initialiseMap(4, new PhysicalCollectible("Potion" ,8,6));
		/* Map 5 */
		game.initialiseMap(5, new PhysicalCollectible("Potion" ,1,4));
		/*
		 * Initializing Map(Object)'s enemylist(ArrayList) with recently created Enemy objects.
		 */
		/* Map 1 */
		game.initialiseMap(1, new Robot(5, 3, 5, 3, true));
		game.initialiseMap(1, new Robot(5, 1, 3, 2, true));
		game.initialiseMap(1, new Cactus(3, 4, 1, 5, true));
		/* Map 2 */
		game.initialiseMap(2, new Robot(2, 2, 4, 3, false));
		game.initialiseMap(2, new Robot(4, 2, 1, 3, false));
		game.initialiseMap(2, new Zombie(4, 5, 6, 3));
		/* Map 3 */
		game.initialiseMap(3, new Zombie(5, 4, 1, 1));
		game.initialiseMap(3, new Zombie(4, 3, 2, 1));
		game.initialiseMap(3, new Cactus(15, 3, 8, 6, false));
		game.initialiseMap(3, new Ghost(2, 1, 8, 2));
		/* Map 4 */
		game.initialiseMap(4, new Ghost(1, 1, 8, 4));
		game.initialiseMap(4, new Ghost(1, 2, 8, 3));
		game.initialiseMap(4, new Ghost(1, 3, 8, 2));
		game.initialiseMap(4, new Zombie(6, 8, 7, 6));
		/* Map 5 */
		game.initialiseMap(5, new Robot(5, 6, 1, 2, false));
		game.initialiseMap(5, new Robot(5, 8, 2, 3, false));
		game.initialiseMap(5, new Robot(5, 6, 3, 3, false));
		game.initialiseMap(5, new Zombie(6, 8, 4, 6));
		game.initialiseMap(5, new Zombie(7, 7, 5, 6));
		game.initialiseMap(5, new Cactus(10, 8, 6, 6, false));
		
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
	            game.takeCommand(play);
	            
				/* Prints 0th timestep and all initial variables.*/
	            System.out.println(0);
	            System.out.print("Health "+play.getHealth()+ "  ");
	            System.out.println("Inventory :  " + play.getInventoryString());
	            System.out.println("WANTED-->\t" + game.getCurrentRoomMap().getEnemyListString());
	            tony.goInTheGame();
	            break;
	        }
	        readString = com.nextLine();
		} while(readString!=null);
		
		/* Entering actual game play, run a loop for every time-step. */
		while(!tony.isGameOver())
		{		
			/* Prints World and spaces with empty lines after it. */
			game.printWorld(play);
			System.out.println("\n\n\n\n\n");
			
			/* Read command from input stream. */
			if(com.hasNextLine())
			{
			String name = com.nextLine();
			game.writeCommand(name);
			game.takeCommand(play);
			game.runEnemiesTurn(play);
			if (play.getHealth()==0) {
				tony.playerDied();
			}
			if (game.getNoMoreGame()) {
				tony.finishTheGame();
				}
			}
			
			game.changeTimeStep();
			System.out.println(game.getTimeStep());	//Prints nth timestep.
            System.out.print("Health "+play.getHealth()+ "  ");
			System.out.println("Inventory:\t" + play.getInventoryString());
			System.out.println("WANTED-->\t" + game.getCurrentRoomMap().getEnemyListString());
		}
		com.close();
    }
	

   public static void main(String[] args) {
    	VariableClass game = new VariableClass();
    	game.start();
    	game.play();
    	
    	
    }

 	
 }

