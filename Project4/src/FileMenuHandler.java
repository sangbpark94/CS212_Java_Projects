//Sang Park CS 212-11C
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/**
 * This class is used to handle the file menu actions
 * and it implements the ActionListener class.
 * 
 * @author spark
 *
 */
public class FileMenuHandler implements ActionListener {
	
	JFrame jframe;
   
	/**
	 * Constructor for a FileMenuHandler that sets
	 * the JFrame in the class.
	 * 
	 * @param jf A type JFrame used to set jFrame in the FileMenuHandler class
	 */
	public FileMenuHandler (JFrame jf) {
		jframe = jf;
	}
	
	/**
	 * This method is called when there is an event, namely
	 * open and quit.
	 */
	public void actionPerformed(ActionEvent event) {
		String  menuName;
		menuName = event.getActionCommand();
		if (menuName.equals("Open"))
			openFile(); 
		else if (menuName.equals("Quit"))
			System.exit(0);
	}
	
	/**
	 * This method opens the file and allows user to choose
	 * a file to read.
	 */
   	private void openFile() {
    	//Sets chooser and status
   		JFileChooser chooser = new JFileChooser();
    	int status = chooser.showOpenDialog(null);
       
    	//If file is approved call readSource method
    	if (status == JFileChooser.APPROVE_OPTION) 
    		readSource(chooser.getSelectedFile());
    	else 
    		JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    
    }
   	
   	/**
   	 * This method reads the file, tokenizes the items and
   	 * stores them into an unsortedlist and sortedlist. At the
   	 * end of the method it calls the printLists method.
   	 * 
   	 * @param chosenFile A type File that is the name of file to be read
   	 */
    private void readSource(File chosenFile) {
		
    	//Sets variables to be used for tokenizer
		String path = chosenFile.getAbsolutePath();
		TextFileInput inFile = new TextFileInput(path);
		String line = inFile.readLine();
		UnsortedWordList uList = new UnsortedWordList();
		SortedWordList sList = new SortedWordList();
		
		//As long as there is a line to read, it tokenizes the words.
		//The valid words are added to the unsorted list as it appears
		//and added to the sorted list alphabetically while the
		//invalid words are printed out onto the console using an
		//IllegalWordException
		while(line != null){
			StringTokenizer myTokens = new StringTokenizer(line,",");
			while(myTokens.hasMoreTokens()){
				String currentToken = myTokens.nextToken();
				try{
					Word wordedToken = new Word(currentToken);
					uList.add(wordedToken);
					sList.add(wordedToken);
				}
				catch(IllegalWord212Exception iwe){
					System.out.println(iwe.getMessage());
				}
			}
			line = inFile.readLine();
		}
		printLists(uList, sList);
    }
    
    /**
     * Takes the 2 lists and prints them onto 2 TextAreas of the GUI.
     * 
     * @param u A type UnsortedWordList with the unsorted words
     * @param s A type SortedWordList with the sorted words
     */
    private void printLists(UnsortedWordList u, SortedWordList s){
    	
    	//Variables used for ContentPane and TextAreas
    	Container myContentPane = jframe.getContentPane();
    	TextArea LeftText = new TextArea();
    	TextArea RightText = new TextArea();
    	myContentPane.add(LeftText);
    	myContentPane.add(RightText);
    	
    	//Sets p to the first non-dummy node of the unsorted list
    	WordNode p = u.first.next;
    	
    	//Appends the words onto the Left TextArea
    	while(p != null){
    		LeftText.append(p.data.toString() + "\n");
    		p = p.next;
    	}
    	
    	//Iterates through treemap and appends sorted Words into Right TextArea
    	Set set = s.treemap.entrySet();
    	Iterator i = set.iterator();
    	Map.Entry<Word, Word> me;
    	
    	while(i.hasNext()){
    		me = (Map.Entry)i.next();
    		RightText.append(me.getKey() + "\n");
    	}
    	
    	
    	//Makes GUI visible
    	jframe.setVisible(true);
    }
}