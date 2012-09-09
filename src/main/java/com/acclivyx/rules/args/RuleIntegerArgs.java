package com.acclivyx.rules.args;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.acclivyx.rules.exceptions.RuleArgsInvalid;

public class RuleIntegerArgs implements RuleArgs{
	private Collection<Integer> args = new ArrayList<Integer>();

	public RuleIntegerArgs() {
		
	}
	public void setArgs(String[] strings) throws RuleArgsInvalid{
		if (strings == null) {
			throw new RuleArgsInvalid("Args can not be null");
		}
		
		for (String arg : strings) {
			try {
				args.add(Integer.parseInt(arg));
			} catch (NumberFormatException e) {
				throw new RuleArgsInvalid("this arg: " + arg + " should be int");
			}
		}
	}
	public Collection<Integer> getArgs() {
		return Collections.unmodifiableCollection(args);
	}
}
