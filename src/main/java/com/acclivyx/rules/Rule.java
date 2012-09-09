package com.acclivyx.rules;

/**
 * Abstract class which stores the name of the rule
 * 
 * @author Barton
 *
 */
public abstract class Rule implements IRule{
	protected String name;
	/**
	 * Constructor to capture the name of the rule
	 * @param name
	 */
	public Rule(String name) {
		this.name = name;
	}
}
