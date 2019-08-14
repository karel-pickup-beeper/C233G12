package com.karelRPG.gui;

import java.util.ArrayList;

import com.karelRPG.gameplay.Enemy;
import com.karelRPG.gameplay.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class HealthBar extends Pane {
	
	/* Initialise all images. */
	
	Image health0 = new Image ("res/Vitality/0.png");
	Image health1 = new Image ("res/Vitality/1.png");
	Image health2 = new Image ("res/Vitality/2.png");
	Image health3 = new Image ("res/Vitality/3.png");
	Image health4 = new Image ("res/Vitality/4.png");
	Image health5 = new Image ("res/Vitality/5.png");
	Image health6 = new Image ("res/Vitality/6.png");
	Image health7 = new Image ("res/Vitality/7.png");
	Image health8 = new Image ("res/Vitality/8.png");
	Image health9 = new Image ("res/Vitality/9.png");
	Image health10 = new Image ("res/Vitality/FullHealth.png");
	ImageView healthBar = new ImageView(health10);
	/**
	 * this constructor allows the initiation of a pane with the dimension of 50x250
	 */
	public HealthBar(){
		setPrefSize(50,250);
	}
	/**
	 * This method sets a pane with an image of the player heath based on the player current health
	 * @param play, this method takes in parameter of player, and checks the health of the player to set the corresponding png
	 * @return pane with image that represent the current player health
	 */

	public void setHealth(Player play) {

		getChildren().clear();
		
		switch ((play.getHealth()+9)/10)
		{
		case 0:
			healthBar = new ImageView(health0);
			break;
		case 1:
			healthBar = new ImageView(health1);
			break;
		case 2:
			healthBar = new ImageView(health2);
			break;
		case 3:
			healthBar = new ImageView(health3);
			break;
		case 4:
			healthBar = new ImageView(health4);
			break;
		case 5:
			healthBar = new ImageView(health5);
			break;
		case 6:
			healthBar = new ImageView(health6);
			break;
		case 7:
			healthBar = new ImageView(health7);
			break;
		case 8:
			healthBar = new ImageView(health8);
			break;
		case 9:
			healthBar = new ImageView(health9);
			break;
		case 10:
			healthBar = new ImageView(health10);
			break;
		default:
			break;
		}
		getChildren().add(healthBar);
	}
}
