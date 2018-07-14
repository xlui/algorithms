package app.xlui.algo.LeetCode.p503;

import java.util.*;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length, current;
        int[] res = new int[length];
        LinkedList<Integer> stack = new LinkedList<>();

        Arrays.fill(res, -1);
        for (int i = 0; i < length * 2; i++) {
            current = nums[i % length];
            while (!stack.isEmpty() && nums[stack.peekLast()] < current) {
                res[stack.peekLast()] = current;
                stack.pollLast();
            }
            if (i < length) {
                stack.addLast(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{1, 2, 1})));
    }
}
