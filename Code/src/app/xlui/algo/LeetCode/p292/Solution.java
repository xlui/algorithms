package app.xlui.algo.LeetCode.p292;

public class Solution {
	public boolean canWinNim(int n) {
		return n % 4 != 0;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.canWinNim(4));
		System.out.println(solution.canWinNim(5));
		System.out.println(solution.canWinNim(6));
		System.out.println(solution.canWinNim(7));
		System.out.println(solution.canWinNim(8));
	}
}
