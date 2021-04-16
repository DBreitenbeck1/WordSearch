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
	String coordinates = "Not Found";
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
		int[] positions = {-1,-1,-1,-1};
		int[] newpositions = {-1,-1,-1,-1};
		//System.out.println(field.length);
		for (int i = 0;i<field.length;i++) {
		//	System.out.println(i);
			newpositions=searchScroller(i);
			/*
			for(int j=0;j<newpositions.length;j++) {
				System.out.print(newpositions[j]+", ");
			//	System.out.print(positions[j]+", ");
			}
			*/
			//System.out.print(checkPositions(positions, newpositions));
			if(checkPositions(positions, newpositions)) {
				setCoordintates(givePositions(newpositions));
				return newpositions;
			}
		}
		return positions;
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
	
	private boolean checkPositions(int[]pos, int[] newpos) {
		return pos[0]!=newpos[0];
	}
	
public String[] givePositions(int[] positions){
		String startPos = String.valueOf(positions[0]) + "," + String.valueOf(positions[1]);
		String endPos = String.valueOf(positions[2]) + "," + String.valueOf(positions[3]);
		String [] coords = {startPos, endPos};
		return coords;
	}
	
	public void setCoordintates(String[] coords) {
		String c = coords[0] +" : " + coords[1];
		
		this.coordinates=c;
	}
	
	public String getCoordinates() {
		return coordinates;
	}
	
	
	public String getWord() {
		return word;
	}
	
}
