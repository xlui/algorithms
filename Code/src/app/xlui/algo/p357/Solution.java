package app.xlui.algo.p357;

public class Solution {
    public static int countNumbersWithUniqueDigits(int n) {
        if (0 == n) {
            return 1;
        }
        int res = 10, base = 9;
        for (int i = 2; i <= n; i++) {
            base = base * (9 - i + 2);
            res += base;
        }
        return res;
    }
}
