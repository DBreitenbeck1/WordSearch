package com.wordkata.WordFind;

public class LetterFinder {
	private String word;
	private char [] letters;
	private int firstLetterPos;
	private char[] foundLetters;
	
	LetterFinder(String word){
		this.word = word.toLowerCase();
		//turn word into a list of letters
		letters = word.toCharArray();
		//create a blank list of letters the same length
		foundLetters = new char[letters.length];
	}
	
	
	public int searchLetter(int pos, char[]list, int let) {
		
		int position=-1;
		if (letters[let] == list[pos]) {
			position=pos;
			
		}
	
		return position;
	}
	
	public void addLetter(char letter, int pos) {
		foundLetters[pos]=letter;
	}
	
	
	public void clearLetters() {
		this.foundLetters=new char[this.letters.length];
	}
	
	public Boolean checkLetters() {
		boolean match = false;
		for(int i = 0; i<letters.length;i++) {
			if(letters[i]!=foundLetters[i]) {
				return false;
			} else {
				match=true;
			}
		}
		return match;
	}

		
	
	public char[] getFoundLetters() {
		return foundLetters;
	}
	
	public char[] getLetters() {
		return letters;
	}
	
	
	
	
	
	public int[] wordForward(char[] list, int pos) {
		int [] positions = new int[letters.length]; 
    	int letter = 0;
		for(int i = pos; i<list.length;i++) {
			int ans=searchLetter(i, list, letter);
				if(ans !=-1) {
					positions[letter] = ans;
		    		addLetter(list[ans], letter);
		    		letter++;
		    			if (checkLetters()) {
						return positions;
						}
		    			
		    		}
	    		else{	
	    			clearLetters();
	    			positions = new int[letters.length]; 	
					return positions;
					}	
			}
		return positions;
	
	}
	
	public int[] wordBackward(char[] list, int pos) {
		int [] positions = new int[letters.length]; 
    	int letter = 0;
    	int count= 0;
		for(int i = pos; i>=0;i--) {
			int ans=searchLetter(i, list, letter);
				if(ans !=-1) {
					positions[letter] = ans;
		    		addLetter(list[ans], letter);
		    		letter++;
		    		count++;
		    			if (checkLetters()) {
						return positions;
						}
		    		}
	    		else{	
	    			clearLetters();
	    			positions = new int[letters.length]; 	
					return positions;
					}	
			}
		return positions;
	
	}
	
	

	

}
