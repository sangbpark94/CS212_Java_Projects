// Sang Park CS 212-11B

import javax.swing.*;
import java.awt.*;

/**
 * Project 1
 * 
 * This class holds the components of the DateGUI. 
 * It has the ability to initialize a Grid Layout with
 * one row and two columns, a set size, location, and title. 
 * The other two methods checks valid dates and print an 
 * inputed list onto the GUI, where the left column is in
 * order that the elements are read and the right column is
 * sorted starting fromt he earliest down to the latest.
 * 
 * @author Park
 *
 */
public class DateGUI extends JFrame{
	
	//Creates a JFrame called myDateGUI
	static JFrame myDateGUI;
	
	//This method initializes size, location, title, layout, and close operation
	public static void initialize(){
		
		//Initializes myDateGUI
		myDateGUI = new DateGUI();
		
		myDateGUI.setSize(1000,500);
		myDateGUI.setLocation(100, 100);
		myDateGUI.setTitle("Date GUI");
		myDateGUI.setLayout(new GridLayout(1,2));
		myDateGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//This method returns true if a string is a valid date (has size equal to eight), and false otherwise
	public static boolean isValidDate(String s){
		if(s.length() != 8)
			return (false);
		return (true);
	}
	
	//This method a string array and a size as parameters and will print the array onto the GUI, unsorted on the left and sorted on the right
	public static void printDatestoGUI(String[] list, int size){
		
		//Creates a ContentPane
		Container myContentPane = myDateGUI.getContentPane();
		
		//Initializes left and right side textareas
		TextArea LeftText = new TextArea();
		TextArea RightText = new TextArea();
		
		//Adds text areas to ContentPane
		myContentPane.add(LeftText);
		myContentPane.add(RightText);
		
		//Loops from first element of the array to the last
		for(int i = 0; i < size; i++)
			
			//Checks if element is a valid date
			if(isValidDate(list[i])){
				
				//Adds to element LeftText
				LeftText.append(list[i]+"\n");
		}
		
		//Initializes another string array for the sorted array
		String[] sortedlist = new String[100];
		
		//Temporarily sets it to equal to list
		sortedlist = list;
		
		//Implements a selection sort
		//Loops from 0 to size-1
		for(int i = 0; i < size; i++){
			
			//Sets index to i
			int index = i;
			
			//Loops from i+1 to the size-1
			for(int j = i+1; j < size; j++)
				
				//Uses compareTo to determine smaller number
				if(sortedlist[j].compareTo(sortedlist[index]) < 0)
					index = j;
			
			//Swaps indexed element with lowest element found
			String temp = sortedlist[index];
			sortedlist[index] = sortedlist[i];
			sortedlist[i] = temp;
		}
		
		//Loops from first element of the array to the last
		for(int i = 0; i < size; i++){
			
			//Checks if element is a valid date
			if(isValidDate(sortedlist[i]))
				
				//Adds to element RightText
				RightText.append(sortedlist[i]+"\n");
		}
		
		//Sets DateGUI to be visible
		myDateGUI.setVisible(true);
	}
	
}
