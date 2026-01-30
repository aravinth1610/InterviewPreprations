package com.logics;

 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
 
public class Test  {
 
public static void main(String[] args) {
 
//	System.out.println(LongestCommonPrefix()); 

	validPalindrome();

}

	public static Map<String, Long> groupByLenght() {

		List<String> words = Arrays.asList("banana", "banana", "cherry", "date", "fig");

		return words.stream().collect(Collectors.groupingBy(m -> m, Collectors.counting()));

	}

	public static Map<Object, Map<String, Object>> CustomerAddress() {

		//OP

		// {ravi={Address=[[fdsf, 3244]], count=1}, ram={Address=[[fdsf, 3244], [fdsf, 3244]], count=2}}

		Map<String, Object> data = new HashMap<>();

		data.put("author", "ram");

		data.put("authdddor", "ramrr");

		data.put("Address", Map.of("address", "line1"));
 
		Map<String, Object> data2 = new HashMap<>();

		data2.put("author", "ravi");

		data2.put("Address", Map.of("address", "line1"));
 
		Map<String, Object> data3 = new HashMap<>();

		data3.put("author", "ram");

		data3.put("Address", Map.of("address", "line2"));
 
		List<Map<String, Object>> author = Arrays.asList(data, data2, data3);


	//	System.out.println(author);

		return author.stream().collect(Collectors.groupingBy(m -> m.get("author"), Collectors.collectingAndThen(Collectors.toList(), m -> {

			System.out.println(m);

			Map<String, Object> st = new  HashMap<>();

			st.put("Count", m.size());

			st.put("address", m.stream().map(add -> add.get("Address")).toList());

			return st;

		})));	

	}

	public static Map<String, Map<String, Object>> evenAndOdd() {

		// OP: [even={Number=[even=98, even=34, even=32, even=42, even=80, even=100], Count=6}, Odd={Number=[Odd=11, Odd=23, Odd=15, Odd=99], Count=4}]
 
		List<Integer> num = Arrays.asList(2, 11, 23, 98, 34, 15, 32, 42, 80, 99, 100);
 
		return num.stream().map(m -> Map.entry(m%2== 0 ? "even" : "odd", m)).collect(Collectors.groupingBy(Entry::getKey, Collectors.collectingAndThen(Collectors.toList(), m -> {

			Map<String, Object> st = new HashMap<>();

			st.put("count", m.size());

			st.put("Number", m.stream().map(v -> v.getValue()).toList());

			return st;

		})));

	}

	public static List<String> sortStringValue() {

		List<String> colors = Arrays.asList("red", "red", "green", "blue", "black", "pink", "a");
 
		

		System.out.println("Rev"+ colors.stream().distinct().sorted(Comparator.comparing(String::valueOf, Comparator.reverseOrder())).toList());

		 return colors.stream().distinct().sorted(Comparator.comparing(String::valueOf)).toList();

	}

	public static List<Integer> sortIntegerValue() {

		List<Integer> colors = Arrays.asList(1, 8, 6, 4, 5, 1);

		return colors.stream().distinct().sorted().toList();

	}

	public static void maxMinValue() {

		List<Integer> num = Arrays.asList(11, 23, 98, 34, 15, 32, 42, 80, 99, 100);
 
		System.out.println("max: "+num.stream().sorted().max(Comparator.comparing(Integer::valueOf)).get() );

		System.out.println("min: "+num.stream().sorted().min(Comparator.comparing(Integer::valueOf)).get());

		System.out.println("Find Sec: "+num.stream().sorted().skip(1).findFirst().get());

	}
 
	public static Map<Object, Object> palidrom() {

		// OP: {mam=true, Madam=true, red=false, blue=false, black=false, defied=false}

		List<String> palllndrom = Arrays.asList("mam", "red", "Madam", "blue", "black", "defied");
 
		return palllndrom.stream().distinct().map(m ->  Map.entry(m, m.equalsIgnoreCase(new StringBuilder().append(m).reverse().toString()))).collect(Collectors.toMap(Entry::getKey, Entry::getValue));

	}

	public static void dateFormate() {

		// Find no.Of days,

		// Find no.of months

		// Find no.of years
 
		String date1 = "10/11/2023";

		String date2 = "11/12/2024";

		DateTimeFormatter dateformate = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	long days =	ChronoUnit.DAYS.between(LocalDate.parse(date1, dateformate), LocalDate.parse(date2, dateformate)) ;

	long month =	ChronoUnit.MONTHS.between(LocalDate.parse(date1, dateformate), LocalDate.parse(date2, dateformate)) ;

	long year =	ChronoUnit.YEARS.between(LocalDate.parse(date1, dateformate), LocalDate.parse(date2, dateformate)) ;

	System.out.println("Days: "+ days+ " month: "+ month+ " year: "+ year);

	}

