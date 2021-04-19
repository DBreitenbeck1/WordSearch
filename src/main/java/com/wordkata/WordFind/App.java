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
   			 {'w','e','m','a','g','i','o','c','m','c','w','m','j','n','q'},
   			 {'r','g','t','d','i','i','t','g','m','r','k','o','g','y','i'},
   			 {'i','o','j','e','y','k','g','e','d','n','w','t','z','g','o'},
   			 {'g','d','o','d','r','f','q','a','f','u','i','h','p','e','g'},
   			 {'o','z','n','t','d','p','t','b','n','z','w','r','w','r','y'},
   			 {'y','i','l','d','l','o','t','e','m','m','a','a','o','u','l'},
   			 {'t','l','d','x','t','n','j','u','a','o','w','d','a','n','r'},
   			 {'k','l','k','d','r','i','w','n','k','n','w','o','i','k','e'},
   			 {'e','a','p','e','q','i','g','l','z','r','o','d','a','n','w'},
   			 {'y','e','j','w','v','u','n','o','i','k','s','y','n','e','k'},
   			 {'m','g','v','d','i','q','t','k','q','h','w','w','w','l','v'},
   			 {'w','m','r','r','w','u','z','e','z','x','w','t','s','f','s'},
   			 {'u','z','u','j','t','h','a','r','o','d','i','h','g','j','a'},
   			 {'r','s','a','h','r','b','t','n','a','e','w','q','v','d','h'}
   	  	};
   	  String[] words = {"Godzilla", "Anguirus", "Mothra","Ghidorah","Rodan",
   			  "Gigan", "Gamera"};
   	  WordSearch search = new WordSearch(words, list);
	  String[] foundWords = search.search();
	  for(int i=0;i<foundWords.length;i++) {
	  System.out.println(foundWords[i]);
	  }
      
    }
}
