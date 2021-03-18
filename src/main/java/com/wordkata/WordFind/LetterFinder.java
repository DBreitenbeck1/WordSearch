package com.wordkata.WordFind;

public class LetterFinder {
	char letter;
	
	LetterFinder(char l){
		letter= l;
	}
	
	public int search(char[] list) {
		int position=-1;
		for(int i = 0; i<list.length;i++) {
			if(letter==list[i]) {
				position=i;
			}
		}
		return position;
		
	}
	

}
