package app.xlui.algo.p826;

import javafx.util.Pair;

import java.util.*;

public class Solution {
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		int result = 0;
		List<Pair<Integer, Integer>> list = new ArrayList<>();
		for (int i = 0; i < difficulty.length; i++) {
			list.add(new Pair<>(difficulty[i], profit[i]));
		}

		int i = 0, max = 0;
		list.sort(Comparator.comparing(Pair::getKey));
		Arrays.sort(worker);
		for (int w : worker) {
			while (i < difficulty.length && w >= list.get(i).getKey()) {
				max = Math.max(max, list.get(i++).getValue());
			}
			result += max;
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.maxProfitAssignment(
				new int[]{2, 4, 6, 8, 10},
				new int[]{10, 20, 30, 40, 50},
				new int[]{4, 5, 6, 7})
		);
		System.out.println(solution.maxProfitAssignment(new int[]{85, 47, 57}, new int[]{24, 66, 99}, new int[]{40, 25, 25}));
		System.out.println(solution.maxProfitAssignment(
				new int[]{68, 35, 52, 47, 86},
				new int[]{67, 17, 1, 81, 3},
				new int[]{92, 10, 85, 84, 82})
		);
		System.out.println(solution.maxProfitAssignment(
				new int[]{66, 1, 28, 73, 53, 35, 45, 60, 100, 44, 59, 94, 27, 88, 7, 18, 83, 18, 72, 63},
				new int[]{66, 20, 84, 81, 56, 40, 37, 82, 53, 45, 43, 96, 67, 27, 12, 54, 98, 19, 47, 77},
				new int[]{61, 33, 68, 38, 63, 45, 1, 10, 53, 23, 66, 70, 14, 51, 94, 18, 28, 78, 100, 16}
		));
	}
}
