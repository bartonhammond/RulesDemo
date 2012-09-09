package com.acclivyx.rules.runner;

import java.util.ArrayList;
import java.util.Collection;

import com.acclivyx.rules.IRule;
import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;
import com.acclivyx.rules.factory.RulesFactory;
/**
 * For all the rules that are appropriate for the
 * arguments, accumulate the results from processing 
 * the rules.
 * 
 * This was refactored out of RuleRunnerDemo as 
 * I wanted to keep the functionality of processing
 * the rules and accumulating the results separate
 * from what should be done with the results.
 * 
 * @author Barton
 *
 */
public class RulesRunner {


	private RulesFactory rulesFactory;

	/**
	 * Initialize 
	 * @param rulesFactory
	 */
	public RulesRunner(RulesFactory rulesFactory) {
		this.rulesFactory = rulesFactory;	
	}
	/**
	 * Process the rules and return the results.
	 * 
	 * This method knows nothing about the types of args
	 * nor the rules.
	 * 
	 * @return results
	 * @throws RuleArgsInvalid
	 */
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
