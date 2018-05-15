package me.xlui.algo.p413;

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

	// 暴力解法
	public static int bruteForce(int[] A) {
		int ret = 0;
		for (int i = 0; i < A.length - 2; i++) {
			int gap = A[i + 1] - A[i];
			for (int j = i + 2; j < A.length; j++) {
				if (A[j] - A[j - 1] == gap)
					ret++;
				else
					break;
			}
		}
		return ret;
	}

	// 节省空间的动态规划
	public static int optimizeSpaceDynamicProgramming(int[] A) {
		int dp = 0, sum = 0;
		for (int i = 2, len = A.length; i < len; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				dp += 1;
				sum += dp;
			} else {
				dp = 0;
			}
		}
		return sum;
	}

	// 利用公式
	public static int formula(int[] A) {
		int count = 0, sum = 0;
		for (int i = 2, len = A.length; i < len; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				count++;
			} else {
				// else 说明当前元素与之前元素不构成 Arithmetic，则计算 sum 并清空 count
				sum += (count + 1) * count * 0.5;
				count = 0;
			}
		}
		return (int) (sum + count * (count + 1) * 0.5);
	}
}
