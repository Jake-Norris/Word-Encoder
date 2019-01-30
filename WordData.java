/*
 * Jake Norris
 * Project 5
 * CS 212 
 * 12/12/2018
 */

public class WordData {
	private char letter;
	private int frequency;
	
	public WordData( char c ) {
		letter = c;
		frequency++;
	}
	
	public void incFreq() {
		frequency++;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public int getFreq() {
		return frequency;
	}
	
	
}
