package app.xlui.algo.LeetCode.p785;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public boolean isBipartite(int[][] graph) {
		// 0(not visited), 1(black), 2(white)
		int[] visited = new int[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (graph[i].length != 0 && visited[i] == 0) {
				visited[i] = 1;
				Queue<Integer> queue = new LinkedList<>();
				queue.offer(i);
				while (!queue.isEmpty()) {
					int current = queue.poll();
					for (int c : graph[current]) {
						if (visited[c] == 0) {
							visited[c] = (visited[current] == 1) ? 2 : 1;
							queue.offer(c);
						} else {
							if (visited[c] == visited[current])
								return false;
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isBipartite(new int[][]{
				{1,3},{0,2},{1,3},{0,2}
		}));
		System.out.println(solution.isBipartite(new int[][]{
				{1, 2, 3},
				{0, 2},
				{0, 1, 3},
				{0, 2},
		}));
	}
}
