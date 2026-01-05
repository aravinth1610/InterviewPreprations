package com.logics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllLogic {

	public static void main(String[] args) {

		LongestCommonPrefix();
	}

	public static void groupByLenght() {
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig");

		Map<Integer, List<String>> ds = words.stream().collect(Collectors.groupingBy(String::length));

		System.out.println(ds);
	}

	public static void groupData() {

		List<String> user = Arrays.asList("ram", "ravi", "ram");
		List<String> address = Arrays.asList("fdsf", "3244");

		Map<String, Object> data = new HashMap<>();
		data.put("author", "ram");
		data.put("Address", address);

		Map<String, Object> data2 = new HashMap<>();
		data2.put("author", "ravi");
		data2.put("Address", address);

		Map<String, Object> data3 = new HashMap<>();
		data3.put("author", "ram");
		data3.put("Address", address);

		List<Map<String, Object>> author = new ArrayList<>();
		author.add(data);
		author.add(data2);
		author.add(data3);

		Map<Object, Object> grpAuthor = author.stream().collect(Collectors.groupingBy(map -> map.get("author"),
				Collectors.collectingAndThen(Collectors.toList(), m -> {

					Map<String, Object> collData = new HashMap<>();

					collData.put("count", m.size());

					collData.put("Address",
							m.stream().map(add -> add.get("Address")).collect(Collectors.toList()));

					return collData;
				})));

		System.out.println(grpAuthor);
	}

	public static void evenAndOddOne() {
		List<Integer> num = Arrays.asList(11, 23, 98, 34, 15, 32, 42, 80, 99, 100);

		Map<String, Map<String, Object>> result = num.stream().map(n -> {
			if (n % 2 == 0) {

				return Map.entry("even", n);
			} else {
				return Map.entry("Odd", n);
			}
		}).collect(Collectors.groupingBy(Entry::getKey, Collectors.collectingAndThen(Collectors.toList(), l -> {
			return Map.of("Count", l.size(), "Number", l);
		}
		// Collectors.mapping(Map.Entry::getValue, Collectors.toList()
		)));

		System.out.println(result);
	}

	public void evenOrOddSec() {
		List<Integer> num = Arrays.asList(11, 23, 98, 34, 15, 32, 42, 80, 99, 100);

		num.stream().map(n -> Map.entry(n % 2 == 0 ? "even" : "odd", n)).collect(Collectors
				.groupingBy(Map.Entry::getKey, Collectors.collectingAndThen(Collectors.toList(), m -> {
					Map<String, Object> collData = new HashMap<>();

					collData.put("count", m.size());

					collData.put("Number", m);

					return collData;
				})));
	}

	public static void sortStringValue() {
		List<String> colors = Arrays.asList("red", "red", "green", "blue", "black", "pink");

		System.out.println(colors.stream().distinct().sorted(Comparator.comparing(String::toString))
				.collect(Collectors.toList()));
	}

	public static void sortIntegerValue() {
		List<Integer> colors = Arrays.asList(1, 8, 6, 4, 5, 1);

		System.out.println(colors.stream().distinct().sorted().collect(Collectors.toList()));
	}

	public static void maxMinValue() {
		List<Integer> num = Arrays.asList(11, 23, 98, 34, 15, 32, 42, 80, 99, 100);

		System.out.println("Max :: "
				+ num.stream().distinct().sorted().max(Comparator.comparing(Integer::intValue)).get() + ", Min"
				+ num.stream().distinct().sorted().min(Comparator.comparing(Integer::intValue)).get());
	}

	public static void secLarg() {
		List<Integer> num = Arrays.asList(11, 23, 98, 34, 15, 32, 42, 80, 99, 100);

		System.out.println(num.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
	}

	public static void palidrom() {
		// OP: {mam=true, Madam=true, red=false, blue=false, black=false, defied=false}
		List<String> palllndrom = Arrays.asList("mam", "red", "Madam", "blue", "black", "defied");

		Map<?, ?> palVal = palllndrom.stream().distinct().map(pal -> {
			Boolean isPal = pal.equalsIgnoreCase(new StringBuilder().append(pal).reverse().toString());
			// Map<String, Boolean> b = new HashMap<String, Boolean>();
			// b.put(pal, isPal);
			// return b;
			return Map.entry(pal, isPal);
		})
				// .flatMap(map -> map.entrySet().stream()) // If we use to return Map we need
				// to use FlatMap
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(palVal);
	}

	public static void dateFormate() {
		// Find no.Of days,
		// Find no.of months
		// Find no.of years

		String date1 = "10/11/2023";
		String date2 = "11/12/2024";

		DateTimeFormatter formate = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // It need to MM not mm

		LocalDate dateVal = LocalDate.parse(date1, formate);
		LocalDate dateVal2 = LocalDate.parse(date2, formate);

		long years = ChronoUnit.YEARS.between(dateVal, dateVal2);
		long months = ChronoUnit.MONTHS.between(dateVal, dateVal2);
		long days = ChronoUnit.DAYS.between(dateVal, dateVal2);

		System.out.println("Years between: " + years); // 3
		System.out.println("Months between: " + months); // 39
		System.out.println("Days between: " + days); // 1189

	}

	public static void groupByKeyAndValue() {
		// O.P 3 :: 2
		// 4 :: 1
		// 5 :: 1

		List<String> value = List.of("one", "two", "three", "four");
		System.out.println(value.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
	}

	public static void stringWordCount() {
		String sent = "System.out.system.println(value.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())))";

		List<String> spSent = Arrays.asList(sent.split("[^a-zA-Z]+"));

		System.out.println("Count Each Values:: "
				+ spSent.stream().map(m -> m + "=" + m.length()).collect(Collectors.toList()));

		System.out.println("Count Each Values in Group:: "
				+ spSent.stream().collect(Collectors.groupingBy(String::length)));

		System.out.println("Counting Each Character of word:: "
				+ spSent.stream().flatMap(m -> m.chars().mapToObj(c -> (char) c)).collect(
						Collectors.groupingBy(m -> Character.toLowerCase(m), Collectors.counting())));

		Map<?, ?> val = spSent.stream().map(m -> {
			Map<Character, Long> chVal = m.chars().mapToObj(c -> (char) c)
					.collect(Collectors.groupingBy(c -> Character.toLowerCase(c), Collectors.counting()));
			return Map.entry(m, chVal);
		}).distinct().collect(Collectors.toMap(Entry::getKey, Entry::getValue));

		System.out.println("Counting Each Character Arrays of word:: " + val);

		System.out.println("Same Word Count"
				+ spSent.stream().collect(Collectors.groupingBy(m -> m.toLowerCase(), Collectors.counting())));

	}

	public static void brackets() {
		String ex1 = "[{((10)(20)(30))}]"; // True
		String ex2 = "((10)(20)(20(}"; // False
		String ex3 = "{[(](10)(20)30(40))}"; // False

		Stack<Character> stValue = new Stack<>();

		AtomicBoolean isValid = new AtomicBoolean(true);

		ex3.chars().mapToObj(m -> (char) m).forEach(c -> {
			Map<Character, Character> bracketPairs = Map.of(')', '(', '}', '{', ']', '[');

			if (bracketPairs.containsValue(c)) {
				stValue.push(c);
			} else if (bracketPairs.containsKey(c)) {
				if (stValue.isEmpty() || stValue.pop() != bracketPairs.get(c)) {
					isValid.set(false);
				}
			}
		});
		System.out.println(stValue.empty() && isValid.get());
	}

	public static void palInter() {

		int numVal = -121;
		int num = 121;

		int val = 0;
		while (num > 0) {
			int last = num % 10;
			val = val * 10 + last;
			num = num / 10;
		}
		System.out.println(numVal == val);

		System.out.println("Pal =" + String.valueOf(numVal)
				.equalsIgnoreCase(new StringBuilder().append(String.valueOf(numVal)).reverse().toString()));
	}

	public static void romancNumber() {
		String s = "LVIII";

		Map<Character, Integer> stVal = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

		AtomicInteger atomicVal = new AtomicInteger(0);

		s.chars().mapToObj(m -> (char) m).forEach(c -> {

			if (stVal.containsKey(c)) {
				atomicVal.addAndGet(stVal.get(c));
			}
		});
		System.out.println(atomicVal.get());
	}

	public static void LongestCommonPrefix() {
		List<String> val = Arrays.asList("flower", "flow", "flight");

		String result = val.stream().sorted().reduce((s1, s2) -> {

			int i = 0;
			int min = Math.min(s1.length(), s2.length());
			while (i < min && s1.charAt(i) == s2.charAt(i)) {
				i++;
			}

			return s1.substring(0, i);

		}).orElse("");

		System.out.println(result);
	}

	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
		}

	}

	public static void BinTreeInOrder() {

		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		root.right = new TreeNode(5);

		List<Integer> result = new ArrayList<>();
		inorder(root, result);
		System.out.println(result);
	}

	public static void inorder(TreeNode node, List<Integer> result) {
		if (node == null) {
			return;
		}

		System.out.println("comes IN" + node.val);

		inorder(node.left, result); // left
		result.add(node.val); // root
		inorder(node.right, result); // right
	}

	public static void isSameTree() {
		TreeNode node1 = new TreeNode(1);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(3);

		TreeNode node2 = new TreeNode(1);
		node2.left = new TreeNode(2);
		node2.right = new TreeNode(3);

		List<Integer> nodeR1 = new ArrayList<>();

		parseNodeValue(node1, nodeR1);

		List<Integer> nodeR2 = new ArrayList<>();

		parseNodeValue(node2, nodeR2);

		System.out.println(nodeR1.equals(nodeR2));

	}

	public static void parseNodeValue(TreeNode node, List<Integer> result) {

		if (node == null)
			return;

		parseNodeValue(node.left, result);
		result.add(node.val);
		parseNodeValue(node.right, result);

	}

	public static void maxDepthBinaryTree() {

		TreeNode node1 = new TreeNode(1);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(3);

		Map<Integer, Integer> map = Map.of(3, 6, 4, 2, 5, 1);

		// Sort by values descending
		// Stream<Map.Entry<Integer, Integer>> sorted =
		// map.entrySet().stream().sorted(Map.Entry.<Integer,
		// Integer>comparingByValue().reversed());
		// .collect(
		// LinkedHashMap::new, // maintain insertion order
		// (m, e) -> m.put(e.getKey(), e.getValue()),
		// LinkedHashMap::putAll
		// )
		// ;
		// Stream<Map.Entry<Integer, Integer>> sorted =
		// map.entrySet().stream()
		// .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed());

		Stream<Entry<Integer, Integer>> sorted = map.entrySet().stream()
				.sorted(Entry.comparingByValue(Comparator.reverseOrder()));

		sorted.forEach(data -> System.out.println(data));

		System.out.println(sorted); // Output: {3=6, 4=2, 5=1}
	}

}
