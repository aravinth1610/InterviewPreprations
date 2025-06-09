package com.logics;

/**
 * Input: ["a","a","b","b","b","b","b","b","b","b","b","b"] Output:
 * ["a","2","b","1","0"] Explanation: The character 'a' is repeated 2 times, and
 * 'b' is repeated 10 times, resulting in the compressed form
 * ["a","2","b","1","0"].
 */

public class StringSplit {

	public static void main(String[] args) {

		String val = "a3b54252";

		StringSpl(val);
	}

	public static void StringSpl(String val) {

		char[] charVal = val.toCharArray();

		for (int i = 0; i < charVal.length; i++) {
			if (Character.isDigit(charVal[i])) {
				int digit = Character.getNumericValue(charVal[i]);
				for (int j = 0; j < digit; j++) {
					System.out.print(charVal[i - 1]);
				}

			}
		}

	}

}
