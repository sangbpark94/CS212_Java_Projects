//Sang Park CS212-11C

/**
 * This class is the nodes used in the WordList which
 * hold a Word called data and a reference to the next
 * Node called next. Also has two constructors.
 * 
 * @author spark
 *
 */

public class WordNode {
	
	//Contains a Word called data and the next WordNode called next
	protected Word data;
	protected WordNode next;
	
	/**
	 * Constructor that sets data and next to null
	 */
	public WordNode(){
		data = null;
		next = null;
	}
	
	/**
	 * Constructor that sets data to a Word called w and next to null
	 * 
	 * @param w A type word used to set data
	 */
	public WordNode(Word w){
		data = w;
		next = null;
	}

}
