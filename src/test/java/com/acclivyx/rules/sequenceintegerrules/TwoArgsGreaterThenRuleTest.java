package com.acclivyx.rules.sequenceintegerrules;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.args.RuleIntegerArgs;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;
/**
 * Test TwoArgsGreaterThenRule rule
 * 
 * @author Barton
 *
 */
public class TwoArgsGreaterThenRuleTest {
	TwoArgsGreaterThenRule sut;
	@Before
	public void setUp() throws Exception {
		sut = new TwoArgsGreaterThenRule();
	}

	@Test
	public void oneArgGreaterBy() throws RuleArgsInvalid {
		RuleArgs ria = new RuleIntegerArgs();
		String[] foo = {"5","1500"};
		ria.setArgs(foo);
		
		RuleResult result = sut.process(ria);
		
		Assert.assertTrue(result.isSatisfied());
	}
	@Test
	public void noArgGreaterBy() throws RuleArgsInvalid {
		RuleArgs ria = new RuleIntegerArgs();
		String[] foo = {"5","500"};
		ria.setArgs(foo);
		
		RuleResult result = sut.process(ria);
		
		Assert.assertFalse(result.isSatisfied());
	}
	@Test
	public void maxInt() throws RuleArgsInvalid {
		RuleArgs ria = new RuleIntegerArgs();
		String[] foo = {Integer.toString(Integer.MAX_VALUE),
				Integer.toString(Integer.MAX_VALUE)};
		ria.setArgs(foo);
		
		RuleResult result = sut.process(ria);
		
		Assert.assertFalse(result.isSatisfied());
	}
}
