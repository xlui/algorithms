package app.xlui.algo.LeetCode.p517;

/**
 * 使用动态规划。
 *
 * 假设有四个洗衣机，初始状态为：[0, 0, 11, 5];
 * 计算可知最终状态会变成 [4, 4, 4, 4]；
 * 将二者做差得到：[-4, -4, 7, 1]，其中负值表示当前洗衣机还需要的衣服数，正值表示当前洗衣机多余的衣服数
 *
 * 我们要做的是将这个差值数组每一项都变为 0；
 * 对于第一个洗衣机，需要四件衣服可以从第二个洗衣机得到，那么就可以把 -4 转移给二号洗衣机，得到 [0, -8, 7, 1]；
 * 此时二号洗衣机需要移动 8 次，转移给三号：[0, 0, -1, 1]；
 * 三号需要移动一次，从四号处获取剩下的一件
 *
 * 移动的最大次数就是差值数组中出现的绝对值最大的数字
 */
public class Solution {
	public static int findMinMoves(int[] machines) {
		int sum = 0;
		for (int machine : machines) {
			sum += machine;
		}

		if (sum % machines.length != 0) {
			return -1;
		}

		int average = sum / machines.length;
		int reverse = 0, ret = 0;
		for (int machine : machines) {
			reverse += machine - average;
			ret = Math.max(ret, Math.max(Math.abs(reverse), machine - average));
		}
		return ret;
	}
}
