package com.logics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiValueMultiple {

	public static void main(String[] args) {

		// OP: [180, 60, 36, 30, 90]

		List<Integer> val = Arrays.asList(1, 3, 5, 6, 2);
		mult(val);
	}

	public static void mult(List<Integer> val) {

		for (int i = 0; i < val.size(); i++) {
			List<Integer> prefix = val.subList(0, i);
			List<Integer> suffix = val.subList(i + 1, val.size());
			List<Integer> concat = new ArrayList<>();
			concat.addAll(prefix);
			concat.addAll(suffix);

			System.out.println(concat.stream().reduce(1, (a, b) -> a * b));

		}

	}

}
