package com.wordkata.WordFindSearches;

public class UpSearch extends Search {

	public UpSearch(char[][] field, String word) {
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
    	

    	
    
    	while (this.xpos!=-1) {
    		firstLetterPos=xpos+1;
    	
    		for(int i = ypos; i>-1;i--) {
    			int ans=searchLetter(xpos, field[i], letter);
				if(ans !=-1) {
					positions[letter] = i;
		    		addLetter(field[i][ans], letter);
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
				}	
			}
    		findFirstLetter(list,firstLetterPos);
    	}
    	positions[0] = -1;
		return positions;
		
	}
	
	
	
	public char[] getList() {
		return this.list;
	}

}