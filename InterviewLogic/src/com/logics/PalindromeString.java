package com.logics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PalindromeString {

	public static void main(String[] args) {
		
		//op --> is my mother tongue
		
		String in= "Malayalam is my mother tongue"; //"He did a good deed";  
		
		String[] sp = in.split(" ");
		
		StringBuilder stBuilder = new StringBuilder();
		
		for(int i=0;i<sp.length;i++) {
			
			String  val = stBuilder.append(sp[i]).reverse().toString();
			
			if(!val.toLowerCase().equals(sp[i].toLowerCase())) {
				System.out.print(sp[i]+" ");
			}
		}
	}
	
	public static void test1() {
	    String in = "Malayalam is my mother tongue";

	    String val = Arrays.stream(in.split(" "))
	        .filter(word -> {
	            Set<Character> seen = new HashSet<>();
	            return word.toLowerCase()
	                       .chars()
	                       .allMatch(c -> seen.add((char) c));
	        })
	        .collect(Collectors.joining(" "));

	    System.out.println(val);
	}

}


