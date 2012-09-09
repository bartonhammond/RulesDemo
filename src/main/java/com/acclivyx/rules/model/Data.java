package com.acclivyx.rules.model;
/**
 * Class to hold arguments from command line
 * or UI 
 * Adds ability to split the string
 * 
 * @author Barton
 *
 */
public class Data {
	private String input;
	
	public String getInput() {
		return input;
	}
	/**
	 * 
	 * @param input - space delimited tokens
	 */
	public void setInput(String input) {
		this.input = input;
	}
	/**
	 * Split the input tokens by spaces
	 * @return array of input
	 */
	public String[] args() {
		if (input != null) {
			return input.split("\\s+");
		} else {
			return null;
		}
	}
}