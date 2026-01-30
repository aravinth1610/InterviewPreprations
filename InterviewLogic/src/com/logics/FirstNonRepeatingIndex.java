package com.logics;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatingIndex {

	
	public static void main(String[] args) {
		List<String> ar = Arrays.asList("teeter", "java", "aabb");
		
//        for(int i=0;i<ar.size();i++) {
//        	System.out.println(firstUniqueIndex(ar.get(i)));
//        }
		
		nonRep();
		
	}
	
	public static int firstUniqueIndex(String val) {
		Map<Character, Long> getVal = val.chars().mapToObj(m -> (char) m).collect(Collectors.groupingBy(m -> m, Collectors.counting()));
		
		for(int i=0;i<val.length();i++) {
			
			
			
			if(getVal.get(val.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}
	
	public static int nonRep() {
		String val = "teeter";
		
		char[] ch = val.toCharArray();
		for(int i=0 ;i<ch.length;i++) {
			
			if(val.indexOf(ch[i]) == val.lastIndexOf(ch[i])) {
			return i;
			}
		}
		return -1;
	}
}
