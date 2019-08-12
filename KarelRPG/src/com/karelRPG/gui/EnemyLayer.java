package com.karelRPG.gui;

import java.util.ArrayList;

import com.karelRPG.gameplay.Enemy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class EnemyLayer extends Pane {

	public EnemyLayer() {
		setPrefSize(500,500);
	}
	public void setEnemyLayer(ArrayList<Enemy> enemylist) {
		getChildren().clear();

		for (int index =0;index<enemylist.size();index++) {
			Enemy enemysingle = enemylist.get(index);

			if (enemysingle.getType()=="Ghost") 
			{
				Pane enemy1 = new Pane();
				
				Image ghost = new Image ("res/Ghost enemy.gif");
				ImageView e = new ImageView(ghost);
				int xpos = enemysingle.getXloc()*50;
				int ypos = enemysingle.getYloc()*50;
				enemy1.getChildren().addAll(e,healthBar(enemysingle));
				getChildren().add(enemy1);
				enemy1.setLayoutX(xpos);
				enemy1.setLayoutY(ypos);
				
				
			}
			else if((enemysingle.getType()=="Cactus")) {
				Pane enemy2 = new Pane();
				
				Image cactusPic = new Image ("res/Cactus enemy.gif");
				ImageView e = new ImageView(cactusPic);
				int xpos = enemysingle.getXloc()*50;
				int ypos = enemysingle.getYloc()*50;
				enemy2.getChildren().addAll(e,healthBar(enemysingle));

				getChildren().add(enemy2);
				enemy2.setLayoutX(xpos);
				enemy2.setLayoutY(ypos);
			}
			else if((enemysingle.getType()=="Zombie")) {
				Pane enemy3 = new Pane();
				Image zombiePic = new Image ("res/zombie enemy.gif");
				ImageView e = new ImageView(zombiePic);
				int xpos = enemysingle.getXloc()*50;
				int ypos = enemysingle.getYloc()*50;
				enemy3.getChildren().addAll(e,healthBar(enemysingle));
				getChildren().add(enemy3);
				enemy3.setLayoutX(xpos);
				enemy3.setLayoutY(ypos);

			}
			else if((enemysingle.getType()=="Robot")) {
				Pane enemy4 = new Pane();
				Image zombiePic = new Image ("res/zombie enemy.gif");
				ImageView e = new ImageView(zombiePic);
				int xpos = enemysingle.getXloc()*50;
				int ypos = enemysingle.getYloc()*50;
				enemy4.getChildren().addAll(e,healthBar(enemysingle));
				getChildren().add(enemy4);
				enemy4.setLayoutX(xpos);
				enemy4.setLayoutY(ypos);

			}
		}
	}
	public Pane healthBar(Enemy enemy) {
			
		Pane health = new Pane();

		if (enemy.getHealth()==1) {
			Image healthBar = new Image ("res/Enemy/1.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()==2) {
			Image healthBar = new Image ("res/Enemy/2.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()==3) {
			Image healthBar = new Image ("res/Enemy/3.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()==4) {
			Image healthBar = new Image ("res/Enemy/4.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()==5) {
			Image healthBar = new Image ("res/Enemy/5.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()==6) {
			Image healthBar = new Image ("res/Enemy/6.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()==7) {
			Image healthBar = new Image ("res/Enemy/7.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()==8) {
			Image healthBar = new Image ("res/Enemy/8.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()==9) {
			Image healthBar = new Image ("res/Enemy/9.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()==10) {
			Image healthBar = new Image ("res/Enemy/10.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()==11) {
			Image healthBar = new Image ("res/Enemy/11.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()==12) {
			Image healthBar = new Image ("res/Enemy/12.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()==13) {
			Image healthBar = new Image ("res/Enemy/13.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()==14) {
			Image healthBar = new Image ("res/Enemy/14.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		else if (enemy.getHealth()>=15) {
			Image healthBar = new Image ("res/Enemy/15.png");
			ImageView healthpic = new ImageView(healthBar);
			health.getChildren().add(healthpic);
		}
		return health;

	}
	}



