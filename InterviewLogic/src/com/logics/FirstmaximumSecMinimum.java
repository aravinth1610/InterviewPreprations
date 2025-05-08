package com.logics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FirstmaximumSecMinimum {

	public static void main(String[] args) {

		/*
		 * OP {7, 1, 6, 2, 5, 3, 4}
		 */

//		int[] num={1, 6, 4, 3, 7,5, 2};

		approach2();
	}
	
	
	public static void approach1() {
		List<Integer> actualList = Arrays.asList(1, 6, 4, 3, 7, 5, 2);

		Collections.sort(actualList);

		List<Integer> asc = new ArrayList<>(actualList);

		Collections.reverse(actualList);

		List<Integer> desc = new ArrayList<>(actualList);

//		asc.forEach((data) -> System.out.println(data));
//
//		desc.forEach((data) -> System.out.println(data));

		List<Integer> solution = new ArrayList<>();
		if (actualList.size() % 2 != 0) {
			for (int i = 0; i < asc.size() / 2; i++) {
				solution.add(desc.get(i));
				solution.add(asc.get(i));
			}
		}

		solution.add(asc.get(asc.size() / 2));

		System.out.println(solution);

	}

	public static void approach2() {
		List<Integer> actualList = Arrays.asList(1, 6, 4, 3, 7, 5, 2);

		Collections.sort(actualList);

		for(int i=0;i<actualList.size();i++) {
			
			int size = actualList.size();
			
			int desc = actualList.get((size-1) - i);
			int asc = actualList.get(i);
			
			if (desc == asc) {
			System.out.println(asc);
		         break;
			}
			
			System.out.println(desc);
			System.out.println(asc);
            	
		}		
	}
	
}