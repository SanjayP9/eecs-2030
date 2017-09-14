package eecs2030.lab1;

/**
 * Thrown to indicate that an illegal number of birthdays
 * has been used as an argument.
 *
 */
public class IllegalBirthdaysException extends Lab1Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6319587660317253961L;

	/**
	 * Initialize an exception with null as its detail message.
	 */
	public IllegalBirthdaysException() {
		super();
	}
	
	/**
	 * Initialize a new exception with the specified detail message.
	 * 
	 * @param message the detail message
	 */
	public IllegalBirthdaysException(String message) {
		super(message);
	}
}
