//Sang Park CS 212-11C

/**
 * This class represents each word used in the WordGUI.
 * The word size is three and it holds the wordstring. This
 * class also contains one constructor and three methods, two of
 * the three being an override from the Object class.
 * The constructors sets the wordstring, isValidWord method
 * checks if a string is a valid word, the toString returns
 * the wordstring, and the compareTo compares two words based
 * on the wordstring. 
 * 
 * @author spark
 *
 */

import java.util.regex.*;

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
	 * if not, it throws an IllegalWord212Exception
	 * 
	 * @param s A type string that is being checked
	 */
	public static void isValidWord(String s){
		Pattern p;
		Matcher m;
		String WORD_PATTERN = "^[a-zA-Z]{3}$";
		p = Pattern.compile(WORD_PATTERN);
		m = p.matcher(s);
		if(!m.matches()){
			throw new IllegalWord212Exception("Invalid Word: " + s);
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
