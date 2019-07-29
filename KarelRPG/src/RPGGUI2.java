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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RPGGUI2 extends Application {
	Button button1, button2;
	Stage primaryStage;
	Scene Openscene, GameStart;
	private VariableClass variable = new VariableClass();
	private int lengthOfStage=900;
	private int widthOfStage=900;
	private int drawXCoord=0;
	private int drawYCoord=0;
	private PlayerPiece piece = new PlayerPiece(0,0);
	private EnemyPiece blob = new EnemyPiece();


	
	//starting screen	
	public void start(Stage primaryStage) throws Exception {
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
		main.getChildren().addAll(canvas, piece, blob);
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
						if (isValidMoveSide(variable.play, -1)==true) {
							variable.play.changeX(-1);
							variable.play.changeY(0);
							piece.setBoardLocation();
							System.out.println(variable.play.getX());
							System.out.println(variable.play.getY());}

						break;	
			    
					case D:
							if (isValidMoveSide(variable.play, +1)==true) {
							variable.play.changeX(+1);
							variable.play.changeY(0);
							piece.setBoardLocation();
							System.out.println(variable.play.getX());
							System.out.println(variable.play.getY());}
							
			    		break;
			    		
			    	case W:
			    		if (isValidMoveUp(variable.play, -1)==true) {
			    			variable.play.changeX(0);
							variable.play.changeY(-1);
							piece.setBoardLocation();		
							System.out.println(variable.play.getX());
							System.out.println(variable.play.getY());
						}
			    		break;
			    		
			    	case S:
			 			if (isValidMoveSide(variable.play, 1)==true) {
			 				variable.play.changeX(0);
							variable.play.changeY(+1);
							piece.setBoardLocation();
							System.out.println(variable.play.getX());
							System.out.println(variable.play.getY());
						}
			    		break;
			    		
					}
				
			}
		);
		
		primaryStage.show(); 		
	}
	

	//moveable player



	private boolean isValidMoveSide(Player play, int i) {
		int x = variable.play.getX();
		int y = variable.play.getY();
		if (variable.map1.detectEnemy(x+i, y) != null) {
			return false;
		}			
		else if (variable.map1.detectTile(x+i, y) == "_") {
			return true;
		}
		else {
			System.out.println("Bump! Whoops, can't pass through walls yet.");
			return false;
	}

	}
	private boolean isValidMoveUp(Player play, int i) {
		int x = variable.play.getX();
		int y = variable.play.getY();
		
		if (variable.map1.detectEnemy(x, y+i) != null) {
			return false;
		}			
		else if (variable.map1.detectTile(x, y+i) == "_") {
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
		piece.setLayoutX(x*50);
		piece.setLayoutY(y*50);	
	}
	
	private void setBoardLocation() {
		int p = variable.play.getX();
		int t = variable.play.getY();
		piece.setTranslateX(p*50);
		piece.setTranslateY(t*50);
	}
	

	}
	//Enemy in game
	
	public class EnemyPiece extends Pane {

		private EnemyPiece() {
			Rectangle enemy = new Rectangle(50, 50);
			enemy.setFill(Color.RED);
			getChildren().addAll(enemy);
			int x = variable.blob.getXloc();
			int y = variable.blob.getYloc();
			enemy.setLayoutX(x*50);
			enemy.setLayoutY(y*50);	
		}
		
	}
	
	
	

public static void main (String [] args) {
	launch(args);
}
}







	 

	
