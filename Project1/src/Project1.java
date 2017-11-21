// Sang Park CS 212-11B

import java.util.*;

/**
 * Project 1
 * 
 * First, the program instantiates a DateGUI and initializes
 * it by calling the initialize method in the DateGUI class.
 * Then, it opens and reads from a file inputed on the command line
 * reading each line with tokens separated by commas.
 * Valid tokens are stored individually into a String array
 * while invalid ones are printed to the console. 
 * Lastly, the printing method in the DateGUI will be used to
 * print the tokens.
 * 
 * @author Park
 *
 */
public class Project1 {
	
	//Creating local variables
	public static TextFileInput myFile;
	public static StringTokenizer myTokens;
	public static String line;
	
	//Main function
	public static void main(String[] args){
		
		//Instantiates and initializes a DateGUI
		DateGUI myDateGUI = new DateGUI();
		myDateGUI.initialize();
		
		//Stores inputed file into myFile variable
		myFile = new TextFileInput(args[0]);
		
		//Initializes a string array and sets size to 0
		String[] list = new String[100];
		int size = 0;
		
		//Creates a new string called temptoken to be used when extracting tokens
		String temptoken = new String();
		
		//Reads first line
		line = myFile.readLine();
		
		//While the line exists
		while(line != null){
			
			//Initializes myTokens to a StringTokenizer using the read line with tokens separated by commas
			myTokens = new StringTokenizer(line,",");
			
			//While there are more tokens to be read
			while(myTokens.hasMoreTokens()){
				
				//Sets temptoken to the next token
				temptoken = myTokens.nextToken();
				
				//Checks if token is a valid date
				if(myDateGUI.isValidDate(temptoken))
					
					//Adds token to list while increasing size
					list[size++] = temptoken;
				
				//If not valid
				else
					
					//Prints invalid token to console
					System.out.println(temptoken);
			}
			
			//Reads next line
			line = myFile.readLine();
		}
		
		//Calls printing method in DateGUI to print to GUI
		myDateGUI.printDatestoGUI(list, size);
		
	}//end of main
}
