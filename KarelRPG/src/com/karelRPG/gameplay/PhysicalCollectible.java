package com.karelRPG.gameplay;

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
	
	/**
	 * This accessor method will return the name of the physical collectible, when called. 
	 * 
	 * @return name
	 * 
	 */
	public String getTag() {
		return this.name;
	}	
	
	/**
	 * This accessor method will return the x-coordinate of the physical collectible, when called. 
	 * 
	 * @return realx
	 * 
	 */
	public int getX() {
		return this.realx;
	}
	
	/**
	 * This accessor method will return the x-coordinate of the physical collectible, when called. 
	 * 
	 * @return realy
	 * 
	 */
	public int getY() {
		return this.realy;
	}
	
	/**
	 * This accessor method will return the name, x-coordinate, and y-coordinate 
	 * of the physical collectible in type String, when called. 
	 * 
	 * @return name
	 * @return realx
	 * @return realy
	 * 
	 */
	public String toString() {
		return" (" + this.name + ":" + this.realx + "," + this.realy + ")";
	}
	
}