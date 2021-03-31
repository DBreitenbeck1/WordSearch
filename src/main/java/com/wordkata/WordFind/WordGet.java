package com.wordkata.WordFind;

public class WordGet {
	String word;
	LetterFinder LF ;
	
	
	
	WordGet(String word){
	word=word.toLowerCase();
	this.word=word;
	this.LF = new LetterFinder(word);
	}
	
	public String getWord() {
		return this.word;
	}
	
	
	
	
}
