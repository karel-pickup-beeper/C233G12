
public class PhysicalCollectible {
	
	//instances
	private String name;
	private int x;
	private int y;
	
	//constructor
	public PhysicalCollectible(String name1, int x1, int y1)
	{
		this.name=name1;
		this.x=x1;
		this.y=y1;
	}
	//copy constructor
	public PhysicalCollectible(PhysicalCollectible p)
	{
		this(p.getTag(),p.getX(),p.getY());
	}
	
	public String getTag() {
		return this.name;
	}	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	
}