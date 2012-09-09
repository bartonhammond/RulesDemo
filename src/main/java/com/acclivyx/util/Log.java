package com.acclivyx.util;
/**
 * Simple logging class so that changing to something like Log4J wouldn't
 * require a lot of code changes....at least thats the idea.
 * 
 * @author Barton
 *
 */
public class Log {
	/**
	 * Print the message to system out.
	 * @param msg
	 */
	public static void message(String msg) {
		System.out.println(msg);
	}
}
