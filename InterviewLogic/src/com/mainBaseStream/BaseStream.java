package com.mainBaseStream;
 
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class BaseStream {
 
	public static void main(String[] args) {
		mergeTwoUnSortedArrayToSingleArray();
	}
 
	public static void seprateOddAndEven() {
		List<Integer> numbers = Arrays.asList(1,6,2,4,7,2,5,11,66);
		
		Map<Object, Object> data = numbers.stream()
				.distinct().map(number -> Map.entry(number, number%2 == 0 ? "even" : "odd")).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
		
		System.out.println(data);
		
		// {1=odd, 2=even, 66=even, 4=even, 5=odd, 6=even, 7=odd, 11=odd}
	}
	
	public static void onlyOdd() {
		List<Integer> numbers = Arrays.asList(1,6,2,4,7,2,5,11,66);
		
		List<Integer> values = numbers.stream().filter(number -> number%2!=0).map(m -> m).toList();
		
		System.out.println(values);
		// [1, 7, 5, 11]
	}
 
	public static void removeDuplicate() {
		
		List<String> values = Arrays.asList("apple", "mango", "apple", "mango");
		
		List<String> step1 = values.stream().distinct().toList();
		
		System.out.println("Distinct: "+ step1);
		
		//O.P Distinct: [apple, mango]
		
		Set<String> stVal = new HashSet<>();
		
		List<String> step2 = values.stream().filter(val -> stVal.add(val)).map(m -> m).toList();
		
		System.out.println("St_Set: "+step2);
		
		//O.P St_Set: [apple, mango]
	}
	
	public static void frequenceOfEachCharInString() {
		
		String val = "Maximumi of mimnimum";
		   
		Map<Character, Long> result = val.chars().mapToObj(v -> (char) v)
				.filter(m -> m!=' ').collect(Collectors.groupingBy(m -> m, Collectors.counting()));
		System.out.println(result);
		
		//O.P {a=1, u=2, f=1, x=1, i=4, m=6, M=1, n=1, o=1}
	}
 
	public static void mostFrequenceOfEachCharInString() {
		
		String val = "Maximumi of mimnimum";
		   
		String result = val.chars().mapToObj(m -> (char) m).filter(m -> m!=' ')
				.collect(Collectors.groupingBy(m -> m, Collectors.counting()))
				.entrySet().stream().filter(m -> m.getValue() > 1).map(m ->  m.getKey().toString()).collect(Collectors.joining());
	
	      System.out.println(result);
	      //O.P uim
	}
	
	public static void maxFrequenceOfEachCharInString() {
		
		String val = "Maximumi of mimnimum";
		   
		Character result = val.chars().mapToObj(m -> (char) m).filter(m -> m!=' ')
				.collect(Collectors.groupingBy(m -> m, Collectors.counting()))
				.entrySet().stream().max(Entry.comparingByValue()).get().getKey();
	
	      System.out.println(result);
	      //O.P m
	}
	
	public static void frequenceOfEachElementInArray() {
		List<String> values = Arrays.asList("apple", "mango", "apple", "mango", "banana");
 
		Set<String> result =  values.stream().collect(Collectors.groupingBy(m -> m, Collectors.counting())).keySet();
		System.out.println(result);
		
           //O.P	[banana, apple, mango]
	}
	
	public static void sortInOrder() {
		
		List<String> values = Arrays.asList("apple", "mango", "apple", "mango", "banana","aaaa","bbb");
 
		List<String> stringValue = values.stream().sorted().toList();
		
		System.out.println("Sort String: "+stringValue);
		
		// O.P Sort String: [aaaa, apple, apple, banana, bbb, mango, mango]
 
		List<String> stringValueRev = values.stream().sorted(Comparator.comparing(m -> m, Comparator.reverseOrder())).toList();
		
		System.out.println("Reverse Sort String: "+stringValueRev);
		
		// O.P Reverse Sort String: [mango, mango, bbb, banana, apple, apple, aaaa]
	}
	
	public static void joinWithDelimiterPrefixSuffix() {
		
		// Join 1st will be place in CENTER , 2nd as PREFIX and last will be SUFFIX
		
		List<String> values = Arrays.asList("apple", "mango", "apple", "mango");
		String result = values.stream().collect(Collectors.joining(" join ", " prefix ", " suffix "));
		System.out.println(result);
		
		//O.P  prefix apple join mango join apple join mango suffix
	}
 
	public static void maxAndMin() {
		List<Integer> numbers = Arrays.asList(1,6,2,4,7,2,5,11,66);
		
	      Integer maxValue = numbers.stream().sorted().max(Comparator.comparing(m -> m)).get();
	      
	      System.out.println("max: "+ maxValue);
            
	      Integer minValue = numbers.stream().sorted().min(Comparator.comparing(m -> m)).get();
	      
	      System.out.println("min: "+ minValue);
	     
	      Integer secMinValue = numbers.stream().sorted().skip(1).min(Comparator.comparing(m -> m)).get();
	      
	      System.out.println("Sec min: "+ secMinValue);
		
	}
	
	public static void mergeTwoUnSortedArrayToSingleArray() {
		List<String> values1 = Arrays.asList("apple", "mango", "apple", "mango", "banana","aaaa");
		List<String> values2 = Arrays.asList("apple", "mango","bbb", "ccc");
		
           //Using Stream.of
           List<String> result1 = Stream.of(values1, values2).flatMap(m -> m.stream()).distinct().sorted().toList();
           
           System.out.println(result1);
		
           // O.P [aaaa, apple, banana, bbb, ccc, mango]
 
           //Using ArrayList
           List<String> result2 = Arrays.asList(values1, values2).stream().flatMap(m -> m.stream()).map(m -> m).distinct().sorted().toList();
 
           System.out.println(result2);
           
           //O.P [aaaa, apple, banana, bbb, ccc, mango]
	}
	
 
	
}