package com.karelRPG.gui;

import com.karelRPG.gameplay.ActionPrompt;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PlayerStatistics extends VBox {

	/* Initialise all images. */
	
	Image normalIcon = new Image ("res/status/equipment/NormalSword.png");
	Image bigIcon = new Image ("res/status/equipment/BigSword.gif");
	Image whackIcon = new Image ("res/status/equipment/WhackSword.png");
	Image potionIcon = new Image ("res/status/equipment/Potion.gif");
	ImageView equip;
	
	Image runIcon = new Image ("res/status/run.png");
	ImageView icon1;
	
	public PlayerStatistics() {
		setPrefSize(50,100);
	}

	public void setStatus(ActionPrompt game) {
		
		getChildren().clear();
		
		switch(game.getEquipmentString())
		{
		case "Potion":
			equip = new ImageView(potionIcon);
			break;
		case "(default sword)":
			equip = new ImageView(normalIcon);
			break;
		case "Big Sword":
			equip = new ImageView(bigIcon);
			break;
		case "Whack Sword":
			equip = new ImageView(whackIcon);
			break;
		default:
			break;
		}
		getChildren().add(equip);
		
		
		if (game.soDoEnemiesRun()) {
			icon1 = new ImageView(runIcon);
			getChildren().add(icon1);
		}
		
	}
}
