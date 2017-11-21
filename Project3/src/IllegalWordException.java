//Sang Park CS 212-11C

/**
 * This class extends IllegalArgumentException and creates
 * a message when thrown.
 * 
 * @author spark
 *
 */
public class IllegalWordException extends IllegalArgumentException{
	
	/**
	 * Constructor for an IllegalWordException using the super class
	 * IllegalArgumentException
	 * 
	 * @param message A type string that is the message to be displayed to console
	 */
	public IllegalWordException(String message){
		super(message);
	}
	
}
