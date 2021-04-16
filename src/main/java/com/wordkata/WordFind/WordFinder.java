package com.wordkata.WordFind;

import java.util.ArrayList;

import com.wordkata.WordFindSearches.BackwardSearch;
import com.wordkata.WordFindSearches.DownForwardSearch;
import com.wordkata.WordFindSearches.DownSearch;
import com.wordkata.WordFindSearches.ForwardSearch;
import com.wordkata.WordFindSearches.Search;
import com.wordkata.WordFindSearches.UpForwardSearch;
import com.wordkata.WordFindSearches.UpBackwardSearch;
import com.wordkata.WordFindSearches.DownBackwardSearch;
import com.wordkata.WordFindSearches.UpSearch;


public class WordFinder {
	String word;
	char[][] field;
	Search[]searches = new Search[8];
	
	WordFinder(char[][]field, String word){
		this.word=word;
		this.field=field;
		createSearches();
	}
	
	public int[] findWord() {
		int[] positions;
		
		return null;
	}
	
	public int[] scrollField() {
		for (int i = 0;i<field.length;i++) {
			
		}
		
		return null;
	}
	
	public int[] searchScroller(int i) {
		int[] positions= {-1,-1,-1,-1};
		for(Search s:searches) {
			positions=s.search(i);
			if(positions[0]!=-1) {
				return positions;
			}
		}
		return positions;
	}
	
	private void createSearches() {
		this.searches[0] =	new ForwardSearch(field, word);
		this.searches[1] =	new BackwardSearch(field, word);
		this.searches[2] =	new UpSearch(field, word);
		this.searches[3] =	new DownSearch(field, word);
		this.searches[4] =	new UpForwardSearch(field, word);
		this.searches[5] =	new DownForwardSearch(field, word);
		this.searches[6] =	new UpBackwardSearch(field, word);
		this.searches[7] =	new DownBackwardSearch(field, word);
	}
	
	
	public Search searchFactory(int s) {
		System.out.println("SearchFactory " + s);
		switch(s) {
		case 1:
			System.out.println("ForwardSearch" );
			return new ForwardSearch(field, word);
		case 2:
			System.out.println("BackwardSearch" );
			return new BackwardSearch(field, word);
		case 3:
			System.out.println("UpSearch" );
			return new UpSearch(field, word);
		case 4:
			System.out.println("DownSearch" );
			return new DownSearch(field, word);
		case 5:
			System.out.println("UpFowardSearch" );
			return new UpForwardSearch(field, word);
		case 6:
			return new DownForwardSearch(field, word);
		case 7:
			return new UpBackwardSearch(field, word);
		case 8:
			return new DownBackwardSearch(field, word);
		default:
			return new ForwardSearch(field, word);
		}
	}
	
	public String getWord() {
		return word;
	}
	
}
