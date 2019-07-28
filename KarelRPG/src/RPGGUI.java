import javafx.application.*;
import java.util.Timer;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class RPGGUI extends Application {
	Button button1, button2;
	Stage primaryStage;
	Scene Openscene, GameStart;
	private VariableClass variable = new VariableClass();
	private int lengthOfStage=640;
	private int widthOfStage=480;
	
	//starting screen	
	public void start(Stage primaryStage) throws Exception {
		Group root=new Group();
		BorderPane layout = new BorderPane();//the layout is basically a root
		Openscene = new Scene (layout, widthOfStage, lengthOfStage);
		primaryStage.setScene(Openscene);
		
		//setting start game button
		button1= new Button();
		button1.setMinSize(300, 100); 
		button1.setStyle("-fx-background-color:white");
		button1.setStyle("-fx-border-color:black");
		
		button1.setOnAction(e->primaryStage.setScene(GameStart));
		button1.setOnAction(e->variable.tony.goInTheGame());
		

		button1.setText("Start Game");
		//set button with text
		primaryStage.setTitle("Karel RPG"); //the title of the window
		//setting start title
		Text Title = new Text("Karel RPG");
		Title.setFont(Font.font(40));
	
		
		//set up layout
		layout.setTop(Title); 
		root.getChildren().add(button1);
		layout.setCenter(root);
		layout.setLeft(button2);
		
		//new scene
		BorderPane layout1= new BorderPane();
		GameStart = new Scene(layout1,widthOfStage,lengthOfStage);
		primaryStage.show(); //the new scene starts now, also where the game will begin
		
		
		
		variable.start();		
		
		}
	
	public static void main (String [] args) {
		launch(args);
		}
	 
	}
	
