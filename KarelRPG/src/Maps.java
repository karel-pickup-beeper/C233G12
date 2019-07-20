
import java.util.ArrayList;

public class Maps {
	private int sizeOfCurrentRoom;
	private String[][] layoutOfCurrentRoom; 
	private ArrayList<PhysicalCollectible> listOfCollectables = new ArrayList<PhysicalCollectible>();

	public Maps() {
		int w,
			l,
			i = 0;

		//	ActionPrompt game;
		
		layoutOfCurrentRoom = new String [sizeOfCurrentRoom][sizeOfCurrentRoom];
		
		sizeOfCurrentRoom = 10;
		
		for (w = 0; w < layoutOfCurrentRoom.length; w++) 
		{
			System.out.print("X");
			for (l = 0; l < layoutOfCurrentRoom[0].length; l++) 
			{
				if (l < layoutOfCurrentRoom[l].length) {
					System.out.print("\n|" + i++);
				}
			}
			System.out.println();
		}
	
	
	
	}

	
	public String detectTile(int xThere, int yThere) 
	{
		
		
		return "hi";
	}
	
	public boolean noMoreCollectable() 
	{
		boolean isThere = true;
		
		return isThere;
	}
	
	public void popCollectable(int xHere, int yHere) 
	{
		/*
			
			
			
		*/
	
	}
	
	public void changeTile(int xThere, int yThere) 
	{
		
	}
}