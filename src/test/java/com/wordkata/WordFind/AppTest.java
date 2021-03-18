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
    	LetterFinder LF = new LetterFinder('c');
    	assertEquals(2, LF.search(list));
    }
    
    @Test
    public void secondTestLetterFind() {
    	char[] list = {'a', 'b','c','d','e'};
    	LetterFinder LF = new LetterFinder('z');
    	assertEquals(-1, LF.search(list));
    }
    
    @Test
    public void thirdTestLetterFind() {
    	char[] list = {'a', 'b','c','d','e'};
    	LetterFinder LF = new LetterFinder('c');
    	int ans = LF.search(list);
    	assertFalse(ans==0 );
    }
    
}
