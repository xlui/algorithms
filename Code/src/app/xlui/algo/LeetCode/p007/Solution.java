package app.xlui.algo.LeetCode.p007;

public class Solution {
	public int reverse(int x) {
		int result = 0;
		while (x != 0) {
			if (Math.abs(result) > Integer.MAX_VALUE / 10) {
				return 0;
			}
			result = result * 10 + x % 10;
			x /= 10;
		}
		return result;
	}

	public int reverse1(int x) {
		int prev = 0, result = 0, tmp;
		while (x != 0) {
			tmp = x % 10;
			result = result * 10 + tmp;
			if ((result - tmp) / 10 != prev) {
				return 0;
			}
			prev = result;
			x /= 10;
		}
		return result;
	}


	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverse(123));
		System.out.println(solution.reverse(-123));
		System.out.println(solution.reverse(120));
		System.out.println(solution.reverse(-10));
	}
}
