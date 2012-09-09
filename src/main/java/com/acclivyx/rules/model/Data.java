package com.acclivyx.rules.model;

public class Data {
	private String input;
	
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	public String[] args() {
		return input.split("\\s+");
	}
}