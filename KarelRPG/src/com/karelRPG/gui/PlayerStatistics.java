package com.karelRPG.gui;

import com.karelRPG.gameplay.ActionPrompt;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PlayerStatistics extends VBox {

	/* Initialise all images. */
	
	Image normal = new Image ("res/status/equipment/NormalSword.png");
	Image big = new Image ("res/status/equipment/BigSword.png");
	Image whack = new Image ("res/status/equipment/WhackSword.png");
	Image potion = new Image ("res/status/equipment/Potion.png");
	ImageView equip;
	
	Image run = new Image ("res/status/run.png");
	ImageView icon1;
	
	public PlayerStatistics() {
		setPrefSize(50,100);
	}

	public void setStatus(ActionPrompt game) {
		
		getChildren().clear();
		
		switch(game.getEquipmentString())
		{
		case "Potion":
			equip = new ImageView(potion);
			break;
		case "(default sword)":
			equip = new ImageView(normal);
			break;
		case "Big Sword":
			equip = new ImageView(big);
			break;
		case "Whack Sword":
			equip = new ImageView(whack);
			break;
		default:
			break;
		}
		getChildren().add(equip);
		
		
		if (game.soDoEnemiesRun()) {
			icon1 = new ImageView(run);
			getChildren().add(icon1);
		}
		
	}
}
