package app.xlui.algo.LeetCode.p806;

public class Solution {
    public static int[] numberOfLines(int[] widths, String S) {
        int total = 0;
        int[] result = new int[2];
        char[] chars = S.toCharArray();
        for (char aChar : chars) {
            total += widths[aChar - 'a'];
            if (total > 100) {
                result[0]++;
                total = widths[aChar - 'a'];
            }
        }
        result[0]++;
        result[1] = total;
        return result;
    }
}
