package com.logics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicatesString {

	public static void main(String[] args) {
		
		duplicateValueSec();
		
//		String in = "Maximumi of mimnimum";
//		String in2 = "CsharpstarZ";
//
//		String[] data = in.split(" ");
//		String datas = "";
//		for (int i = 0; i < data.length; i++) {
//			datas += data[i];
//		}
//		System.out.println(datas);
//
//		Map<Object, Long> countVal =  datas.toLowerCase().trim().chars().mapToObj(m -> (char) m)
//				.collect(Collectors.groupingBy(v -> v, Collectors.counting()));
//		
//		System.out.println(countVal);
//		
//		Stream<Entry<Object, Long>> AssData =  countVal.entrySet().stream().sorted(Entry.comparingByValue());
//		
//		AssData.forEach(m -> {
//			
//			if(1 < m.getValue()) {
//				System.out.println(m.getKey());
//			}
//			
//		});
		
	}
	
	public static void duplicateValue() {
		String in = "Maximumi of mimnimum";
		String in2 = "CsharpstarZ";

		Set<Character> val = new HashSet<Character>();
		Set<Character> stVal = new HashSet<Character>();
		
		in2.trim().toLowerCase().chars().mapToObj(m -> (char) m).filter(m -> m != ' ').forEach(m -> {
			boolean isValue = !val.add(m);

			if(isValue) {
				stVal.add(m);
			}			
		});
		
		System.out.println(stVal);
		
	}
	
	public static void duplicateValueSec() {
		String in = "Maximumi of mimnimum";
		String in2 = "CsharpstarZ";

		List<Character> val = in.trim().toLowerCase().chars().mapToObj(m -> (char) m).filter(m -> m!=' ').collect(Collectors.groupingBy(m -> m, Collectors.counting())).entrySet().stream().filter(m -> m.getValue() > 1).map(Entry::getKey).collect(Collectors.toList());
	    System.out.println(val);
	
	}

}