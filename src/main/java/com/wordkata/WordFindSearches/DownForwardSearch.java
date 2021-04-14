package com.wordkata.WordFindSearches;

public class DownForwardSearch extends Search {

	public DownForwardSearch(char[][] field, String word) {
		super(field, word);
		// TODO Auto-generated constructor stub
	}

	public int[] search(int row) {
		findList(row);
		findFirstLetter(list,0);

		//System.out.println("ypos "+ypos);
		int[] co = new int[4];
		int [] ypositions = new int[letters.length]; 
		int [] xpositions = new int[letters.length]; 
    	int letter = 0;
    	int firstLetterPos=0;
    	int xTraject;

    	while (this.xpos!=-1) {
    		firstLetterPos=xpos+1;
    		xTraject=xpos;
    		for(int i = ypos; i<field.length;i++) {
    			
    			int ans=searchLetter(xTraject, field[i], letter);
				if(ans !=-1) {
					ypositions[letter] = i;
					xpositions[letter]=xTraject;
		    		addLetter(field[i][ans], letter);
		    		letter++;
		    		//System.out.println(this.foundLetters);
		    			if (checkLetters()) {
		    				this.setCoordintates(
		    						givePositions(
		    						xpositions[0],
		    						ypositions[0],
		    						xpositions[xpositions.length-1],
		    						ypositions[ypositions.length-1]
		    					)
		    				);
			    			co[0]=xpositions[0];
			    			co[1]=ypositions[0];
			    			co[2]=xpositions[xpositions.length-1];
			    			co[3]=ypositions[ypositions.length-1];       
							return co;
						}
		    	xTraject=(xTraject+1<list.length)? xTraject+1:xTraject;		
		    	
				}else{	
	    			clearLetters();
	    			letter=0;
	    			xpositions = new int[letters.length]; 
	    			ypositions = new int[letters.length]; 
				}	
		    			
			}
    		findFirstLetter(list,firstLetterPos);
    	}
    	
    	for(int i =0; i<co.length;i++){
    		co[i]=-1;
    	}
    	this.setCoordintates(givePositions(-1,-1,-1,-1));
		return co;
		
	}
	
	
	
	public char[] getList() {
		return this.list;
	}
	
	
}
