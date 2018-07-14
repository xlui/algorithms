package app.xlui.algo.LeetCode.p318;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int maxProduct(String[] words) {
		int max = 0, len = words.length;
		int[] mask = new int[len];
		for (int i = 0; i < len; i++) {
			for (char c : words[i].toCharArray()) {
				mask[i] |= 1 << (c - 'a');
			}
		}
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if ((mask[i] & mask[j]) == 0) {
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}
		return max;
	}

	public int maxProduct1(String[] words) {
		int max = Integer.MIN_VALUE;
		Arrays.sort(words, Comparator.comparing(String::length));
		Set<Character> set = new HashSet<>();
		for (int i = words.length - 1; i >= 0; i--) {
			addAll(set, words[i].toCharArray());
			for (int j = i - 1; j >= 0; j--) {
				if (disjoint(set, words[j].toCharArray())) {
					int t = words[i].length() * words[j].length();
					max = Math.max(max, t);
				}
			}
			set.clear();
		}
		return max == Integer.MIN_VALUE ? 0 : max;
	}

	private boolean disjoint(Set<Character> set, char[] chars) {
		for (char aChar : chars) {
			if (set.contains(aChar)) {
				return false;
			}
		}
		return true;
	}

	private void addAll(Set<Character> set, char[] chars) {
		for (char aChar : chars) {
			set.add(aChar);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// 16
		System.out.println(solution.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
		// 4
		System.out.println(solution.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
		// 0
		System.out.println(solution.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
	}
}
