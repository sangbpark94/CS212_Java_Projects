//Sang Park CS 212-11C

/**
 * This class implements a Comparator and is used by the
 * Treemap to compare two words.
 * 
 * @author spark
 */

import java.util.Comparator;

public class WordComparator implements Comparator<Word>{
	public int compare(Word a, Word b){
		return a.compareTo(b);
	}
}
