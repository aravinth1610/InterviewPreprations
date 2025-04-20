package com.logics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class findDuplicatesNumber {

	public static void main(String[] args) {

		List<Integer> num = Arrays.asList(7, 5, 3, 6, 4,1);
		System.out.println(hasDuplicates(num));
	}

	public static boolean hasDuplicates(List<Integer> numbers) {
//        boolean inval =false;
//        for(int i=0;i<numbers.size();i++) {
//        	if(!unique.add(numbers.get(i))){
//        		inval = true;
//        	}
//        }
//        System.out.println();

		Set<Integer> unique = new HashSet<>();

        return numbers.stream().anyMatch(n -> !unique.add(n));
    }
	

	
	

}
