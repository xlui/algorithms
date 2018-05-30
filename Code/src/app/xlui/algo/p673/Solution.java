package app.xlui.algo.p673;

public class Solution {
	public int findNumberOfLIS(int[] nums) {
		int maxLen = 0, maxNum = 0;
		int[] lengths = new int[nums.length];
		int[] subsequence = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			lengths[i] = subsequence[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (lengths[i] == lengths[j] + 1) {
						subsequence[i] += subsequence[j];
					} else if (lengths[i] < lengths[j] + 1) {
						lengths[i] = lengths[j] + 1;
						subsequence[i] = subsequence[j];
					}
				}
			}
			if (maxLen == lengths[i]) {
				maxNum += subsequence[i];
			} else if (maxLen < lengths[i]) {
				maxLen = lengths[i];
				maxNum = subsequence[i];
			}
		}
		return maxNum;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
		System.out.println(solution.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
	}
}
