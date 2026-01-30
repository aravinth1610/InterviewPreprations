package com.logics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class VolwelsIArray {

	public static void main(String[] args) {
		CountNumberVowelIRange();
	}

	public static void volwelsICountString() {
		String name = "ramravigopal";
		List<Character> volwels = Arrays.asList('a', 'e', 'i', 'o', 'u');


		//Count
		long count = name.chars().mapToObj(c -> (char) c).filter(volwels::contains).count();

		//Remove the volwels and print in List
		List<Character> rmVolwels = name.chars().mapToObj(c -> (char) c).filter(c -> !volwels.contains(c)).collect(Collectors.toList());
		
		//Only Volwels and print in String
		String onlyVolwels = name.chars().mapToObj(c -> (char) c).filter(c -> volwels.contains(c)).map(c -> String.valueOf(c)).collect(Collectors.joining());
		
		System.out.println("Count ::"+count);
		
		System.out.println("Remove the Volwels in List ::"+rmVolwels);
		
		System.out.println("Only Volwels in String ::"+onlyVolwels);
	}

	public static void CountNumberVowelIRange() {
//		You are given a 0-indexed array of string words and two integers left and right.
//
//		A string is called a vowel string if it starts with a vowel character and ends with a vowel character where vowel characters are 'a', 'e', 'i', 'o', and 'u'.
//
//		Return the number of vowel strings words[i] where i belongs to the inclusive range [left, right].
//
//		 
//
//		Example 1:
//
//		Input: words = ["are","amy","u"], left = 0, right = 2
//		Output: 2
//		Explanation: 
//		- "are" is a vowel string because it starts with 'a' and ends with 'e'.
//		- "amy" is not a vowel string because it does not end with a vowel.
//		- "u" is a vowel string because it starts with 'u' and ends with 'u'.
//		The number of vowel strings in the mentioned range is 2.
//		Example 2:
//
//		Input: words = ["hey","aeo","mu","ooo","artro"], left = 1, right = 4
//		Output: 3
//		Explanation: 
//		- "aeo" is a vowel string because it starts with 'a' and ends with 'o'.
//		- "mu" is not a vowel string because it does not start with a vowel.
//		- "ooo" is a vowel string because it starts with 'o' and ends with 'o'.
//		- "artro" is a vowel string because it starts with 'a' and ends with 'o'.
//		The number of vowel strings in the mentioned range is 3.

		List<String> words = Arrays.asList("hey","aeo","mu","ooo","artro");
		List<Character> volwels = Arrays.asList('a', 'e', 'i', 'o', 'u');

		
		words.stream().filter(m -> m.chars().mapToObj(c ->(char) c).noneMatch(volwels::contains)).toList();
		
		List<String> ds = words.stream()
			    .filter(m ->
			        !m.isEmpty() &&
			        volwels.contains(m.charAt(0)) &&
			        volwels.contains(m.charAt(m.length() - 1))
			    )
			    .toList();

	System.out.println("ds: "+ds);
		
		
		Set<String> stValue = new HashSet<>();

		for (int i = 0; i < words.size(); i++) {

			int status = -2;
			char first = words.get(i).charAt(0);
			char last = words.get(i).charAt(words.get(i).length() - 1);

			for (int j = 0; j < volwels.size(); j++) {
				if (first == volwels.get(j)) {
					status = 0;
				}

				if (last == volwels.get(j)) {
					status = 1;

				}

			}
			if (status == 1) {
				System.out.println(words.get(i));
				stValue.add(words.get(i));
			}

		}

		System.out.println(stValue.stream().count());
	}

	public static void countVowelSubStringCount() {
//		A substring is a contiguous (non-empty) sequence of characters within a string.
//
//		A vowel substring is a substring that only consists of vowels ('a', 'e', 'i', 'o', and 'u') and has all five vowels present in it.
//
//		Given a string word, return the number of vowel substrings in word.
//
//		 
//
//		Example 1:
//
//		Input: word = "aeiouu"
//		Output: 2
//		Explanation: The vowel substrings of word are as follows (underlined):
//		- "aeiouu"
//		- "aeiouu"
//		Example 2:
//
//		Input: word = "unicornarihan"
//		Output: 0
//		Explanation: Not all 5 vowels are present, so there are no vowel substrings.
//		Example 3:
//
//		Input: word = "cuaieuouac"
//		Output: 7
//		Explanation: The vowel substrings of word are as follows (underlined):
//		- "cuaieuouac"
//		- "cuaieuouac"
//		- "cuaieuouac"
//		- "cuaieuouac"
//		- "cuaieuouac"
//		- "cuaieuouac"
//		- "cuaieuouac"

		String word = "cuaieuouac";
		 int vow = 0;
		
		char[] chWord = word.toCharArray();

		Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

		
		for (int i = 0; i < chWord.length; i++) {
			String stValue = "";
			Set<Character> seen = new HashSet<>();

			for (int j = i; j < chWord.length; j++) {
				//System.out.println(chWord[j]);
				if (vowels.contains(chWord[j])) {
					seen.add(chWord[j]);
					stValue = stValue + chWord[j];
					if(seen.size()==5) {
						vow++;
						System.out.println(stValue);
					}
					
				} else {
					stValue = "";
					break;
				}
			}
		}
		
		System.out.println(vow);

	}

}