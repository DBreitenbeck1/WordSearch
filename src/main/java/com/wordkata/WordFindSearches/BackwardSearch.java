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
		int[] co = new int[4];
    	int letter = 0;
    	int firstLetterPos=0;
    	
    	int [] ypositions = new int[letters.length]; 
		int [] xpositions = new int[letters.length]; 
		for(int i =0; i<ypositions.length;i++){
    		ypositions[i]=row;
    	}
    	
    	
    	
    	while (xpos!=-1) {
    		
    	firstLetterPos=xpos+1;
    	
		for(int i = xpos; i>=0;i--) {
			int ans=searchLetter(i, list, letter);
				if(ans !=-1) {
					xpositions[letter] = ans;
		    		addLetter(list[ans], letter);
		    		letter++;
		    			if (checkLetters()) {
		    			co[0]=xpositions[0];
		    			co[1]=ypositions[0];    
		    			co[2]=xpositions[xpositions.length-1];
		    			co[3]=ypositions[ypositions.length-1];       
						return co;
						}
		    			
		    		}
	    		else{	
	    			clearLetters();
	    			letter=0;
	    			xpositions = new int[letters.length]; 
	    			findFirstLetter(list,firstLetterPos);
					}	
			}
    	}
    	for(int i =0; i<co.length;i++){
    		co[i]=-1;
    	}
		return co;
	
		
	}
	
	public char[] getList() {
		return this.list;
	}
	
	
	
}
