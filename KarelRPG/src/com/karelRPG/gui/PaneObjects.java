package com.karelRPG.gui;
import com.karelRPG.gameplay.*;
import com.karelRPG.gameplay.Enemy;
import com.karelRPG.gameplay.PhysicalCollectible;
import com.karelRPG.gameplay.Player;
import com.karelRPG.gameplay.Zombie;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PaneObjects extends Pane {

	public PaneObjects(Player play) {
		Image player = new Image ("res/Player.png");
		ImageView piece = new ImageView();
		piece.setImage(player);
		getChildren().addAll(piece);
		// This sets location in the text based logic code.	
	}

	public PaneObjects(Enemy p) { //you can make more constructors as you go
		Image enemypic = new Image ("res/Enemy.png");
		ImageView enemy = new ImageView();
		enemy.setImage(enemypic);
		getChildren().addAll(enemy);
		int x = p.getXloc();
		int y = p.getYloc();
		enemy.setLayoutX(x*50);
		enemy.setLayoutY(y*50);	
	}
	public PaneObjects(Robot p) { //you can make more constructors as you go
		Image enemypic = new Image ("res/Enemy.png");
		ImageView enemy = new ImageView();
		enemy.setImage(enemypic);
		getChildren().addAll(enemy);
		int x = p.getXloc();
		int y = p.getYloc();
		enemy.setLayoutX(x*50);
		enemy.setLayoutY(y*50);	
	}
	public PaneObjects(Zombie p) { //you can make more constructors as you go
		Image enemypic = new Image ("res/Enemy.png");
		ImageView enemy = new ImageView();
		enemy.setImage(enemypic);
		getChildren().addAll(enemy);
		int x = p.getXloc();
		int y = p.getYloc();
		enemy.setLayoutX(x*50);
		enemy.setLayoutY(y*50);	
	}	
	
	public PaneObjects(PhysicalCollectible g) {
		Rectangle collectible = new Rectangle(50, 50);
		collectible.setFill(Color.YELLOW);
		getChildren().addAll(collectible);
		int x = g.getX();
		int y = g.getY();
		collectible.setLayoutX(x*50);
		collectible.setLayoutY(y*50);
	}
}
	
	//
	




