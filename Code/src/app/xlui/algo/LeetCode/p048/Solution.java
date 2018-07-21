package app.xlui.algo.LeetCode.p048;

import java.util.Arrays;

public class Solution {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int n = matrix.length;
		for (int begin = 0, end = n - 1; begin < end; begin++, end--) {
			int[] tmp = matrix[begin];
			matrix[begin] = matrix[end];
			matrix[end] = tmp;
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] matrix1 = new int[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9},
		};
		solution.rotate(matrix1);
		System.out.println(Arrays.deepToString(matrix1));

		int[][] matrix2 = new int[][]{
				{5, 1, 9, 11},
				{2, 4, 8, 10},
				{13, 3, 6, 7},
				{15, 14, 12, 16}
		};
		solution.rotate(matrix2);
		System.out.println(Arrays.deepToString(matrix2));
	}
}
