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
		getChildren().clear();
	for (int index =0;index<collectiblelist.size();index++) {
			PhysicalCollectible singleItem = collectiblelist.get(index);
			if (singleItem.getTag()=="Key") {
				Pane item = new Pane();
				int xpos = singleItem.getX()*50;
				int ypos = singleItem.getY()*50;
				Image keypic = new Image ("res/Key.png");
				ImageView e = new ImageView(keypic);
				getChildren().add(item);
				item.getChildren().add(e);
				item.setLayoutX(xpos);
				item.setLayoutY(ypos);
			}
			
		}
	}

}

