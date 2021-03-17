package com.wordkata.WordFind;

public class LetterField {
	String[] WordList;
	String[] LETTERS= {};//LETTERS
	int fieldSize;
	
	LetterField(String[] list){
		this.WordList=list;
	}
	
	public String[][] createField(){
		
		return null;
	}
	
	public int calcWordSize() {
		int size=0;
		for(String word:WordList) {
			if(word.length()>size) {
				size=word.length();
			}
		}
		return size;
	}
	
	
	public void calcFieldSize() {
		int size = calcWordSize();
		if(size+(size/2)>8) {
			size = size+(size/2);
		} else {
			size = 8;
		}
		this.fieldSize=size;
	}
	
	public int getFieldSize() {
		return fieldSize;
	}
	

}
