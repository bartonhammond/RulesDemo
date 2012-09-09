package com.acclivyx.rules;

import org.junit.Assert;
import org.junit.Test;

public class RuleResultTest {

	@Test
	public void isPassed() {
		RuleResult rr = new RuleResult(true,"foo");
		Assert.assertTrue(rr.isSatisified());
		Assert.assertTrue(rr.getMessage().contains("foo"));
		Assert.assertTrue(rr.getMessage().contains("passed"));
	}
	@Test
	public void isFailed() {
		RuleResult rr = new RuleResult(false,"foo");
		Assert.assertFalse(rr.isSatisified());
		Assert.assertTrue(rr.getMessage().contains("foo"));
		Assert.assertTrue(rr.getMessage().contains("failed"));
	}

}
