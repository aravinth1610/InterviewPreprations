package com.logics;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicatesString {

	public static void main(String[] args) {
		String in = "Maximumi of mimnimum";
		String in2 = "CsharpstarZ";

		String[] data = in.split(" ");
		String datas = "";
		for (int i = 0; i < data.length; i++) {
			datas += data[i];
		}
		System.out.println(datas);

		Map<Object, Long> countVal =  datas.toLowerCase().trim().chars().mapToObj(m -> (char) m)
				.collect(Collectors.groupingBy(v -> v, Collectors.counting()));
		
		System.out.println(countVal);
		
		Stream<Entry<Object, Long>> AssData =  countVal.entrySet().stream().sorted(Entry.comparingByValue());
		
		AssData.forEach(m -> {
			
			if(1 < m.getValue()) {
				System.out.println(m.getKey());
			}
			
		});
		
	}

}