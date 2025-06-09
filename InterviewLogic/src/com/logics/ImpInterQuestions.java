package com.logics;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;


public class ImpInterQuestions {
	public static void main(String[] args) throws IOException {
		getShiftedString("fdsfds",2,1);
	}
	
	/*
	 * Complete the 'getShiftedString' function below.
	 *
	 * The function is expected to return a STRING. The function accepts following
	 * parameters: 1. STRING s 2. INTEGER leftShifts 3. INTEGER rightShifts
	 */

	public static String getShiftedString(String s, int leftShifts, int rightShifts) {
		// Write your code here
		System.out.println("===" + s + "-" + leftShifts + "-" + rightShifts);
		List<Character> list = s.chars().mapToObj(m -> (char) m).toList(); //////////////////
		Deque<Character> deque = new ArrayDeque<>();
		deque.addAll(list);

		for (int i = 0; i < leftShifts; i++) {
			char v = deque.removeFirst();
			deque.addLast(v);
		}

		for (int i = 0; i < rightShifts; i++) {
			char v = deque.removeLast();
			deque.addFirst(v);
		}

		return deque.stream().map(String::valueOf).collect(Collectors.joining()); ////////////////////////
	}


}
