package app.xlui.algo.LeetCode.p453;

public class Solution {
	public int minMoves(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int min = nums[0];
		for (int num : nums) {
			if (min > num)
				min = num;
		}
		int result = 0;
		for (int num : nums) {
			result += num - min;
		}
		return result;
	}
}
