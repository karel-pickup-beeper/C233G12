package com.karelRPG.gui;
import java.util.ArrayList;
import java.util.Scanner;

import com.karelRPG.gameplay.ActionPrompt;
import com.karelRPG.gameplay.EndGame;
import com.karelRPG.gameplay.Maps;
import com.karelRPG.gameplay.Player;
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
	
	/* Logic Objects */
	private Scene openScene, helpScene, creditsScene, gameStart, gameEnd, gameOverScene;
	private VariableClass variables = new VariableClass();
	/* Reiterated Variables */
	ActionPrompt console = variables.game;
	Player person = variables.play;
	EndGame flag = variables.tony;
	
	/* Panes */
	//private InventoryLayer inventory = new InventoryLayer();
	private PlayerLayer playerLocation = new PlayerLayer();
	private EnemyLayer enemyRadar = new EnemyLayer();
	private CollectibleLayer scatteredTreasures = new CollectibleLayer();
	private MapLayer terrain = new MapLayer();
	private HealthBar health = new HealthBar();
	private PlayerStatistics status = new PlayerStatistics();
	private InventoryLayer inventory = new InventoryLayer();


	
	private boolean turn = true;

	
	public DrawPane(Stage s) {
		s.setTitle("Karel RPG");
		s.setScene(openingScene());
		t=s;
	}

	// This draws opening screen.
	public Scene openingScene() {
		
		StackPane stackPane = new StackPane();
		openScene = new Scene(stackPane, lengthOfStage, widthOfStage);	
				
				
		// This is the start screen art.
		Image startImage = new Image ("res/StartScreen.png");
		stackPane.getChildren().add(new ImageView(startImage));		
		
		// This is the start button.
		Image image = new Image("res/Button/STARTGAME.png");
		ImageView start = new ImageView(image);
		Button startButton = new Button("", start);
		//Button startButton = new Button ("Start Game");
		startButton.setMinSize(218, 98); 
		startButton.setStyle("-fx-background-color: transparent;");
		startButton.setOnAction(e-> t.setScene(gameScene()));
		
		stackPane.getChildren().add(startButton);
		startButton.setTranslateX(18);
		startButton.setTranslateY(-122);
		
		// This is the help button.
		Image helpButtonImage = new Image("res/Button/HELP.png");
		ImageView help = new ImageView(helpButtonImage);
		Button helpButton = new Button("", help);
		//Button helpButton = new Button ("Help");
		helpButton.setMinSize(218, 90); 
		helpButton.setStyle("-fx-background-color: transparent;");
		helpButton.setOnAction(f-> t.setScene(helpScene()));
			
		stackPane.getChildren().add(helpButton);
		helpButton.setTranslateX(18);
		helpButton.setTranslateY(-7);
				
		
		// This is the credits button.
		Image creditsButtonimage = new Image("res/Button/CREDIT.png");
		ImageView credits = new ImageView(creditsButtonimage);
		Button creditsButton = new Button("", credits);
		//Button creditsButton = new Button ("Credits");
		creditsButton.setMinSize(218, 98); 
		creditsButton.setStyle("-fx-background-color: transparent;");
		creditsButton.setOnAction(f-> t.setScene(creditsScene()));		
				
		stackPane.getChildren().add(creditsButton);
		creditsButton.setTranslateX(18);
		creditsButton.setTranslateY(112);
		

		return openScene;

	}
	
	public Scene helpScene() { //this draws the end screen
		StackPane helpStack = new StackPane();
		helpScene = new Scene (helpStack, lengthOfStage, widthOfStage);	
				
				
		// This is the help screen art.
		Image helpImage = new Image ("res/HelpScreen.png");
		helpStack.getChildren().add(new ImageView(helpImage));		
		
		// This is the player GIF.
		Image playerImageInHelp = new Image("res/PlayerInHelp.gif");
		ImageView player = new ImageView(playerImageInHelp);
		Button playerInHelp = new Button("", player);
		
		playerInHelp.setStyle("-fx-background-color: transparent;");
			
				
		helpStack.getChildren().add(playerInHelp);
		playerInHelp.setTranslateX(10);
		playerInHelp.setTranslateY(-240);
		
		// This button goes back to start screen from the help screen.
		Button helpBackButton = new Button ();
		helpBackButton.setMinSize(218, 90); 
		helpBackButton.setStyle("-fx-background-color: transparent;");
		helpBackButton.setOnAction(f-> t.setScene(openingScene()));
				
		helpStack.getChildren().add(helpBackButton);
		helpBackButton.setTranslateX(-475);
		helpBackButton.setTranslateY(-400);
		
		return helpScene;
	}
	
	public Scene creditsScene() { //this draws the end screen
		StackPane creditsStack = new StackPane();
		creditsScene = new Scene (creditsStack, lengthOfStage, widthOfStage);
		
		// This is the credit screen art.
		Image creditsImage = new Image ("res/StartScreen.png");
		creditsStack.getChildren().add(new ImageView(creditsImage));
		
		Button creditsBackButton = new Button ("GO BACK TO HOME SCREEN \nFROM CREDITS");
		creditsBackButton.setMinSize(218, 90); 
		//creditsBackButton.setStyle("-fx-background-color: transparent;");
		creditsBackButton.setOnAction(f-> t.setScene(openingScene()));

		creditsStack.getChildren().add(creditsBackButton);
		creditsBackButton.setTranslateX(18);
		creditsBackButton.setTranslateY(112);
		
		return creditsScene;
	}
	
	//the game scene set up 
	
	public Scene gameScene() {
		BorderPane root = new BorderPane();
		StackPane center = new StackPane();
		center.setPrefHeight(750);
		center.setPrefWidth(750);
		VBox left = new VBox();
		left.setPrefWidth(100);
		Pane bottom = new Pane();
		bottom.setPrefHeight(100);
		Image po = new Image("res/big border.png");
		ImageView i = new ImageView(po);
		i.setTranslateX(-213);
		i.setTranslateY(-63);
		variables.start();
		
		
		center.getChildren().addAll(i,terrain,scatteredTreasures,enemyRadar,playerLocation);
		left.getChildren().addAll(health,status);
		
		
	
		Button key = inventory.keyButton();
		Button star = inventory.starButton();
		Button potion = inventory.potionButton();
		Button wackS = inventory.wackSword();
		Button bigS = inventory.bigSword();
		
		star.setOnAction(e->{
    		console.switchEquipment("star");
		});
		potion.setOnAction(e->{
			console.switchEquipment("potion");
		});
		wackS.setOnAction(e->{
			console.switchEquipment("whack");
		});
		bigS.setOnAction(e->{
    		console.switchEquipment("big");
		});
		
		
		inventory.slot1.getChildren().add(key);
		inventory.slot2.getChildren().add(star);
		inventory.slot3.getChildren().add(potion);
		inventory.slot4.getChildren().add(wackS);
		inventory.slot5.getChildren().add(bigS);
		
						
		bottom.getChildren().addAll(inventory/*, systemMessage */);
		inventory.setLayoutX(300);
		inventory.setLayoutY(0);

		root.setCenter(center);
		root.setLeft(left);
		root.setBottom(bottom);
		
		gameStart = new Scene (root, lengthOfStage, widthOfStage);
		gameStart.setOnKeyPressed(this);
		flag.goInTheGame();
		if(!flag.isGameOver()) {
			update();
		}
		return gameStart;
	}
	
	public void update() {
		console.takeCommand(person);
		console.runEnemiesTurn(person);
		if (person.getHealth()==0) {
			flag.playerDied();
			t.setScene(GameOver());
		}
		if (console.getNoMoreGame()) {
			flag.finishTheGame();
			t.setScene(GameWin());
		}
		terrain.setMap(console);
		playerLocation.setPlayer(console,person);
		enemyRadar.setEnemyLayer(console.getCurrentRoomMap().getEnemyList());
		scatteredTreasures.setCollectibleLayer(console.getCurrentRoomMap().getListOfCollectibles());
		health.setHealth(person);
		status.setStatus(console);
	}				

	public Scene GameWin() { //this draws the end screen when player wins
		
		StackPane gameWinStack = new StackPane();
		Scene gameWinScene = new Scene(gameWinStack, lengthOfStage, widthOfStage);
		
		Image gameWinImage = new Image ("res/GameWin.png");
		gameWinStack.getChildren().add(new ImageView(gameWinImage));		
		
		Text winText = new Text ("YOU WIN!");
		winText.setFont(Font.font("Snap ITC",60));
		winText.setStyle("-fx-font-weight: bold");
		gameWinStack.getChildren().add(winText);
		winText.setTranslateY(-400);

		return gameWinScene;
	}
	
	public Scene GameOver() { //this draws the end screen when player dies

		StackPane gameOverStack = new StackPane();
		Scene gameOverScene = new Scene(gameOverStack, lengthOfStage, widthOfStage);
		
		Image gameOverImage = new Image ("res/GameOver.png");
		gameOverStack.getChildren().add(new ImageView(gameOverImage));		
		
		Text gameOverText = new Text ("GAME OVER!");
		gameOverText.setFont(Font.font("Snap ITC",60));
		gameOverText.setStyle("-fx-font-weight: bold");
		gameOverStack.getChildren().add(gameOverText);
		gameOverText.setTranslateY(-400);
		
		return gameOverScene;
	}
	
	
	public void SwitchScene (Stage s, Scene i) {
		s.setScene(i);
	}
	

	
	
	public void handle(KeyEvent event) {
		switch (event.getCode())
			{
			case A:
	    		console.writeCommand("A");
	    		update();
	    		break;
	    		
	    	case D:
	    		console.writeCommand("D");
	    		update();
	    		break;
	    	case W:
	       		console.writeCommand("W");
	    		update();
	    		break;
	    	case S:
	    		console.writeCommand("S");
	    		update();
	    		break;
	    		
	    	case P:
	    		console.writeCommand("P");  
	    		update();
	    		break;
	    		
	    	case U:
	    		console.writeCommand("U");
	    		update();
	    		break;
	    		
	    	case H:
	    		System.out.println("What were the commands again?");
	    		console.writeCommand("H");
	    		update();
	    		break;
	    		
	    	case ENTER:
	    		console.writeCommand("");
	    		update();
	    		break;
	    		
	    	//Placeholder Cases, they should not be here, they should be called by button clicks.
	    	case NUMPAD0:
	    		console.switchEquipment("normal");
	    		break;
	    	case NUMPAD1:
	    		console.switchEquipment("potion");
	    		break;
	    	case NUMPAD2:
	    		console.switchEquipment("big");
	    		break;
	    	case NUMPAD3:
	    		console.switchEquipment("whack");
	    		break;
	    	case NUMPAD4:
	    		console.switchEquipment("star");
	    		break;
	    	//End of placeholder case
	    	//underneath each case into the button set on clicks. (exclude break statements)
	    	default:
	    		System.out.print(event.getCode().toString());
	    		System.out.println(" That was not a valid command, type h for the list of commands.");
	    		break;
	    		
			}
		}
}

