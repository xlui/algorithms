package app.xlui.algo.LeetCode.p561;

import java.util.Arrays;

public class Solution {
	public int _arrayPairSum(int[] nums) {
		int n = nums.length >> 1;
		int sum = 0;
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			sum += nums[i << 1];
		}
		return sum;
	}

	public int arrayPairSum(int[] nums) {
		int[] bucket = new int[20001];
		int sum = 0;
		boolean odd = true;
		for (int num : nums) {
			bucket[num + 10000]++;
		}
		for (int i = 0; i < bucket.length; i++) {
			while (bucket[i] > 0) {
				if (odd) {
					sum += i - 10000;
				}
				odd = !odd;
				bucket[i]--;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// 4
		System.out.println(solution.arrayPairSum(new int[]{1, 4, 3, 2}));
		// 1
		System.out.println(solution.arrayPairSum(new int[]{1, 1}));
		// 7
		System.out.println(solution.arrayPairSum(new int[]{1, 4, 3, 2, 5, 1}));
	}
}
