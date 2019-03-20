package edu.ben.labs.lab6;
/**
 * 
 * @author ryanhassoun
 * @version 1.0
 *
 */
public class InvalidInputType extends Exception {

	/**
	 * The serial number of the exception
	 */
	private static final long serialVersionUID = -1125848588555368328L;

	/**
	 * Creates an Invalid Input Type Exception
	 * 
	 * @param message
	 *            the message to be displayed
	 */
	public InvalidInputType(String message) {

		super(message);
	}
}