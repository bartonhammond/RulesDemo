package com.acclivyx.main;

import java.util.ArrayList;
import java.util.Collection;

import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;
import com.acclivyx.rules.factory.RulesFactory;
import com.acclivyx.rules.runner.RulesRunner;
import com.acclivyx.util.Log;
/**
 * Main class that can be run from the command line.
 * 
 * It is also used by the UI to  process all the rules
 * for the given arguments.
 * 
 * 
 * @author Barton
 *
 */
public class RuleRunnerDemo {
	/**
	 * Process the arguments from the command line.
	 * Log to results.
	 * 
	 * @param args - command line arguments
	 */
	public static void main(String[] args) {
		RuleRunnerDemo ruleRunnerDemo = new RuleRunnerDemo();
	
		for (RuleResult result : ruleRunnerDemo.process(new RulesFactory(args))) {
			Log.message(result.getMessage());
		}
	}
	/**
	 * Process the results of running the rules and return a collection
	 * of results that include whether or not all the rules passed.
	 * This method does not specifically know what the arguments are
	 * nor which rules are being processed.
	 * 
	 * @param rulesFactory 
	 * @return collection of results
	 */
	public Collection<RuleResult> process(RulesFactory rulesFactory) { 
		Collection<RuleResult> results = null;
		
		boolean allRulesPassed = true;
		RulesRunner rulesRunner = new RulesRunner(rulesFactory);
		try {
			results = rulesRunner.runRules();
			for (RuleResult result : results) {
				if (!result.isSatisfied()) {
					allRulesPassed = false;
				}
			}
		} catch (RuleArgsInvalid e) {
			allRulesPassed = false;
		}
		if (allRulesPassed) {
			if (results == null) {
				results = new ArrayList<RuleResult>();
			}
			results.add(new RuleResult(true,"All rules"));
		}
		return results;
	}



}
