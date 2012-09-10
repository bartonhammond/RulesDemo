package com.acclivyx.rules.runner;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.acclivyx.loader.RulesLoader;
import com.acclivyx.rules.IRule;
import com.acclivyx.rules.Rule;
import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.args.RuleIntegerArgs;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;
import com.acclivyx.rules.factory.RulesFactory;
import com.acclivyx.rules.sequenceintegerrules.AverageIsGreaterThenRule;
/**
 * Test RulesRunner process the rules for the args and returns
 * the results
 * 
 * Note: this uses Mockito to mock out all the objects
 * required by RulesRunner since all those classes have
 * already been unit tested.
 * 
 * @author Barton
 *
 */
public class RulesRunnerTest {
	
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Mock out all the supporting classes for RuleRunner
	 * @throws RuleArgsInvalid
	 */
	@Test
	public void test() throws RuleArgsInvalid {
		//Mock RuleArgs
		RuleIntegerArgs ruleIntegerArgs = Mockito.mock(RuleIntegerArgs.class);
		Collection<RuleArgs> ruleArgs = new ArrayList<RuleArgs>();
		ruleArgs.add(ruleIntegerArgs);
		
		//Mock one Rule	
		Rule testRule = Mockito.mock(AverageIsGreaterThenRule.class);
		Mockito.when(testRule.process(ruleIntegerArgs)).thenReturn(new RuleResult(true,"test"));

		//Mock rulesLoader and methods
		RulesLoader rulesLoader = Mockito.mock(RulesLoader.class);
		Collection<IRule> rules = new ArrayList<IRule>();
		rules.add(testRule);
		Mockito.when(rulesLoader.getRulesForArgs(ruleIntegerArgs)).thenReturn(rules);
		
		//Mock RulesFactory methods
		RulesFactory rulesFactory = Mockito.mock(RulesFactory.class);		
		Mockito.when(rulesFactory.getRulesIntegerArgs()).thenReturn(ruleIntegerArgs);
		Mockito.when(rulesFactory.getRulesLoader()).thenReturn(rulesLoader);	
		Mockito.when(rulesFactory.getRuleArgs()).thenReturn(ruleArgs);
				
		//Real RulesRunner
		RulesRunner sut = new RulesRunner(rulesFactory);

		//Run test
		Collection<RuleResult> results = sut.runRules();
		 
		//Validate 
		Assert.assertEquals(1, results.size());
		
		RuleResult[] resultsArray = new RuleResult[1];
		Assert.assertTrue(results.toArray(resultsArray)[0].isSatisfied());
	}

}
