package com.logics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicatCount {

	public static void main(String[] args) {
		
		//// op -> ara 2 ravi 2 ram 3 7

		List<String> n = Arrays.asList("ara", "ravi", "ara", "ram", "ram", "ravi", "ram");

		System.out.println(n.stream().collect(Collectors.groupingBy(m -> m, Collectors.counting())));
	}
}
