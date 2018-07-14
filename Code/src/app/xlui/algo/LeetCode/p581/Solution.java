package app.xlui.algo.LeetCode.p581;

public class Solution {
//	public int findUnsortedSubarray(int[] nums) {
//		int[] copy = nums.clone();
//		Arrays.sort(copy);
//		int start = copy.length, end = 0;
//		for (int i = 0; i < copy.length; i++) {
//			if (copy[i] != nums[i]) {
//				start = Math.min(start, i);
//				end = Math.max(end, i);
//			}
//		}
//		return end >= start ? end - start + 1 : 0;
//	}

	// 99.8
//	public int findUnsortedSubarray(int[] nums) {
//		int start = 0, end = nums.length - 1;
//		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//
//		while (start < end && nums[start] <= nums[start + 1])
//			start++;
//		if (start == end) return 0;    // 数组为升序
//
//		// 这一步的时候数组不可能为升序，故不需要 end > 0 的条件
//		while (nums[end] >= nums[end - 1])
//			end--;
//
//		for (int i = start; i <= end; i++) {
//			max = Math.max(max, nums[i]);
//			min = Math.min(min, nums[i]);
//		}
//
//		while (start >= 0 && min < nums[start])
//			start--;
//		while (end <= nums.length - 1 && max > nums[end])
//			end++;
//
//		// start 多减了 1，end 多加了 1
//		return end - start - 1;
//	}

	public int findUnsortedSubarray(int[] nums) {
		int start = 0, end = -1;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

		for (int l = 0, r = nums.length - 1; r >= 0; l++, r--) {
			max = Math.max(max, nums[l]);
			if (nums[l] != max) end = l;

			min = Math.min(min, nums[r]);
			if (nums[r] != min) start = r;
		}

		return end - start + 1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// 5
		System.out.println(solution.findUnsortedSubarray(new int[]{2, 6, 4, 3, 8, 10, 9, 15}));
	}
}
