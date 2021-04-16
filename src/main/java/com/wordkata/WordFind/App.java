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
   			 {'p','u','n','f','e','n','t','a','e','z','w','e','m','y','m'},
   			 {'w','e','m','a','l','i','o','c','m','c','w','u','j','n','q'},
   			 {'r','m','t','d','i','n','t','g','m','r','k','r','g','y','i'},
   			 {'i','h','j','e','y','k','p','e','d','n','w','j','z','g','o'},
   			 {'g','u','o','d','r','f','q','l','f','u','i','w','p','e','g'},
   			 {'o','s','n','t','d','p','t','b','g','z','w','b','w','r','y'},
   			 {'y','n','l','d','l','o','e','e','m','m','a','m','o','u','l'},
   			 {'t','j','d','x','t','n','j','u','h','o','w','d','a','s','r'},
   			 {'k','c','k','d','r','i','w','h','k','n','w','o','b','k','e'},
   			 {'e','o','p','e','q','i','d','l','z','l','w','i','r','p','w'},
   			 {'y','e','j','w','v','f','n','o','i','k','n','y','n','e','k'},
   			 {'m','g','v','d','b','q','t','k','q','h','w','w','w','l','v'},
   			 {'w','m','r','y','w','u','z','e','z','x','w','t','s','f','s'},
   			 {'u','z','q','j','t','w','c','f','j','r','w','g','d','j','a'},
   			 {'r','s','a','h','r','b','t','n','a','e','w','q','v','d','h'}
   	  	};
   	  String[] words = {"Emma", "Peter", "Nibs","Fred"};
   	  WordSearch search = new WordSearch(words, list);
	  String[] foundWords = search.search();
	  for(int i=0;i<foundWords.length;i++) {
	  System.out.println(foundWords[i]);
	  }
      
    }
}
