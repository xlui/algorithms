package app.xlui.algo.LeetCode.p039;

import java.util.*;

public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> tmp = new ArrayDeque<>();
        dfs(result, tmp, candidates, target, 0);
        return result;
    }

    private static void dfs(List<List<Integer>> result, Deque<Integer> tmp, int[] candidates, int target, int j) {
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = j; i < candidates.length && target >= candidates[i]; i++) {
            tmp.add(candidates[i]);
            dfs(result, tmp, candidates, target - candidates[i], i);
            tmp.pollLast();
        }
    }
}
