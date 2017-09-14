package eecs2030.lab1;

/**
 * Thrown to indicate that an illegal birth year has been
 * used as an argument.
 *
 */
public class IllegalBirthYearException extends Lab1Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2352873593232193581L;

	/**
	 * Initialize an exception with null as its detail message.
	 */
	public IllegalBirthYearException() {
		super();
	}
	
	/**
	 * Initialize a new exception with the specified detail message.
	 * 
	 * @param message the detail message
	 */
	public IllegalBirthYearException(String message) {
		super(message);
	}
}
