package me.xlui.algo.p350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                resultList.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0, len = resultList.size(); i < len; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