	public static void stringWordCount() {

//		            Count Each Values:: [System=6, out=3, system=6, println=7, value=5, stream=6, collect=7, Collectors=10, groupingBy=10, String=6, length=6, Collectors=10, counting=8]

//				Count Each Values in Group:: {3=[out], 5=[value], 6=[System, system, stream, String, length], 7=[println, collect], 8=[counting], 10=[Collectors, groupingBy, Collectors]}

//				Counting Each Character of word:: {a=2, b=1, c=7, e=8, g=5, h=1, i=4, l=9, m=3, n=7, o=8, p=2, r=6, s=8, t=11, u=4, v=1, y=3}

//				Counting Each Character Arrays of word:: {counting={c=1, t=1, u=1, g=1, i=1, n=2, o=1}, Collectors={r=1, s=1, c=2, t=1, e=1, l=2, o=2}, groupingBy={p=1, b=1, r=1, u=1, g=2, y=1, i=1, n=1, o=1}, println={p=1, r=1, t=1, i=1, l=1, n=2}, system={s=2, t=1, e=1, y=1, m=1}, stream={a=1, r=1, s=1, t=1, e=1, m=1}, length={t=1, e=1, g=1, h=1, l=1, n=1}, String={r=1, s=1, t=1, g=1, i=1, n=1}, value={a=1, e=1, u=1, v=1, l=1}, collect={c=2, t=1, e=1, l=2, o=1}, System={s=2, t=1, e=1, y=1, m=1}, out={t=1, u=1, o=1}}

//				Same Word Count{counting=1, groupingby=1, println=1, collectors=2, system=2, string=1, stream=1, length=1, collect=1, value=1, out=1}
 
		

		String sent = "System.out.system.println(value.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())))";

		List<String> sp = Arrays.asList(sent.split("[^a-zA-z]+")) ;

		System.out.println("Count Each Values in Group:: "+sp.stream().collect(Collectors.groupingBy(m -> m.toLowerCase(), Collectors.counting())));

		System.out.println("Count Each Values:: "+sp.stream().map(m -> m + "="+m.length()).toList());

		System.out.println("Count the String value "+sent.chars().mapToObj(m -> (char) m).filter(m -> !m.toString().matches("[^a-zA-Z]+")) .collect(Collectors.groupingBy(m -> m, Collectors.counting())));

		Map<?, ?> val = sp.stream().map(m -> {

			Map<Character, Long> chVal = m.chars().mapToObj(c -> (char) c)

					.collect(Collectors.groupingBy(c -> Character.toLowerCase(c), Collectors.counting()));

			return Map.entry(m, chVal);

		}).distinct().collect(Collectors.toMap(Map.Entry::getKey, Entry::getValue));

		System.out.println("Counting Each Character Arrays of word:: " + val);

	}

	public static boolean brackets() {

		String ex1 = "[{((10)(20)(30))}]"; // True

		String ex2 = "((10)(20)(20(}"; // False

		String ex3 = "{[(](10)(20)30(40))}"; // False
 
		char[] ch = ex2.toCharArray();

		Stack<Character> st = new Stack<>();

		for(int i=0;i<ch.length;i++) {

		 Map<Character, Character> value =	 Map.of(')', '(','}', '{', ']', '[');

		 if(value.containsValue(ch[i])) {

			 st.push(ch[i]);

		 }

		 if(value.containsKey(ch[i])) {

			 if(st.isEmpty() || st.pop() != value.get(ch[i])) {

				 return false;

			 }

		 }

		}

		return true;

	}

	public static void palInter() {
 
		int num = Math.abs(-121);

		int numVal = Math.abs(-121) ;

		int st = 0;

		System.out.println("numVal"+ numVal);

		while(0 < numVal) {

			int l = numVal % 10;

			System.out.println(l);

			st = st * 10 + l;

			numVal = numVal / 10;

		}

		System.out.println(st == num);

	}

	public static String LongestCommonPrefix() {

		List<String> val = Arrays.asList("flower", "flightw", "floiooooooo");

		return val.stream().sorted().reduce((val1, val2) -> {

		int minLength = Math.min(val1.length(), val2.length());

		int subCount = 0;

		while(subCount < minLength ) {

			if(val1.charAt(subCount) == val2.charAt(subCount)) {

				subCount++;

			}else {

				System.out.println("pp");

				break;

			}
 
		}

			return val1.substring(0, subCount);

		}) .filter(s -> !s.isEmpty()).orElse("-");

	}

