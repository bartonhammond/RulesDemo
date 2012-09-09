package com.acclivyx.rules;

public class RuleResult {

	private boolean isSatisfied;
	private String name;
	
	public RuleResult(boolean isSatisfied, String name) {
		this.isSatisfied = isSatisfied;
		this.name = name;
	}
	public boolean isSatisified() {
		return isSatisfied;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return name + (isSatisfied ? " passed " : " failed");
	}
}
