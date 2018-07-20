package app.xlui.algo.LeetCode.p009;

public class Solution {
	public boolean isPalindrome(int x) {
		String string = String.valueOf(x);
		int len = string.length();
		int middle = (len & 0x1) == 1 ? len / 2 + 1 : len / 2;
		for (int i = 0; i < middle; i++) {
			if (string.charAt(i) != string.charAt(len - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// true
		System.out.println(solution.isPalindrome(121));
		// false
		System.out.println(solution.isPalindrome(-121));
		// false
		System.out.println(solution.isPalindrome(10));
		// true
		System.out.println(solution.isPalindrome(1221));
		// true
		System.out.println(solution.isPalindrome(0));
	}
}
