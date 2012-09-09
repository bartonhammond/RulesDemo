package com.acclivyx.rules;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.args.RuleIntegerArgs;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;
import com.acclivyx.rules.sequenceintegerrules.AverageIsGreaterThenRule;
/**
 * Test the abstract class SequenceIntegerRule by testing a concrete class
 * @author Barton
 *
 */
public class SequenceIntegerRuleTest {
	AverageIsGreaterThenRule sut;
	//Dummy class to demonstrate wrong instanceof
	class TestRuleArgs implements RuleArgs {
		@Override
		public void setArgs(String[] strings) throws RuleArgsInvalid {			
		}
		
	}
	@Before
	public void setup() {
		sut = new AverageIsGreaterThenRule();
	}
	@Test
	public void wrongRulesInstanceOf() {
		RuleArgs ruleArgs = new TestRuleArgs();
		try {
			sut.process(ruleArgs);
			Assert.fail("arguments are not valid");
		} catch (RuleArgsInvalid e)  {
			Assert.assertTrue(true);
		}
	}
	@Test
	public void argumentsAreEmpty() {
		RuleArgs ruleArgs = new RuleIntegerArgs();
		
		try {
			sut.process(ruleArgs);
			Assert.fail("arguments are not valid");
		} catch (RuleArgsInvalid e) {
			Assert.assertTrue(true);
		}
	}
	@Test
	public void argumentsLessThenTwo()  {
		RuleArgs ruleArgs = new RuleIntegerArgs();
		String foo[] = {"one"};
		
		try {
			ruleArgs.setArgs(foo);
			sut.process(ruleArgs);
			Assert.fail("arguments are not valid");
		} catch (RuleArgsInvalid e) {
			Assert.assertTrue(true);
		}
	}
}
