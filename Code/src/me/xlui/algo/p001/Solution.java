package me.xlui.algo.p001;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int i = 0, len = list.size(); i < len; i++) {
            int tmp = list.indexOf(target - list.get(i));
            if (tmp != i && tmp != -1) {
                return new int[]{i, tmp};
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        int tmp = 0;
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            tmp = target - nums[i];
            if (res.containsKey(tmp)) {
                result[0] = res.get(tmp);
                result[1] = i;
                break;
            }
            res.put(nums[i], i);
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)));
    }
}
