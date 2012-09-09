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
import com.acclivyx.rules.args.RuleIntegerArgs;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;
import com.acclivyx.rules.factory.RulesFactory;
import com.acclivyx.rules.sequenceintegerrules.AverageIsGreaterThenRule;

public class RulesRunnerTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws RuleArgsInvalid {
		RulesLoader rulesLoader = Mockito.mock(RulesLoader.class);
		RuleIntegerArgs ruleIntegerArgs = Mockito.mock(RuleIntegerArgs.class);
		
		RulesFactory rulesFactory = Mockito.mock(RulesFactory.class);
		
		Mockito.when(rulesFactory.getRulesIntegerArgs()).thenReturn(ruleIntegerArgs);
		Mockito.when(rulesFactory.getRulesLoader()).thenReturn(rulesLoader);
		
		Collection<IRule> rules = new ArrayList<IRule>();
		Rule testRule = Mockito.mock(AverageIsGreaterThenRule.class);
		rules.add(testRule);
				
		Mockito.when(rulesLoader.getRulesForArgs(ruleIntegerArgs)).thenReturn(rules);
		
		Mockito.when(testRule.process(ruleIntegerArgs)).thenReturn(new RuleResult(true,"test"));
	
		RulesRunner sut = new RulesRunner(rulesFactory);
		String foo[] = {"1","2"};
		Collection<RuleResult> results = sut.runRules(foo);
		 
		Assert.assertEquals(1, results.size());
		RuleResult[] resultsArray = new RuleResult[1];
		Assert.assertTrue(results.toArray(resultsArray)[0].isSatisified());
	}

}
