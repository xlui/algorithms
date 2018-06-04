package app.xlui.algo.p229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>(nums.length);
		Map<Integer, Integer> map = new HashMap<>();
		int frequent = nums.length / 3;

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > frequent) {
				result.add(entry.getKey());
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
		System.out.println(solution.majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
	}
}
