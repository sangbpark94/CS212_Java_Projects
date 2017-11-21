//Sang Park CS 212-11C

/**
 * This class extends WordList and has a method that
 * adds a Word to the end of the WordList.
 * 
 * @author spark
 *
 */

import java.util.TreeMap;
public class SortedWordList{
	public static TreeMap<Word, Word> treemap;
	/**
	 * Constructor that creates a WordList using the super class
	 */
	public SortedWordList(){
		treemap = new TreeMap<Word, Word>(new WordComparator());
	}

	/**
	 * Inserts a word into the treemap with key and value equal 
	 * to the word
	 * 
	 * @param w A type word that is to be inserted
	 */
	public void add(Word w){
		treemap.put(w, w);
	}
	
}
