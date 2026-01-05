package com.logics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxSubArray {

	public static void main(String[] args) {
		
		List<Integer> val = Arrays.asList(-2,1,-3,4,-1,2,1,-5,4);
		List<Integer> val1 = Arrays.asList(5,4,-1, 7,8);
		maxSubArraysSec(val);
	}
	
	public static void maxSubArrays(List<Integer> vals) {

		int stVals =0;
		List<Integer> values = new ArrayList<Integer>();

		
		for(int i=0;i<vals.size();i++) {
			
			if(stVals < 0) {
				stVals =0;
			}
			
			stVals = stVals + vals.get(i);
			values.add(stVals);
		}
		System.out.println(values.toString());
		
		 System.out.println(values.stream().max(Comparator.comparing(Integer::intValue)).get());
		
	}
	
	
	public static void maxSubArraysSec(List<Integer> vals) {
		
		List<Integer> in = new ArrayList<Integer>();
		
	 vals.stream().reduce((val1, val2) -> {
			
			if(val1 < 0) {
				val1 = 0;
			}
			
			val1 = val1 + val2;
					
			in.add(val1);
			
			return val1;		
		});
	 
		System.out.println(in.stream().max(Comparator.comparing(Integer::valueOf)).get());
		
	}
	
}