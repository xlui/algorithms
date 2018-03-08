package me.xlui.algo.Problem413;

import java.util.Arrays;

/**
 * 找规律：
 * 1, 2, 3 => 1
 * 1, 2, 3, 4 => 3 = 1 + 2
 * 1, 2, 3, 4, 5 => 6 = 3 + 3
 * 1, 2, 3, 4, 5, 6 => 10 = 6 + 4
 * 1, 2, 3, 4, 5, 6, 7 => 15 = 10 + 5
 */
public class Solution {
	public static int numberOfArithmeticSlices(int[] A) {
		int ret = 0;
		int[] count = new int[A.length];
		Arrays.fill(count, 0);
		for (int i = 2, len = A.length; i < len; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				count[i] = count[i - 1] + 1;
			}
			ret += count[i];
		}
		return ret;
	}
}
