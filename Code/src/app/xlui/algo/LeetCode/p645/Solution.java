package app.xlui.algo.LeetCode.p645;

import java.util.Arrays;

public class Solution {
	public int[] findErrorNums(int[] nums) {
		int[] ret = new int[2];
		int[] store = new int[nums.length + 1];
		for (int num : nums) {
			store[num] = store[num] + 1;
		}
		for (int i = 1; i < nums.length + 1; i++) {
			if (store[i] == 0) {
				ret[1] = i;
			}
			if (store[i] == 2) {
				ret[0] = i;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 2, 2, 4})));
		System.out.println(Arrays.toString(solution.findErrorNums(new int[]{1, 1})));
	}
}
