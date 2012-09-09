package com.acclivyx.main;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.factory.RulesFactory;

public class RuleRunnerDemoTest {
	RuleRunnerDemo sut;
	@Before
	public void setup() {
		sut = new RuleRunnerDemo();
	}
	@Test
	public void allRulesPass() {
		String[] foo = {"600","1500"};
				
		Collection<RuleResult> results = sut.process(new  RulesFactory(foo));
		Assert.assertEquals(4, results.size());
	}
	@Test
	public void ruleAFails() throws Exception {
		String[] foo = {"6","5"};
				
		Collection<RuleResult> results = sut.process(new  RulesFactory(foo));
		Assert.assertEquals(3, results.size());
		Assert.assertFalse(isRuleSatisfied(results,"RuleA"));
	}
	@Test
	public void ruleBFails() throws Exception {
		String[] foo = {"600","500"};
				
		Collection<RuleResult> results = sut.process(new  RulesFactory(foo));
		Assert.assertEquals(3, results.size());
		Assert.assertFalse(isRuleSatisfied(results,"RuleB"));
	}
	@Test
	public void ruleCFails() throws Exception {
		String[] foo = {"6","5"};
				
		Collection<RuleResult> results = sut.process(new  RulesFactory(foo));
		Assert.assertEquals(3, results.size());
		Assert.assertFalse(isRuleSatisfied(results,"RuleC"));
	}
	private boolean isRuleSatisfied(Collection<RuleResult> results,
			String name) throws Exception {
		for(RuleResult result: results) {
			if (result.getName().equals(name)) {
				return result.isSatisified();
			}
		}
		throw new Exception("rule: " + name + " not found");
	}
}
