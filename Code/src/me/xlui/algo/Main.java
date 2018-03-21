package me.xlui.algo;

import me.xlui.algo.Problem406.Solution;

public class Main {
	public static void main(String[] args) throws Exception {
		int[][] people = new int[][]{
			new int[]{7, 0},
			new int[]{4, 4},
			new int[]{7, 1},
			new int[]{5, 0},
			new int[]{6, 1},
			new int[]{5, 2},
		};
		people = Solution.reconstructQueue(people);
		for (int[] person : people) {
			System.out.println(person[0] + " " + person[1]);
		}
	}
}
