package com.karelRPG.gui;

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
	public void setPlayer(Player play) {
		
		Pane player = new Pane();
		
		Image playerpic = new Image ("res/Player.png");
		ImageView e = new ImageView(playerpic);
		int x = play.getX();
		int y = play.getY();
		player.getChildren().add(e);
		getChildren().add(e);
		setLayoutX(x*50);
		setLayoutY(y*50);	
	}
	
	
}
