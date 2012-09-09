package com.acclivyx.loader;

import java.util.ArrayList;
import java.util.Collection;

import com.acclivyx.rules.IRule;
import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.args.RuleIntegerArgs;
import com.acclivyx.rules.sequenceintegerrules.AverageIsGreaterThenRule;
import com.acclivyx.rules.sequenceintegerrules.TwoArgsGreaterThenRule;
import com.acclivyx.rules.sequenceintegerrules.TwoArgsSpanGreaterThenRule;


public class RulesLoader {

	public Collection<IRule> getRulesForArgs(RuleArgs args) {
		Collection<IRule> rules = new ArrayList<IRule>();
		if (args instanceof RuleIntegerArgs) {
			rules.add(new TwoArgsGreaterThenRule());
			rules.add(new TwoArgsSpanGreaterThenRule());
			rules.add(new AverageIsGreaterThenRule());
		}
		return rules;
	}


}
