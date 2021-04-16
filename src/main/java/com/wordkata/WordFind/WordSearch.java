package com.wordkata.WordFind;

public class WordSearch {
	String[] words;
	char[][] field;
	
	
	public WordSearch(String[]words, char[][] field) {
		this.words=words;
		this.field=field;
	}
	
	public String[] search() {
		String[] foundWords = new String[words.length];
		for(int i =0; i<words.length;i++) {
			String coordinates = findWord(words[i]);
			foundWords[i] = coordinates;
		//	System.out.println(coordinates);
		}
		
		return foundWords;
		
	}
	
	public String findWord(String word) {
		WordFinder WF = new WordFinder(field,word);
		WF.scrollField();
		String coords = word + ": " + WF.getCoordinates();
		
		return coords;
	}
	
}
