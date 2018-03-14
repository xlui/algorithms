package me.xlui.algo;

import me.xlui.algo.Problem417.Solution;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		int[][] matrix = new int[5][5];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 2;
		matrix[0][3] = 3;
		matrix[0][4] = 5;
		matrix[1][0] = 3;
		matrix[1][1] = 2;
		matrix[1][2] = 3;
		matrix[1][3] = 4;
		matrix[1][4] = 4;
		matrix[2][0] = 2;
		matrix[2][1] = 4;
		matrix[2][2] = 5;
		matrix[2][3] = 3;
		matrix[2][4] = 1;
		matrix[3][0] = 6;
		matrix[3][1] = 7;
		matrix[3][2] = 1;
		matrix[3][3] = 4;
		matrix[3][4] = 5;
		matrix[4][0] = 5;
		matrix[4][1] = 1;
		matrix[4][2] = 1;
		matrix[4][3] = 2;
		matrix[4][4] = 4;
		List<int[]> list = Solution.pacificAtlantic(matrix);
		for (int[] ints : list) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}
}
