package app.xlui.algo.p565;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int arrayNesting(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				int start = nums[i], count = 0;
				do {
					start = nums[start];
					count++;
					visited[start] = true;
				} while (start != nums[i]);
				result = Math.max(result, count);
			}
		}
		return result;
	}

	public int arrayNesting1(int[] nums) {
		int max = 0;
		Set<Integer> set = new HashSet<>();

		for (int num : nums) {
			int t = num;
			while (!set.contains(t)) {
				set.add(t);
				t = nums[t];
			}
			if (max < set.size()) {
				max = set.size();
			}
			set.clear();
		}
		return max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
	}
}
