package app.xlui.algo.LeetCode.p447;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int numberOfBoomerangs(int[][] points) {
		if (points == null || points.length < 2) {
			return 0;
		}
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0, len = points.length; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (i == j) {
					continue;
				}
				int distance = distance(points[i], points[j]);
				map.put(distance, map.getOrDefault(distance, 0) + 1);
			}
			for (Map.Entry<Integer, Integer> e : map.entrySet()) {
				if (e.getValue() > 1) {
					int t = e.getValue();
					count += t * (t - 1);
				}
			}
			map.clear();
		}
		return count;
	}

	private int distance(int[] x, int[] y) {
		int a = Math.abs(x[0] - y[0]);
		int b = Math.abs(x[1] - y[1]);
		return a * a + b * b;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
	}
}
