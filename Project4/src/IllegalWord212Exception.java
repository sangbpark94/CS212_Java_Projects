//Sang Park CS 212-11C

/**
 * 
 * This class extends IllegalArgumentException and creates
 * a message when thrown.
 * 
 * @author spark
 *
 */
public class IllegalWord212Exception extends IllegalArgumentException{
	
	/**
	 * Constructor for an IllegalWordException using the super class
	 * IllegalArgumentException
	 * 
	 * @param message A type string that is the message to be displayed to console
	 */
	public IllegalWord212Exception(String message){
		super(message);
	}
}
