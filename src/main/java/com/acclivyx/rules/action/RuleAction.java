package com.acclivyx.rules.action;

import java.util.ArrayList;
import java.util.Collection;

import com.acclivyx.main.RuleRunnerDemo;
import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.exceptions.RuleArgsInvalid;
import com.acclivyx.rules.factory.RulesFactory;
import com.acclivyx.rules.model.Data;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Struts 2 Action class that is defined in struts.xml
 * 
 * @author Barton
 *
 */
public class RuleAction extends ActionSupport {

	private static final long serialVersionUID = -8366209797454396351L;

	//Collection of results
	private Collection<RuleResult> results = new ArrayList<RuleResult>();
	
	//Factory for required objects
	private RulesFactory rulesFactory;

	//Form input
	private Data data = new Data();

	/**
	 * Action that forwards to display list.  the results are processed
	 * @return indication of success
	 */
	public String list() {
		return SUCCESS;
	}
	/**
	 * 
	 * @return indication of success
	 */
	public String runRule() {
		RuleRunnerDemo demo = new RuleRunnerDemo();
		results = demo.process(rulesFactory);

		return SUCCESS;
	}
	/**
	 * Called by framework to validate form entry fields before
	 * running Rule
	 */
	public void validate() {
	
		rulesFactory = new RulesFactory(data.args());
		try {
			rulesFactory.getRuleArgs();
		} catch (RuleArgsInvalid invalid) {
			addFieldError( "data.input", invalid.getMessage() );
		}
		
	}
	/**
	 * Results of processing the rules 
	 * @return
	 */
	public Collection<RuleResult> getRuleResults() {
		return results;
	}

	public void setRuleResults(Collection<RuleResult> results) {
		this.results = results;
	}
	/**
	 * The data this is modified via the form
	 * @return
	 */
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
