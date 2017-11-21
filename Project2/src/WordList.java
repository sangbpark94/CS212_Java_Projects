//Sang Park CS212-11C

/**
 * This class is a linked list that store WordNodes. 
 * It has the ability to create a WordList, append a 
 * word to the list, and insert a word to the list.
 * 
 * @author spark
 *
 */
public class WordList {
	
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
	
	/**
	 * Adds a word to the end of the list
	 * 
	 * @param w The word to be appended
	 */
	public void append(Word w){
		WordNode n = new WordNode(w);
		last.next = n;
		last = n;
		length++;
	}
	
	/**
	 * Inserts a word into the right location in the list
	 * so that the list remains in alphabetical order.
	 * 
	 * @param w The word to be inserted
	 */
	public void insert(Word w){
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
