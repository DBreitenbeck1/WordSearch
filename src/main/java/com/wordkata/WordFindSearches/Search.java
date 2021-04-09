package com.wordkata.WordFindSearches;

public abstract class Search {
	char[] letters;
	char[][] field;
	char[]foundLetters;
	char[]list;
	int xpos;
	int ypos;
	
	public Search(char[][]field, String word) {
		this.field=field;
		word=word.toLowerCase();
		this.letters=word.toCharArray();
		this.foundLetters=new char[letters.length];
	}
	
	
	
	public int[] find() {
		int[] t = new int[2]; 
		
		return t;
	}
	
	public int firstLetter(int pos, char[]list) {
		int position=-1;
		if (letters[0] == list[pos]) {
			position=pos;	
		}
		return position;
	}
	
	public void findFirstLetter(char[] list, int p) {
		int pos=-1;
		for(int i = p; i<list.length;i++) {
			if((pos=firstLetter(i, list))!=-1) {
				break;
			}
		}
		this.ypos = pos;
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

	
	public void findList(int row) {
		this.list=field[row];
		setXpos(row);
	}
	
	public void setXpos(int row) {
		this.xpos=row;
	}
	
	public void setYpos(int col) {
		this.ypos=col;
	}
		
	public int getYpos() {
		return ypos;
	}
	
	public int getXpos() {
		return xpos;
	}
	
	public char[] getList() {
		return list;
	}
	
	
	public char[] getFoundLetters() {
		return foundLetters;
	}
	
	public char[] getLetters() {
		return letters;
	}
	
	
}
