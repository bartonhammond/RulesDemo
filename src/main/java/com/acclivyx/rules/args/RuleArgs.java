package com.acclivyx.rules.args;

import com.acclivyx.rules.exceptions.RuleArgsInvalid;


public interface RuleArgs {
	public void setArgs(String[] strings) throws RuleArgsInvalid;
}
