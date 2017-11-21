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
 * @author Park
 *
 */
public class Word {
	
	//Sets WORD_SIZE to 3
	private static int WORD_SIZE = 3;
	
	//Holds a string called wordstring
	private String wordstring;
	
	//A constructor that takes in a string s and sets it to wordstring
	public Word(String s){
		wordstring = s;
	}
	
	//This method checks if a string is a valid word
	public static boolean isValidWord(String s){
		
		//Checks if the size of the words is 3
		if(s.length() != WORD_SIZE)
			return (false);
		else 
			
			//Checks if each character of word is a letter
			for(int i = 0; i < WORD_SIZE; i++){
				if(!Character.isLetter(s.charAt(i)))
					return (false);
			}
		return (true);
	}
	
	//Overrides toString to return the wordstring
	public String toString(){
		return wordstring;
	}
	
	//Overrides compareTo to compare to words
	public int compareTo(Word other){
		return wordstring.compareTo(other.toString());
	}
}
