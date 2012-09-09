package com.acclivyx.rules.action;

import java.util.ArrayList;
import java.util.List;

import com.acclivyx.rules.RuleResult;
import com.acclivyx.rules.model.Data;
import com.opensymphony.xwork2.ActionSupport;

public class RuleAction extends ActionSupport {

	private static final long serialVersionUID = -8366209797454396351L;

	private List<RuleResult> results = new ArrayList<RuleResult>();

	private Data data = new Data();

	public String list() {
		return SUCCESS;
	}

	public String add() {

		results.add(new RuleResult(true, "ruleA"));
		results.add(new RuleResult(true, "ruleB"));
		results.add(new RuleResult(true, "ruleC"));

		return SUCCESS;
	}


	public List<RuleResult> getResults() {
		return results;
	}

	public void setResults(List<RuleResult> results) {
		this.results = results;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
}
