package com.wordkata.WordFind;

import static org.junit.Assert.*;

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
    	assertEquals(9, field.calcWordSize());
    }
    
    
    public void firstTestFieldSize() {
    	String[] list = {"Pear","Apple","Banana","Pineapple"};
    	LetterField field = new LetterField(list);
    	field.calcFieldSize();
    	assertEquals(13, field.getFieldSize());
    }
}
