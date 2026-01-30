package com.logics;

 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class GroupAnagrams {
 
	public static void main(String[] args) {
//		Input: strs = ["eat","tea","tan","ate","nat","bat"]
//
//				Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//				Explanation:
//
//				There is no string in strs that can be rearranged to form "bat".
//				The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
//				The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
		
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		
		Map<String, List<String>> st = new HashMap<>();
		
		for(int i=0;i<strs.length;i++){
		        char[] ch = strs[i].toCharArray();
		        Arrays.sort(ch);
		        String key = String.valueOf(ch);
		        
		        List<String> s = st.get(key);
		        if (s == null) {
		              s = new ArrayList<>();
		              st.put(key, s);
		          }
		        s.add(strs[i]);
			      
		        
		      }
 
		System.out.println(st.values());
		
	}
 
}
 
 
