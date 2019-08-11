package com.karelRPG.gui;

import com.karelRPG.gameplay.ActionPrompt;
import com.karelRPG.gameplay.Player;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class PlayerLayer extends Pane{
	public PlayerLayer () {
		setPrefSize(500,500);
	}
	public void setPlayer(ActionPrompt direction, Player play) {
		getChildren().clear();
		Pane player = new Pane();
		
		if (direction.getCommandType()=="right") {
			Image playerpic = new Image ("res/Player Right.gif");
			ImageView e = new ImageView(playerpic);
			int x = play.getX();
			int y = play.getY();
			player.setLayoutX(x*50);
			player.setLayoutY(y*50);
			player.getChildren().add(e);
			getChildren().add(player);
		}else if (direction.getCommandType()=="down") {
			Image playerpic = new Image ("res/Player Front.gif");
			ImageView e = new ImageView(playerpic);
			int x = play.getX();
			int y = play.getY();
			player.setLayoutX(x*50);
			player.setLayoutY(y*50);
			player.getChildren().add(e);
			getChildren().add(player);
			
		}else if (direction.getCommandType()=="left") {
			Image playerpic = new Image ("res/Player Left.gif");
			ImageView e = new ImageView(playerpic);
			int x = play.getX();
			int y = play.getY();
			player.setLayoutX(x*50);
			player.setLayoutY(y*50);
			player.getChildren().add(e);
			getChildren().add(player);
			
		}else if (direction.getCommandType()=="up") {
			Image playerpic = new Image ("res/Player Back.gif");
			ImageView e = new ImageView(playerpic);
			int x = play.getX();
			int y = play.getY();
			player.setLayoutX(x*50);
			player.setLayoutY(y*50);
			player.getChildren().add(e);
			getChildren().add(player);
			
		}else {
			Image playerpic = new Image ("res/Player Default.gif");
			ImageView e = new ImageView(playerpic);
			int x = play.getX();
			int y = play.getY();
			player.setLayoutX(x*50);
			player.setLayoutY(y*50);
			player.getChildren().add(e);
			getChildren().add(player);
		}
	
	
}
}
