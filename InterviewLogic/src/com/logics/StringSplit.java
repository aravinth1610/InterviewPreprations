package com.logics;

/**
 * Input: ["a","a","b","b","b","b","b","b","b","b","b","b"] Output:
 * ["a","2","b","1","0"] Explanation: The character 'a' is repeated 2 times, and
 * 'b' is repeated 10 times, resulting in the compressed form
 * ["a","2","b","1","0"].
 */

public class StringSplit {

	public static void main(String[] args) {

		String val = "a3b10";

		StringSpl(val);
	}

	public static void StringSpl(String val) {

		StringBuilder stb = new StringBuilder();
		char[] charVal = val.toCharArray();

		int digitSt = 0;
		char stValue = 0;
		
		for(int i=0;i<charVal.length;i++) {
			
			
			if(Character.isDigit(charVal[i])) {
				digitSt = digitSt * 10 + (charVal[i] - '0');
			}else {
				if(digitSt != 0 && stValue != 0) {
				stb.append(String.valueOf(stValue).repeat(digitSt));	
				}
				
				stValue = charVal[i];
				digitSt = 0;
			}
		}
		
		stb.append(String.valueOf(stValue).repeat(digitSt));
		
		System.out.println(stb);
		

	}

}
