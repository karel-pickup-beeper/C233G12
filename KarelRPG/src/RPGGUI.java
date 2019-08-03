import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RPGGUI extends Application {
	private Button button1;
	private Stage primaryStage;
	private Scene Openscene, GameStart, GameEnd;
	private VariableClass variable = new VariableClass();
	private int lengthOfStage=900;
	private int widthOfStage=900;
	private int drawXCoord=0;
	private int drawYCoord=0;
	private PlayerPiece piece = new PlayerPiece(1,1);
	private EnemyPiece1 blob = new EnemyPiece1();
	private boolean gameOver = false;
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
		Title.setFont(Font.font(70));
		Text paragraph = new Text(	"To input a command: enter a letter key and press the return key.\n" + 
									"WASD tells the player to move up, left, down, right respectively.\n" + 
									"p tells the player to pick up a collectible.\n" + 
									"t tells the player to spin attack enemies in each adjacent tiles.\n" +
									"return to original tile, press f to finish game");
		paragraph.setFont(Font.font(20));
	
		
		//set up layout
		layout.setTop(Title); 
		root.getChildren().addAll(button1);
		HBox H = new HBox();
		H.getChildren().add(paragraph);
		VBox V = new VBox();
		V.getChildren().addAll(H,root);
		layout.setCenter(V);
		
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
		
		Image po = new Image("res/Potion.png");
		ImageView i = new ImageView(po);
		Button slot1 = new Button("",i);
		slot1.setMinSize(80, 80); 
		
		toolbar.getItems().add(slot1);

		Image sw = new Image("res/Sword.png");
		ImageView i2 = new ImageView(sw);
		Button slot2 = new Button("", i2);
		slot2.setMinSize(80, 80); 
		toolbar.getItems().add(slot2);

		Image ke = new Image("res/Key.png");
		ImageView i3 = new ImageView(ke);
		Button slot3 = new Button("", i3);
		slot3.setVisible(false);
		slot3.setMinSize(80, 80); 
		toolbar.getItems().add(slot3);
							
		paneroot.setBottom(toolbar);
		Scene scene = new Scene(paneroot, 900,900);
		button1.setOnAction(e->primaryStage.setScene(scene)); //this action switches scene when pressed		
		
		BorderPane layout3 = new BorderPane();
		Text text = new Text ("You've won!");
		text.setFont(Font.font(40));
		Group end = new Group();
		end.getChildren().add(text);
		layout3.setCenter(end);
		GameEnd = new Scene (layout3, widthOfStage, lengthOfStage);
		
		
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
			    	case P:
			    		String p = variable.map1.detectItem(variable.play.getX(), variable.play.getY());
			    		if (p != null)
			    		{
			    			variable.map1.popCollectible(variable.play.getX(), variable.play.getY());
			    			variable.play.pickUpItem(p);
			    				if (p.equals("Key")){
			    					Q1.setVisible(false);
			    					slot3.setVisible(true);

			    			}
	
			    		}
			    		else
			    			System.out.println("There is no item to be picked up.");
			    		break;
			    	case F:
			    		if (variable.map1.areWeDoneYet()) {
			    			if(variable.play.getX() == 5 && variable.play.getY()== 5) {
			    				//End the game.
			    				gameOver = true;		
			    				if (gameOver == true) {
			    					primaryStage.setScene(GameEnd);
			    				}
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
		Image player = new Image ("res/Player.png");
		ImageView piece = new ImageView();
		piece.setImage(player);
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
			Image enemypic = new Image ("res/Enemy.png");
			ImageView enemy = new ImageView();
			enemy.setImage(enemypic);
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
			Image enemypic = new Image ("res/Enemy.png");
			ImageView enemy = new ImageView();
			enemy.setImage(enemypic);
			getChildren().addAll(enemy);
			int x = variable.bob.getXloc();
			int y = variable.bob.getYloc();
			enemy.setLayoutX(x*50);
			enemy.setLayoutY(y*50);	
		}
					
	}
	
	public class EnemyPiece3 extends Pane {

		private EnemyPiece3() {
			Image enemypic = new Image ("res/Enemy.png");
			ImageView enemy = new ImageView();
			enemy.setImage(enemypic);
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







	 

	
