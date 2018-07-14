package app.xlui.algo.LeetCode.p162;

public class Solution {
	public int findPeakElement(int[] nums) {
		if (nums.length <= 1) {
			return 0;
		}
		if (nums[0] > nums[1]) {
			return 0;
		}
		if (nums[nums.length - 1] > nums[nums.length - 2]) {
			return nums.length - 1;
		}
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
				return i;
			}
		}
		return -1;
	}

	public int findPeakElement1(int[] nums) {
		if (nums.length == 1)
			return 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1])
				return i;
		}
		return nums.length - 1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		assert 2 == solution.findPeakElement(new int[]{1, 2, 3, 1});
		assert 1 == solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
		assert 0 == solution.findPeakElement(new int[]{1});
	}
}
