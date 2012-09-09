package com.acclivyx.rules.sequenceintegerrules;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.args.RuleIntegerArgs;
/**
 * Test TwoArgsSpanGreaterThenRule rule
 * 
 * @author Barton
 *
 */
public class TwoArgsSpanGreaterThenRuleTest {
	TwoArgsSpanGreaterThenRule sut;
	@Before
	public void setUp() throws Exception {
		sut = new TwoArgsSpanGreaterThenRule();
	}

	@Test
	public void twoSequentialNumbersGreater() throws Exception {
		RuleArgs ria = new RuleIntegerArgs();
		String[] foo = {"500","500"};
		ria.setArgs(foo);
		
		RuleResult result = sut.process(ria);
		
		Assert.assertTrue(result.isSatisified());
	}
	@Test
	public void twoSequentialNumbersLess() throws Exception {
		RuleArgs ria = new RuleIntegerArgs();
		String[] foo = {"50","500"};
		ria.setArgs(foo);
		
		RuleResult result = sut.process(ria);
		
		Assert.assertFalse(result.isSatisified());
	}
	@Test
	public void twoMaxInts() throws Exception {
		RuleArgs ria = new RuleIntegerArgs();
		String[] foo = 	{Integer.toString(Integer.MAX_VALUE),
				Integer.toString(Integer.MAX_VALUE)};
		ria.setArgs(foo);
		
		RuleResult result = sut.process(ria);
		
		Assert.assertTrue(result.isSatisified());
	}

}
