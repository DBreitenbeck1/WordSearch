package com.wordkata.WordFindSearches;

public class BackwardSearch extends Search {

	public BackwardSearch(char[][] field, String word) {
		super(field, word);
		// TODO Auto-generated constructor stub
	}


	
	public int[] search(int row) {
		findList(row);
		findFirstLetter(list,0);

		//System.out.println("ypos "+ypos);
		int[] co = new int[2];
		int [] positions = new int[letters.length]; 
    	int letter = 0;
    	int firstLetterPos=0;
    	
    	while (ypos!=-1) {
    		
    	firstLetterPos=ypos+1;
    	System.out.println(firstLetterPos);
		for(int i = ypos; i>=0;i--) {
			int ans=searchLetter(i, list, letter);
				if(ans !=-1) {
					positions[letter] = ans;
		    		addLetter(list[ans], letter);
		    		letter++;
		    			if (checkLetters()) {
		    			co[0]=positions[0];
		    			co[1]=positions[positions.length-1];       
						return co;
						}
		    			
		    		}
	    		else{	
	    			clearLetters();
	    			letter=0;
	    			positions = new int[letters.length]; 
	    			findFirstLetter(list,firstLetterPos);
					}	
			}
    	}
    	positions[0] = -1;
		return positions;
	
		
	}
	
	public char[] getList() {
		return this.list;
	}
	
	
	
}
