package me.xlui.algo;

import me.xlui.algo.Problem010.Solution;

public class Main {
	public static void main(String[] args) throws Exception {
		Assert.assertFalse(Solution.isMatch("aa", "a"));
		Assert.assertTrue(Solution.isMatch("aa", "aa"));
		Assert.assertFalse(Solution.isMatch("aaa", "aa"));
		Assert.assertTrue(Solution.isMatch("aa", "a*"));
		Assert.assertTrue(Solution.isMatch("aa", ".*"));
		Assert.assertTrue(Solution.isMatch("ab", ".*"));
		Assert.assertTrue(Solution.isMatch("aab", "c*a*b"));
		Assert.assertFalse(Solution.isMatch("aaba", "ab*a*c*a"));
		Assert.assertFalse(Solution.isMatch("ab", ".*c"));
		System.out.println("pass!");
	}
}
