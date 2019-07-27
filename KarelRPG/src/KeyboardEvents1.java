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
			keyPressed.setText(event.getCode().toString());
			
		}

		@Override
		public void start(Stage primaryStage) {
			primaryStage.setTitle("Keyboard Events Test");
			StackPane root = new StackPane();
			
		
			root.getChildren().add(keyPressed);
			
			Scene scene = new Scene (root, 500, 500);
			// This method looks for a handle method whenever a key is pressed.
			scene.setOnKeyPressed(this);
			
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		}
}
