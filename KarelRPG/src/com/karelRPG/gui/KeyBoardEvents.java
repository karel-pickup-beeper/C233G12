package com.karelRPG.gui;
import com.karelRPG.gameplay.*;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyBoardEvents implements EventHandler <KeyEvent> {
	private String i ;
	@Override
	public void handle(KeyEvent event) {
	switch (event.getCode())
		{
		case A:
			i="A";
    		System.out.println("Moved Left");
    		break;
    		
    	case D:
    		i="D";
    		System.out.println("Moved Right");
    		break;
    		
    	case W:
    		i="W";
    		System.out.println("Moved Up");
    		break;
    		
    	case S:
    		i="S";
    		System.out.println("Moved Down");
    		break;
    		
    	case P:
    		i="S";
    		System.out.println("Picking Up the Item");
    		break;
    		
    	case T:
    		i="T";
    		System.out.println("ATTACK!");
    		break;
    		
    	case H:
    		i="H";
    		System.out.println("What were the commands again?");
    		break;
    		
    	case ENTER:
    		i="";
    		break;
    	default:
    		System.out.println("That was not a valid command, type h for the list of commands.");
    		break;
    		//System.out.println("That was not a valid command, type h for the list of commands.");
		}
		System.out.println(i);
	}
	
}
	

