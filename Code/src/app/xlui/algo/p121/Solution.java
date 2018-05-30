package app.xlui.algo.p121;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0], max = 0, current = 0;
        for (int price : prices) {
            current = price - min;
            if (price < min) {
                min = price;
            }
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1, 0}));
    }
}
