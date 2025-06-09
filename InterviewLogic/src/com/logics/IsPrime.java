package com.logics;

import java.util.stream.IntStream;

public class IsPrime {

	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		return IntStream.rangeClosed(2, (int) Math.sqrt(n)).allMatch(i -> n % i != 0);
	}
}
