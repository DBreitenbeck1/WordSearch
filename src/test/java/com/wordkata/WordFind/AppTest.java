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
    public void firstTestLetterFind() {
    	char[] list = {'a', 'b','c','d','e'};
    	LetterFinder LF = new LetterFinder("c");
    	int position = -1; 
    	for(int i=0; i<list.length;i++) {
    		if(LF.searchFirst(i, list)!=-1) {
    		position = LF.searchFirst(i, list);
    		}
    	}
    	assertEquals(2, position);
    }
    
    @Test
    public void secondTestLetterFind() {
    	char[] list = {'a', 'b','c','d','e'};
    	LetterFinder LF = new LetterFinder("emma");
    	int position = -1; 
    	for(int i=0; i<list.length;i++) {
    		if(LF.searchFirst(i, list)!=-1) {
    		position = LF.searchFirst(i, list);
    		}
    	}
    	assertEquals(4, position);
    }
    
   
    @Test
    public void thirdTestLetterFind() {
    	char[] list = {'a', 'b','c','d'};
    	LetterFinder LF = new LetterFinder("emma");
    	int position = -1; 
    	for(int i=0; i<list.length;i++) {
    		if(LF.searchFirst(i, list)!=-1) {
    		position = LF.searchFirst(i, list);
    		}
    	}
    	assertEquals(-1, position);
    }
    
    @Test
    public void firstTestNextLetter() {
    	char[] list = {'a', 'b', 'e', 'm', 'c','d'};
    	LetterFinder LF = new LetterFinder("emma");
    	int secondPos = -1; 
    	int position = -1;
    	for(int i=0;i<list.length;i++) {
    		if(LF.searchFirst(i, list) != -1) {
    			position=LF.searchFirst(i, list);
    			if(LF.searchNext(list, position, 1) != -1) {
    				secondPos=LF.searchNext(list, position, 1);
    			}
    		}
    	}
    	
    	assertEquals(3, secondPos);	
    }
    
    
    @Test
    public void secondTestNextLetter() {
    	char[] list = {'a', 'e', 'b', 'e', 'm', 'c','d'};
    	LetterFinder LF = new LetterFinder("emma");
    	int secondPos = -1; 
    	int position = -1;
    	for(int i=0;i<list.length;i++) {
    		if(LF.searchFirst(i, list) != -1) {
    			position=LF.searchFirst(i, list);
    			if(LF.searchNext(list, position, 1) != -1) {
    				secondPos=LF.searchNext(list, position, 1);
    			}
    		}
    	}
    	
    	assertEquals(4, secondPos);	
    }
    
    
    @Test
    public void thirdTestNextLetter() {
    	char[] list = {'a', 'e', 'b', 'e', 'm', 'm', 'c','d'};
    	LetterFinder LF = new LetterFinder("emma");
    	int nextPos = -1; 
    	int position = -1;
    	int letter =1;
    	for(int i=0;i<list.length;i++) {
    		if(LF.searchFirst(i, list) != -1) {
    			position=LF.searchFirst(i, list);
    			while(LF.searchNext(list, position, letter) != -1) {
    				nextPos=LF.searchNext(list, position, letter);
    				letter++;
    				position++;
    			}
    		}
    	}
    	
    	assertEquals(5, nextPos);	
    }
    
  @Test
  public void firstTestLastLetter() {
	  char[] list = {'b','c','a','d','e'};
  	LetterFinder LF = new LetterFinder("emma");
  	int position = -1; 
  	for(int i=0; i<list.length;i++) {
  		if(LF.searchLast(i, list)!=-1) {
  		position = LF.searchLast(i, list);
  		}
  	}
  	assertEquals(2, position);
  }
  
  
  @Test
  public void secondTestLastLetter() {
	  char[] list = {'b','c','d','e','m','m'};
  	LetterFinder LF = new LetterFinder("emma");
  	int position = -1; 
  	for(int i=0; i<list.length;i++) {
  		if(LF.searchLast(i, list)!=-1) {
  		position = LF.searchLast(i, list);
  		}
  	}
  	assertEquals(-1, position);
  }
  
  @Test
  public void firstTestWord() {
	  String word="Emma";
	  WordGet WG=new WordGet("Emma");
	  
	  assertEquals("emma", WG.getWord());
  }
    
}
