enum WinCondition
{
	win,dead,in,out;
}
public class EndGame {

	private boolean gameOver;
	private WinCondition title;
	
	public EndGame()
	{
		this.gameOver = true;
		this.title = WinCondition.out;
	}
	
	/**
	 * This accessor method will return true if the gameplay is over or has not begun.
	 * 
	 * @Param gameOver
	 */
	public boolean isGameOver()
	{
		return this.gameOver;
	}
	
	public void goInTheGame()
	{
		this.gameOver = false;
		this.title = WinCondition.in;
	}
	public void printTitle()
	{
		switch (this.title)
		{
		case win:
			/* Prints WinGame Title Card. */
			System.out.println(	" __     __            __          __ _____  _   _  _  _  _ \n" + 
						" \\ \\   / /            \\ \\        / /|_   _|| \\ | || || || |\n" + 
						"  \\ \\_/ /___   _   _   \\ \\  /\\  / /   | |  |  \\| || || || |\n" + 
						"   \\   // _ \\ | | | |   \\ \\/  \\/ /    | |  | . ` || || || |\n" + 
						"    | || (_) || |_| |    \\  /\\  /    _| |_ | |\\  ||_||_||_|\n" + 
						"    |_| \\___/  \\__,_|     \\/  \\/    |_____||_| \\_|(_)(_)(_)\n" + 
						"             NOW close THE window!!!         ");
			break;
			
		case dead:
			/* Prints GameOver Title Card. */
			System.out.println(	"   _____            __  __         ____          ______       \n" + 
								"  / ____|    /\\    |  \\/  |       / __ \\        |  ____|      \n" + 
								" | |  __    /  \\   | \\  / |  ___ | |  | |__   __| |__    _ __ \n" + 
								" | | |_ |  / /\\ \\  | |\\/| | / _ \\| |  | |\\ \\ / /|  __|  | '__|\n" + 
								" | |__| | / ____ \\ | |  | ||  __/| |__| | \\ V / | |____ | |   \n" + 
								"  \\_____|/_/    \\_\\|_|  |_| \\___| \\____/   \\_/  |______||_|   \n" + 
								"       press the ENTER key to go back to the TITLE scrEEN");
			break;
			
		case out:
			/* Prints Start Game Title Screen. */
			System.out.println(	"  _  __              _   _____  _____   _____ \n" + 
								" | |/ /             | | |  __ \\|  __ \\ / ____|\n" + 
								" | ' / __ _ _ __ ___| | | |__) | |__) | |  __ \n" + 
								" |  < / _` | '__/ _ \\ | |  _  /|  ___/| | |_ |\n" + 
								" | . \\ (_| | | |  __/ | | | \\ \\| |    | |__| |\n" + 
								" |_|\\_\\__,_|_|  \\___|_| |_|  \\_\\_|     \\_____|\n" +
								"              PRESS enter key TO start !!!            ");
			break;
			
		case in:
		default:
			/*
			 * Sets title card to null. In reality, case IN would never be passed as a WinCondition
			 * to the updateTitle() method because It's never called while IN gameplay.
			 */
			break;
			
		}
	}
	
	public void finishTheGame()
	{
		this.gameOver = true;
		this.title = WinCondition.win;
		this.printTitle();
	}
	
	/**
	 * This method will force the player to quit game back to the title screen.
	 * 
	 * 
	 */
	public void restartGame()
	{
		/* Forces player to quit game back to title screen. */
		this.gameOver = true;
		this.title = WinCondition.out;
		this.printTitle();
	}
	
	/**
	 * This method will start a new game when player won the game or if the game is over.
	 * 
	 * 
	 */
	public void newGame()
	{
		if (this.gameOver == true)
		{
			/* Starts new game when player is at a WinGame or GameOver Title Card. */
			this.title = WinCondition.out;
			this.printTitle();
		}
	}
}
