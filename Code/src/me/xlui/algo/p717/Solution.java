package me.xlui.algo.p717;

/**
 * 110 true
 * 1110 false
 * 111010 false
 *
 * 算法的思想是通过索引 i 的跳转，遇到 1 跳两步，遇到 0 跳一步。
 * 当 while 循环结束的时候，通过 i 的位置来判断，如果 i 的位置刚好是 bits 数组最后一个元素，则 true；如果 i 的位置跳过了最后一个元素，则 false
 */
public class Solution {
	public static boolean isOneBitCharacter(int[] bits) {
		int len = bits.length, i = 0;
		while (i < len - 1) {
			if (0 == bits[i])
				i++;
			else
				i += 2;
		}
		return i == len - 1;
	}
}
