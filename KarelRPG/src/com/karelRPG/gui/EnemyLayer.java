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
				enemy1.getChildren().add(e);
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
				
				enemy2.getChildren().add(e);
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
				
				enemy3.getChildren().add(e);
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
				
				enemy4.getChildren().add(e);
				getChildren().add(enemy4);
				enemy4.setLayoutX(xpos);
				enemy4.setLayoutY(ypos);

			}
		}
	}

}



