// Sang Park CS 212-11C

import javax.swing.*;

/**
 * Project 0
 * 
 * Calculates the number of lower and upper case 'E's 
 * from an user inputed text using JOptionPane and 
 * outputs the results also using JOptionPane
 * 
 * @author S. Park
 *
 */
public class Project0 {
	
	public static void main(String[] args){
		
		while(true){
			
			//Prompts user for input text using JOptionPane
			String input = JOptionPane.showInputDialog(null, "Please enter a sentence.");
			
			//Checks if program should terminate
			if(input.equalsIgnoreCase("STOP"))
				System.exit(0);
			
			//Initializes variables
			int length = input.length();
			int index = 0, lowE = 0, upE = 0;
			
			//Keeps count for every lower/upper case 'E'
			while(index < length){
				if(input.charAt(index) == 'e')
					lowE++;
				if(input.charAt(index) == 'E')
					upE++;
				index++;
			}
			
			//Outputs # of lower/upper 'E' using JOptionPane
			JOptionPane.showMessageDialog(null, "Number of lower case e's: " + lowE + "\nNumber of upper case e's: " + upE);	
		}
	}
}
