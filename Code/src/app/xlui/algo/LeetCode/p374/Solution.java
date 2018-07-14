package app.xlui.algo.LeetCode.p374;

class GuessGame {
	private static final int given = 7;

	int guess(int num) {
		return Integer.compare(given, num);
	}
}

public class Solution extends GuessGame {
	public int guessNumber(int n) {
		int left = 0, right = n;
		if (0 == guess(n)) {
			return n;
		}
		while (true) {
			int middle = (left + right) >>> 1;
			int result = guess(middle);
			if (result > 0) {
				left = middle;
			} else if (result < 0) {
				right = middle;
			} else {
				return middle;
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.guessNumber(10));
	}
}
