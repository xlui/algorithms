package me.xlui.algo;

import me.xlui.algo.Problem806.Solution;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] width = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Arrays.toString(Solution.numberOfLines(width, s)));

        width = new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        s = "bbbcccdddaaa";
        System.out.println(Arrays.toString(Solution.numberOfLines(width, s)));
    }
}
