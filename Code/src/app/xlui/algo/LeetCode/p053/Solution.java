package app.xlui.algo.LeetCode.p053;

public class Solution {
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (max < sum) {
				max = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
		System.out.println(solution.maxSubArray(new int[]{-1}));
	}
}
