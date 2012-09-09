package com.acclivyx.rules.runner;

import java.util.ArrayList;
import java.util.Collection;

import com.acclivyx.rules.IRule;
import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;
import com.acclivyx.rules.factory.RulesFactory;

public class RulesRunner {


	private RulesFactory rulesFactory;

	public RulesRunner(RulesFactory rulesFactory) {
		this.rulesFactory = rulesFactory;	
	}

	public Collection<RuleResult> runRules() throws RuleArgsInvalid {
		Collection<RuleResult> results = new ArrayList<RuleResult>();
		for (RuleArgs rulesArg : rulesFactory.getRuleArgs()) {

			for (IRule rule : rulesFactory.getRulesLoader().getRulesForArgs(
					rulesArg)) {
				results.add(rule.process(rulesArg));
			}

		}
		return results;
	}
}
