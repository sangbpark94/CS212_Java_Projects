//Sang Park CS212-11C

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * This class is the WordGUI which initializes a GUI that
 * has a grid layout with 1 row and 2 columns. It also reads
 * the words from a file and store them into 2 different lists:
 * one unsorted and one sorted. It also prints the lists onto
 * the GUI.
 * 
 * @author spark
 *
 */
public class WordGUI extends JFrame{
	
	//Contains a JFrame called myWordGUI and the TextFileInput and StringTokenizer to be used in the other methods
	private static JFrame myWordGUI;
	private static TextFileInput inFile;
	private static StringTokenizer myTokens;
	
	/**
	 * Initializes the size, location, title, layout and close operation of the GUI
	 */
	public static void initialize(){
		myWordGUI = new WordGUI();
		myWordGUI.setSize(1000, 500);
		myWordGUI.setLocation(100, 100);
		myWordGUI.setTitle("WordGUI");
		myWordGUI.setLayout(new GridLayout(1,2));
		myWordGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Reads the words from the file and stores them into 2 lists: one unsorted and one sorted
	 * 
	 * @param filename Name of file used to access the words
	 * @param unsortedlist A WordList for the unsorted words
	 * @param sortedlist A WordList for the sorted words
	 */
	public static void readWordsFromFile(String filename, WordList unsortedlist, WordList sortedlist){
		
		//Variables used in reading each line
		String line;
		inFile = new TextFileInput(filename);
		line = inFile.readLine();
		
		//As long as there is a line to read, it tokenizes the words.
		//The valid words are appended to the unsorted list and inserted into the sorted list.
		//The invalid words are printed out onto the console.
		while(line != null){
			myTokens = new StringTokenizer(line,",");
			while(myTokens.hasMoreTokens()){
				String currentToken = myTokens.nextToken();
				Word wordedToken = new Word(currentToken);
				if(wordedToken.isValidWord(currentToken)){
					unsortedlist.append(wordedToken);
					sortedlist.insert(wordedToken);
				}
				else
					System.out.println(wordedToken);
			}
			line = inFile.readLine();
		}
	}
	
	/**
	 * Takes the 2 lists and prints them onto 2 TextAreas of the GUI.
	 * 
	 * @param unsortedlist A WordList for the unsorted words
	 * @param sortedlist A WordList for the sorted words
	 */
	public static void printWordtoWordGUI(WordList unsortedlist, WordList sortedlist){
		
		//Variables used for ContentPane and TextAreas
		Container myContentPane = myWordGUI.getContentPane();
		TextArea LeftText = new TextArea();
		TextArea RightText = new TextArea();
		myContentPane.add(LeftText);
		myContentPane.add(RightText);
		
		//Sets p to the first non-dummy node of the unsorted list
		WordNode p = unsortedlist.first.next;
		
		//Appends the words onto the Left TextArea
		while(p != null){
			LeftText.append(p.data.toString() + "\n");
			p = p.next;
		}
		
		//Sets p to the first non-dummy node of the sorted list
		p = sortedlist.first.next;
		
		//Appends the words onto the Right TextArea
		while(p != null){
			RightText.append(p.data.toString() + "\n");
			p = p.next;
		}
		
		//Makes GUI visible
		myWordGUI.setVisible(true);
	}
}
