package app.xlui.algo.LeetCode.p242;

import java.util.Arrays;

public class Solution {
	public boolean isAnagram(String s, String t) {
		int len1 = s.length(), len2 = t.length();
		if (len1 != len2) {
			return false;
		}
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		Arrays.sort(sChars);
		Arrays.sort(tChars);
		for (int i = 0; i < len1; i++) {
			if (sChars[i] != tChars[i]) {
				return false;
			}
		}
		return true;
	}

	public boolean isAnagram2(String s, String t) {
		int[] frequent = new int[26];
		for (char c : s.toCharArray()) {
			frequent[c - 'a']++;
		}
		for (char c : t.toCharArray()) {
			frequent[c - 'a']--;
		}
		for (int i : frequent) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isAnagram("anagram", "nagaram"));
		System.out.println(solution.isAnagram("rat", "car"));
	}
}
