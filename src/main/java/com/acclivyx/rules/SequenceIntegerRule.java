package com.acclivyx.rules;

import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.args.RuleIntegerArgs;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;

/**
 * Base class for sequence of integers.  It provides
 * basic argument validation so that sub classes do not
 * (DRY) have to repeat.
 * 
 * 
 * @author Barton
 *
 */
public abstract class SequenceIntegerRule extends Rule{
	/**
	 * Name of rule
	 * @param name
	 */
	public SequenceIntegerRule(String name) {
		super(name);
	}
	/**
	 * Basic validation for rules of this type.
	 * Requires arguments to be of type integer
	 * and at least two provided.
	 * 
	 * @param ruleArgs
	 * @return result
	 * @throws when args are invalid for this rule
	 */
	public RuleResult process(RuleArgs ruleArgs) throws RuleArgsInvalid {
		if (false == (ruleArgs instanceof RuleIntegerArgs)) {
			throw new RuleArgsInvalid("args not instanceof RulesIntegerArgs");
		}		

		RuleIntegerArgs args= (RuleIntegerArgs) ruleArgs;
		
		if (args.getArgs().size() < 2) {
			throw new RuleArgsInvalid("there are less then two arguments (" + args.getArgs().size() + ")");
		}
		return process(args);
	}
	
	public abstract RuleResult process(RuleIntegerArgs ruleArgs) ;

}
