package com.acclivyx.rules.exceptions;
/**
 * Business exception to indicate if the arguments
 * provided are valid.
 * 
 * @author Barton
 *
 */
public class RuleArgsInvalid extends Exception {

	private static final long serialVersionUID = 1974274984690217745L;
	/**
	 * Initialize the message
	 * @param message
	 */
	public RuleArgsInvalid(String message) {
		super(message);
	}
}
