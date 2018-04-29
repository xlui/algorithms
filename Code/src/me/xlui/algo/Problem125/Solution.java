package me.xlui.algo.Problem125;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
	public static boolean isPalindrome(String s) {
		String f = Arrays.asList(s.split(""))
				.parallelStream()
				.filter(s1 -> s1.matches("[a-zA-Z0-9]"))
				.map(String::toLowerCase)
				.collect(Collectors.joining());
		return f.equals(new StringBuilder(f).reverse().toString());
	}
}
