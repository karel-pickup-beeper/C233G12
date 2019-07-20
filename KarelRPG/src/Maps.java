
import java.util.ArrayList;

public class Maps {
	private int sizeOfCurrentRoom;
	private String[][] layoutOfCurrentRoom; 
	private ArrayList<PhysicalCollectible> listOfCollectibles = new ArrayList<PhysicalCollectible>();

	
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
		/*	for (w = 0; w < layoutOfCurrentRoom.length; w++) 
			{
				System.out.print("X");
				for (l = 0; l < layoutOfCurrentRoom[0].length; l++) 
				{
					if (l < layoutOfCurrentRoom[l].length) {
						System.out.print("X" + i++);
					}
				}
				System.out.println();
			}
			*/
			layoutOfCurrentRoom = new String[][] {
				{"X","X","X","X","X","X","X","X","X","X"},
				{"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","_","_","_","_","_","_","_","_","X"},
			    {"X","X","X","X","X","X","X","X","X","X"}};
			
			break;
			
			case 1:
				layoutOfCurrentRoom = new String[][] {
					{"X","X","X","X","X","X","X","X","X","X"},
					{"X","_","_","_","_","x","_","_","_","X"},
				    {"X","_","_","_","_","x","_","_","_","X"},
				    {"X","_","_","_","_","x","_","_","_","X"},
				    {"X","x","x","_","_","x","_","_","_","X"},
				    {"X","_","_","_","_","_","_","x","x","X"},
				    {"X","_","_","_","_","_","x","x","_","X"},
				    {"X","_","x","_","_","_","_","_","_","X"},
				    {"X","_","x","_","_","_","_","_","_","X"},
				    {"X","X","X","X","X","X","X","X","X","X"}};
		}	
	}

	
	public String detectTile(int xThere, int yThere) 
	{
		String n = "_";
	
		for (int i = 0; i < layoutOfCurrentRoom.length; i++) {
			
			for(int j = 0; j < layoutOfCurrentRoom[i].length; j++) {
				if (i == xThere && j == yThere) {
					n = layoutOfCurrentRoom[i][j];
				}
			}
		}
		return n;
	}
	
	public String[][] getlayoutOfCurrentRoom()
	{
		return this.layoutOfCurrentRoom;
	}
	
	public String detectItem(int xHere, int yHere)
	{
		String n = null;
		
		for (PhysicalCollectible i : listOfCollectibles) {
			
			if (i.getX() == xHere && i.getY() == yHere) {
				n = i.getTag();
			}
			else  {
				n = null;
			}
		}
		return n;
		
	}
	
	
	public boolean noMoreCollectible() 
	{
		boolean isThere = false;
		
		if (listOfCollectibles.isEmpty()) {
			isThere = true;
		}
		
		return isThere;
	}
	
	/**
	 * This method searches for a collectible at a specified location. If the collectible 
	 * is present in that location it is removed from the arrayList and no longer shown 
	 * on the map.
	 * 
	 * @param xHere
	 * @param yHere
	 */
	public void popCollectible(int xHere, int yHere) 
	{
		/*
			In Here we just delete the Physical Collectible on the map that happens to be at the location given
			in the parameters. In the program we have to iterate through the arraylist of physical collectible objects
			until we find the physical collectible with the matching xHere = X and yHere = y. And deleted that from the arrayList.
		*/
		for (PhysicalCollectible i : listOfCollectibles) {
			if (i.getX() == xHere && i.getY() == yHere) {
				listOfCollectibles.remove(i);
			}
		}
	}
	
	public void setTile(int xThere, int yThere) 
	{
		//future implementation
	}
}