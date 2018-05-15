package me.xlui.algo.p387;

@SuppressWarnings("WeakerAccess")
public class Solution {
    public int firstUniqChar(String s) {
        int[] alphabet = new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            alphabet[aChar - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (alphabet[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input1 = "leetcode";
        String input2 = "loveleetcode";
        // expect -1
        System.out.println(solution.firstUniqChar(""));
        // expect 0
        System.out.println(solution.firstUniqChar(input1));
        // expect 2
        System.out.println(solution.firstUniqChar(input2));
    }
}