	public static void buyStock() {

//		You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

//

//		On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

//

//		Find and return the maximum profit you can achieve.

//

//		 

//

//		Example 1:

//

//		Input: prices = [7,1,5,3,6,4]

//		Output: 7

//		Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.

//		Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

//		Total profit is 4 + 3 = 7.

//		Example 2:

//

//		Input: prices = [1,2,3,4,5]

//		Output: 4

//		Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.

//		Total profit is 4.

//		Example 3:

//

//		Input: prices = [7,6,4,3,1]

//		Output: 0

//		Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 
	      List<Integer> in = Arrays.asList(7,1,5,3,6,4);

	      AtomicInteger stIn = new AtomicInteger(0);

	      in.stream().reduce((val1, val2) -> {

	      	if(val1 > val2) {

	      		return val2;

	      	}else {

	      		int st = val2 - val1;

	      		stIn.addAndGet(st);

	      		return val2;

	      	}

	      }).orElse(0);

	      System.out.println(stIn.get());

	}

	public static void findDuplicatesNumber() {

		List<Integer> num = Arrays.asList(7, 5,5, 3, 3, 6, 5, 4,1, 3);

		Set<Integer>  isVal = new HashSet<>();
		Set<Integer> duplicates = new HashSet<>();
		
		num.forEach(m -> {

			if(!isVal.add(m)) {
				duplicates.add(m);
				
			}

		});	

		System.out.println(duplicates);
		
		
	}

	public static void findDuplicatesNumber2() {

		List<Integer> num = Arrays.asList(7, 5,5, 3, 3, 6, 5, 4,1, 3);

		Set<Integer> duplicates = num.stream()
		        .collect(Collectors.groupingBy(
		                n -> n,
		                Collectors.counting()
		        ))
		        .entrySet()
		        .stream()
		        .filter(e -> e.getValue() <= 1)
		        .map(Map.Entry::getKey)
		        .collect(Collectors.toSet());

		System.out.println(duplicates);
		
		
	}
	 public static List<Character> hasDuplicate() {

		   String val = "Maximumi of mimnimum";

		   return val.chars().mapToObj(m -> (char) m).filter(c -> c != ' ').collect(Collectors.groupingBy(m -> m, Collectors.counting())).entrySet().stream().filter(m -> m.getValue() > 1).map(m -> m.getKey()).toList();

	 }

	 public static String longestPalindrome(String s) {

	        String longest = "";
 
	        for (int i = 0; i < s.length(); i++) {

	            for (int j = i + 1; j <= s.length(); j++) {

	                String sub = s.substring(i, j);

                     System.out.println("sub:: "+sub+" subLen: "+sub.length()+" long: "+ longest.length());

	                if (isPalindrome(sub) && sub.length() > longest.length()) {

	                    longest = sub;

	                    System.out.println("long "+ longest);

	                }

	            }

	        }

	        return longest;

	    }
 
	    private static boolean isPalindrome(String s) {

	        int left = 0, right = s.length() - 1;

System.out.println("left: "+left+" right: "+right);

	        while (left < right) {

	            if (s.charAt(left) != s.charAt(right)) {

	                return false;

	            }

	            left++;

	            right--;

	        }

	        return true;

	    }
	    
	    public static void validPalindrome() {
	    	 String[] tests = {
	    	            "aabaa",
	    	            "aabcaa",
	    	            "aacaad",
	    	            "faacaa",
	    	            "aabcdeaa"
	    	        };
	    	 
	    	 
	    	 String val = "aabcaa";
	    	 for(int i =0 , j = val.length() -1 ;i< val.length();i++, j--) {
	    		 
	    		 char firstIndex = val.charAt(i);
	    		 char lastIndex = val.charAt(val.length() -1 -i);
	    		 
	    		 System.out.println(firstIndex+"-"+lastIndex);
	    		 
	    		 if(firstIndex != lastIndex) {
	    			 System.out.println(pal(val, i+1, j) || pal(val, i, j-1)) ;
	    		 }
	    		 
	    	 }
	    }
	    
	    public static boolean pal(String v , int f , int l) {
	    	
	    	while(f < l) {
	    		if(v.charAt(f++) != v.charAt(l--)) {
	    			return false;
	    		}
	    		
	    	}
			return true;
	    	
	    }
 	    
	    public static void validPalindromeWithoutDel() {

	        String val = "aabcaa";
	        boolean isPalindrome = true;

	        for (int i = 0; i < val.length() / 2; i++) {

	            char firstIndex = val.charAt(i);
	            char lastIndex  = val.charAt(val.length() - 1 - i);

	            System.out.println(firstIndex + "-" + lastIndex);

	            if (firstIndex != lastIndex) {
	                isPalindrome = false;
	                break;
	            }
	        }

	        System.out.println("Palindrome: " + isPalindrome);
	    }
}

/////////////////



class customeLinkedList{
	
	Node head;
	
	public void add(int add) {
		Node node = new Node(add);
		
		if(head == null) {
			head = node;
		}
		
		Node current = node;
		
		if(current.next != null) {
			current = current.next;
		}
		
		current.next = current;
	}
	
	public void getFirst(int add) {
		Node node = new Node(add);
		
		node.next = head;
		
		head = node;
	}
	
}

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

 
