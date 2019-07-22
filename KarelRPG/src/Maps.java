
import java.util.ArrayList;
import java.util.Iterator;

public class Maps {
	private int sizeOfCurrentRoom;
	private String[][] layoutOfCurrentRoom; 
	private ArrayList<PhysicalCollectible> listOfCollectibles = new ArrayList<PhysicalCollectible>();
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	
	public Maps(int room) {
		
//		sizeOfCurrentRoom = 10;
//		layoutOfCurrentRoom = new String [sizeOfCurrentRoom][sizeOfCurrentRoom];
		
		
		
		/*
		 * 
		 * int w, l, i = 0;
		 *
		 * for (w = 0; w < layoutOfCurrentRoom.length; w++) { System.out.print("X"); for
		 * (l = 0; l < layoutOfCurrentRoom[0].length; l++) { if (l <
		 * layoutOfCurrentRoom[l].length) { System.out.print("\n|" + i++); } }
		 * System.out.println(); }
		 */
		
		switch (room)
		{
		case 0:
			/*
			 * for (w = 0; w < layoutOfCurrentRoom.length; w++) { System.out.print("X"); for
			 * (l = 0; l < layoutOfCurrentRoom[0].length; l++) { if (l <
			 * layoutOfCurrentRoom[l].length) { System.out.print("X" + i++); } }
			 * System.out.println(); }
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
	
	public String[][] getLayoutOfCurrentRoom()
	{
		return this.layoutOfCurrentRoom;
	}
	
	public String detectItem(int xHere, int yHere)
	{
		String n = null;
		
		for (PhysicalCollectible k : listOfCollectibles) {
			
			if (k.getX() == xHere && k.getY() == yHere) {
				n = k.getTag();
			}
		}
		return n;
		
	}
	
	public ArrayList<PhysicalCollectible> getListOfCollectibles() {
		//get list of collectibles that exists in physical space.
		return listOfCollectibles;
	}
	
	public Enemy detectEnemy(int xHere, int yHere)
	{
		Enemy e = null;
		
		for (Enemy l : enemyList) {
			
			if (l.getXloc() == xHere && l.getYloc() == yHere) {
				 e = l;
			}
		}
		return e;
		
	}
	
	public ArrayList<Enemy> getEnemyList() {
		//get list of enemies that occupy physical space.
		return enemyList;
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
		for (Iterator<PhysicalCollectible> iterator = listOfCollectibles.iterator(); iterator.hasNext();) {
//				PhysicalCollectible i : listOfCollectibles) {
			PhysicalCollectible thing = iterator.next();
			if (thing.getX() == xHere && thing.getY() == yHere) {
				iterator.remove();
			}
		}
	}
	
	public void setTile(int xThere, int yThere) 
	{
		//future implementation
	}
}