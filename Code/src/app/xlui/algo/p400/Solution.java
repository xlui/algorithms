package app.xlui.algo.p400;

public class Solution {
	public static int findNthDigit(int n) {
		int digitCount = 1; // 整数位数
		long digitNum = 9;   // 该位数情况下整数个数

		// digitCount * digitNum = 该位数情况下，数字个数
		while (n > digitCount * digitNum) {
			n -= digitCount * digitNum;
			++digitCount;
			digitNum *= 10;
		}

		int position = (n - 1) / digitCount;    // 在该位数情况下，n 的位置
		int index = (n - 1) % digitCount;       // 要求的数字在 n 中的位置

		int number = (int) (Math.pow(10, digitCount - 1) + position);
		return Integer.parseInt(String.valueOf(String.valueOf(number).charAt(index)));
	}
}
