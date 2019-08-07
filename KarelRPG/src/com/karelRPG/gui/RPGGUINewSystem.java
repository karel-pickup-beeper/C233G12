package com.karelRPG.gui;
import com.karelRPG.gameplay.*;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RPGGUINewSystem extends Application {
	//starting screen	
	public void start(Stage primaryStage) throws Exception {
		DrawPane board = new DrawPane(primaryStage);
		board.SwitchScene(primaryStage, board.OpeningScene());
		
		primaryStage.show(); 
	}
	
public static void main (String [] args) {
	launch(args);
}

}








	 

	
