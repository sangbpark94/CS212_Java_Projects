//Sang Park CS 212-11C

/**
 * This class represents each word used in the WordGUI.
 * The word size is three and it holds the wordstring. This
 * class also contains 1 constructor and three methods, two of
 * the three being an override from the Object class.
 * The constructors sets the wordstring, isValidWord method
 * checks if a string is a valid word, the toString returns
 * the wordstring, and the compareTo compares two words based
 * on the wordstring. 
 * 
 * @author spark
 *
 */
public class Word {
	
	//Creates variables for size of word and the wordstring
	private static int WORD_SIZE = 3;
	private String wordstring;
	
	/**
	 * Constructor creates a Word with a set wordstring
	 * 
	 * @param s A type string used to set wordstring
	 */
	public Word(String s){
		isValidWord(s);
		wordstring = s;
	}
	
	/**
	 * Checks if a string is valid, meaning it is three letters and
	 * if not, it throws an IllegalWordException
	 * 
	 * @param s A type string that is being checked
	 */
	public static void isValidWord(String s){
		
		//Checks size of word
		if(s.length() != WORD_SIZE)
			throw new IllegalWordException("Invalid Word: " + s);
		
		//Checks if characters in word are letters
		else
			for(int i = 0; i < WORD_SIZE; i++){
				if(!Character.isLetter(s.charAt(i)))
					throw new IllegalWordException("Invalid Word: " + s);
			}
	}
	
	/**
	 * Overrides toString to return the wordstring
	 * 
	 * @return A type string that returns the wordstring
	 */
	public String toString(){
		return wordstring;
	}
	
	/**
	 * Overrides compareTo so it compares the wordstrings
	 * 
	 * @param other A type word that is the word being compared to
	 * @return Returns a type integer using compareTo in the String class
	 */
	public int compareTo(Word other){
		return wordstring.compareTo(other.toString());
	}
}
