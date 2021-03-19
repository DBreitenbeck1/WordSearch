package com.wordkata.WordFind;

public class LetterFinder {
	String word;
	char [] letters;
	int firstLetterPos;
	
	LetterFinder(String word){
		this.word = word;
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
			if(position+1 < list.length && list[position+1]==letters[1]) {
					secondPos=position+1;
				} else if(position-1 > -1 && list[position-1]==letters[1]) {
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
	
	public String findWord(char[] list) {
		int position = searchFirst(list);
		String word="";
		
		while(position!=-1) {
			word+= list[position];
			position=searchNext(list,position);
			System.out.println(word);
		}
		
		return word;
		
	}
	

}
