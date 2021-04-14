package com.wordkata.WordFind;

import static org.junit.Assert.*;

import java.nio.charset.Charset;

import org.junit.Test;

import com.wordkata.WordFindSearches.BackwardSearch;
import com.wordkata.WordFindSearches.DownForwardSearch;
import com.wordkata.WordFindSearches.DownSearch;
import com.wordkata.WordFindSearches.ForwardSearch;
import com.wordkata.WordFindSearches.Search;
import com.wordkata.WordFindSearches.UpForwardSearch;
import com.wordkata.WordFindSearches.UpSearch;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    
    @Test
    public void firstTestWordSize() {
    	String[] list = {"Pear","Apple","Banana","Pineapple"};
    	LetterField field = new LetterField(list);
    	assertEquals(9, field.calcLargestWordSize());
    }
    
    @Test
    public void firstTestFieldSize() {
    	String[] list = {"Pear","Apple","Banana","Pineapple"};
    	LetterField field = new LetterField(list);
    	field.calcFieldSize();
    	assertEquals(13, field.getFieldSize());
    }
    
    @Test
    public void secondTestFieldSize() {
    	String[] list = {"Pear","A","B","DC"};
    	LetterField field = new LetterField(list);
    	field.calcFieldSize();
    	assertEquals(8, field.getFieldSize());
    }
    
    
    @Test
    public void firstTestWordPosition() {
    	String[] list = {"Pear"};
    	LetterField field = new LetterField(list);
    	field.calcFieldSize();
    	int rand =field.generateRandomWordPosition("Pear");
    	assertTrue(rand <= 4);
  
    }
    
    @Test
    public void secondTestWordPosition() {
    	String[] list = {"Pear"};
    	LetterField field = new LetterField(list);
    	field.calcFieldSize();
    	int rand =field.generateRandomWordPositionCommonVector();
    	assertTrue(rand != 8 && rand >=0);
    	
    }
    
    
    @Test
    public void firstTestFindLet() {
    	char[] list = {'a', 'b','c','d','e','m'};
    	LetterFinder LF = new LetterFinder("emma");
    	int position = -1; 
    	int letter = 0;
    	for(int i=0; i<list.length;i++) {
    		int ans=LF.searchLetter(i, list,letter);
    		if(ans!=-1) {
    		position = ans;
    		}
    	}
    	assertEquals(4, position);
    	
    }
    
    @Test
    public void secondTestFindLet() {
    	char[] list = {'a', 'b','c','d','e','m'};
    	LetterFinder LF = new LetterFinder("emma");
    	int [] positions = new int[4]; 
    	int letter = 0;
    	for(int i=0; i<list.length;i++) {
    		int ans=LF.searchLetter(i, list,letter);
    		if(ans!=-1) {
    		positions[letter] = ans;
    		letter++;
    		}
    	}
    	assertEquals(4, positions[0]);
    }
    
    
    
    @Test
    public void thirdTestFindLet() {
    	char[] list = {'a', 'b','c','d','e','m'};
    	LetterFinder LF = new LetterFinder("emma");
    	int [] positions = new int[4]; 
    	int letter = 0;
    	for(int i=0; i<list.length;i++) {
    		int ans=LF.searchLetter(i, list,letter);
    		if(ans!=-1) {
    		positions[letter] = ans;
    		letter++;
    		}
    	}
    	assertEquals(5, positions[1]);
    }
    
    @Test //search letters adds to 'found letters'
    public void fourthTestFindLet() {
    	char[] list = {'a', 'b','c','d','e','m'};
    	LetterFinder LF = new LetterFinder("emma");
    	int [] positions = new int[4]; 
    	int letter = 0;
    	for(int i=0; i<list.length;i++) {
    		int ans=LF.searchLetter(i, list,letter);
    		if(ans!=-1) {
    		positions[letter] = ans;
    		LF.addLetter(list[ans], letter);
    		letter++;
    		}
    	}
    	assertEquals('e', LF.getFoundLetters()[0]);
    }
    
   
    
    @Test //Search Letter finds all letters
    public void sixthTestFindLet() {
    	char[] list = {'a', 'b','c','d','e','m','m','a'};
    	LetterFinder LF = new LetterFinder("emma");
    	int [] positions = new int[LF.getLetters().length]; 
    	int letter = 0;
    	for(int i=0; i<list.length;i++) {
    		int ans=LF.searchLetter(i, list,letter);
    		if(ans!=-1) {
	    		positions[letter] = ans;
	    		LF.addLetter(list[ans], letter);
	    		letter++;
    		}
    	}
    	assertEquals('a', LF.getFoundLetters()[3]);
    }
    
    @Test //Check Letters True
    public void seventhTestFindLet() {
    	char[] list = {'a', 'b','c','d','e','m','m','a'};
    	LetterFinder LF = new LetterFinder("emma");
    	int [] positions = new int[LF.getLetters().length]; 
    	int letter = 0;
    	for(int i=0; i<list.length;i++) {
    		int ans=LF.searchLetter(i, list,letter);
    		if(ans!=-1) {
    		positions[letter] = ans;
    		LF.addLetter(list[ans], letter);
    		letter++;
    		}
    	}
    	assertTrue(LF.checkLetters());
    }
    
    @Test //check Letters False
    public void eightTestFindLet() {
    	char[] list = {'a', 'b','c','d','e','m','a'};
    	LetterFinder LF = new LetterFinder("emma");
    	int [] positions = new int[LF.getLetters().length]; 
    	int letter = 0;
    	for(int i=0; i<list.length;i++) {
    		int ans=LF.searchLetter(i, list,letter);
    		if(ans!=-1) {
    		positions[letter] = ans;
    		LF.addLetter(list[ans], letter);
    		letter++;
    		}
    	}
    	assertFalse(LF.checkLetters());
    }
    
    
    @Test //Clear Letters
    public void ninthTestFindLet() {
    	char[] list = {'a', 'b','c','d','e','m','m','t','a'};
    	LetterFinder LF = new LetterFinder("emma");
    	int [] positions = new int[LF.getLetters().length]; 
    	int letter = 0;
    	for(int i=0; i<list.length;i++) {
    		int ans=LF.searchLetter(i, list,letter);
    		if(ans!=-1) {
    		positions[letter] = ans;
    		LF.addLetter(list[ans], letter);
    		letter++;
    		} else if (LF.getFoundLetters().length!=0) {
    			LF.clearLetters();
    		}
    	}
    	assertFalse(LF.checkLetters());
    }
    
    
   
    
    
  @Test //first test Forward
  public void firstTestWord() {
	char[] list = {'a', 'b','c','d','e','m','m','a'};
  	LetterFinder LF = new LetterFinder("emma");
  	int [] positions = LF.wordForward(list, 4);
 
  	assertEquals(4, positions[0]);
  }
  
  @Test //assert failure
  public void secondTestWord() {
	char[] list = {'a', 'b','c','d','e','m','m', 't','d'};
  	LetterFinder LF = new LetterFinder("emma");
  	int [] positions = LF.wordForward(list, 4);
  	
  	assertTrue(positions[0]== positions[positions.length-1]);
  	//^Way to test if the array has any content
  }
  
  
  @Test //test that it breaks out of the loop
  public void thirdTestWord() {
	char[] list = {'a', 'b','c','d','e','m','m','a','t'};
  	LetterFinder LF = new LetterFinder("emma");
  	int [] positions = LF.wordForward(list, 4);
  	/*for (int p: positions) {
  		System.out.println(p);
  	}*/
  	assertFalse(positions[0]== positions[positions.length-1]);
  }
  
  @Test //test inside a for loop
  public void fourthTestWord() {
	char[] list = {'a', 'b','c','d','e','m','m','a','t'};
  	LetterFinder LF = new LetterFinder("emma");
	int [] positions = new int[LF.getLetters().length];
	int count=0;
  	for(int i = 0; i<list.length;i++) {
  
  		if(LF.checkLetters()!=true) {
  		positions = LF.wordForward(list, i);
  		} else {
  			break;
  		}
		
  	}
  	/*for (int p: positions) {
  		System.out.println(p);
  	}*/
  	assertFalse(positions[0]== positions[positions.length-1]);
  }
  
  
  @Test //fail inside a for loop
  public void fifthTestWord() {
	char[] list = {'a', 'b','c','d','e','m','m','d', 'a','t'};
  	LetterFinder LF = new LetterFinder("emma");
	int [] positions = new int[LF.getLetters().length];
	int count=0;
  	for(int i = 0; i<list.length;i++) {
  
  		if(LF.checkLetters()!=true) {
  		positions = LF.wordForward(list, i);
  		} else {
  			break;
  		}
		
  	}
  	/*for (int p: positions) {
  		System.out.println(p);
  	}*/
  	assertTrue(positions[0]== positions[positions.length-1]);
  }
  
  
  @Test //word backwards
  public void firstTestBackwards() {
		char[] list = {'a', 'b','c','d','a','m','m','e'};
	  	LetterFinder LF = new LetterFinder("emma");
	  	int [] positions = LF.wordBackward(list, 7);
	 
	  	assertEquals(4, positions[3]);
  }
  
  @Test //backwards failure
  public void secondTestBackwards() {
		char[] list = {'a', 'b','c','d','a', 'f','m','m','e'};
	  	LetterFinder LF = new LetterFinder("emma");
	  	int [] positions = LF.wordBackward(list, 8);
	 
	  	assertTrue(positions[0]== positions[positions.length-1]);
  }
  
  @Test //backwards inside loop
  public void thirdTestBackwards() {
	  char[] list = {'a', 'b','c','a','m','m','e', 'a','t'};
	  	LetterFinder LF = new LetterFinder("emma");
		int [] positions = new int[LF.getLetters().length];
		int count=0;
	  	for(int i = 0; i<list.length;i++) {
	  		if(LF.checkLetters()!=true) {
	  		positions = LF.wordBackward(list, i);
	  		} else {
	  			break;
	  		}	
	  	}
	  	for (int p: positions) {
	  	//	System.out.println(p);
	  	}
	  
		assertEquals(6, positions[0]);
  }
  
  
  @Test //First Letter anchor
  public void firstFirstLetter() {
	  char[] list = {'a','b','c','a','m','m','e', 'a','t'};
	  	LetterFinder LF = new LetterFinder("emma");
		int [] positions = new int[LF.getLetters().length];
		int count=0;
	  	for(int i = 0; i<list.length;i++) {
	  		int firstLetter = LF.firstLetter(i, list);
	  		if (firstLetter!=-1) {
	  			
	  		if(LF.checkLetters()!=true) {
	  		positions = LF.wordBackward(list, firstLetter);
	  		} else {
	  			break;
	  		}	
	  		}
	  	}
	  	for (int p: positions) {
	  	//	System.out.println(p);
	  	}
	  
		assertEquals(6, positions[0]);
  }
  
  @Test
  public void scrollField() {
	  char[][] list={{'1', '2'},
			  {'a','b','c', 'e','m','m','a'},{'d','g','c'}};
	  Search search = new ForwardSearch(list,"emma");
	search.findList(2);
	 char[] newList = ((ForwardSearch) search).getList();
	 //System.out.println(((ForwardSearch) search).getList());
	  char[] check = {'d','g','c'};
	//  System.out.println(check);
	 assertTrue(newList[2]==check[2]);
  }
  
  
  @Test
  public void SearchObjectFirstLetter() {
	  char[][] list={{'1', '2'},
			  {'a','b','c', 'e','m','m','a'},{'d','g','c'}};
	  Search search = new ForwardSearch(list,"emma");
	 
	 search.findFirstLetter(list[1],0);
	// System.out.println(search.getYpos());
	 assertEquals(3,search.getXpos());
  }
  
  
  
  @Test
  public void forwardSearchObjectFirstPos() {
	  char[][] list={{'1'},{'a','b','c', 'e','m','m','a'}};
	  Search search = new ForwardSearch(list,"emma");
	 // System.out.println(search.getLetters());

	  int[] positions = ((ForwardSearch) search).search(1);
	  
	  assertEquals(3,positions[0]);
  }
  
  @Test
  public void forwardSearchObjectSecondPos() {
	  char[][] list={{'1'},{'a','b','c', 'e','m','m','a'}};
	  Search search = new ForwardSearch(list,"emma");
	  

	  int[] positions = ((ForwardSearch) search).search(1);
	  
	  
	  assertEquals(6,positions[1]);
  }
  
  @Test
  public void forwardSearchObjectFail() {
	  char[][] list={{'1'},{'a','b','c', 'e','m','a'}};
	  Search search = new ForwardSearch(list,"emma");
	 

	  int[] positions = ((ForwardSearch) search).search(1);
	  
	  assertEquals(-1,positions[0]);
  }
  
  @Test
  public void forwardSearchObjectSecondPass() {
	  char[][] list={{'1'},{'a','e','m','b','c','e','m','m','a'}};
	  Search search = new ForwardSearch(list,"emma");
	 // System.out.println(search.getLetters());

	  int[] positions = ((ForwardSearch) search).search(1);
	  
	  assertEquals(5,positions[0]);
  }
  
  @Test
  public void forwardSearchObjectStringCoords() {
	  char[][] list={{'1'},{'a','e','m','b','c','e','m','m','a'}};
	  Search search = new ForwardSearch(list,"emma");
	 // System.out.println(search.getLetters());

	  int[] positions = ((ForwardSearch) search).search(1);
	  String [] coords = search.givePositions(positions[0], search.getYpos(), positions[1], search.getYpos());
	/*
	  for(String c: coords) {
	  System.out.println(c);
	}
	  */
	  
	  assertEquals("5,1",coords[0]);
  }
  
  
  @Test
  public void backwardSearchFirstPos() {
	  char[][] list={{'1'},{'a','b','c', 'a','m','m','e','t'}};
	  Search search = new BackwardSearch(list,"emma");
	 // System.out.println(search.getLetters());

	  int[] positions = ((BackwardSearch) search).search(1);
	  
	  assertEquals(6,positions[0]);
  }
  
  @Test
  public void backwardSearchSecondPos() {
	  char[][] list={{'1'},{'a','b','c', 'a','m','m','e','t'}};
	  Search search = new BackwardSearch(list,"emma");
	 // System.out.println(search.getLetters());

	  int[] positions = ((BackwardSearch) search).search(1);
	  
	  assertEquals(3,positions[1]);
  }
  
  @Test
  public void backwardSearchObjectSecondPass() {
	  char[][] list={{'1'},{'a','m','e','b','c','a','m','m','e','t'}};
	  Search search = new BackwardSearch(list,"emma");
	 // System.out.println(search.getLetters());

	  int[] positions = ((BackwardSearch) search).search(1);
	  
	  assertEquals(8,positions[0]);
  }
  
  
  @Test
  public void backwardSearchObjectFail() {
	  char[][] list={{'a','m','e','b'},{'a','m','e','b'},{'a','m','e','b','c','a','m','e','t'}};
	  Search search = new BackwardSearch(list,"emma");
	 // System.out.println(search.getLetters());
	  int[] positions = ((BackwardSearch) search).search(1);
	  
	  assertEquals(-1,positions[0]);
  }
  
  
  @Test
  public void upSearchObjectFirstTest() {
	  char[][]list= {
			  {'a','m','a','b'},
			  {'a','m','m','b'},
	  		  {'a','m','e','b'}
	  };
	  
	  Search search = new UpSearch(list,"ema");
	  
	  int[] positions = ((UpSearch) search).search(2);
	  
	  String [] coords = search.givePositions(search.getXpos(),positions[0], search.getXpos(),positions[1]);
		/*	
	  for(String c: coords) {
	  System.out.println(c);
	}
	  */
	  assertEquals("2,0",coords[1]);
	  
  }
  
  @Test
  public void upSearchObjectSecondTest() {
	  char[][]list= {
			  {'a','m','a','b'},
			  {'a','m','m','b'},
	  		  {'a','m','m','b'},
			  {'a','e','e','b'}
	  };
	  
	  Search search = new UpSearch(list,"emma");
	  
	  int[] positions = ((UpSearch) search).search(3);
	  
	  String [] coords = search.givePositions(search.getXpos(),positions[0], search.getXpos(),positions[1]);
		/*
	  for(String c: coords) {
	  System.out.println(c);
	}
	  */
	  assertEquals("2,0",coords[1]);
	  
  }
    

  @Test
  public void upSearchObjectThirdTest() {
	  char[][]list= {
			  {'a','d','a','b'},
			  {'a','m','a','b'},
			  {'a','m','m','b'},
	  		  {'a','m','m','b'},
			  {'a','e','e','b'}
	  };
	  
	  Search search = new UpSearch(list,"emma");
	  
	  int[] positions = ((UpSearch) search).search(4);
	   
	  String [] coords = search.givePositions(search.getXpos(),positions[0], search.getXpos(),positions[1]);
		/*
	  for(String c: coords) {
	  System.out.println(c);
	}
	  */
	  assertEquals("2,1",coords[1]);
	  
  }
  
  @Test
  public void upSearchObjectFailTest() {
	  char[][]list= {
			  {'a','d','a','b'},
			  {'a','m','d','b'},
			  {'a','m','m','b'},
	  		  {'a','m','m','b'},
			  {'a','e','e','b'}
	  };
	  
	  Search search = new UpSearch(list,"emma");
	  
	  int[] positions = ((UpSearch) search).search(4);
	    
	  assertEquals(-1,positions[0]);
	  
  }
    

  @Test
  public void downSearchObjectFirstTest() {
	  char[][]list= {
			  {'a','m','e','b'},
			  {'a','m','m','b'},
	  		  {'a','m','m','b'},
			  {'a','e','a','b'}
	  };
	  
	  Search search = new DownSearch(list,"emma");
	  
	  int[] positions = ((DownSearch) search).search(0);
	  
	  String [] coords = search.givePositions(search.getXpos(),positions[0], search.getXpos(),positions[1]);
		/*
	  for(String c: coords) {
	  System.out.println(c);
	}
	 */ 
	  assertEquals("2,0",coords[0]);
	  
  }
    
  

  @Test
  public void downSearchObjectSecondTest() {
	  char[][]list= {
			  {'e','e','e','b'},
			  {'a','m','m','b'},
	  		  {'a','m','m','b'},
			  {'a','e','a','b'}
	  };
	  
	  Search search = new DownSearch(list,"emma");
	  
	  int[] positions = ((DownSearch) search).search(0);
	  
	  String [] coords = search.givePositions(search.getXpos(),positions[0], search.getXpos(),positions[1]);
		/*
	  for(String c: coords) {
	  System.out.println(c);
	}
	  */
	  assertEquals("2,0",coords[0]);
	  
  }
  

  @Test
  public void downSearchObjectFailTest() {
	  char[][]list= {
			  {'e','e','e','b'},
			  {'a','m','m','b'},
			  {'a','e','a','b'}
	  };
	  
	  Search search = new DownSearch(list,"emma");
	  
	  int[] positions = ((DownSearch) search).search(0);
	  
	  String [] coords = search.givePositions(search.getXpos(),positions[0], search.getXpos(),positions[1]);
		/*
	  for(String c: coords) {
	  System.out.println(c);
	}
	  */
	  assertEquals(-1,positions[0]);
	  
  }
  
  @Test
  public void UpFowardSearchFirstTest() {
	  char[][]list= {
			  {'e','e','e','a'},
			  {'a','c','m','b'},
	  		  {'a','m','d','b'},
			  {'e','e','x','b'}
	  };
	  
	  Search search = new UpForwardSearch(list,"emma");
	  
	  int[] positions = ((UpForwardSearch) search).search(3);
	 /* 
	  String [] coords = search.getCoordinates();
	  for(String c: coords) {
	  System.out.println(c);
	}
	  */
	  assertEquals(0,positions[0]);
  }
  
  @Test
  public void UpFowardSearchSecondTest() {
	  char[][]list= {
			  {'e','e','e','d','a'},
			  {'a','m','m','m','c'},
	  		  {'a','m','m','b','f'},
			  {'e','e','x','b','t'}, 
	  };
	  
 Search search = new UpForwardSearch(list,"emma");
	  
	  int[] positions = ((UpForwardSearch) search).search(3);
	 /* 
	  String [] coords = search.getCoordinates();
	  for(String c: coords) {
	  System.out.println(c);
	}
	  */
	  assertEquals(1,positions[0]);
  }
  
  @Test
  public void UpFowardSearchFailTest() {
	  char[][]list= {
			  {'e','e','e','d','c'},
			  {'a','m','m','m','c'},
	  		  {'a','m','m','b','f'},
			  {'e','e','x','b','t'} 
	  };
	  
	  Search search = new UpForwardSearch(list,"emma");
	  
	  int[] positions = ((UpForwardSearch) search).search(3);
/*
	  String [] coords = search.getCoordinates();
	  for(String c: coords) {
	  System.out.println(c);
	}

	  for(int p:positions) {
		  System.out.println(p);
	  }
	  System.out.println(search.getXpos());
	  */
	  assertEquals(-1,positions[0]);
  }
  
  @Test
  public void UpFowardSearchFailSecondTest() {
	  char[][]list= {
			  {'e','e','e','d','m'},
			  {'a','m','m','m','c'},
	  		  {'a','m','e','b','f'},
			  {'e','e','x','b','t'} 
	  };
	  
	  Search search = new UpForwardSearch(list,"emma");
	  
	  int[] positions = ((UpForwardSearch) search).search(2);
/*
	  String [] coords = search.getCoordinates();
	  for(String c: coords) {
	  System.out.println(c);
	}

	  for(int p:positions) {
		  System.out.println(p);
	  }
	  System.out.println(search.getXpos());
	  */
	  assertEquals(-1,positions[0]);
  }
  
  @Test 
  public void DownForwardSearchFirstTest() {
	  
	  char[][]list= {
			  {'e','e','e','d','e'},
			  {'a','m','c','n','c'},
	  		  {'a','t','m','b','f'},
			  {'a','e','x','a','t'}, 
	  };
	  
 Search search = new DownForwardSearch(list,"emma");
	  
	  int[] positions = ((DownForwardSearch) search).search(0);
	  
	  
	  String [] coords = search.getCoordinates();
	  for(String c: coords) {
	  System.out.println(c);
	}

	  for(int p:positions) {
		  System.out.println(p);
	  }
	//  System.out.println(search.getXpos());
	  
	  
	  assertEquals(0,positions[0]);
	  
  }
  
  
  @Test 
  public void DownForwardSearchSecondTest() {
	  
	  char[][]list= {
			  {'e','e','e','d','e'},
			  {'a','m','m','n','c'},
	  		  {'a','t','m','m','f'},
			  {'a','e','x','c','a'}, 
	  };
	  
 Search search = new DownForwardSearch(list,"emma");
	  
	  int[] positions = ((DownForwardSearch) search).search(0);
	  
	  
	  String [] coords = search.getCoordinates();
	  for(String c: coords) {
	  System.out.println(c);
	}

	  for(int p:positions) {
		  System.out.println(p);
	  }
	//  System.out.println(search.getXpos());
	  
	  
	  assertEquals(1,positions[0]);
	  
  }
  

  @Test 
  public void DownForwardSearchFailTest() {
	  
	  char[][]list= {
			  {'e','e','e','d','e'},
			  {'a','m','m','n','c'},
	  		  {'a','t','m','m','f'},
			  {'a','e','x','c','t'}, 
	  };
	  
 Search search = new DownForwardSearch(list,"emma");
	  
	  int[] positions = ((DownForwardSearch) search).search(0);
	  
	  /*
	  String [] coords = search.getCoordinates();
	  for(String c: coords) {
	  System.out.println(c);
	}

	  for(int p:positions) {
		  System.out.println(p);
	  }
	  */
	//  System.out.println(search.getXpos());
	  
	  
	  assertEquals(-1,positions[0]);
	  
  }
  
}
