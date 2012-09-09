package com.acclivyx.rules;

public abstract class Rule implements IRule{
	protected String name;
	public Rule(String name) {
		this.name = name;
	}
}
