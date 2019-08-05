package com.karelRPG.gameplay;
import java.util.Scanner;

public class VariableClass {
	
    ActionPrompt game = new ActionPrompt(0, CommandType.help, 1);
	
	/* Create EndGame Object to flash title card. */
    EndGame tony = new EndGame();
    
 	/* Initializing Player's Inventory(ArrayList) with the Collectible types. */
 	Player play = new Player(100,5,5);
   
 	public void start() {
 		/* Create EndGame Object to flash title card. */
        tony.newGame();
        /* At this point we are at the Title Screen. */
        
        /* Initializing Player's Inventory(ArrayList) with recently created Collectible objects of all possible types. */
 		play.setInventory(new Collectible("Key", "object", 0));
 		play.setInventory(new Collectible("Star", "object", 0));
 		play.setInventory(new Collectible("Sun", "object", 0));
 		play.setInventory(new Collectible("sword", "weapon", 0));
 		
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
		game.initialiseMap(3, new PhysicalCollectible("Sun" ,3,1));
		game.initialiseMap(3, new PhysicalCollectible("Sun" ,8,0));
		/* Map 4 */
		game.initialiseMap(4, new PhysicalCollectible("Sun" ,4,8));
		game.initialiseMap(4, new PhysicalCollectible("Sun" ,8,6));
		/* Map 5 */
		game.initialiseMap(5, new PhysicalCollectible("Sun" ,1,4));
		/*
		 * Initializing Map(Object)'s enemylist(ArrayList) with recently created Enemy objects.
		 */
		/* Map 1 */
		game.initialiseMap(1, new Enemy(2, 3, 5, EnemyType.CACTUS));
		game.initialiseMap(1, new Enemy(2, 1, 3, EnemyType.CACTUS));
		game.initialiseMap(1, new Enemy(3, 4, 1, EnemyType.CACTUS));
		game.initialiseMap(1, new Enemy(5, 4, 1, EnemyType.CACTUS));
		/* Map 2 */
		game.initialiseMap(2, new Enemy(2, 2, 4, EnemyType.CACTUS));
		game.initialiseMap(2, new Enemy(4, 2, 1, EnemyType.CACTUS));
		game.initialiseMap(2, new Enemy(4, 5, 6, EnemyType.CACTUS));
		/* Map 3 */
		game.initialiseMap(3, new Enemy(5, 4, 1, EnemyType.CACTUS));
		game.initialiseMap(3, new Enemy(4, 3, 2, EnemyType.CACTUS));
		game.initialiseMap(3, new Enemy(15, 3, 8, EnemyType.CACTUS));
		/* Map 4 */
		game.initialiseMap(4, new Enemy(1, 1, 8, EnemyType.CACTUS));
		game.initialiseMap(4, new Enemy(1, 2, 8, EnemyType.CACTUS));
		game.initialiseMap(4, new Enemy(1, 3, 8, EnemyType.CACTUS));
		game.initialiseMap(4, new Enemy(6, 8, 7, EnemyType.CACTUS));
		/* Map 5 */
		game.initialiseMap(5, new Enemy(5, 6, 1, EnemyType.CACTUS));
		game.initialiseMap(5, new Enemy(5, 8, 2, EnemyType.CACTUS));
		game.initialiseMap(5, new Enemy(5, 6, 3, EnemyType.CACTUS));
		game.initialiseMap(5, new Enemy(5, 8, 4, EnemyType.CACTUS));
		game.initialiseMap(5, new Enemy(5, 7, 5, EnemyType.CACTUS));
		game.initialiseMap(5, new Enemy(10, 8, 6, EnemyType.CACTUS));
		
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
	            System.out.println("Inventory :  " + play.getInventory().toString());
	            System.out.println("WANTED-->\t" + game.getCurrentRoomMap().getEnemyList().toString());
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
			if (game.getNoMoreGame()) {
				tony.finishTheGame();
				}
			}
			
			game.changeTimeStep();
			System.out.println(game.getTimeStep());	//Prints nth timestep.
			System.out.println("Inventory:\t" + play.getInventory().toString());
			System.out.println("WANTED-->\t" + game.getCurrentRoomMap().getEnemyList().toString());
		}
		com.close();
    }
	

    public static void main(String[] args) {
    	VariableClass game = new VariableClass();
    	game.start();
    	game.play();
    	
    	
    }

 	
 }

