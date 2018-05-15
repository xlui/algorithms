package me.xlui.algo.p788;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int rotatedDigits(int N) {
        int ret = 0, tmp;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(0, 0);
            put(1, 1);
            put(8, 8);
            put(2, 5);
            put(5, 2);
            put(6, 9);
            put(9, 6);
        }};
        for (int i = 1; i <= N; i++) {
            int currentNum = i;
            int calcNum = 0;
            int degree = 0;
            boolean isValid = true;
            while (currentNum != 0) {
                tmp = currentNum % 10;
                if (map.containsKey(tmp)) {
                    calcNum += map.get(tmp) * Math.pow(10, degree);
                    currentNum /= 10;
                } else {
                    isValid = false;
                    break;
                }
                degree++;
            }
            if (isValid && calcNum != i) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rotatedDigits(10));
        System.out.println(solution.rotatedDigits(857));
    }
}
