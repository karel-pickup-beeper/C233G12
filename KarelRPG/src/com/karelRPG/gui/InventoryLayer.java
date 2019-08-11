package com.karelRPG.gui;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class InventoryLayer extends ToolBar{

	
	public void setToolBar(ToolBar o) {
		
		Image po = new Image("res/potion.png");
		ImageView i = new ImageView(po);
		Button slot1 = new Button("",i);
		slot1.setMinSize(50, 50); 
		
		o.getItems().add(slot1);

		Image sw = new Image("res/Sword.png");
		ImageView i2 = new ImageView(sw);
		Button slot2 = new Button("", i2);
		slot2.setMinSize(50, 50); 
		o.getItems().add(slot2);

		Image ke = new Image("res/Key.png");
		ImageView i3 = new ImageView(ke);
		Button slot3 = new Button("", i3);
		slot3.setVisible(false);
		slot3.setMinSize(50, 50); 
		o.getItems().add(slot3);
		
	}

}
