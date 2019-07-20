enum WinCondition
{
	win,dead,in,out;
}
public class EndGame {

	private boolean gameOver;
	private WinCondition title;
	public EndGame() {
		this.gameOver = true;
		this.title = WinCondition.out;
				
	}

}
