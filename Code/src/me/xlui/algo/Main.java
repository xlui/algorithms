package me.xlui.algo;

import me.xlui.algo.Problem350.Solution;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(Solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(Solution.intersect(new int[]{1}, new int[]{1, 1})));
	}
}
