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

	public void printScreen(WinCondition title)
	{
		switch (title)
		{
		case win:
			//Prints WinGame Title Card.
			break;
		case dead:
			//Prints GameOver Title Card.
			break;
		case out:
			//Prints Start Game Title Screen.
			break;
		case in:
			//Don't print title Card.
			//In reality, case IN would never be passed as a
			//WinCondition to the printScreen() method because
			//It's never called while IN gameplay.
			break;
		default:
			break;
			
		}
	}
	
	public void restartGame()
	{
		//Forces player to quit game back to title screen.
		this.gameOver = true;
		this.title = WinCondition.out;
	}
	
	public void newGame()
	{
		//Starts new game when player is at a WinGame or GameOver Title Card.
		this.title = WinCondition.out;
	}
}
