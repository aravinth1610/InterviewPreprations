package com.logics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxSubArray {

	public static void main(String[] args) {
		
		List<Integer> val = Arrays.asList(-2,1,-3,4,-1,2,1,-5,4);
		List<Integer> val1 = Arrays.asList(5,4,-1, 7,8);
		maxSubArrays(val);
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
	
}