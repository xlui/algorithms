package app.xlui.algo.LeetCode.p526;

import java.util.Arrays;

/**
 * rule1：ith 可以被 i 整除
 * rule2：i 可以被 ith 整除
 *
 * 标准的回溯算法
 */
public class Solution {
	public static int countArrangement(int N) {
		if (0 == N)
			return 0;
		boolean[] visited = new boolean[N + 1];
		Arrays.fill(visited, false);
		return backtracking(N, 1, visited);
	}

	private static int backtracking(int N, int position, boolean[] visited) {
		if (position > N) {
			return 1;
		}
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && (position % i == 0 || i % position == 0)) {
				visited[i] = true;
				count += backtracking(N, position + 1, visited);
				visited[i] = false;
			}
		}
		return count;
	}
}
