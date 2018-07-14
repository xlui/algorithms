package app.xlui.algo.LeetCode.p038;

public class Solution {
	public static String countAndSay(int n) {
		if (1 == n) {
			return "1";
		}
		String str = countAndSay(n - 1) + ".";
		char[] chars = str.toCharArray();
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0, len = chars.length - 1; i < len; i++) {
			if (chars[i] == chars[i + 1]) {
				count++;
			} else {
				sb.append(count).append(chars[i]);
				count = 1;
			}
		}
		return sb.toString();
	}
}
