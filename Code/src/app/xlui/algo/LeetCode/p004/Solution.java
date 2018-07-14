package app.xlui.algo.LeetCode.p004;

public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length, l2 = nums2.length;
		int mid = (l1 + l2) / 2;
		int[] merge = new int[mid + 1];
		int j = 0, k = 0;
		for (int i = 0; i < mid + 1; i++) {
			if (j < l1 && (k >= l2 || nums1[j] < nums2[k])) {
				merge[i] = nums1[j++];
			} else {
				merge[i] = nums2[k++];
			}
		}
		if ((l1 + l2) % 2 == 0) {
			return (merge[mid - 1] + merge[mid]) / 2.0;
		} else {
			return (double) merge[mid];
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
//		System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
		System.out.println(solution.findMedianSortedArrays(new int[]{1}, new int[]{1}));
	}
}
