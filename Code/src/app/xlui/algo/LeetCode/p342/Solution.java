package app.xlui.algo.LeetCode.p342;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private final static Set<Integer> set = new HashSet<Integer>() {{
        add(1);
        add(1 << 2);
        add(1 << 4);
        add(1 << 6);
        add(1 << 8);
        add(1 << 10);
        add(1 << 12);
        add(1 << 14);
        add(1 << 16);
        add(1 << 18);
        add(1 << 20);
        add(1 << 22);
        add(1 << 24);
        add(1 << 26);
        add(1 << 28);
        add(1 << 30);
    }};

    public static boolean isPowerOfFour(int num) {
        return set.contains(num);
    }
}
