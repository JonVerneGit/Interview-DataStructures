package exceptions;

/**
 * The file format exception is thrown when we are trying to read a file
 * but it is not in the format that you expect! 
 * 
 * This should be a checked exception, which forces users to wrap this in
 * a try/catch rather than a runtime exception.
 *  
 * Most of the work in the file format exception can be handled by the super class!
 *  
 * @author Jonathan Verne
 *
 */
public class FileFormatException extends Exception {
	/**
	 * Default Constructor for the exception 
	 */
	public FileFormatException(){
		super();
	}
	
	/**
	 * Constructor for the exception that takes a String message
	 * @param String s
	 */
	public FileFormatException(String s){
		super(s);
	}

}
