package app.xlui.algo.LeetCode.p849;

import java.util.Arrays;

public class Solution {
	public int maxDistToClosest(int[] seats) {
		if (seats == null || seats.length < 2) {
			return 0;
		}
		int len = seats.length;
		int[] left = new int[len];
		int[] right = new int[len];
		Arrays.fill(left, Integer.MAX_VALUE);
		Arrays.fill(right, Integer.MAX_VALUE);
		for (int i = 0; i < len; i++) {
			if (seats[i] == 1) {
				left[i] = 0;
			} else if (i > 0) {
				left[i] = left[i - 1] + 1;
			}
		}
		for (int i = len - 1; i >= 0; i--) {
			if (seats[i] == 1) {
				right[i] = 0;
			} else if (i < len - 1) {
				right[i] = right[i + 1] + 1;
			}
		}

		int res = 0;
		for (int i = 0; i < len; i++) {
			if (seats[i] == 0) {
				res = Math.max(res, Math.min(left[i], right[i]));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// 2
		System.out.println(solution.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
		// 3
		System.out.println(solution.maxDistToClosest(new int[]{1, 0, 0, 0}));
	}
}
