package me.xlui.algo.p010;

public class Solution {
	public static boolean isMatch(String s, String p) {
		int lenS = s.length(), lenP = p.length();
		char[] sc = s.toCharArray(), pc = p.toCharArray();
		boolean[][] dp = new boolean[lenS + 1][lenP + 1];
		dp[0][0] = true;    // 两个空数组 match
		// dp 中 i，j 为 0 代表 s 或 p 为空的情况，所以下面的循环中 sc[i] 与 pc[j] 的匹配情况为 dp[i+1][j+1]
		for (int i = 0; i < lenP; i++) {
			if (pc[i] == '*' && dp[0][i - 1]) {
				dp[0][i + 1] = true;
			}
		}

		// dp 中 i，j 为 0 代表 s 或 p 为空的情况，所以下面的循环中 sc[i] 与 pc[j] 的匹配情况为 dp[i+1][j+1]
		for (int i = 0; i < lenS; i++) {
			for (int j = 0; j < lenP; j++) {
				if (sc[i] == pc[j] || pc[j] == '.') {
					// 匹配
					dp[i + 1][j + 1] = dp[i][j];
				} else if (pc[j] == '*') {
					if (sc[i] != pc[j - 1] && pc[j - 1] != '.') {
						// 如果 pc[j] == '*' 并且 pc[j-1] 与 sc[i] 不匹配，则 i、j 处匹配情况等于 sc[i]、pc[j-2] 处匹配情况
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else {
						// 如果 pc[j] == '*' 并且 pc[j-1] 与 sc[i] 匹配，则
						// 1、'*' 前元素出现 零 次，则 i、j 处匹配情况等于 sc[i]、pc[j-2] 处匹配情况（dp[i+1][j-1]）
						// 2、'*' 前元素出现 一 次，则 i、j 处匹配情况等于 sc[i] 和 pc[j - 1] 的匹配情况（dp[i+1][j]）
						// 3、'*' 前元素出现 多 次，可以认为 pc[j] 会重复出现 n 次，则 i、j 处的匹配情况应该等于 sc[i-1] 和 pc[j] 处的匹配情况
						// 对于第三种情况，很自然我们会想到将 i、j 处匹配情况设置为 sc[i+1]、pc[j] 的匹配情况，但是这样不行，会导致 ArrayIndexOutOfBoundsException
						// 所以我们要想一个同等情况的转换。
						// 通过观察，我们得出结论，第三种情况代表了元素 sc[i] 在此之前至少出现了一次。
						// 我们得出这个结论的依据是通过反证法：如果元素 sc[i] 在此之前没有出现过，那么不会进入第三种情况。所以如果进入第三种情况，那么元素 sc[i] 在 sc 中至少出现了一次并且肯定是 sc[i-1]。
						// 这样，我们就可以把 i、j 处匹配情况替换为 i-1 与 j 的匹配情况。
						dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1];
					}
				}
			}
		}
		return dp[lenS][lenP];
	}

	public static boolean is_match(String s, String p) {
		if (p.length() == 0) {
			return s.length() == 0;
		}

		if (s.length() == 0) {
			return p.length() > 1 && p.charAt(1) == '*' && is_match(s, p.substring(2));
		}

		if (p.length() > 1 && p.charAt(1) == '*') {
			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
				if (is_match(s.substring(1), p.substring(2))) {
					// '*' 匹配 1 次
					return true;
				}
				if (is_match(s.substring(1), p)) {
					// '*' 匹配多次
					return true;
				}
			}
			if (is_match(s, p.substring(2))) {
				// '*' 匹配 0 次
				return true;
			}
			return false;
		} else if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
			// 正常匹配
			return is_match(s.substring(1), p.substring(1));
		} else {
			// 未匹配
			return false;
		}
	}
}
