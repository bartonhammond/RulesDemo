package com.acclivyx.rules.sequenceintegerrules;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.args.RuleIntegerArgs;
/**
 * Test rule AverageIsGreaterThen
 * 
 * @author Barton
 *
 */
public class AverageIsGreaterThenRuleTest {
	AverageIsGreaterThenRule sut;
	@Before
	public void setup() {
		sut = new AverageIsGreaterThenRule();
	}
	@Test
	public void testAverageIsGreater() throws Exception{
		RuleIntegerArgs args = new RuleIntegerArgs();
		String foo[] = {"500","500"};
		args.setArgs(foo);
		RuleResult result = sut.process(args);
		Assert.assertTrue(result.isSatisified());
		
	}
	@Test
	public void testAverageIsNotGreater() throws Exception{
		RuleIntegerArgs args = new RuleIntegerArgs();
		String foo[] = {"499","500"};
		args.setArgs(foo);
		RuleResult result = sut.process(args);
		Assert.assertFalse(result.isSatisified());
		
	}
	@Test
	public void testAverageIsTooBig() throws Exception {
		RuleIntegerArgs args = new RuleIntegerArgs();		
		String foo[] = {Integer.toString(Integer.MAX_VALUE),Integer.toString(Integer.MAX_VALUE)};
		args.setArgs(foo);
		RuleResult result = sut.process(args);
		Assert.assertTrue(result.isSatisified());
	}}
