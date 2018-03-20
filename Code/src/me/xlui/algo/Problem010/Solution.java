package me.xlui.algo.Problem010;

public class Solution {
		public static boolean isMatch(String s, String p) {
		int lenS = s.length(), lenP = p.length();
		char[] sc = s.toCharArray(), pc = p.toCharArray();
		boolean[][] dp = new boolean[lenS + 1][lenP + 1];
		dp[0][0] = true;    // 两个空数组 match
		// dp 中 i，j 为零代表 s 或 p 为空的情况，所以下面的循环中 i、j 的值比实际大 1
		for (int i = 0; i < lenP; i++) {
			if (pc[i] == '*' && dp[0][i - 1]) {
				dp[0][i + 1] = true;
			}
		}

		// dp 中 i，j 为零代表 s 或 p 为空的情况，所以下面的循环中 i、j 的值比实际大 1
		for (int i = 0; i < lenS; i++) {
			for (int j = 0; j < lenP; j++) {
				if (sc[i] == pc[j] || pc[j] == '.') {
					// 匹配
					dp[i + 1][j + 1] = dp[i][j];
				} else if (pc[j] == '*') {
					if (sc[i] != pc[j - 1] && pc[j - 1] != '.') {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else {
						// 有三种情况：
						// todo: 情况分析
						dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
					}
				}
			}
		}
		return dp[lenS][lenP];
	}
}
