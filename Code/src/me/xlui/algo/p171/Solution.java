package me.xlui.algo.p171;

public class Solution {
	/*
		1, (s[0]-'A'+1)
		2, (s[0]-'A'+1)*26 + (s[1]-'A'+1)
		3, (s[0]-'A'+1)*26*26+(s[1]-'A'+1)*26+(s[3]-'A'+1)
	 */
	public static int titleToNumber(String s) {
		char[] input = s.toCharArray();
		int len = input.length;
		int ret = 0;
		for (int i = len - 1; i >= 0; i--) {
			ret += (input[i] - 'A' + 1) * Math.pow(26, (len - 1 - i));
		}
		return ret;
	}
}
