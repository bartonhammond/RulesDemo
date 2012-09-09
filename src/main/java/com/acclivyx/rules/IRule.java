package com.acclivyx.rules;

import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;

/**
 * All Rules implement some instance of RuleArgs and either throw
 * an invalid argument exception or return results.
 * 
 * @author Barton
 *
 */
public interface IRule {
	/**
	 * Apply the rules for the args and return the results or throw
	 * exception if args are inappropriate for this rule
	 * 
	 * @param args
	 * @return result
	 * @throws RuleArgsInvalid
	 */
	public RuleResult process(RuleArgs args) throws RuleArgsInvalid;
}
