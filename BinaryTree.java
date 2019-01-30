/*
 * Jake Norris
 * Project 5
 * CS 212 
 * 12/12/2018
 */

import java.util.*;

public class BinaryTree 
{
	// instance variables
	private Node root;
	private int frequency;
	private ArrayList<WordCode> codes = new ArrayList<WordCode>();
	
	public BinaryTree( )
	{
		root = null;
		
	}
	
	public BinaryTree( WordData data )
	{
		root = new Node( data );
	}
	
	public BinaryTree( WordData data, int freq) {
		root = new Node( data );
		frequency = freq;
	}
	
	public void attachLeft( BinaryTree bt )
	{
		root.setLeft( bt.root );
		
	}
	
	public void attachRight( BinaryTree bt )
	{
		root.setRight( bt.root );
		
	}
	
	public static BinaryTree combine( BinaryTree bt1, BinaryTree bt2, WordData value )
	{
		BinaryTree result = new BinaryTree( value );
		result.attachLeft( bt1 );
		result.attachRight( bt2 );
		return result;
	}
	
	private void preOrder( Node nd )
	{
		if( nd != null )
		{
			System.out.print( nd.getData( ) + " " );
			preOrder( nd.getLeft( ) ); // visit left subtree in pre order
			preOrder( nd.getRight( ) ); // visit right subtree in pre order
		}
	}
	
	public void preOrder( )
	{
		System.out.print(  "Pre order: " );
		preOrder( root );
		System.out.println( );
	}
	
	private void inOrder( Node nd )
	{
		if( nd != null )
		{
			inOrder( nd.getLeft( ) ); // visit left subtree in order
			System.out.print( nd.getLetter( ) + " " );
			inOrder( nd.getRight( ) ); // visit right subtree in order
		}
	}
	
	public void inOrder( )
	{
		System.out.print(  "In order: " );
		inOrder( root );
		System.out.println( );
	}
	
	private void postOrder( Node nd )
	{
		if( nd != null )
		{
			postOrder( nd.getLeft( ) ); // visit left subtree in post order
			postOrder( nd.getRight( ) ); // visit right subtree in post order
			System.out.print( nd.getData( ) + " " );
		}
	}
	
	public void postOrder( )
	{
		System.out.print(  "Post order: " );
		postOrder( root );
		System.out.println( );
	}
	
	public void setFreq( int i ) {
		frequency = i;
	}
	
	public int getFreq( ) {
		return frequency;
	}
	
	//private char getLetter( ) {
		//return root.getLetter();
	//}
	
	public BinaryTree encode() {
		// Traverse the tree preorder 
		// If something has been seen once, then the next item gets a "0"
		// If something has been seen twice, then the next item gets a "0"
		encode(root, "");
		return this;
	}
	
	private void encode( Node nd, String s ) {
		// Traverse the tree preorder 
		// If something has been seen once, then the next item gets a "0"
		// If something has been seen twice, then the next item gets a "0"
		if( nd != null )
		{
			codes.add(new WordCode(nd.getLetter(), s));
			encode( nd.getLeft( ), s + "0"); // visit left subtree in pre order
			encode( nd.getRight( ), s + "1"); // visit right subtree in pre order
			
		}
		
	}
	
	public ArrayList<WordCode> getCodes() {
		return codes;
	}
}
