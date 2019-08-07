package com.karelRPG.gui;

import com.karelRPG.gameplay.Maps;
import com.karelRPG.gameplay.VariableClass;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class MapLayer extends Pane{

	
public MapLayer() {
	setPrefSize(500,500);	
}

public void setMap(Maps map1) {
	int drawXCoord=0;
	int drawYCoord=0;
	Canvas canvas = new Canvas(500,500);
	GraphicsContext context = canvas.getGraphicsContext2D();
	Image grass = new Image ("res/Grass.png");
	Image rock = new Image ("res/Rock.png");
	context.drawImage(rock, 0,50);
	Maps mappo = new Maps(map1);
	for (String[] y:mappo.getLayoutOfCurrentRoom()) { 
		drawXCoord=0; 
		for (String x:y) {
			if (x.equals("X")) { 
				context.drawImage(rock, drawXCoord,drawYCoord); 
			}else if (x.equals("x")) {
				context.drawImage(rock, drawXCoord,drawYCoord); 				
				}else {
				context.drawImage(grass, drawXCoord,drawYCoord); 
			}
			drawXCoord+=50; 
			}
		drawYCoord+=50;

	}
	getChildren().addAll(canvas);
}
	

}
