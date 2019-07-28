import java.util.Scanner;

public class VariableClass {
	public int roomNumber;
	Player play = new Player(100,5,5);
    EndGame tony = new EndGame();
    Collectible q = new Collectible("Key", "object", 0);
 	Collectible t = new Collectible("Star", "object", 0);
 	Collectible s = new Collectible("Sun", "object", 0);
 	Collectible sword = new Collectible("sword", "weapon", 0);
    ActionPrompt game = new ActionPrompt(0, CommandType.help, 1); 
	
    Maps map0 = new Maps(game.getroomNumber());
   
    public VariableClass() {
    }
    


 	public void start() {
 		play.getInventory().add(q);
 		play.getInventory().add(t);
 		play.getInventory().add(s);
 		play.getInventory().add(sword);
 		PhysicalCollectible Q1 = new PhysicalCollectible("Key",1,1);
		PhysicalCollectible Q2 = new PhysicalCollectible("Key",8,1);
		PhysicalCollectible Q3 = new PhysicalCollectible("Key",1,8);
		PhysicalCollectible Q4 = new PhysicalCollectible("Key",8,8);
		PhysicalCollectible Q5 = new PhysicalCollectible("Sun",8,6);
		map0.getListOfCollectibles().add(Q1);
		map0.getListOfCollectibles().add(Q2);
		map0.getListOfCollectibles().add(Q3);
		map0.getListOfCollectibles().add(Q4);
		map0.getListOfCollectibles().add(Q5);
		Enemy bob = new Enemy(2, 3, 5, EnemyType.robot);
		Enemy blob = new Enemy(5, 1,3, EnemyType.robot);
		Enemy mega = new Enemy(10, 4,1,EnemyType.robot);
		map0.getEnemyList().add(bob);
		map0.getEnemyList().add(blob);
		map0.getEnemyList().add(mega);
        tony.newGame(); 
    	
		
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
	            game.takeCommand(play,map0);
	            
				/* Prints 0th timestep and all initial variables.*/
	            System.out.println(0);			
	            System.out.println("Inventory :  " + play.getInventory().toString());
	            System.out.println("WANTED-->\t" + map0.getEnemyList().toString());
	            tony.goInTheGame();
	            break;
	        }
	        readString = com.nextLine();
	        
		} while(readString!=null);
        
    	
        while(!tony.isGameOver())
    		{		
    			game.printWorld(map0.getLayoutOfCurrentRoom(),play,map0);
    			System.out.println("\n\n\n\n\n");
    			/* Read command from input stream. */
    			while(true){
    				if(com.hasNextLine()) {
    				String name = com.nextLine();
    				game.writeCommand(name);
    				game.takeCommand(play,map0);
    				if (game.getNoMoreGame()) {
    					tony.finishTheGame();
    				}
    				break;
    				}
    			}
    			game.changeTimeStep();
    			System.out.println(game.getTimeStep());	//Prints nth timestep.
    			System.out.println("Inventory:\t" + play.getInventory().toString());
    			System.out.println("WANTED-->\t" + map0.getEnemyList().toString());
    		}
    		com.close();
        }
 	
 	
 	
 	public static void main (String[] args){
 		VariableClass game = new VariableClass();
 		game.start();
 		game.play();
 	}
 }

