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
import javafx.scene.layout.StackPane;

public class InventoryLayer extends ToolBar{
	
	/* Initialise all images. */
	Image potionItem = new Image ("res/items/Potion.gif");
	Image starItem = new Image ("res/items/Star.png");
	Image keyItem = new Image ("res/items/Key.png");
	Image noEquipment = new Image ("res/items/No.png");
	Image bigEquipped = new Image ("res/items/BigSword.gif");
	Image whackEquipped = new Image ("res/items/WhackSword.png");
	StackPane slot1, slot2, slot3, slot4, slot5, slot6;
	Button key,star,potion,ns,bs,ws;
	//ArrayList <Button> buttons = new ArrayList<Button>();

	public static final int buttonSize = 50;
	
	public Button potionButton() { 
		Image po = potionItem;
		ImageView i = new ImageView(po);
		potion = new Button("",i);
		potion.setStyle("-fx-background-color: transparent;");
		potion.setMinSize(buttonSize, buttonSize);
		return potion;
		
	}
	public Button keyButton() {
		Image ke = keyItem;
		ImageView i3 = new ImageView(ke);
		key = new Button("", i3);
		key.setMinSize(buttonSize, buttonSize); 
		key.setStyle("-fx-background-color: transparent;");

		//potion.setOnAction(); INSERT ACTION HERE

		return key;
	}
//	public Button startSword() {
//		Image sw = starItem;
//		ImageView i2 = new ImageView(sw);
//		ns = new Button("", i2);
//		ns.setMinSize(buttonSize, buttonSize); 
//		//potion.setOnAction(); INSERT ACTION HERE
//
//
//		return ns;
//	}
	public Button starButton() {
		Image sw = starItem;
		ImageView i2 = new ImageView(sw);
		star = new Button("", i2);
		star.setStyle("-fx-background-color: transparent;");
		star.setMinSize(buttonSize, buttonSize); 
		return star;
	}
	public Button wackSword() {
		Image sw = whackEquipped;
		ImageView i2 = new ImageView(sw);
		ws = new Button("", i2);
		ws.setStyle("-fx-background-color: transparent;");
		ws.setMinSize(buttonSize, buttonSize); 
		return ws;
	}
	public Button bigSword() {
		Image sw = bigEquipped;
		ImageView i2 = new ImageView(sw);
		bs = new Button("", i2);
		bs.setStyle("-fx-background-color: transparent;");
		bs.setMinSize(buttonSize, buttonSize); 
		return bs;
	}
	public InventoryLayer() {
		setStyle("-fx-background-color: black;");
		Image po = new Image("res/WoodFrame.png");
		ImageView i = new ImageView(po);
		ImageView i1 = new ImageView(po);
		ImageView i2 = new ImageView(po);
		ImageView i3 = new ImageView(po);
		ImageView i4 = new ImageView(po);
		ImageView i5 = new ImageView(po);
		ImageView i6 = new ImageView(po);


		
		slot1 = new StackPane();
		slot2 = new StackPane();
		slot3 = new StackPane();
		slot4 = new StackPane();
		slot5 = new StackPane();
		slot6 = new StackPane();
		
		slot1.getChildren().add(i);
		slot2.getChildren().add(i1);
		slot3.getChildren().add(i2);
		slot4.getChildren().add(i3);
		slot5.getChildren().add(i4);
		slot6.getChildren().add(i5);
		
		getItems().add(slot1);
		getItems().add(slot2);
		getItems().add(slot3); //adding to tool bar, the order determines the order they appear in the toolbar
		getItems().add(slot4);
		getItems().add(slot5);
		getItems().add(slot6);
	}
}

