package app.xlui.algo.p659;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public boolean isPossible(int[] nums) {
		Map<Integer, Integer> frequent = new HashMap<>();
		Map<Integer, Integer> exist = new HashMap<>();
		for (int num : nums) {
			frequent.put(num, frequent.getOrDefault(num, 0) + 1);
		}
		for (int num : nums) {
			if (frequent.getOrDefault(num, 0) == 0) {
				continue;
			}
			if (exist.getOrDefault(num, 0) > 0) {
				exist.put(num, exist.get(num) - 1);
				exist.put(num + 1, exist.getOrDefault(num + 1, 0) + 1);
				frequent.put(num, frequent.get(num) - 1);
			} else if (frequent.getOrDefault(num + 1, 0) > 0 && frequent.getOrDefault(num + 2, 0) > 0) {
				frequent.put(num + 1, frequent.get(num + 1) - 1);
				frequent.put(num + 2, frequent.get(num + 2) - 1);
				exist.put(num + 3, exist.getOrDefault(num + 3, 0) + 1);
				frequent.put(num, frequent.get(num) - 1);
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.isPossible(new int[]{1, 2, 3, 3, 4, 5}));
		System.out.println(solution.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
//		System.out.println(solution.isPossible(new int[]{1, 2, 3, 4, 4, 5}));
//		System.out.println(solution.isPossible(new int[]{1, 2, 5, 6, 7, 8}));
	}
}
