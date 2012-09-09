package com.acclivyx.rules.sequenceintegerrules;

import java.math.BigInteger;

import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.SequenceIntegerRule;
import com.acclivyx.rules.args.RuleIntegerArgs;


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
	/**
	 * @param args - specific instance/type of args to be processed
	 * @return results of processing
	 */
	@Override
	public RuleResult process(RuleIntegerArgs args)   {
		BigInteger bigInteger = BigInteger.valueOf(0);
		
		for (Integer arg : args.getArgs()) {
			bigInteger = bigInteger.add(BigInteger.valueOf(arg));
		}
		BigInteger average = bigInteger.divide(BigInteger.valueOf(args.getArgs().size()));
		
		return new RuleResult(average.compareTo(MIN) >= 0,
				this.name);
	}



}
