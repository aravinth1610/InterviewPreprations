package com.logics;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
 
public class MaximumProductWordLengths {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		productWordLength();
	}
	public static void productWordLength() {
		 String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
		 
		 List<String> wordsList = Arrays.asList(words);
		 AtomicInteger val = new AtomicInteger(0);
		 
		 wordsList.stream().filter(w -> w.length() > 0).reduce((val1, val2) -> {
			 List<Character> next = val2.chars().mapToObj(c -> (char) c).toList();
			if(val1.chars().mapToObj(m -> (char) m).anyMatch(next::contains)) {
				return val1;
			}else {
				System.out.println(val1 +" -"+val2);
				int vl = val1.length() * val2.length();
				if(val.get()  < vl) {
					val.set(vl);
				}
				System.out.println(val.get());
			}
			 return val1;
		 });
		 System.out.println(val);
	}
 
}