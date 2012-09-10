package com.acclivyx.rules;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test the RulesResult 
 * 
 * @author Barton
 *
 */
public class RuleResultTest {

	@Test
	public void isPassed() {
		RuleResult rr = new RuleResult(true,"foo");
		Assert.assertTrue(rr.isSatisfied());
		Assert.assertTrue(rr.getMessage().contains("foo"));
		Assert.assertTrue(rr.getMessage().contains("passed"));
	}
	@Test
	public void isFailed() {
		RuleResult rr = new RuleResult(false,"foo");
		Assert.assertFalse(rr.isSatisfied());
		Assert.assertTrue(rr.getMessage().contains("foo"));
		Assert.assertTrue(rr.getMessage().contains("failed"));
	}

}
