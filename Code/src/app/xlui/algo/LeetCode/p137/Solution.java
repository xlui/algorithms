package app.xlui.algo.LeetCode.p137;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue().equals(1)) {
				return entry.getKey();
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.singleNumber(new int[]{2, 2, 3, 2}));
		System.out.println(solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
	}
}
