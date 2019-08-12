package com.karelRPG.gameplay;
public class Collectible {
	/* instances */
	private String name;
	private String type;
	private int count;
	
	
	/* constructors */
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
	
	/**
	 * This accessor method will return a count, when called.
	 * 
	 * @Return count
	 */
	/* methods */
	public int getCount() {
		return count;
	}
	
	/**
	 * This mutator method will return an increased value of count, when called.
	 * 
	 * @Param c
	 * @Return count
	 */
	public void increaseCount(int c) {
		count+=c;
	}
	/**
	 * This accessor method will return the name of the collectible, when called.
	 * 
	 * @Return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This mutator method will return string that contains the name of the collectible 
	 * and the amount, when called.
	 * 
	 * @Return name
	 * @Return count
	 */
	public String toString() {
		return" (" + name+ ": " +count+ ")";
	}
		
} 
