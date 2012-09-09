package com.acclivyx.loader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.args.RuleIntegerArgs;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;

public class RulesLoaderTest {
	RulesLoader sut;
	@Before
	public void setUp() throws Exception {
		sut = new RulesLoader();
	}

	@Test
	public void testRuleIntegerArgs() {
		RuleArgs ria = new RuleIntegerArgs();
		Assert.assertEquals(3,sut.getRulesForArgs(ria).size());
	}
	@Test
	public void testSomeOtherArgs() {
		RuleArgs ria = new SomeOtherArgs();
		Assert.assertEquals(0,sut.getRulesForArgs(ria).size());
	}
	/**
	 * Dummy class for testing
	 * @author Barton
	 *
	 */
	class SomeOtherArgs implements RuleArgs {

		@Override
		public void setArgs(String[] strings) throws RuleArgsInvalid {
			// TODO Auto-generated method stub
			
		}
		
	}
}
