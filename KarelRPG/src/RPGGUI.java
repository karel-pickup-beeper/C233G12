import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
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
		layout.setLeft(button2);
		
		
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
					context.drawImage(rock, drawXCoord,drawYCoord); 				}
				else {
					context.drawImage(grass, drawXCoord,drawYCoord); 
				}
				drawXCoord+=50; 
				}
			drawYCoord+=50;

		}
		button1.setOnAction(e->primaryStage.setScene(new Scene(new Pane(canvas)))); //this action switches scene when pressed		
		
		//Movable Player

		
		
		
		
		
		
		primaryStage.show(); 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
		}
	
	public static void main (String [] args) {
		launch(args);
		}
	}
	 

	
