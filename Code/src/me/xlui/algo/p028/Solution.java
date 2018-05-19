package me.xlui.algo.p028;

public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        char[] sources = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        int sl = sources.length, nl = needles.length;
        int result;
        for (int i = 0; i < sl; i++) {
            if (sources[i] == needles[0]) {
                int si = i, ni = 0, match = 0; // needle index
                result = i;
                while (si < sl && ni < nl && sources[si] == needles[ni]) {
                    match++;
                    si++;
                    ni++;
                }
                if (match == nl) {
                    return result;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("aaaaa", "bba"));
        System.out.println(solution.strStr("aaaaa", ""));
    }
}
