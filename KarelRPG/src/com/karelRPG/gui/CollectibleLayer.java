package com.karelRPG.gui;

import java.util.ArrayList;

import com.karelRPG.gameplay.Collectible;
import com.karelRPG.gameplay.Enemy;
import com.karelRPG.gameplay.PhysicalCollectible;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CollectibleLayer extends Pane{
	
	public CollectibleLayer() {
		setPrefSize(500,500);
	}
	
	public void setCollectibleLayer(ArrayList<PhysicalCollectible> collectiblelist) {
		
		
		for (PhysicalCollectible w: collectiblelist) {
			Pane multi = new Pane();
			if (w.getTag()=="Key") {
				Pane item = new Pane();
				int xpos = w.getX()*50;
				int ypos = w.getY()*50;
				Image keypic = new Image ("res/Key.png");
				ImageView e = new ImageView(keypic);
				item.getChildren().add(e);
				item.setLayoutX(xpos);
				item.setLayoutY(ypos);
				multi.getChildren().add(item);
			}
			else if(w.getTag()=="Sword") {
				Pane item = new Pane();
				int xpos = w.getX()*50;
				int ypos = w.getY()*50;
				Image sword = new Image ("res/Sword.png");
				ImageView e = new ImageView(sword);
				item.getChildren().add(e);
				item.setLayoutX(xpos);
				item.setLayoutY(ypos);
				multi.getChildren().add(item);
			}
		}
	}

}

