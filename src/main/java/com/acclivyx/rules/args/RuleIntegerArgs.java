package com.acclivyx.rules.args;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.acclivyx.rules.exceptions.RuleArgsInvalid;

/**
 * This class requires all arguments to be of type Integer
 * 
 * @author Barton
 *
 */
public class RuleIntegerArgs implements RuleArgs{
	private Collection<Integer> args = new ArrayList<Integer>();

	public RuleIntegerArgs() {
		
	}
	/*
	 *
	 * Specific rules require that all input are integers
	 *
	 * (non-Javadoc)
	 * @see com.acclivyx.rules.args.RuleArgs#setArgs(java.lang.String[])
	 */
	@Override
	public void setArgs(String[] strings) throws RuleArgsInvalid{
		if (strings == null) {
			throw new RuleArgsInvalid("Please provide a sequence of integer numbers.");
		}
		if (strings.length < 2) {
			throw new RuleArgsInvalid("Please provide at least two integer numbers.");
		}
		for (String arg : strings) {
			try {
				args.add(Integer.parseInt(arg));
			} catch (NumberFormatException e) {
				throw new RuleArgsInvalid("Please correct input.  This value (: " + arg + ") should be integer number.");
			}
		}
	}
	/**
	 * 
	 * @return unModifiableCollection of the args
	 */
	public Collection<Integer> getArgs() {
		return Collections.unmodifiableCollection(args);
	}
}
