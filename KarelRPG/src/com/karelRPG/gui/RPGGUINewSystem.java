package com.karelRPG.gui;

import java.util.ArrayList;

import com.karelRPG.gameplay.ActionPrompt;
import com.karelRPG.gameplay.EndGame;
import com.karelRPG.gameplay.VariableClass;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class RPGGUINewSystem extends Application{

	
	//starting screen	
	public void start(Stage primaryStage) throws Exception {
		DrawPane board = new DrawPane(primaryStage);
		board.SwitchScene(primaryStage, board.openingScene());
		primaryStage.show();
	}

	
public static void main (String [] args) {
	launch(args);
}

}








	 

	
