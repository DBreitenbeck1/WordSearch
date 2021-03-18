package com.wordkata.WordFind;

public class LetterFinder {
	char [] letters;
	int firstLetterPos;
	
	LetterFinder(String word){
		letters = word.toCharArray();
	}
	
	public int searchFirst(char[] list) {
		int position=-1;
		for(int i = 0; i<list.length;i++) {
			if(letters[0]==list[i]) {
				position=i;
			}
		}
		return position;
	}
	
	public int searchNext(char[] list, int position) {
		int secondPos=-1;
		if(position+1 < list.length) {
			if(list[position+1]==letters[1]) {
				secondPos=position+1;
			}
		} else if(position-1 > -1) {
			if(list[position-1]==letters[1]) {
				secondPos=position-1;
			}
		}
		
		
		return secondPos;
	}
	

}
