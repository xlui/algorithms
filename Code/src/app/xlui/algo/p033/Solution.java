package app.xlui.algo.p033;

public class Solution {
	public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] > nums[right]) {
				// 转折点在 mid 右侧，或者 min 是转折点
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				// 转折点在 mid 左侧
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		assert 4 == solution.search(new int[]{7, 8, 3, 4, 5}, 5);
		assert 4 == solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
		assert 3 == solution.search(new int[]{4, 5, 6, 0, 1, 2}, 0);

		assert 0 == solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4);
		assert 3 == solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7);
		assert 4 == solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
		assert 6 == solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2);
		assert 0 == solution.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 0);
		assert 6 == solution.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 7);
		assert 1 == solution.search(new int[]{5, 1, 3}, 1);

		assert -1 == solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
		assert -1 == solution.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 8);
		assert -1 == solution.search(new int[]{}, 8);
		assert 0 == solution.search(new int[]{8}, 8);
		assert -1 == solution.search(new int[]{3}, 8);
	}
}
