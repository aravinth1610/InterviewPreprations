package com.logics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumDis {

	public static void main(String[] args) {

//		Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
//
//				 
//
//				Example 1:
//
//				Input: nums = [4,3,2,7,8,2,3,1]
//				Output: [5,6]
//
//				Example 2:
//
//				Input: nums = [1,1]
//				Output: [2]

		List<Integer> numVal = Arrays.asList(1,1);
		Set<Integer> num = new HashSet<Integer>(numVal);

		Collections.sort(numVal);

		int max = numVal.size()+1;
		// System.out.println(max);

		for (int i = 1; i < max; i++) {
			if (!num.contains(i)) {  // set can't contain get(), but in Object data can see the value is present
				System.out.println(i);
			}

		}

	}
}
