package app.xlui.algo.LeetCode.p300;

public class Solution {
	public int lengthOfLIS(int[] nums) {
		int max = 0;
		int[] dp = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
	}
}
