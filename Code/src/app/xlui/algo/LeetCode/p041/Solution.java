package app.xlui.algo.LeetCode.p041;

public class Solution {
	public int firstMissingPositive(int[] nums) {
		if (nums.length == 0) {
			return 1;
		}
		for (int i = 0, len = nums.length; i < len; i++) {
			if (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
				swap(nums, i, nums[i] - 1);
				i -= 1;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	private void swap(int[] numbers, int i, int j) {
		int t = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = t;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// 3
		System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0}));
		// 2
		System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
		// 1
		System.out.println(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
	}
}
