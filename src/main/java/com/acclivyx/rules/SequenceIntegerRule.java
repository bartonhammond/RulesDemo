package com.acclivyx.rules;

import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.args.RuleIntegerArgs;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;

public abstract class SequenceIntegerRule extends Rule{

	public SequenceIntegerRule(String name) {
		super(name);
	}

	@Override
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
	
	public abstract RuleResult process(RuleIntegerArgs ruleArgs) throws RuleArgsInvalid ;

}
