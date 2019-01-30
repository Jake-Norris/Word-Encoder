/*
 * Jake Norris
 * Project 5
 * CS 212 
 * 12/12/2018
 */

import java.util.*;
import java.lang.*;

public class EncodingClient {
	public static void main( String[] args ) {
		
		// Ask the user for a word or phrase
		Scanner scan = new Scanner( System.in );
		System.out.println("Enter a word you would like encoded: ");
		String word = scan.nextLine();
		scan.close();
		// Create an arraylist of data objects for the word 
		ArrayList<WordData> wordList = new ArrayList<WordData>();
		for(int i = 0; i < word.length(); i++) {
			boolean inList = false;
			for(int j = 0; j < wordList.size(); j++) {
				if ( Character.toLowerCase(word.charAt(i)) == wordList.get(j).getLetter() ) {
					wordList.get(j).incFreq();
					inList = true;
				}
			}
			if (!inList)
				wordList.add(new WordData(Character.toLowerCase( word.charAt(i) )));
		}
		
		// Sort in ascending order (bubble sort)
				int size = wordList.size(); 
		        for (int i = 0; i < size-1; i++) 
		            for (int j = 0; j < size-i-1; j++) 
		                if (wordList.get(j).getFreq() > wordList.get(j+1).getFreq()) 
		                {  
		                    WordData temp = wordList.get(j); 
		                    wordList.set(j, wordList.get(j+1)); 
		                    wordList.set(j+1, temp); 
		                } 
		
     		
		// Make a forest of binary trees 
		ArrayList<BinaryTree> forest = new ArrayList<BinaryTree>();
		for(int i = 0; i < wordList.size(); i++) {
			forest.add(new BinaryTree( wordList.get(i), wordList.get(i).getFreq()));
		}
		
		// Combine trees in the forest until there is one left 
		while(forest.size() >= 2) {
			// combine two smallest binary trees 
			BinaryTree tempBt = BinaryTree.combine(forest.get(0), forest.get(1), new WordData('?'));
			// delete two that were combined 
			int freq1 = forest.get(0).getFreq();
			int freq2 = forest.get(1).getFreq();
			forest.remove(0);
			forest.remove(0);
			// set frequency of binary tree 
			tempBt.setFreq(freq1 + freq2);
			// insert binary tree in a way that keeps it sorted 
			int indx = 0;
			if(forest.size() != 0) {
				while( tempBt.getFreq() > forest.get(indx).getFreq() && indx < forest.size() - 1) {
					indx++;
				}
			}
			forest.add(indx, tempBt);
		}
		
		
		// Encode the word 
		// Output each letter individually 
		ArrayList<WordCode> codes = forest.get(0).encode().getCodes();
		ArrayList<WordCode> letterCodes = new ArrayList<WordCode>();
		for(int i = 0; i < codes.size(); i++) {
			if(codes.get(i).getLetter() != '?')
				letterCodes.add(codes.get(i));
		}
		String encodedWord = "";
		for(int i = 0; i < word.length(); i++ ){
			for(int j = 0; j < letterCodes.size(); j++) {
				if(Character.toLowerCase(word.charAt(i))== letterCodes.get(j).getLetter())
					encodedWord += letterCodes.get(j).getCode();
			}
		}
		
		System.out.println(word + " is now " + encodedWord + " after encoding.");
		
	}
}
