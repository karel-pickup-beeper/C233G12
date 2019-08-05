package com.karelRPG.gameplay;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
	
	public class KeyboardEvents1 extends Application implements 
		EventHandler<KeyEvent>{
		
		//Global variable.
		Text keyPressed = new Text();
		
		// This method can use variable "keyPressed" since it's global.
		@Override
		public void handle(KeyEvent event) {
			// This message will display when any key is pressed.
			// keyPressed.setText("A key has been pressed.");
			
			/* 
			 * Since the accessor method getCode() does not return a string;
			 * The return value needs to be converted to String using the 
			 *  method toString().
			 *  
			 *  This mutator method sets the text to the character that the user
			 *  pressed on the keyboard.
			 */ 
			switch (event.getCode().toString())
		
			{
			case "LEFT":
	    		this.currentCommand = CommandType.left;
	    		System.out.println("Moved Left");
	    		break;
	    		
	    	case "RIGHT":
	    	
	    		this.currentCommand = CommandType.right;
	    		System.out.println("Moved Right");
	    		break;
	    		
	    	case "UP":
	    	
	    		this.currentCommand = CommandType.up;
	    		System.out.println("Moved Up");
	    		break;
	    		
	    	case "DOWN":
	    		this.currentCommand = CommandType.down;
	    		System.out.println("Moved Down");
	    		break;
	    		
	    	case "P":
	    		this.currentCommand = CommandType.pickup;
	    		System.out.println("Picking Up the Item");
	    		break;
	    		
	    	case "T":
	    		this.currentCommand = CommandType.attack;
	    		System.out.println("ATTACK!");
	    		break;
	    		
	    	case "H":
	    		this.currentCommand = CommandType.help;
	    		System.out.println("What were the commands again?");
	    		break;
	    		
	    	case "":
	    		this.currentCommand = CommandType.systemcheck;
	    		break;
	    		
	    	default:
	    		this.currentCommand = CommandType.no;
	    		System.out.println("That was not a valid command, type h for the list of commands.");
	    		break;
			}
			
			//keyPressed.setText(event.getCode().toString());
			
		}

		public static void main (String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) {
			primaryStage.setTitle("Keyboard Events Test");
			
			StackPane root = new StackPane();
			Scene scene = new Scene (root, 500, 500);
			primaryStage.setScene(scene);
		
		
			
			// This method looks for a handle method whenever a key is pressed.	
			scene.setOnKeyPressed(this);
			root.getChildren().add(keyPressed);
			
			
			primaryStage.show();
		}
}

	