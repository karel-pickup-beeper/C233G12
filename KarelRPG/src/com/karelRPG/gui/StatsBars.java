package com.karelRPG.gui;

import java.util.ArrayList;

import com.karelRPG.gameplay.Enemy;
import com.karelRPG.gameplay.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class StatsBars extends Pane{
	
	public StatsBars(){
		setPrefSize(200,200);
}

	public void setStats(Player play, ArrayList<Enemy> enemylist) {
		//player health
		getChildren().clear();
		Pane player = new Pane();
		if (play.getHealth()<=0) {
			Image health = new Image ("res/Healthbar/0.png");
			ImageView health0 = new ImageView(health);
			player.getChildren().add(health0);
			getChildren().add(player);	
		}else if(play.getHealth()<=10) {
			Image health = new Image ("res/Healthbar/1.png");
			ImageView health0 = new ImageView(health);
			player.getChildren().add(health0);
			getChildren().add(player);	
		}else if(play.getHealth()<=20) {
			Image health = new Image ("res/Healthbar/2.png");
			ImageView health0 = new ImageView(health);
			player.getChildren().add(health0);
			getChildren().add(player);	
		}else if(play.getHealth()<=30) {
			Image health = new Image ("res/Healthbar/3.png");
			ImageView health0 = new ImageView(health);
			player.getChildren().add(health0);
			getChildren().add(player);	
		}else if(play.getHealth()<=40) {
			Image health = new Image ("res/Healthbar/4.png");
			ImageView health0 = new ImageView(health);
			player.getChildren().add(health0);
			getChildren().add(player);	
		}
		else if(play.getHealth()<=50) {
			Image health = new Image ("res/Healthbar/5.png");
			ImageView health0 = new ImageView(health);
			player.getChildren().add(health0);
			getChildren().add(player);	
		}
		else if(play.getHealth()<=60) {
			Image health = new Image ("res/Healthbar/6.png");
			ImageView health0 = new ImageView(health);
			player.getChildren().add(health0);
			getChildren().add(player);	
		}
		else if(play.getHealth()<=70) {
			Image health = new Image ("res/Healthbar/7.png");
			ImageView health0 = new ImageView(health);
			player.getChildren().add(health0);
			getChildren().add(player);	
		}
		else if(play.getHealth()<=80) {
			Image health = new Image ("res/Healthbar/8.png");
			ImageView health0 = new ImageView(health);
			player.getChildren().add(health0);
			getChildren().add(player);	
		}
		else if(play.getHealth()<=90) {
			Image health = new Image ("res/Healthbar/9.png");
			ImageView health0 = new ImageView(health);
			player.getChildren().add(health0);
			getChildren().add(player);	
		}
		else if(play.getHealth()<=100) {
			Image health = new Image ("res/Healthbar/FullHealth.png");
			ImageView health0 = new ImageView(health);
			player.getChildren().add(health0);
			getChildren().add(player);	
		}
		
			
	}

}
