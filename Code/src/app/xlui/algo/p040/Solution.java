package app.xlui.algo.p040;

import java.util.*;

public class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new LinkedList<>();
		combination(candidates, 0, target, new LinkedList<>(), result);
		return result;
	}

	private void combination(int[] candidates, int current, int target, Deque<Integer> path, List<List<Integer>> result) {
		if (target < 0) return;
		if (target == 0) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = current; i < candidates.length; i++) {
			if (i > current && candidates[i] == candidates[i - 1]) continue;
			path.offer(candidates[i]);
			combination(candidates, i + 1, target - candidates[i], path, result);
			path.pollLast();
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
		System.out.println(solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
	}
}
