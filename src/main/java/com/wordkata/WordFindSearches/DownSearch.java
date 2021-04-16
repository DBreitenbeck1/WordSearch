package com.wordkata.WordFindSearches;

public class DownSearch extends Search{

	public DownSearch(char[][] field, String word) {
		super(field, word);
		// TODO Auto-generated constructor stub
	}
	

	public int[] search(int row) {
		findList(row);
		findFirstLetter(list,0);

		//System.out.println("ypos "+ypos);
		int[] co = new int[4];
		//int [] positions = new int[letters.length]; 
    	int letter = 0;
    	int firstLetterPos=0;
    	
    	int [] ypositions = new int[letters.length]; 
    	//	int [] xpositions = new int[letters.length]; 
    	
    
    	while (this.xpos!=-1) {
    		firstLetterPos=xpos+1;
    	
    		for(int i = ypos; i<field.length;i++) {
    			int ans=searchLetter(xpos, field[i], letter);
				if(ans !=-1) {
					ypositions[letter] = i;
		    		addLetter(field[i][ans], letter);
		    		letter++;
		    			if (checkLetters()) {
			    			co[0]=xpos;
			    			co[1]=ypositions[0];       
			    			co[2]=xpos;
			    			co[3]=ypositions[ypositions.length-1];       
							return co;
						}	
		    		}
	    		else{	
	    			clearLetters();
	    			letter=0;
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
