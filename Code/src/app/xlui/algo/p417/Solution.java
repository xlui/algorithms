package app.xlui.algo.p417;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {1, -1, 0, 0};

	public static List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> ret = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return ret;
		}
		int n = matrix.length, m = matrix[0].length;
		boolean[][] pacificVisited = new boolean[n][m];
		boolean[][] atlanticVisited = new boolean[n][m];
		// 从每一行的首尾对每一个元素进行判断，首代表 pacific，尾代表 Atlantic
		for (int i = 0; i < n; i++) {
			flow(pacificVisited, matrix, i, 0, n, m);
			flow(atlanticVisited, matrix, i, m - 1, n, m);
		}
		// 从每一列的首尾对每一个元素进行判断，首代表 pacific，尾代表 Atlantic
		for (int i = 0; i < m; i++) {
			flow(pacificVisited, matrix, 0, i, n, m);
			flow(atlanticVisited, matrix, n - 1, i, n, m);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (pacificVisited[i][j] && atlanticVisited[i][j]) {
					ret.add(new int[]{i, j});
				}
			}
		}
		return ret;
	}

	// 流向的含义是：当前元素小于或者等于下一个（前后左右）元素，则可以流通
	private static void flow(boolean[][] visited, int[][] matrix, int x, int y, int n, int m) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (!visited[nx][ny] && matrix[nx][ny] >= matrix[x][y]) {
					flow(visited, matrix, nx, ny, n, m);
				}
			}
		}
	}
}
