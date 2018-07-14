package app.xlui.algo.LeetCode.p015;

import java.util.*;

public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		if (nums == null || nums.length < 3) {
			return new ArrayList<>();
		}
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return new ArrayList<>(result);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
	}
}
