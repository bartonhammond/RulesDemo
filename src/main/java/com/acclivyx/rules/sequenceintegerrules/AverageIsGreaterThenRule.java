package com.acclivyx.rules.sequenceintegerrules;

import java.math.BigInteger;

import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.SequenceIntegerRule;
import com.acclivyx.rules.args.RuleIntegerArgs;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;

/**
 * If the average of all the integers in the sequence is 500 or greater, the
 * rule is "passed", else it is "failed".
 * @throws RuleArgsInvalid 
 */
public class AverageIsGreaterThenRule extends SequenceIntegerRule{
	private final BigInteger MIN = BigInteger.valueOf(500);
	public AverageIsGreaterThenRule() {
		super("RuleC");
	}

	@Override
	public RuleResult process(RuleIntegerArgs args) throws RuleArgsInvalid  {
		BigInteger bigInteger = BigInteger.valueOf(0);
		
		for (Integer arg : args.getArgs()) {
			bigInteger = bigInteger.add(BigInteger.valueOf(arg));
		}
		BigInteger average = bigInteger.divide(BigInteger.valueOf(args.getArgs().size()));
		
		return new RuleResult(average.compareTo(MIN) >= 0,
				this.name);
	}



}
