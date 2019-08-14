package com.karelRPG.gui;

import java.util.ArrayList;

import com.karelRPG.gameplay.Collectible;
import com.karelRPG.gameplay.Enemy;
import com.karelRPG.gameplay.PhysicalCollectible;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CollectibleLayer extends Pane{
	
	
	/* Initialise all images. */
	Image keyPic = new Image ("res/items/Key.png", 50, 50, true, true);
	Image potionPic = new Image ("res/items/Potion.gif", 50, 50, true, true);
	Image starPic = new Image ("res/items/Star.png", 50, 50, true, true);
	Image bigSwordArt = new Image ("res/items/BigSword.gif", 50, 50, true, true);
	Image whackSwordArt = new Image ("res/items/WhackSword.png", 50, 50, true, true);
	
	/**
	 * This constructor allows the initialization of a pane with size 500x500
	 */
	public CollectibleLayer() {
		setPrefSize(750,750);
	}
	/**
	 * This method prints out collectibles based on the type of collectibles it is, and the location of the collectibles
	 * @param collectiblelist will pass a list of physical collectible that exist on the current map the player is in.
	 * @return a pane with collectibles set on the location specified
	 */
	public void setCollectibleLayer(ArrayList<PhysicalCollectible> collectiblelist) {
		getChildren().clear();
	for (PhysicalCollectible singleItem : collectiblelist) {
			switch (singleItem.getTag())
			{
			case "Key":
				int xK = singleItem.getX()*50;
				int yK = singleItem.getY()*50;
				ImageView key = new ImageView(keyPic);
				getChildren().add(key);
				key.setLayoutX(xK);
				key.setLayoutY(yK);
				break;
			case "Star":
				int xS = singleItem.getX()*50;
				int yS = singleItem.getY()*50;
				ImageView star = new ImageView(starPic);
				getChildren().add(star);
				star.setLayoutX(xS);
				star.setLayoutY(yS);
				break;
			case "Potion":
				int xP = singleItem.getX()*50;
				int yP = singleItem.getY()*50;
				ImageView potion = new ImageView(potionPic);
				getChildren().add(potion);
				potion.setLayoutX(xP);
				potion.setLayoutY(yP);
				break;
			default:
				break;
			}
			
		}
	}

}

