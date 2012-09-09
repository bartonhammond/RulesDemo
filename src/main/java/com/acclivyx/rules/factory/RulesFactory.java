package com.acclivyx.rules.factory;

import java.util.ArrayList;
import java.util.Collection;

import com.acclivyx.loader.RulesLoader;
import com.acclivyx.rules.args.RuleArgs;
import com.acclivyx.rules.args.RuleIntegerArgs;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;
/**
 * Simple factory to produce required classes
 * 
 * @author Barton
 *
 */
public class RulesFactory {
	private String[] args; 
	private Collection<RuleArgs> ruleArgs;
	
	/**
	 * 
	 * @param args - arguments provided to the specific rules
	 * 
	 */
	public RulesFactory(String[] args) {
		this.args = args;
	}
	/**
	 * 
	 * @return RulesLoader
	 */
	public RulesLoader getRulesLoader() {
		return new RulesLoader();
	}
	/**
	 * 
	 * @return RuleIntegerArgs
	 */
	public  RuleIntegerArgs getRulesIntegerArgs() {
		return new RuleIntegerArgs();
	}
	/**
	 * Create collection of valid arguments
	 * Uses the constructor args to initialize the RuleArgs
	 * @return the Collection of valid arguments
	 * @throws RuleArgsInvalid if for any type of 
	 *         RuleArgs the conversion fails
	 */
	public Collection<RuleArgs> getRuleArgs() throws RuleArgsInvalid {
		if (ruleArgs != null) {
			return ruleArgs;
		}
		ruleArgs = new ArrayList<RuleArgs>();
		ruleArgs.add(getRulesIntegerArgs());
		for(RuleArgs ruleArg: ruleArgs) {
			ruleArg.setArgs(args);
		}
		return ruleArgs;
	}
}
