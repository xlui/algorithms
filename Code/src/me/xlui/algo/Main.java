package me.xlui.algo;

import me.xlui.algo.Problem120.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(-1));
        lists.add(Arrays.asList(2, 3));
        lists.add(Arrays.asList(1, -1, -3));
        System.out.println(Solution.minimumTotal(lists));

        lists = new ArrayList<>();
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3, 4));
        lists.add(Arrays.asList(6, 5, 7));
        lists.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(Solution.minimumTotal(lists));
    }
}
