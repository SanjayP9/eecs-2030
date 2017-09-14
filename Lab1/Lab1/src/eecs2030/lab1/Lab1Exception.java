package eecs2030.lab1;

/**
 * Parent class for exceptions thrown by the Lab1 utility class.
 *
 */
public class Lab1Exception extends RuntimeException {

	private static final long serialVersionUID = 4332638942234794176L;

	/**
	 * Initialize an exception with null as its detail message.
	 */
	public Lab1Exception() {
		super();
	}
	
	/**
	 * Initialize a new exception with the specified detail message.
	 * 
	 * @param message the detail message
	 */
	public Lab1Exception(String message) {
		super(message);
	}
	
}
