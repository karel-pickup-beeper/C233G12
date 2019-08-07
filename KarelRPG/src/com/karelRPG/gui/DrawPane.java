package com.karelRPG.gui;
import com.karelRPG.gameplay.*;
import java.util.ArrayList;

import com.karelRPG.gameplay.VariableClass;

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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

	
public class DrawPane {
	private Stage t;
	private int lengthOfStage=900;
	private int widthOfStage=900;
	private Scene openScene, gameStart, gameEnd;
	private Button button1= new Button();
	private VariableClass variable = new VariableClass();
	private PaneObjects playerpiece = new PaneObjects(variable.play);
	private BorderPane gameBoard = new BorderPane();
	private ToolBar inventory = new ToolBar();

		
	public DrawPane(Stage s) {
		s.setTitle("Karel RPG");
		s.setScene(OpeningScene());
		t=s;
	}//make the pane big 500x500, and add the canvas to the pain, and the canvas will be drawing each enemy on different layers

	public BorderPane start() {
		variable.start();
		Group g = new Group();
		Maps k = variable.game.getDungeon().get(1);
		g.getChildren().addAll(drawMap(k), playerpiece);
		gameBoard.setCenter(g);
		setToolBar(inventory);
		gameBoard.setBottom(inventory);
		return gameBoard;

	}
	
	public Scene OpeningScene() { //this draws the opening screen
		button1.setMinSize(300, 100); 
		button1.setStyle("-fx-background-color:white");
		button1.setStyle("-fx-border-color:black");
		button1.setText("Start Game");
		button1.setOnAction(e-> t.setScene(GameScene()));
		//set button with text
		//this is drawing a scene that is a border pane, the size of the stage
		BorderPane borderpane = new BorderPane();
		openScene = new Scene(borderpane, lengthOfStage, widthOfStage);	
		//setting up button;

		//setting start title
		Text Title = new Text("Karel RPG");
		Title.setFont(Font.font(70));
		Text paragraph = new Text("\"To input a command: enter a letter key and press the return key. \\n\" +\r\n" + 
				"    			   \"WASD tells the player to move up, left, down, right respectively.\\n\" +\r\n" + 
				"    			   \"p tells the player to pick up a collectible. \\n\" +\r\n" + 
				"    			   \"t tells the player to spin attack enemies in each adjacent tiles.\\n\" +\r\n" +
				"return to original tile, press f to finish game");
		paragraph.setFont(Font.font(20));

		//set up layout
		HBox H = new HBox();
		H.getChildren().add(paragraph);
		VBox V = new VBox();
		V.getChildren().addAll(H,button1);		

		borderpane.setCenter(V);
		borderpane.setTop(Title); 
		return openScene;
	}
	//the game scene set up 
	
	public Scene GameScene() {
		gameStart = new Scene (start(), widthOfStage, lengthOfStage);
		KeyBoardEvents handle = new KeyBoardEvents();
		gameStart.setOnKeyPressed(handle);
		return gameStart;
	}
	
	
	
	public void setToolBar(ToolBar o) {
		Image po = new Image("res/Potion.png");
		ImageView i = new ImageView(po);
		Button slot1 = new Button("",i);
		slot1.setMinSize(80, 80); 
		
		o.getItems().add(slot1);

		Image sw = new Image("res/Sword.png");
		ImageView i2 = new ImageView(sw);
		Button slot2 = new Button("", i2);
		slot2.setMinSize(80, 80); 
		o.getItems().add(slot2);

		Image ke = new Image("res/Key.png");
		ImageView i3 = new ImageView(ke);
		Button slot3 = new Button("", i3);
		slot3.setVisible(false);
		slot3.setMinSize(80, 80); 
		o.getItems().add(slot3);
		
	}			
			
	
	public void setPlayer(Maps map, Player play, Pane piece) {
		int xpos = converter(play.getX());
		int ypos = converter(play.getY());
		piece.setLayoutX(xpos);
		piece.setLayoutX(ypos);
	}
	
	public void updatePlayer(Player play, Pane piece) {
		int xpos = converter(play.getX());
		int ypos = converter(play.getY());
		piece.setLayoutX(xpos-100);
		piece.setLayoutY(ypos-100);
	}
	
	
	public void updateItems() {
		
	}
	
	public void updateAllEnemy(ArrayList<Enemy> p) {
		for (int i =0;i<p.size();i++) {
			Enemy enemy = p.get(i);
			int xpos = converter(enemy.getXloc());
			int ypos = converter(enemy.getYloc());	
	}	
}
		
	public Canvas drawMap(Maps room) {
		int drawXCoord=0;
		int drawYCoord=0;
		Canvas canvas = new Canvas(500,500);
		GraphicsContext context = canvas.getGraphicsContext2D();
		Image grass = new Image ("res/Grass.png");
		Image rock = new Image ("res/Rock.png");
		context.drawImage(rock, 0,50);
		
		for (String[] y:room.getLayoutOfCurrentRoom()) { 
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
		return canvas;
	}
	
		
		
	
	public int converter(int x){
		x*=50;
		return x;
	}
	
	
		
		
	public Scene GameEnd() { //this draws the end screen
		BorderPane layout3 = new BorderPane();
		Text text = new Text ("You've won!");
		text.setFont(Font.font(40));
		Group end = new Group();
		end.getChildren().add(text);
		layout3.setCenter(end);

		return gameEnd = new Scene (layout3, widthOfStage, lengthOfStage);
	}
	
	public void SwitchScene (Stage s, Scene i) {
		s.setScene(i);
	}


	}


