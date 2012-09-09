package com.acclivyx.rules;

import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;


public interface IRule {
	public RuleResult process(RuleArgs args) throws RuleArgsInvalid;
}
