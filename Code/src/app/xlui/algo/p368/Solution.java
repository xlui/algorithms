package app.xlui.algo.p368;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		int max = 0, index = -1;
		int[] dp = new int[nums.length];
		int[] pre = new int[nums.length];
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			pre[i] = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0 && dp[i] < 1 + dp[j]) {
					dp[i] = 1 + dp[j];
					pre[i] = j;
				}
			}
			if (max < dp[i]) {
				max = dp[i];
				index = i;
			}
		}

		List<Integer> list = new LinkedList<>();
		while (index != -1) {
			list.add(nums[index]);
			index = pre[index];
		}
		return list;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.largestDivisibleSubset(new int[]{1, 2, 3}));
		System.out.println(solution.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
	}
}
