package app.xlui.algo.p322;

public class Solution {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			int min = Integer.MAX_VALUE;
			for (int coin : coins) {
				if (i >= coin && dp[i - coin] != -1) {
					min = Math.min(min, dp[i - coin]);
				}
			}
			dp[i] = min == Integer.MAX_VALUE ? -1 : min + 1;
		}
		return dp[amount];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// 3
		System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
		// -1
		System.out.println(solution.coinChange(new int[]{2}, 3));
		// 20
		System.out.println(solution.coinChange(new int[]{186, 419, 83, 408}, 6249));
	}
}
