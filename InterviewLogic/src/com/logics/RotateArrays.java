package com.logics;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class RotateArrays {

	public static void main(String[] args) {
//		Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//
//		 
//
//		Example 1:
//
//		Input: nums = [1,2,3,4,5,6,7], k = 3
//		Output: [5,6,7,1,2,3,4]
//		Explanation:
//		rotate 1 steps to the right: [7,1,2,3,4,5,6]
//		rotate 2 steps to the right: [6,7,1,2,3,4,5]
//		rotate 3 steps to the right: [5,6,7,1,2,3,4]
//
//		Example 2:
//
//		Input: nums = [-1,-100,3,99], k = 2
//		Output: [3,99,-1,-100]
//		Explanation: 
//		rotate 1 steps to the right: [99,-1,-100,3]
//		rotate 2 steps to the right: [3,99,-1,-100]
		
		
		List<Integer> num = Arrays.asList(-1,-100,3,99);
		
		
		Deque<Integer> deque = new ArrayDeque<>();
		deque.addAll(num);

	
		for(int i=0;i<2;i++) {
			int val = deque.removeLast();
			deque.addFirst(val);
		}
		
		System.out.println(deque);
	}
}