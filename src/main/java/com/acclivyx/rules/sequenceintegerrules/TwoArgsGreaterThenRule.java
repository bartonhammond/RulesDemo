package com.acclivyx.rules.sequenceintegerrules;

import java.util.Iterator;

import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.SequenceIntegerRule;
import com.acclivyx.rules.args.RuleIntegerArgs;

/**
 * If any integer in the sequence is at least 500 greater than the one
 * previous to it in the sequence, the rule is "passed", else it is
 * "failed"..
 */
public class TwoArgsGreaterThenRule extends SequenceIntegerRule {
	private final Integer MIN = 500;

	public TwoArgsGreaterThenRule() {
		super("RuleB");
	}

	/**
	 * @param specific instance/type of args
	 * @return results
	 */
	public RuleResult process(RuleIntegerArgs args) {
		
		Integer first = null;
		Integer second = null;
		for (Iterator<Integer> iter = args.getArgs().iterator(); iter.hasNext();) {
			if (first == null) {
				first = second = iter.next();
				continue;
			}
			first = second;
			second = iter.next();
			if (second - first >= MIN) {
				return new RuleResult(true, this.name);
			}
		}
		return new RuleResult(false,this.name);
	}

}
