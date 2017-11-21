//Sang Park CS212-11C

/**
 * This class contains the main method of the program
 * which creates two WordLists, one unsorted and one sorted
 * and calls the initialize, readWordsFromFile and
 * printWordtoWordGUI methods in the WordGUI class.
 * 
 * @author spark
 *
 */
public class Project2 {
	
	public static void main(String[] args){
		
		//Creates two WordLists for the unsorted and sorted Words
		WordList unsorted = new WordList();
		WordList sorted = new WordList();
	
		//Creates a WordGUI and calls its 3 methods to initialize, read and print the WordLists
		WordGUI myWordGUI = new WordGUI();
		myWordGUI.initialize();
		myWordGUI.readWordsFromFile(args[0], unsorted, sorted);
		myWordGUI.printWordtoWordGUI(unsorted, sorted);
	
	}
}
