package app.xlui.algo.LeetCode.p279;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static int numSquares(int n) {
		if (0 == n) {
			return 0;
		}
		List<Integer> perfectSquares = new LinkedList<>();
		int current = 1, square = 1;
		while ((square = current * current) <= n) {
			perfectSquares.add(square);
			current++;
		}
		int[] dp = new int[n + 1];
		for (int i = 1; i < dp.length; i++) {
			int solutions = i;
			for (Integer perfectSquare : perfectSquares) {
				if (perfectSquare > i)
					break;
				solutions = Math.min(solutions, dp[i - perfectSquare] + 1);
			}
			dp[i] = solutions;
		}
		return dp[n];
	}
}
