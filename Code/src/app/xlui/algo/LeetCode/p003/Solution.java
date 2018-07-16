package app.xlui.algo.LeetCode.p003;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int max = 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0, len = s.length(); i < len; i++) {
			int thisMax = 0, index = i;
			while (index < len) {
				char c = s.charAt(index);
				if (!set.contains(c)) {
					set.add(c);
					index++;
					thisMax++;
				} else {
					break;
				}
			}
			max = Math.max(max, thisMax);
			set.clear();
		}
		return max;
	}

	public int _lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		boolean[] exist = new boolean[128];
		int max = 0, start = 0;
		for (int i = 0, len = s.length(); i < len; i++) {
			char c = s.charAt(i);
			if (exist[c]) {
				max = Math.max(max, i - start);
				// 我们使用 start 来记录最长无重复子串的起始位置
				// 每次当数组中出现一个重复字符 c 的时候，将之前一个重复的 c 之前的元素设为未出现（exist[i]=false）
				// 例如，对于 abcbefc，当扫描到第二个 c 的时候，
				for (int j = start; j < i; j++) {
					if (s.charAt(j) == c) {
						start = j + 1;
						break;
					}
					exist[s.charAt(j)] = false;
				}
			} else {
				exist[c] = true;
			}
		}
		return Math.max(s.length() - start, max);
	}

		public static void main(String[] args) {
		Solution solution = new Solution();
		// 3
		System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
		// 1
		System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
		// 3
		System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
		// 5
		System.out.println(solution.lengthOfLongestSubstring("abcde"));
		// 0
		System.out.println(solution.lengthOfLongestSubstring(""));
	}
}
