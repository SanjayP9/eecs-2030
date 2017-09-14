package eecs2030.lab1;

/**
 * Thrown to indicate that an illegal address has been used
 * as an argument.
 *
 */
public class IllegalAddressException extends Lab1Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3143036140234364655L;

	/**
	 * Initialize an exception with null as its detail message.
	 */
	public IllegalAddressException() {
		super();
	}
	
	/**
	 * Initialize a new exception with the specified detail message.
	 * 
	 * @param message the detail message
	 */
	public IllegalAddressException(String message) {
		super(message);
	}
}
