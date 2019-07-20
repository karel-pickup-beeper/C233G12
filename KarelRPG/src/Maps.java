
import java.util.ArrayList;

public class Maps {
	private int sizeOfCurrentRoom;
	private String[][] layoutOfCurrentRoom; 
	private ArrayList<PhysicalCollectible> listOfCollectables = new ArrayList<PhysicalCollectible>();

	
	public Maps(int room) {
		int w,
			l,
			i = 0;
		
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
	
		switch (room)
		{
		case 0:
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
			break;
		}
	
	}

	
	public String detectTile(int xThere, int yThere) 
	{
		
		
		return "_";
	}
	
	public String[][] getlayoutOfCurrentRoom()
	{
		return this.layoutOfCurrentRoom;
	}
	
	public String detectItem(int xHere, int yHere)
	{
		return "Key";
	}
	
	public boolean noMoreCollectable() 
	{
		boolean isThere = true;
		
		return isThere;
	}
	
	public void popCollectable(int xHere, int yHere) 
	{
		/*
			In Here we just delete the Physical Collectible on the map that happens to be at the location given
			in the parameters. In the program we have to iterate through the arraylist of physical collectible objects
			until we find the physical collectible with the matching xHere = X and yHere = y. And deleted that from the arrayList.
		*/
	
	}
	
	public void changeTile(int xThere, int yThere) 
	{
		
	}
}