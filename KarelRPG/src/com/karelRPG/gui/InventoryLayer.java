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
	Image noEquipment = new Image ("res/items/No.png", 50, 50, true, true);
	Image bigEquipped = new Image ("res/items/BigSword.gif");
	Image whackEquipped = new Image ("res/items/WhackSword.png");
	Image[] images = {noEquipment,keyItem,starItem,potionItem,bigEquipped,whackEquipped};
	StackPane slot1, slot2, slot3, slot4, slot5, slot6;
	Button stopIcon, keyIcon,starIcon,potionIcon,bigSwordIcon,whackSwordIcon;

	public static final int buttonSize = 50;
	
	
	public Button inventoryIcon(int item) {
		ImageView i0 = new ImageView(images[item]);
		Button icon = new Button("", i0);
		icon.setMinSize(buttonSize, buttonSize);
		icon.setStyle("-fx-background-color: transparent;");

		return icon;
	}
	
	public InventoryLayer() {
		setStyle("-fx-background-color: black;");
		Image woodenSlot = new Image("res/WoodFrame.png");
		ImageView i1 = new ImageView(woodenSlot);
		ImageView i2 = new ImageView(woodenSlot);
		ImageView i3 = new ImageView(woodenSlot);
		ImageView i4 = new ImageView(woodenSlot);
		ImageView i5 = new ImageView(woodenSlot);
		ImageView i6 = new ImageView(woodenSlot);
		
		slot1 = new StackPane();
		slot2 = new StackPane();
		slot3 = new StackPane();
		slot4 = new StackPane();
		slot5 = new StackPane();
		slot6 = new StackPane();
		
		slot1.getChildren().add(i1);
		slot2.getChildren().add(i2);
		slot3.getChildren().add(i3);
		slot4.getChildren().add(i4);
		slot5.getChildren().add(i5);
		slot6.getChildren().add(i6);
		
		getItems().add(slot1);
		getItems().add(slot2);
		getItems().add(slot3); //adding to tool bar, the order determines the order they appear in the toolbar
		getItems().add(slot4);
		getItems().add(slot5);
		getItems().add(slot6);
	}
}

