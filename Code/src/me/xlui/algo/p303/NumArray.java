package me.xlui.algo.p303;

public class NumArray {
	// 1 2 3 4 5
	// 1 3 6 10 15
	private int[] nums;

	public NumArray(int[] nums) {
		for (int i = 1, len = nums.length; i < len; i++) {
			nums[i] += nums[i - 1];
		}
		this.nums = nums;
	}

	public int sumRange(int i, int j) {
		if (0 == i) {
			return nums[j];
		}
		return nums[j] - nums[i - 1];
	}
}
