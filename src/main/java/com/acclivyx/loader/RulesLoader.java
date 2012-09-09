package com.acclivyx.loader;

import java.util.ArrayList;
import java.util.Collection;

import com.acclivyx.rules.IRule;
import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.args.RuleIntegerArgs;
import com.acclivyx.rules.sequenceintegerrules.AverageIsGreaterThenRule;
import com.acclivyx.rules.sequenceintegerrules.TwoArgsGreaterThenRule;
import com.acclivyx.rules.sequenceintegerrules.TwoArgsSpanGreaterThenRule;

/**
 * Loads appropriate Rules for the type of Arguments to be processed.
 * 
 * As new types of Arguments are added to the system, there would be associated
 * new Rules. The Loader needs to be updated to associate the Arguments to the
 * Rules. Certain Rules are only applicable to specific Arguments.
 * 
 * If this were to grow the implementation could be changed to dynamically find
 * all the classes on the classpath that implement the Rule and a verifcation
 * could be introduced to determine if the Rule supports the Argument
 * dynamically.
 * 
 * But this exercise, this implementation is sufficient.
 * 
 * @author Barton
 * 
 */

public class RulesLoader {
	/**
	 * Determine which instance of the RuleArgs is
	 * passed in and associated the Rules that 
	 * support them.
	 * 
	 * @param args arguments 
	 * @return
	 */
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
