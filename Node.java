/*
 * Jake Norris
 * Project 5
 * CS 212 
 * 12/12/2018
 */

public class Node 
{
	// instance variables
	private WordData letter;
	private Node left;
	private Node right;
	
	public Node( WordData data )
	{
		left = null;
		right = null;
		letter = data;
	}
	
	public int getFreq( )
	{
		return letter.getFreq();
	}
	
	public char getLetter( )
	{
		return letter.getLetter();
	}
	
	public WordData getData() {
		return letter;
	}
	
	public Node getLeft( )
	{
		return left;
	}
	
	public Node getRight( )
	{
		return right;
	}
	
	public void setData( WordData newData )
	{
		letter = newData;
	}
	
	public void setLeft( Node nd )
	{
		left = nd;
	}
	
	public void setRight( Node nd )
	{
		right = nd;
	}
	
}
