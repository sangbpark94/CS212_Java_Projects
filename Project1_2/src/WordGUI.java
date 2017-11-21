//Sang Park CS212-11C

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Project 1
 * 
 * This class holds the components of the WordGUI. 
 * It has the ability to initialize a Grid Layout with
 * one row and two columns, a set size, location, and title. 
 * The readWordsFromFile method checks reads from a file 
 * and stores the valid words into an array of words using
 * a String Tokenizer. It also outputs the invalid words.
 * The other method printWordtoWordGUI takes a list of words
 * and outputs them onto a Grid, the left column being the
 * order of the words found in the list and the right column
 * being the words in alphabetical order.
 * 
 * @author Park
 *
 */

public class WordGUI extends JFrame{
	
	//Creates a JFrame called myDateGUI
	private static JFrame myWordGUI;
	
	//Creates text file input called inFile
	private static TextFileInput inFile;
	
	//Initializes wordlist size to 0
	public static int wordlistsize = 0;
	
	//Initializes the wordlist to an array of words size 100
	public static Word[] wordlist = new Word[100];
	
	//Creates a String Tokenizer called myTokens
	private static StringTokenizer myTokens;
	
	//This method initializes size, location, title, layout, and close operation
	public static void initialize(){
		myWordGUI = new WordGUI();
		myWordGUI.setSize(1000, 500);
		myWordGUI.setLocation(100, 100);
		myWordGUI.setTitle("WordGUI");
		myWordGUI.setLayout(new GridLayout(1,2));
		myWordGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//This method reads words from file, tokenizes it into an array of words, and prints invalid words.
	public static void readWordsFromFile(String filename){
		
		//Creates string called line
		String line;
		
		//Sets inFile to be a Text File Input of the name of the file
		inFile = new TextFileInput(filename);
		
		//Initializes line to the first line read
		line = inFile.readLine();
		
		//As long as there is a line
		while(line != null){
			
			//Tokenizes the line into myTokens
			myTokens = new StringTokenizer(line,",");
			
			//As long as there is more tokens
			while(myTokens.hasMoreTokens()){
				
				//Creates a string called to store the next token
				String currentToken = myTokens.nextToken();
				
				//Turns string into a word
				Word wordedToken = new Word(currentToken);
				
				//If word is valid
				if(wordedToken.isValidWord(currentToken))
					
					//Add the word to wordlist and increment the wordlistsize
					wordlist[wordlistsize++] = wordedToken;
				
				//If invalid word
				else
					//Print word
					System.out.println(wordedToken);
			}
			
			//Read next line
			line = inFile.readLine();
		}
	}
	
	//This method prints a list of words to grid layout
	public static void printWordtoWordGUI(Word[] list, int listsize){
		
		//Creates a content pane
		Container myContentPane = myWordGUI.getContentPane();
		
		//Creates text areas
		TextArea LeftText = new TextArea();
		TextArea RightText = new TextArea();
		
		//Adds text areas to content pane
		myContentPane.add(LeftText);
		myContentPane.add(RightText);
		
		//Loops from 0 to listsize-1
		for(int i = 0; i < listsize; i++)
			
			//Adds each word from list to the left text area
			LeftText.append(list[i]+"\n");
		
		//Creates a list of words called sortedlist of size 100
		Word[] sortedlist = new Word[100];
		
		//Sets sortedlist to equal wordlist
		sortedlist = wordlist;
		
		//Implements selection sort
		//Loops from 0 to listsize-1
		for(int i = 0; i < listsize; i++){
			
			//Sets index equal to i
			int index = i;
			
			//Loops from i+1 to listsize-1
			for(int j = i + 1; j < listsize; j++)
				
				//If the jth element of sortedlist is lower than the index element of sorted list
				if(sortedlist[j].compareTo(sortedlist[index]) < 0)
					
					//Set index to equal j
					index = j;
			
			//Swaps ith element of sorted list with the index element of sorted list
			Word temp = new Word(sortedlist[index].toString());
			sortedlist[index] = sortedlist[i];
			sortedlist[i] = temp;
		}
		
		//Loops from 0 to listsize-1
		for(int i = 0; i < listsize; i++){
			
			//Adds each word from sortedlist to right text area
			RightText.append(sortedlist[i]+"\n");
		}
		
		//Makes GUI visible
		myWordGUI.setVisible(true);
	}
}
