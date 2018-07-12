package app.xlui.algo.p050;

public class Solution {
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		double result = myPow(x, n / 2);
		result *= result;
		if ((n & 0x1) == 0) {
			return result;
		} else {
			return n > 0 ? result * x : result / x;
		}
	}

	public double _myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		if (n > 0) {
			return n % 2 == 0 ? myPow(x * x, n / 2) : myPow(x * x, n / 2) * x;
		}
		if (n == Integer.MIN_VALUE) {
			return 1 / myPow(x, Integer.MAX_VALUE) / x;
		}
		return 1 / myPow(x, -n);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.myPow(2.0, 10));
//		System.out.println(solution.myPow(2.1, 3));
		System.out.println(solution.myPow(2, -5));
//		System.out.println(solution.myPow(1, 0));
//		System.out.println(solution.myPow(1, -2147483648));
	}
}
