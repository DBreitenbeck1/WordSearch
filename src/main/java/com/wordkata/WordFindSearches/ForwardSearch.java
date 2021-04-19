package com.wordkata.WordFindSearches;

public class ForwardSearch extends Search {

	
	public ForwardSearch(char[][] field, String word) {
		super(field, word);
		// TODO Auto-generated constructor stub
	}
	

	
	
	public int[] search(int row) {
		
		findList(row);
		findFirstLetter(list,0);

	//	System.out.println("ypos "+ypos);
		int[] co = new int[4];
    	int letter = 1;
    	int [] ypositions = new int[letters.length]; 
		int [] xpositions = new int[letters.length]; 
		for(int i =0; i<ypositions.length;i++){
    		ypositions[i]=row;
    	}
    	
  //  	System.out.println(foundLetters.length);
	//	System.out.println(letters.length);
    	
    	while (this.xpos!=-1) {
    	//	System.out.println("xpos "+xpos);
    		for(int i = xpos; i<list.length;i++) {
    			
    			//System.out.println("letter is: " +letter);
    			int ans=searchLetter(i, list, letter);
    			//System.out.println("ans is: " +ans);
    		
    			//System.out.println("i is: " +i);
    			
    			//System.out.println("foundLetters: " +foundLetters);
				if(ans !=-1) {
					xpositions[letter] = ans;
		    		addLetter(list[ans], letter);
		    		
		    		
		    			if (checkLetters()) {
		    			//	System.out.println(checkLetters());
		    			//	System.out.println(xpositions.length);
		    			//	System.out.println(co.length);
			    			co[0]=xpositions[0];
			    			co[1]=ypositions[0];
			    			co[2]=xpositions[xpositions.length-1]; 
			    			co[3]=ypositions[ypositions.length-1]; 
			    			
							return co;
						}	
		    			letter++;
		    		}
	    		else{	
	    			clearLetters();
	    			letter=1;
	    			xpositions = new int[letters.length]; 
	    			findFirstLetter(list,i);
	    			xpositions[0]=xpos;
	    		//	System.out.println("xpos is: " +xpos);
				}	
				//System.out.println("##");
			}
    		xpos=-1;
    		
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
