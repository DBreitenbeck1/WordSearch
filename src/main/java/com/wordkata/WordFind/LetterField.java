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
	
	public int calcLargestWordSize() {
		int size=0;
		for(String word:WordList) {
			if(word.length()>size) {
				size=word.length();
			}
		}
		return size;
	}
	
	
	public void calcFieldSize() {
		int size = calcLargestWordSize();
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
	
	public int generateRandomWordPosition(String word) {
		//generates random number to position word
		int rand = (int) Math.random()* fieldSize;
		if(rand>fieldSize-word.length()) {
			generateRandomWordPosition(word);
		} 
		return rand;
	}
	
	
	

}
