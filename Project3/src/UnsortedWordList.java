//Sang Park CS 212-11C

/**
 * This class extends WordList and has a method that
 * adds a Word to the end of the WordList.
 * 
 * @author spark
 *
 */
public class UnsortedWordList extends WordList{
	
	/**
	 * Constructor that creates a WordList using the super class
	 */
	public UnsortedWordList(){
		super();
	}

	/**
	 * Adds a word to the end of the list
	 * 
	 * @param w A type word to be appended
	 */
	public void add(Word w){
		WordNode n = new WordNode(w);
		last.next = n;
		last = n;
		length++;
	}
	
}
