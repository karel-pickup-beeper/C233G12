
import java.util.ArrayList;
import java.util.Iterator;

public class Maps {
	private int sizeOfCurrentRoom;
	private String[][] layoutOfCurrentRoom; 
	private ArrayList<PhysicalCollectible> listOfCollectibles = new ArrayList<PhysicalCollectible>();
	private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
	
	public Maps(int room) {

		switch (room)
		{
		case 0:
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
				break;
			
			default:
				break;
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
		
		for (PhysicalCollectible k : listOfCollectibles)
		{
			if (k.getX() == xHere && k.getY() == yHere)
			{
				n = k.getTag();
			}
		}
		return n;
		
	}

	/* Retrieve the list of collectibles that exists in physical space. */
	public ArrayList<PhysicalCollectible> getListOfCollectibles()
	{
		return listOfCollectibles;
	}
	
	public Enemy detectEnemy(int xHere, int yHere)
	{
		Enemy e = null;
		
		for (Enemy l : enemyList)
		{
			if (l.getXloc() == xHere && l.getYloc() == yHere)
			{
				 e = l;
			}
		}
		return e;
		
	}

	/* Retrieve the list of enemies that occupy physical space. */
	public ArrayList<Enemy> getEnemyList()
	{
		return enemyList;
	}
	
	public boolean areWeDoneYet() 
	{
		boolean yep = false;
		
		if (listOfCollectibles.isEmpty() && enemyList.isEmpty()) {
			yep = true;
		}
		
		return yep;
	}
	
	/**
	 * This method searches for a collectible at a specified location. If the collectible 
	 * is present in that location it is removed from the arrayList and no longer printed 
	 * on the map.
	 * 
	 * @param xHere
	 * @param yHere
	 */
	public void popCollectible(int xHere, int yHere) 
	{
		
		/*
		 * Now we must iterate through the ArrayList of PhysicalCollectible objects
		 * representing the existence of Collectible class objects on the map, until we find a location
		 * match with our passed parameters. And ultimately, to delete them from the ArrayList.
		 */
		
		for (Iterator<PhysicalCollectible> iterator = listOfCollectibles.iterator(); iterator.hasNext();) {
			PhysicalCollectible thing = iterator.next();
			if (thing.getX() == xHere && thing.getY() == yHere) {
				iterator.remove();
			}
		}
	}
	
	public void popEnemy (int xHere, int yHere)
	{
		/*
		 * Now we must iterate through the ArrayList of Enemy objects
		 * representing the enemies' existence on the map, until we find a location
		 * match with our passed parameters. And ultimately, to delete them from the ArrayList.
		 */
	for (Iterator<Enemy> iterator = enemyList.iterator(); iterator.hasNext();) {
		Enemy stuff = iterator.next();
		if (stuff.getXloc() == xHere && stuff.getYloc() == yHere) {
			iterator.remove();
		}
	}
	}
	public void setTile(int xThere, int yThere) 
	{
		/* future implementation */
	}
}