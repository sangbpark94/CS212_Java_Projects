//Sang Park CS212-11C

/**
 * Project 1
 * 
 * This class represents each word used in the WordGUI.
 * The word size is 3 and it holds the wordstring. This
 * class also contains 1 constructor and 3 methods, 2 of
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
	
	//Creats variables for size of word and the wordstring
	private static int WORD_SIZE = 3;
	private String wordstring;
	
	/**
	 * Constructor creates a Word with a set wordstring
	 * 
	 * @param s The string used to set wordstring
	 */
	public Word(String s){
		wordstring = s;
	}
	
	/**
	 * Checks if a string is valid, meaning it is 3 letters
	 * 
	 * @param s The string being checked.
	 * @return Returns true if valid and false otherwise
	 */
	public static boolean isValidWord(String s){
		
		//Checks size of word
		if(s.length() != WORD_SIZE)
			return (false);
		
		//Checks if characters in word are letters
		else
			for(int i = 0; i < WORD_SIZE; i++){
				if(!Character.isLetter(s.charAt(i)))
					return (false);
			}
		return (true);
	}
	
	/**
	 * Overrides toString to return the wordstring
	 * 
	 * @return Returns the wordstring
	 */
	public String toString(){
		return wordstring;
	}
	
	/**
	 * Overrides compareTo so it compares the wordstrings
	 * 
	 * @param other The word being compared to
	 * @return Returns an integer using compareTo in String
	 */
	public int compareTo(Word other){
		return wordstring.compareTo(other.toString());
	}
}
