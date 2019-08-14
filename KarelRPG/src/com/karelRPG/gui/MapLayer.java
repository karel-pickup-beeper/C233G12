package com.karelRPG.gui;

import com.karelRPG.gameplay.*;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class MapLayer extends Pane{
	public static final int  squareSize = 50;
	Image grass = new Image ("res/terrain/Grass.png");
	Image rock = new Image ("res/terrain/Wall.png");
	Image win = new Image ("res/terrain/WinTile.png");
public MapLayer() {
	setPrefSize(750,750);	
}

public void setMap(ActionPrompt console) {
	int room = console.getRoomNumber();
	Maps thisMap = console.getCurrentRoomMap();
	getChildren().clear();
	Canvas canvas = new Canvas(750, 750);
	GraphicsContext context = canvas.getGraphicsContext2D();
	
	
	String[][] thisWorld = thisMap.getLayoutOfCurrentRoom();
	for(int j=0;j<thisWorld.length; j++)
    {
    	for(int i=0;i<thisWorld[j].length; i++)
    	{
    		if (room==3 && i==5 && j==8) {
    			context.drawImage(win, i * squareSize,j * squareSize);
    		} else {
	    		switch (thisMap.detectTile(i, j))
	    		{
	    		case "_":
	    			context.drawImage(grass, i * squareSize,j * squareSize); 
	    			break;
	    		case "X":
	    			context.drawImage(rock, i * squareSize,j * squareSize); 
	    			break;
	    		case "x":
	    			context.drawImage(rock, i * squareSize,j * squareSize);
	    			break;
	    		}
    		}
    	}
    }
	
	getChildren().addAll(canvas);
}
	

}
