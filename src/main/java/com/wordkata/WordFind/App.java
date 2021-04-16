package com.wordkata.WordFind;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	char[][]list= {
   			  {'p','d','m','d','e','n'},
   			  {'e','a','m','m','c','i'},
   	  		  {'t','c','m','m','f','b'},
   			  {'e','a','x','a','t','s'}, 
   			  {'r','t','c','i','f','g'}
   	  	};
   	  String[] words = {"Emma", "Peter", "Nibs","Fred"};
   	  WordSearch search = new WordSearch(words, list);
	  String[] foundWords = search.search();
	  for(int i=0;i<foundWords.length;i++) {
	  System.out.println(foundWords[i]);
	  }
      
    }
}
