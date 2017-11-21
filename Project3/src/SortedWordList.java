//Sang Park CS 212-11C

/**
 * This class extends WordList and has a method that
 * adds a Word to the end of the WordList.
 * 
 * @author spark
 *
 */
public class SortedWordList extends WordList{
	
	/**
	 * Constructor that creates a WordList using the super class
	 */
	public SortedWordList(){
		super();
	}

	/**
	 * Inserts a word into the right location in the list
	 * so that the list remains in alphabetical order.
	 * 
	 * @param w A type word that is to be inserted
	 */
	public void add(Word w){
		WordNode p = first;
		WordNode q = first.next;
		WordNode i = new WordNode(w);
		while(q != null && (q.data).compareTo(w) < 0){
			p = p.next;
			q = q.next;
		}
		p.next = i;
		i.next = q;
	}
	
}
