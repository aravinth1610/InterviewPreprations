package com.logics;

public class PalondromeInteger {

	public static void main(String[] args) {
		
		// 626 True 643 False
		
		int in = 626;
		
		int stLast = 0;
		
		while(0 < in) {
			int lastValue = in%10;
			System.out.println("last"+lastValue);
			stLast = (stLast * 10) + lastValue;
			System.out.println(stLast);
			in = in/10;
		}
		
	}
	
}
