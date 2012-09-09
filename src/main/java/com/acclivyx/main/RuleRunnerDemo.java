package com.acclivyx.main;

import java.util.ArrayList;
import java.util.Collection;

import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;
import com.acclivyx.rules.factory.RulesFactory;
import com.acclivyx.rules.runner.RulesRunner;
import com.acclivyx.util.Log;

public class RuleRunnerDemo {

	public static void main(String[] args) {
		RuleRunnerDemo ruleRunnerDemo = new RuleRunnerDemo();
	
		for (RuleResult result : ruleRunnerDemo.process(new RulesFactory(args))) {
			Log.message(result.getMessage());
		}
	}

	public Collection<RuleResult> process(RulesFactory rulesFactory) { 
		Collection<RuleResult> results = null;
		
		boolean allRulesPassed = true;
		RulesRunner rulesRunner = new RulesRunner(rulesFactory);
		try {
			results = rulesRunner.runRules();
			for (RuleResult result : results) {
				if (!result.isSatisified()) {
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
