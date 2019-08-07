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
		for (int index =0;index<enemylist.size();index++) {
			
			Enemy enemysingle = enemylist.get(index);
			//Class n = enemysingle.getClass();
			Pane multi = new Pane();
			getChildren().add(multi);
			
			
			if (enemysingle.getType()=="Ghost") 
			{
				Pane enemy1 = new Pane();
				int xpos = enemysingle.getXloc()*50;
				int ypos = enemysingle.getYloc()*50;
				Image ghost = new Image ("res/Ghost enemy.gif");
				ImageView e = new ImageView(ghost);
				enemy1.getChildren().add(e);
				enemy1.setLayoutX(xpos);
				enemy1.setLayoutY(ypos);
				multi.getChildren().add(enemy1);
			}
			else if((enemysingle.getType()=="Cactus")) {
				Pane enemy2 = new Pane();
				int xpos = enemysingle.getXloc()*50;
				int ypos = enemysingle.getYloc()*50;
				Image cactusPic = new Image ("res/Cactus enemy.gif");
				ImageView e = new ImageView(cactusPic);
				enemy2.getChildren().add(e);
				enemy2.setLayoutX(xpos);
				enemy2.setLayoutY(ypos);
				multi.getChildren().add(enemy2);

			}
			else if((enemysingle.getType()=="Zombie")) {
				Pane enemy3 = new Pane();
				int xpos = enemysingle.getXloc()*50;
				int ypos = enemysingle.getYloc()*50;
				Image zombiePic = new Image ("res/zombie enemy.gif");
				ImageView e = new ImageView(zombiePic);
				enemy3.getChildren().add(e);
				enemy3.setLayoutX(xpos);
				enemy3.setLayoutY(ypos);
				multi.getChildren().add(enemy3);

			}
			else if((enemysingle.getType()=="Robot")) {
				Pane enemy4 = new Pane();
				int xpos = enemysingle.getXloc()*50;
				int ypos = enemysingle.getYloc()*50;
				Image zombiePic = new Image ("res/zombie enemy.gif");
				ImageView e = new ImageView(zombiePic);
				enemy4.getChildren().add(e);
				enemy4.setLayoutX(xpos);
				enemy4.setLayoutY(ypos);
				multi.getChildren().add(enemy4);

			}
		}
	}

}



