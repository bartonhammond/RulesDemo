package com.acclivyx.rules;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The result of applying the rule
 * 
 * Note that it is immutable to avoid modification after the 
 * rule has run.
 * 
 * This object is returned by the RulesService class 
 * and requires a default no arg constructor
 * @see com.acclivyx.webservice.RulesService
 * 
 * @author Barton
 *
 */
@XmlRootElement(name = "result")
public class RuleResult {

	private boolean isSatisfied;
	private String name;
	public RuleResult() {}
	/**
	 * 
	 * @param isSatisfied - did the rule pass?
	 * @param name - of rule 
	 */
	public RuleResult(boolean isSatisfied, String name) {
		this.isSatisfied = isSatisfied;
		this.name = name;
	}
	@XmlElement
	public boolean isSatisfied() {
		return isSatisfied;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public String getMessage() {
		return name + (isSatisfied ? " passed " : " failed");
	}
}
