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
    	assertEquals(2, LF.searchFirst(list,0));
    }
    
    @Test
    public void secondTestLetterFind() {
    	char[] list = {'a', 'b','c','d','e'};
    	LetterFinder LF = new LetterFinder("z");
    	assertEquals(-1, LF.searchFirst(list,0));
    }
    
    @Test
    public void thirdTestLetterFind() {
    	char[] list = {'a', 'b','c','d','e'};
    	LetterFinder LF = new LetterFinder("c");
    	int ans = LF.searchFirst(list,0);
    	assertFalse(ans==0 );
    }
    
    @Test
    public void fourthTestLetterFind() {
    	LetterFinder LF = new LetterFinder("emma");
    	char[] list = {'a', 'b','c','d','e'};
    	assertEquals(4, LF.searchFirst(list,0));
    	
    }
    
    @Test
    public void firstTestNextLetterFind() {
    	LetterFinder LF = new LetterFinder("emma");
    	char[] list = {'a', 'b','c','e','m', 'm','a','t'};
    	assertEquals(4, LF.searchNext(list, 3));
    }
    
    @Test
    public void secondTestNextLetterFind() {
    	LetterFinder LF = new LetterFinder("emma");
    	char[] list = {'a', 'b','c','e','m', 'm','a','t'};
    	assertEquals(4, LF.searchNext(list, LF.searchFirst(list,0)));
    }
    
    @Test
    public void firstTestPrevLetterFind() {
    	LetterFinder LF = new LetterFinder("emma");
    	char[] list = {'a', 'b','c','a', 'm', 'm', 'e','t'};
    	assertEquals(5, LF.searchPrev(list, LF.searchFirst(list,0)));
    }
    
    @Test
    public void secondTestPrevLetterFind() {
    	LetterFinder LF = new LetterFinder("emma");
    	char[] list = {'a', 'b','c','a', 'm', 'm', 'e'};
    	assertEquals(5, LF.searchPrev(list, LF.searchFirst(list,0)));
    }
    
    @Test
    public void fifthTestNextLetterFind() {
    	LetterFinder LF = new LetterFinder("emma");
    	char[] list = {'e','a', 'b','c','a', 'm', 'm', 'e'};
    	assertEquals(-1, LF.searchNext(list, 0));
    }
    
    
    @Test
    public void sixthTestNextLetterFind() {
    	LetterFinder LF = new LetterFinder("emma");
    	char[] list = {'e'};
    	assertEquals(-1, LF.searchNext(list, LF.searchFirst(list,0)));
    }
    
    @Test
    public void firstTestLastLetterFind() {
    	LetterFinder LF = new LetterFinder("emma");
    	char[] list = {'e','a', 'b','c','d'};
    	assertEquals(1, LF.searchLast(list));	
    }
    
    @Test
    public void secondTestLastLetterFind() {
    	LetterFinder LF = new LetterFinder("emma");
    	char[] list = {'e', 'b','c','d'};
    	assertEquals(-1, LF.searchLast(list));	
    }
    
   /*   
    @Test 
    public void firstTestWordFind() {
    	LetterFinder LF = new LetterFinder("emma");
    	char[] list = {'e', 'm','a', 'b','c','a', 'm', 'm', 'e'};
    	assertEquals(8, LF.findWord(list));
    }
    */
    @Test 
    public void secondTestWordFind() {
    	LetterFinder LF = new LetterFinder("emma");
    	char[] list = {'e','m','m','a', 'b','c','a', 'm', 'e'};
    	assertEquals(0, LF.findWord(list));
    }
    
    
}
