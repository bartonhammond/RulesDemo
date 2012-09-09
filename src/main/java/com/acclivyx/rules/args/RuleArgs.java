package com.acclivyx.rules.args;

import com.acclivyx.rules.exceptions.RuleArgsInvalid;

/**
 * Basic interface that all Rules will implement.
 * Those that implement this should provide their own validation
 * of the arguments
 * @author Barton
 *
 */
public interface RuleArgs {
	/**
	 * 
	 * @param strings
	 * @throws RuleArgsInvalid
	 */
	public void setArgs(String[] strings) throws RuleArgsInvalid;
}
