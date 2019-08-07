package com.karelRPG.gui;
import java.util.ArrayList;
import java.util.Scanner;

import com.karelRPG.gameplay.ActionPrompt;
import com.karelRPG.gameplay.EndGame;
import com.karelRPG.gameplay.Maps;
import com.karelRPG.gameplay.VariableClass;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

	
public class DrawPane implements EventHandler<KeyEvent> {
	private Stage t;
	private int lengthOfStage=900;
	private int widthOfStage=900;
	private Scene openScene, gameStart, gameEnd;
	private VariableClass game = new VariableClass();
	private ToolBar inventory = new ToolBar();
	PlayerLayer playerlayer = new PlayerLayer();
	EnemyLayer enemylayer = new EnemyLayer();
	CollectibleLayer collectlayer = new CollectibleLayer();
	MapLayer maplayer = new MapLayer();
	
	public static boolean turn = true;

	
	public DrawPane(Stage s) {
		s.setTitle("Karel RPG");
		s.setScene(openingScene());
		t=s;
	}//make the pane big 500x500, and add the canvas to the pain, and the canvas will be drawing each enemy on different layers


	public Scene openingScene() { //this draws the opening screen
		Button button1=new Button();
		button1.setMinSize(300, 50); 
		button1.setStyle("-fx-background-color:white");
		button1.setStyle("-fx-border-color:black");
		button1.setText("Start Game");
		button1.setOnAction(e-> t.setScene(gameScene()));
		//set button with text
		//this is drawing a scene that is a border pane, the size of the stage
		BorderPane borderpane = new BorderPane();
		openScene = new Scene(borderpane, lengthOfStage, widthOfStage);	
		//setting up button;

		//setting start title
		Text Title = new Text("KAREL RPG");
		Title.setFont(Font.font(70));
		Title.setFont(Font.font("Arial",FontWeight.BOLD, 70));
		Title.setFill(Color.WHITE);
		Text paragraph = new Text("To input a command: enter a letter key." + "\n" + 
 			   "The 'W', 'A', 'S', 'D' keys are used to move the player up, left, down, right respectively." 
 			   + "\n" + "The 'P' key allows the player to pick up a collectible item." + "\n" + 
 			   "The 'T' key allows the player to spin attack enemies in each adjacent tiles." + "\n" +
					"To successfully win the game, the player must return to the original tile, and press 'F'. ");
		paragraph.setFont(Font.font(20));
		paragraph.setFill(Color.WHITE);

		//set up layout
//		HBox H = new HBox();
//		H.getChildren().add(paragraph);
//		VBox V = new VBox();
//		V.getChildren().addAll(H,button1);		

//		borderpane.setCenter(V);
		
		Image startImage = new Image ("res/Blue.png");
		borderpane.getChildren().add(new ImageView(startImage));
		
		//Sets border size (top, right,bottom,left)
		borderpane.setPadding(new Insets(100, 20, 200, 20));
		
		borderpane.setTop(Title); 
		BorderPane.setAlignment(Title, Pos.TOP_CENTER);
		
		borderpane.setCenter(button1);

		borderpane.setBottom(paragraph);
		BorderPane.setAlignment(paragraph, Pos.BOTTOM_CENTER);
		
		return openScene;
	}
	//the game scene set up 
	
	public Scene gameScene() {
		BorderPane b = new BorderPane();
		Pane bundle = new Pane();
		game.start();
		bundle.getChildren().addAll(maplayer,playerlayer,enemylayer,collectlayer);
		b.setCenter(bundle);
		gameStart = new Scene (b, widthOfStage, lengthOfStage);
		KeyBoardEvents handle = new KeyBoardEvents();
		gameStart.setOnKeyPressed(handle);
		System.out.println("BEEEE");
		game.tony.goInTheGame();
		if(!game.tony.isGameOver()) {
			if (turn) {
				maplayer.setMap(game.game.getCurrentRoomMap());
				game.game.takeCommand(game.play);
				playerlayer.setPlayer(game.play);
				enemylayer.setEnemyLayer(game.game.getCurrentRoomMap().getEnemyList());
				collectlayer.setCollectibleLayer(game.game.getCurrentRoomMap().getListOfCollectibles());
			}
			turn = false;
		}
		return gameStart;
	}
	
	public void refreshh() {
		game.game.takeCommand(game.play);
		playerlayer.setPlayer(game.play);
		enemylayer.setEnemyLayer(game.game.getCurrentRoomMap().getEnemyList());
		collectlayer.setCollectibleLayer(game.game.getCurrentRoomMap().getListOfCollectibles());
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
	

	
	
	public void handle(KeyEvent event) {
		String i;
		switch (event.getCode())
			{
			case A:
				i="A";
	    		//System.out.println("Moved Left");
	    		game.game.writeCommand(i);
	    		turn = true;	    	
	    		break;
	    		
	    	case D:
	    		i="D";
	    		//System.out.println("Moved Right");
	    		game.game.writeCommand(i);
	    		turn = true;	    	
	    		break;
	    		
	    	case W:
	    		i="W";
	    		System.out.println("Moved Up");
	    		game.game.writeCommand(i);
	    		turn = true;	    	
	    		break;
	    	case S:
	    		i="S";
	    		System.out.println("Moved Down");
	    		game.game.writeCommand(i);
	    		turn = true;	    	
	    		break;
	    		
	    	case P:
	    		i="S";
	    		System.out.println("Picking Up the Item");
	    		game.game.writeCommand(i);
	    		turn = true;	    	
	    		break;
	    		
	    	case T:
	    		i="T";
	    		System.out.println("ATTACK!");
	    		game.game.writeCommand(i);
	    		turn = true;
	    		break;
	    		
	    	case H:
	    		i="H";
	    		System.out.println("What were the commands again?");
	    		game.game.writeCommand(i);
	    		turn = true;
	    		break;
	    		
	    	case ENTER:
	    		i="";
	    		game.game.writeCommand(i);
	    		turn = true;
	    		break;
	    	default:
	    		System.out.println("That was not a valid command, type h for the list of commands.");
	    		break;
	    		//System.out.println("That was not a valid command, type h for the list of commands.");
			}
		}
}

		
//		game.game.writeCommand(name);
//		game.takeCommand(play);
//		game.runEnemiesTurn(play);
//		if (play.getHealth()==0) {
//			tony.playerDied();
//		}
//		if (game.getNoMoreGame()) {
//			tony.finishTheGame();
//		}
//	}
//
//	game.changeTimeStep();
//	System.out.println(game.getTimeStep());	//Prints nth timestep.
//	System.out.print("Health "+play.getHealth()+ "  ");
//	System.out.println("Inventory:\t" + play.getInventory().toString());
//	System.out.println("WANTED-->\t" + game.getCurrentRoomMap().getEnemyListString());
//}
//com.close();
//}
//}
//
//}

