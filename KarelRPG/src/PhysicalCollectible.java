
public class PhysicalCollectible {
	
	/* Instances Variables */
	private String name;
	private int realx;
	private int realy;
	
	/* Constructor */
	public PhysicalCollectible(String name1, int x1, int y1)
	{
		this.name=name1;
		this.realx=x1;
		this.realy=y1;
	}

	/* Copy constructor */
	public PhysicalCollectible(PhysicalCollectible p)
	{
		this(p.getTag(),p.getX(),p.getY());
	}
	
	public String getTag() {
		return this.name;
	}	
	public int getX() {
		return this.realx;
	}
	
	public int getY() {
		return this.realy;
	}
	
	public String toString() {
		return" (" + this.name + ":" + this.realx + "," + this.realy + ")";
	}
	
}