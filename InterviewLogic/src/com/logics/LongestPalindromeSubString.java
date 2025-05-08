package com.logics;

public class LongestPalindromeSubString {

	public static void main(String[] args) {
		
//		   Example 1:
//
//			Input: s = "babad"
//			Output: "bab"
//			Explanation: "aba" is also a valid answer.
//
//			Example 2:
//
//			Input: s = "cbbd"
//			Output: "bb"

		String in = "babad";
		
		System.out.println(pallString(in));
		

	}
	
	public static String pallString(String in) {
		for(int i=0;i<in.length();i++) {
			char fVal = in.charAt(i);
			String stVal = ""+fVal;
			
			for(int j=i+1;j<in.length();j++) {
				
				stVal = stVal + in.charAt(j) ;
				
				//System.out.println(stVal);
				
				String revString = new StringBuilder().append(stVal).reverse().toString();
				
				if(revString.equalsIgnoreCase(stVal)) {
					//System.out.println(stVal);
					return stVal;
				}
				
			}
		}
		return "";
	}
	
}