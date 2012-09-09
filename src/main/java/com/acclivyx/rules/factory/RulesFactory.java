package com.acclivyx.rules.factory;

import com.acclivyx.loader.RulesLoader;
import com.acclivyx.rules.args.RuleIntegerArgs;

public class RulesFactory {

	public RulesLoader getRulesLoader() {
		return new RulesLoader();
	}
	public  RuleIntegerArgs getRulesIntegerArgs() {
		return new RuleIntegerArgs();
	}
}
