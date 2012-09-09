package com.acclivyx.rules.args;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.acclivyx.rules.exceptions.RuleArgsInvalid;
/**
 * Test the RuleIntegerArgs
 * 
 * @author Barton
 *
 */
public class RuleIntegerArgsTest {
	RuleIntegerArgs sut;
	@Before
	public void setup () {
		sut = new RuleIntegerArgs();
	}
	
	@Test
	public void areArgsNull() {
		try {
			sut.setArgs(null);
			Assert.fail("should have thrown an exception");
		} catch (RuleArgsInvalid rai) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void invalidArg() {
		try {
			String foo[] = {"5","a"};
			sut.setArgs(foo);
			Assert.fail("should have failed with invalid argument");
		} catch (RuleArgsInvalid rai) {
			Assert.assertTrue(true);
		}
	}
}
