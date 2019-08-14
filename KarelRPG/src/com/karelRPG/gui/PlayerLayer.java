package com.karelRPG.gui;

import com.karelRPG.gameplay.ActionPrompt;
import com.karelRPG.gameplay.Player;
import com.karelRPG.gameplay.VariableClass;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class PlayerLayer extends Pane{
	
	/* Initialise All Images */
	Image right = new Image ("res/Player/Player Right.gif");
	Image front = new Image ("res/Player/Player Front.gif");
	Image left = new Image ("res/Player/Player Left.gif");
	Image back = new Image ("res/Player/Player Back.gif");
	Image nope = new Image ("res/Player/Player Default.gif");
	ImageView look;
	
	public PlayerLayer () {
		setPrefSize(750,750);
	}
	public void setPlayer(ActionPrompt machine, Player play) {
		String direction = machine.getCommandType();
		
		getChildren().clear();
		Pane player = new Pane();
		int x = play.getX();
		int y = play.getY();
		switch (direction)
		{
		case "right":
			look = new ImageView(right);
			player.getChildren().add(look);
			break;
			
		case "down":
			look = new ImageView(front);
			player.getChildren().add(look);
			break;
			
		case "left":
			look = new ImageView(left);
			player.getChildren().add(look);
			break;
			
		case "up":
			look = new ImageView(back);
			player.getChildren().add(look);
			break;
			
		default:
			look = new ImageView(nope);
			player.getChildren().add(look);
			break;
		}
		player.setLayoutX(x*50);
		player.setLayoutY(y*50);
		
		getChildren().add(player);
	
}
}
