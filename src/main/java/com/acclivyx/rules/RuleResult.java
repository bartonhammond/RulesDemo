package com.acclivyx.rules;
/**
 * The result of applying the rule
 * Note that it is immutable to avoid modification after the 
 * rule has run.
 * 
 * @author Barton
 *
 */
public class RuleResult {

	private boolean isSatisfied;
	private String name;
	/**
	 * 
	 * @param isSatisfied - did the rule pass?
	 * @param name - of rule 
	 */
	public RuleResult(boolean isSatisfied, String name) {
		this.isSatisfied = isSatisfied;
		this.name = name;
	}
	public boolean isSatisified() {
		return isSatisfied;
	}
	public String getName() {
		return name;
	}
	public String getMessage() {
		return name + (isSatisfied ? " passed " : " failed");
	}
}
