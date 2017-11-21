//Sang Park CS212-11C

/**
 * Project 1
 * 
 * This file creates a WordGUI, initializes it, calls the
 * readWordsFromFile method using the inputed filename, and
 * calls the printWordtoWordGUI to print the list to the
 * GUI.
 * 
 * @author Park
 *
 */
public class Project1 {
	
	//Main function
	public static void main(String[] args){
		
		//Creates a WordGUI called myWordGUI
		WordGUI myWordGUI = new WordGUI();
		
		//Initializes the Word GUI
		myWordGUI.initialize();
		
		//Calls the readWordsFromFile method with the inputed file name as a parameter
		myWordGUI.readWordsFromFile(args[0]);
		
		//Calls the printWordtoWordGUI method with the wordlist and wordlistsize as parameters.
		myWordGUI.printWordtoWordGUI(myWordGUI.wordlist, myWordGUI.wordlistsize);
	}
}
