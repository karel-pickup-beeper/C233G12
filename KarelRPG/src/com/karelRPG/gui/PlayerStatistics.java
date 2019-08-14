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
	Image starIcon = new Image ("res/status/equipment/Star.png");
	ImageView equip;
	
	Image runIcon = new Image ("res/status/run.png");
	ImageView icon1;
	
	/**
	 * this constructor allows the initialization of the Vbox with the dimention 50x100
	 */
	public PlayerStatistics() {
		setPrefSize(50,100);
	}
	/**
	 * this method sets the the stats icon on the left of the pane
	 * @param game, the method takes in the parameter of game, and checks to see which item the player is current equipping
	 * @return the method returns a Vbox containing an item (potion, sword..) depending on the item that is currently selected by the player
	 */

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
		case "Starlight":
			equip = new ImageView(starIcon);
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
