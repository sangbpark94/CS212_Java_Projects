//Sang Park CS 212-11C

/**
 * This is an abstract class which stores WordNodes 
 * into a link list and contains one constructor.
 * 
 * @author spark
 *
 */
public abstract class WordList {
	
	//Contains the first node, last node, and the length of the list
	protected WordNode first;
	protected WordNode last;
	protected int length;
	
	/**
	 * Constructor that initializes the first and last node to reference
	 * a dummy node and sets length to 0
	 */
	public WordList(){
		WordNode ln = new WordNode();
		first = ln;
		last = ln;
		length = 0;
	}
	
}
