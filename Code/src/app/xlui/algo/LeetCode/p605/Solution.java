package app.xlui.algo.LeetCode.p605;

public class Solution {
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		boolean flag = flowerbed[0] != 1;

		for (int i = 0, len = flowerbed.length; i < len; i++) {
			if (flag) { // flag 为 true 表示上一位是 0
				if (flowerbed[i] == 0) {
					if ((i < len - 1 && flowerbed[i + 1] == 0) || i == len - 1) {
						flowerbed[i] = 1;
						n--;
						flag = false;
					}
				} else {
					flag = false;
				}
			} else { // 上一位是 1
				if (flowerbed[i] == 0) {
					flag = true;
				}
			}
		}

		return n <= 0;
	}
}
