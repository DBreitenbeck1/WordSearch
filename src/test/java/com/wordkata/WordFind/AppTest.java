package com.wordkata.WordFind;

import static org.junit.Assert.*;

import java.nio.charset.Charset;

import org.junit.Test;

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
	  		System.out.println(p);
	  	}
	  
		assertEquals(6, positions[0]);
  }
  
    
}
