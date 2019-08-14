package com.karelRPG.gameplay;
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
	
	public EndGame(EndGame tony) {
		this.gameOver = tony.gameOver;
		this.title = tony.title;
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
								"       NOW close THE window!!!");
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
	
	public void playerDied()
	{
		this.gameOver = true;
		this.title = WinCondition.dead;
		this.printTitle();
	}
	/**
	 * This mutator method will change the game over status of the game to be true midgame,
	 * and the title screen would also be printed.
	 */
	public void restartGame()
	{
		/* Forces player to quit game back to title screen. */
		this.gameOver = true;
		this.title = WinCondition.out;
		this.printTitle();
	}
	
	/**
	 * This mutator method only switches back into the title screen if the game over status
	 * of the game is true.
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
