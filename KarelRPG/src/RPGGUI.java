import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RPGGUI extends Application {
	Button button1, button2;
	Stage primaryStage;
	Scene Openscene, GameStart;
	private VariableClass variable = new VariableClass();
	private int lengthOfStage=900;
	private int widthOfStage=900;
	private int drawXCoord=0;
	private int drawYCoord=0;
	private PlayerPiece piece = new PlayerPiece(1,1);
	private EnemyPiece1 blob = new EnemyPiece1();
	private boolean gameOver;
	private EnemyPiece2 bob = new EnemyPiece2();
	private EnemyPiece3 mega = new EnemyPiece3();
	private CollectiblePiece Q1 = new CollectiblePiece();

	
	//starting screen	
	public void start(Stage primaryStage) throws Exception {
		variable.start();
		Group root=new Group();
		BorderPane layout = new BorderPane();//the layout is basically a root
		Openscene = new Scene (layout, widthOfStage, lengthOfStage);
		primaryStage.setScene(Openscene);
		
		//setting start game button
		button1= new Button();
		button1.setMinSize(300, 100); 
		button1.setStyle("-fx-background-color:white");
		button1.setStyle("-fx-border-color:black");
		

		button1.setText("Start Game");
		//set button with text
		primaryStage.setTitle("Karel RPG"); //the title of the window
		//setting start title
		Text Title = new Text("Karel RPG");
		Title.setFont(Font.font(40));
	
		
		//set up layout
		layout.setTop(Title); 
		root.getChildren().add(button1);
		layout.setCenter(root);		
		
		//the new scene starts now, also where the game will begin
		
		//drawing the map depending on map file
		Canvas canvas = new Canvas(500,500);
		canvas.setVisible(true);
		
		GraphicsContext context = canvas.getGraphicsContext2D();
		String[][] n = variable.map1.getLayoutOfCurrentRoom();
		Image grass = new Image ("res/Grass.png");
		Image rock = new Image ("res/Rock.png");
		context.drawImage(rock, 0,50);
		for (String[] y:variable.map1.getLayoutOfCurrentRoom()) { 
			drawXCoord=0; 
			for (String x:y) {
				if (x.equals("X")) { 
					context.drawImage(rock, drawXCoord,drawYCoord); 
				}else if (x.equals("x")) {
					context.drawImage(rock, drawXCoord,drawYCoord); 				
					}else {
					context.drawImage(grass, drawXCoord,drawYCoord); 
				}
				drawXCoord+=50; 
				}
			drawYCoord+=50;

		}
		
		BorderPane paneroot = new BorderPane();
		Group main = new Group();
		main.getChildren().addAll(canvas, Q1,piece, blob, bob,mega);
		
		
		paneroot.setCenter(main);
		//Creating the bottom inventory
		//tool bar
		ToolBar toolbar = new ToolBar();
		Button slot1 = new Button();
		slot1.setMinSize(80, 80); 
		toolbar.getItems().add(slot1);

		Button slot2 = new Button("Weapon");
		slot2.setMinSize(80, 80); 
		toolbar.getItems().add(slot2);

		Button slot3 = new Button("Items");
		slot3.setMinSize(80, 80); 
		toolbar.getItems().add(slot3);
							
		paneroot.setBottom(toolbar);
		Scene scene = new Scene(paneroot, 900,900);
		button1.setOnAction(e->primaryStage.setScene(scene)); //this action switches scene when pressed		
		
		
		
		//the movable player section with controls (bug: the first move jumps for some reason)

		scene.setOnKeyPressed(e-> {
					switch (e.getCode())
					{
					case A:
						variable.play.changeX(-1);
						variable.play.changeY(0);
						if (isValidMoveSide(variable.play)==true) {
							piece.setBoardLocation();
							System.out.println(variable.play.getX());
							System.out.println(variable.play.getY());

						}else {
							variable.play.changeX(+1);
							variable.play.changeY(0);
							System.out.println(variable.play.getX());
							System.out.println(variable.play.getY());
							
						}
						break;	
			    
					case D:
						variable.play.changeX(+1);
						variable.play.changeY(0);
						if (isValidMoveSide(variable.play)==true) {
							piece.setBoardLocation();
							System.out.println(variable.play.getX());
							System.out.println(variable.play.getY());
							
						}else {
							variable.play.changeX(-1);
							variable.play.changeY(0);
							System.out.println(variable.play.getX());
							System.out.println(variable.play.getY());
						}
			    		break;
			    		
			    	case W:
			    		variable.play.changeX(0);
						variable.play.changeY(-1);
						if (isValidMoveUp(variable.play)==true) {
							piece.setBoardLocation();		
							System.out.println(variable.play.getX());
							System.out.println(variable.play.getY());
							System.out.println(variable.map1.getEnemyList().toString());
						}else {
							variable.play.changeX(0);
							variable.play.changeY(+1);
							System.out.println(variable.play.getX());
							System.out.println(variable.play.getY());
						}
			    		break;
			    		
			    	case S:
			    		variable.play.changeX(0);
						variable.play.changeY(+1);
						if (isValidMoveSide(variable.play)==true) {
							piece.setBoardLocation();
							System.out.println(variable.play.getX());
							System.out.println(variable.play.getY());
						}else {
							variable.play.changeX(0);
							variable.play.changeY(-1);
							System.out.println(variable.play.getX());
							System.out.println(variable.play.getY());
						 			
			    		}
			    		break;
			    	case T:
			    		int v = 0;
			    		for (int w=-1; w<2; w++) {
			    			for (int z=-1; z<2; z++) {
			    				Enemy a = variable.map1.detectEnemy(variable.play.getX()+w, variable.play.getY()+z);
			    				
			    				if (a != null) {
			    					variable.map1.detectEnemy(variable.play.getX()+w, variable.play.getY()+z).loseHealth(1);
			    					if (variable.map1.detectEnemy(variable.play.getX()+w, variable.play.getY()+z).getHealth() == 0) {
			    						if (variable.map1.detectEnemy(variable.play.getX()+w, variable.play.getY()+z)==variable.blob){
			    							blob.setVisible(false);
			    						}
			    						if (variable.map1.detectEnemy(variable.play.getX()+w, variable.play.getY()+z)==variable.bob){
			    							bob.setVisible(false);
			    						}
			    						if (variable.map1.detectEnemy(variable.play.getX()+w, variable.play.getY()+z)==variable.mega){
			    							mega.setVisible(false);
			    						}
			    						
			    						variable.map1.popEnemy(variable.play.getX()+w, variable.play.getY()+z);
			    					} else {
			    	     			System.out.println("The enemy now has " + variable.map1.detectEnemy(variable.play.getX()+w, variable.play.getY()+z).getHealth() + " health left!");
			    					}
			    					v++;
			    				}
			    			}
			    		}
			    	case ENTER:
			    		if (variable.map1.areWeDoneYet()) {
			    			if(variable.play.getX() == 5 && variable.play.getY()== 5) {
			    				//End the game.
			    				gameOver = true;
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
		);
		
		primaryStage.show(); 		
	}
	

	//Movable player



	private boolean isValidMoveSide(Player play) {
		int x = play.getX();
		int y = play.getY();
		if (variable.map1.detectEnemy(x, y) != null) {
			System.out.println("Enemy there!");
			return false;
		}			
		else if (variable.map1.detectTile(x, y) == "_") {
			return true;
		}
		else {
			System.out.println("Bump! Whoops, can't pass through walls yet.");
			return false;
	}

	}
	private boolean isValidMoveUp(Player play) {
		int x = play.getX();
		int y = play.getY();
		
		if (variable.map1.detectEnemy(x, y) != null) {
			return false;
		}			
		else if (variable.map1.detectTile(x, y) == "_") {
			return true;
		}
		else {
			System.out.println("Bump! Whoops, can't pass through walls yet.");
			return false;
	}
	}

	public class PlayerPiece extends Pane {

	private PlayerPiece(int x, int y) {
		Rectangle piece = new Rectangle(50, 50);
		piece.setFill(Color.AQUAMARINE);
		getChildren().addAll(piece);
		// This sets location in the text based logic code.
		variable.play.setLocation(x, y);
		piece.setLayoutX(x*50+50);
		piece.setLayoutY(y*50+50);	
	}
	//
	private void setBoardLocation() {
		int p = variable.play.getX();
		int t = variable.play.getY();
		piece.setLayoutX(p*50-100);
		piece.setLayoutY(t*50-100);
	}
	

	}
	//Enemy in game
	
	public class EnemyPiece1 extends Pane {

		private EnemyPiece1() {
			Rectangle enemy = new Rectangle(50, 50);
			enemy.setFill(Color.RED);
			getChildren().addAll(enemy);
			int x = variable.blob.getXloc();
			int y = variable.blob.getYloc();
			enemy.setLayoutX(x*50);
			enemy.setLayoutY(y*50);	
		}
					
	}
	
	//Enemy bob in game.
	public class EnemyPiece2 extends Pane {

		private EnemyPiece2() {
			Rectangle enemy = new Rectangle(50, 50);
			enemy.setFill(Color.RED);
			getChildren().addAll(enemy);
			int x = variable.bob.getXloc();
			int y = variable.bob.getYloc();
			enemy.setLayoutX(x*50);
			enemy.setLayoutY(y*50);	
		}
					
	}
	
	public class EnemyPiece3 extends Pane {

		private EnemyPiece3() {
			Rectangle enemy = new Rectangle(50, 50);
			enemy.setFill(Color.RED);
			getChildren().addAll(enemy);
			int x = variable.mega.getXloc();
			int y = variable.mega.getYloc();
			enemy.setLayoutX(x*50);
			enemy.setLayoutY(y*50);	
		}
					
	}
	
	public class CollectiblePiece extends Pane {

		private CollectiblePiece() {
			Rectangle collectible = new Rectangle(50, 50);
			collectible.setFill(Color.YELLOW);
			getChildren().addAll(collectible);
			int x = variable.Q1.getX();
			int y = variable.Q1.getY();
			collectible.setLayoutX(x*50);
			collectible.setLayoutY(y*50);
	}
	}
	
	

public static void main (String [] args) {
	launch(args);
}
}







	 

	
