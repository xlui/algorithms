package me.xlui.algo;

import me.xlui.algo.Problem215.Solution;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] input1 = {3, 2, 1, 5, 6, 4};
        int[] input2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(Solution.findKthLargest(input1, 2));
        System.out.println(Solution.findKthLargest(input2, 4));
    }
}
