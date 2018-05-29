package me.xlui.algo.p016;

import java.util.Arrays;

public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int minDiff = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			int iLeft = i + 1;
			int iRight = nums.length - 1;
			while (iLeft < iRight) {
				int tmp = nums[i] + nums[iLeft] + nums[iRight];
				int diff = Math.abs(target - tmp);
				if (diff < minDiff) {
					minDiff = diff;
					result = tmp;
				}

				if (tmp > target) {
					iRight--;
				} else if (tmp < target) {
					iLeft++;
				} else {
					return tmp;
				}
			}
		}
		return result;
	}

	public int silly(int[] nums, int target) {
		int minDiff = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int tmp = nums[i] + nums[j] + nums[k];
					int diff = Math.abs(target - tmp);
					if (diff < minDiff) {
						minDiff = diff;
						result = tmp;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
		System.out.println(solution.silly(new int[]{-1, 2, 1, -4}, 1));
	}
}
