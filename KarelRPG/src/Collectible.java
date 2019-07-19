public class Collectible {
	//instances
	private String name;
	private String type;
	private int count;
	
	
	//constructors
	public Collectible(String name1, String type1, int count1) {//this one handles object: eg. keys
		name=name1;
		type=type1;
		count=count1;
	}

	public Collectible(Collectible c ) {
		name=c.name;
		type=c.type;
		count=c.count;
	}
	
	
	//methods	 
	public int getCount() {
		return count;
	}
	public int increaseCount(int c) {
		count+=c;
		return count;	
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return" (" + name + "," + count+ ")";
	}
	public boolean isComplete(String name) {
		if (Player.getSingleItemCount(name)>8) {
			return true;
		}
		return false;
		
	}
	
} 
