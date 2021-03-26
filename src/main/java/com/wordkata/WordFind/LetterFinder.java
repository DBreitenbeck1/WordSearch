package com.wordkata.WordFind;

public class LetterFinder {
	String word;
	char [] letters;
	int firstLetterPos;
	
	LetterFinder(String word){
		this.word = word;
		letters = word.toCharArray();
	}
	
	public int searchFirst(char[] list, int initPos) {
		int position=-1;
		for(int i = initPos; i<list.length;i++) {
			if(letters[0]==list[i]) {
				position=i;
				break;
			}
		}
		return position;
	}
	
	public int searchNext(char[] list, int position) {
		int secondPos=-1;
			if(position+1 < list.length && list[position+1]==letters[1]) {
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
	
	public String getWord(char[] list, int pos) {
		int initPos = 0;
		int position = searchFirst(list,initPos);
		String word="";
		if(searchNext(list,position)!=-1) {
			while(position!=-1) {
				word+= list[position];
				position=searchNext(list,position);
				System.out.println(word);
			}
		} else if(searchPrev(list,position)!=-1) {
			while(position!=-1) {
				word+= list[position];
				position=searchPrev(list,position);
				System.out.println(word);
			}
		}
		return word;
		
	}
	
	
	
	public int findWord(char[] list) {
		int initPos = 0;
		int position = searchFirst(list,initPos);
		System.out.println(position);
		int secondPosition =-1;
		if(searchNext(list,position)!=-1) {
			secondPosition = searchNext(list,position);
			System.out.println(secondPosition);
			if(searchNext(list,secondPosition)!=-1) {
				return position;
			}
		} else if(searchPrev(list,position)!=-1) {
			secondPosition = searchPrev(list,position);
			if(searchPrev(list,secondPosition)!=-1) {
				return position;
			}
		} else {
			return -1;
		}
		
		System.out.println(position);
		return -1;
	}
	

}
