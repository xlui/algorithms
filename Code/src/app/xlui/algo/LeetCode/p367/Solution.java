package app.xlui.algo.LeetCode.p367;

public class Solution {
    public boolean isPerfectSquare(int num) {
        int middle = num / 2 + 1;
        for (int i = 0; i <= middle; i++) {
            if (num == i * i) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        assert solution.isPerfectSquare(0);
        assert solution.isPerfectSquare(1);
        assert !solution.isPerfectSquare(2);
        assert !solution.isPerfectSquare(3);
        assert solution.isPerfectSquare(4);
        assert solution.isPerfectSquare(16);
        assert !solution.isPerfectSquare(14);
        assert solution.isPerfectSquare(64);
        assert !solution.isPerfectSquare(33);
    }
}
