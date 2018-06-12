package app.xlui.algo.p275;

public class Solution {
	public int hIndex(int[] citations) {
		int len = citations.length;
		int max = 0;
		for (int i = len; i > 0; i--) {
			if (citations[len - i] >= i) {
				if (max < i) {
					max = i;
				}
			}
		}
		return max;
	}

	public int hIndex1(int[] citations) {
		int l = 0, r = citations.length - 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (citations.length - mid <= citations[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return citations.length - l;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.hIndex1(new int[]{0, 1, 3, 5, 6}));
		System.out.println(solution.hIndex1(new int[]{0, 1, 4, 5, 6, 9}));
		System.out.println(solution.hIndex1(new int[]{0, 1, 3, 5, 6, 9}));
	}
}
