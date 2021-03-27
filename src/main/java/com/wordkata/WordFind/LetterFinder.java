package com.wordkata.WordFind;

public class LetterFinder {
	String word;
	char [] letters;
	int firstLetterPos;
	
	LetterFinder(String word){
		this.word = word.toLowerCase();
		letters = word.toCharArray();
	}
	
	public int searchFirst(int pos, char[] list) {
		
		
		int position=-1;
		if (letters[0] == list[pos]) {
			position=pos;
		}
	
		return position;
	}
	
	public int searchNext(char[] list, int position, int letter) {
		int secondPos=-1;
			if(position+1 < list.length && list[position+1]==letters[letter]) {
					secondPos=position+1;
				} 
		
		return secondPos;
	}
	
	public int searchPrev(char[] list, int position) {
		int secondPos=-1;
			if(position-1 > -1 && list[position-1]==letters[1]) {
				secondPos=position-1;
			}
			return secondPos;
	}
	
	public int searchLast(char[] list) {
		int position=-1;
		int lastLet = letters.length-1;
		for(int i = 0; i<list.length;i++) {
			if(letters[lastLet]==list[i]) {
				position=i;
			}
		}
		return position;
		
	}
	
	
	public String wordForward(char[] list) {
		
		
		
		
		return null;
	}
	
	

	

}
