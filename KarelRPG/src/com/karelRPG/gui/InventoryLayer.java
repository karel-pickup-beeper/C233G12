package com.karelRPG.gui;

import java.util.ArrayList;

import com.karelRPG.gameplay.Collectible;
import com.karelRPG.gameplay.Enemy;
import com.karelRPG.gameplay.Player;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class InventoryLayer extends ToolBar{
	
	Button key,star,potion,ns,bs,ws;
	//ArrayList <Button> buttons = new ArrayList<Button>();

	
	public Button potionButton() { 
		Image po = new Image("res/potion.png");
		ImageView i = new ImageView(po);
		potion = new Button("",i);
		potion.setMinSize(50, 50);
		//potion.setOnAction(); INSERT ACTION HERE
		return potion;
		
	}
	public Button keyButton() {
		Image ke = new Image("res/Key.png");
		ImageView i3 = new ImageView(ke);
		key = new Button("", i3);
		key.setMinSize(50, 50); 
		//potion.setOnAction(); INSERT ACTION HERE

		return key;
	}
	public Button startSword() {
		Image sw = new Image("res/Sword.png");
		ImageView i2 = new ImageView(sw);
		ns = new Button("", i2);
		ns.setMinSize(50, 50); 
		//potion.setOnAction(); INSERT ACTION HERE


		return ns;
	}
	public Button starButton() {
		Image sw = new Image("res/star.png");
		ImageView i2 = new ImageView(sw);
		star = new Button("", i2);
		star.setMinSize(50, 50); 
		//potion.setOnAction(); INSERT ACTION HERE
		return star;
	}
	public InventoryLayer() {
		Button p = potionButton();
		Button k = keyButton();
		Button sw = startSword();
		Button s = starButton();
		
		//attempt at making the buttons invisible, doesn't work, not sure why
//		p.setVisible(false);
//		k.setVisible(false);
//		sw.setVisible(false);
//		s.setVisible(false);
		getItems().add(k);
		getItems().add(s);
		getItems().add(p); //adding to tool bar, the order determines the order they appear in the toolbar
//		buttons.add(p);
//		buttons.add(k);
//		buttons.add(sw);
//		buttons.add(s);
		
	}
	
	public void updateToolBar(Player play) {
		for (int index =0;index<play.getInventory().size();index++) {
		Collectible i = play.getInventory().get(index);
//		if (i.getName()=="Potion") {
//			if(i.getCount()==0) {
//				buttons.get(1).setVisible(false);
//			}
//			else{
//				buttons.get(1).setVisible(true);
//			}
		}
}
		
		
		
	}


