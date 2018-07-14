package app.xlui.algo.LeetCode.p467;

import java.util.Arrays;

public class Solution {
	public int findSubstringInWraproundString(String p) {
		int[] count = new int[26];
		char[] input = p.toCharArray();
		int tmpMax = 0;
		for (int i = 0; i < input.length; i++) {
			if (i > 0 && (input[i] - input[i - 1] == 1 || input[i - 1] - input[i] == 25)) {
				tmpMax++;
			} else {
				tmpMax = 1;
			}

			int index = input[i] - 'a';
			count[index] = Math.max(count[index], tmpMax);
		}

		return Arrays.stream(count).sum();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		assert 1 == solution.findSubstringInWraproundString("a");
		assert 2 == solution.findSubstringInWraproundString("cac");
		assert 6 == solution.findSubstringInWraproundString("zab");
	}
}
