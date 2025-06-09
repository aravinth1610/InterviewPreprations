package com.logics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMerge {

	public static void main(String[] args) {
		Map<String, Integer> map1 = Map.of("English", 1,"Maths",5,"Science", 5);
		Map<String, Integer> map2 = Map.of("English", 2,"Maths",5,"Science", 5);
		Map<String, Integer> map3 = Map.of("English", 2,"Maths",5,"Science", 5);
		
		
		List<Map<String, Integer>> allMap = List.of(map1,map2,map3);
		
		Map<String, Integer> stMap = new HashMap<>();
		
		for(Map<String, Integer> map : allMap) {
			map.forEach((k, v) -> {
				stMap.merge(k, v, Integer::sum);	
			});
		}
		System.out.println(stMap);
		
	}
}
