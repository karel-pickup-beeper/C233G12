package com.karelRPG.gui;
import java.util.ArrayList;
import java.util.Scanner;

import com.karelRPG.gameplay.ActionPrompt;
import com.karelRPG.gameplay.EndGame;
import com.karelRPG.gameplay.Maps;
import com.karelRPG.gameplay.VariableClass;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

	
public class DrawPane implements EventHandler<KeyEvent> {
	private Stage t;
	private static final int lengthOfStage=1280;
	private static final int widthOfStage=960;
	private static final int lengthOfGameArea = 500;
	private static final int widthOfGameArea = 500;
	
	private Scene openScene, gameStart, gameEnd;
	private VariableClass game = new VariableClass();
	private ToolBar inventory = new ToolBar();
	private PlayerLayer playerlayer = new PlayerLayer();
	private EnemyLayer enemylayer = new EnemyLayer();
	private CollectibleLayer collectlayer = new CollectibleLayer();
	private MapLayer maplayer = new MapLayer();
	private StatsBars statslayer = new StatsBars();
	
	
	private boolean turn = true;

	
	public DrawPane(Stage s) {
		s.setTitle("Karel RPG");
		s.setScene(openingScene());
		t=s;
	}

	// This draws opening screen.
	public Scene openingScene() {
		

		
		//This is drawing a scene that is a stackPane, with a custom size.
		StackPane stackPane = new StackPane();
		openScene = new Scene(stackPane, lengthOfStage, widthOfStage);	
				
				
		// This is the start screen art.
		Image startImage = new Image ("res/StartScreen.png");
		stackPane.getChildren().add(new ImageView(startImage));		
		
		// This is the start button.
		Image image = new Image("res/Button/STARTGAME.png");
		ImageView start = new ImageView(image);
		Button startButton = new Button("", start);
//		Button startButton = new Button ("Start Game");
		startButton.setMinSize(218, 98); 
		startButton.setStyle("-fx-background-color: transparent;");
		startButton.setOnAction(e-> t.setScene(gameScene()));
		
		stackPane.getChildren().add(startButton);
		startButton.setTranslateX(18);
		startButton.setTranslateY(-122);
		
		// This is the help button.
		Button helpButton = new Button ("Help");
		helpButton.setMinSize(218, 90); 
		//helpButton.setStyle("-fx-background-color: transparent;");
		//helpButton.setOnAction(f-> t.setScene(helpScene()));
			
		stackPane.getChildren().add(helpButton);
		helpButton.setTranslateX(18);
		helpButton.setTranslateY(-7);
				
		
		// This is the credits button.
		Button creditsButton = new Button ("Credits");
		creditsButton.setMinSize(218, 98); 
		//helpButton.setStyle("-fx-background-color: transparent;");
				
				
		stackPane.getChildren().add(creditsButton);
		creditsButton.setTranslateX(18);
		creditsButton.setTranslateY(112);
		
		
		
//		Text paragraph = new Text(	"To input a command: enter a letter key and press the return key.\n" + 
//		"WASD tells the player to move up, left, down, right respectively.\n" + 
//		"p tells the player to pick up a collectible.\n" + 
//		"t tells the player to spin attack enemies in each adjacent tiles.\n" +
//		"return to original tile, press f to finish game");
//		paragraph.setFont(Font.font(20));
//

		return openScene;
	}
	//the game scene set up 
	
	public Scene gameScene() {
		BorderPane b = new BorderPane();
		Pane center = new Pane();
		Pane right = new Pane();
		b.autosize();
		game.start();
		center.getChildren().addAll(maplayer,enemylayer,collectlayer,playerlayer);
		right.getChildren().add(statslayer);
		b.setCenter(center);
		b.setRight(right);
		gameStart = new Scene (b, lengthOfStage, widthOfStage);
		gameStart.setOnKeyPressed(this);
		System.out.println("BEEEE");
		game.tony.goInTheGame();
		if(!game.tony.isGameOver()) {
			update();
		}
		return gameStart;
	}
	
	public void update() {
		game.game.takeCommand(game.play);
		game.game.runEnemiesTurn(game.play);
		if (game.play.getHealth()==0) {
			game.tony.playerDied();
		}
		if (game.game.getNoMoreGame()) {
			game.tony.finishTheGame();
		}
		maplayer.setMap(game.game.getCurrentRoomMap());
		playerlayer.setPlayer(game.game,game.play);
		enemylayer.setEnemyLayer(game.game.getCurrentRoomMap().getEnemyList());
		collectlayer.setCollectibleLayer(game.game.getCurrentRoomMap().getListOfCollectibles());
		statslayer.setStats(game.play, game.game.getCurrentRoomMap().getEnemyList());
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
		switch (event.getCode())
			{
			case A:
	    		game.game.writeCommand("A");
	    		update();
	    		break;
	    		
	    	case D:
	    		game.game.writeCommand("D");
	    		update();
	    		break;
	    	case W:
	       		game.game.writeCommand("W");
	    		update();
	    		break;
	    	case S:
	    		game.game.writeCommand("S");
	    		update();
	    		break;
	    		
	    	case P:
	    		game.game.writeCommand("P");  
	    		update();
	    		break;
	    		
	    	case T:
	    		game.game.writeCommand("T");
	    		update();
	    		break;
	    	case H:
	    		System.out.println("What were the commands again?");
	    		game.game.writeCommand("H");
	    		update();
	    		break;
	    	case ENTER:
	    		game.game.writeCommand("");
	    		update();
	    		break;
	    	default:
	    		System.out.println("That was not a valid command, type h for the list of commands.");
	    		break;
	    		//System.out.println("That was not a valid command, type h for the list of commands.");
			}
		}
}

