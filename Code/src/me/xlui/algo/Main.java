package me.xlui.algo;

import me.xlui.algo.Problem039.Solution;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<List<Integer>> lists;
        lists = Solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

        System.out.println();
        lists = Solution.combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

        System.out.println();
        lists = Solution.combinationSum(new int[]{8, 7, 4, 3}, 11);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
