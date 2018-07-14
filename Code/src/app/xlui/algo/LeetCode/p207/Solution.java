package app.xlui.algo.LeetCode.p207;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = queue.size();
        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (t == prerequisite[1]) {
                    int l = prerequisite[0];
                    inDegree[l]--;
                    if (inDegree[l] == 0) {
                        queue.add(l);
                        ++count;
                    }
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        assert solution.canFinish(2, new int[][]{new int[]{1, 0}});
        assert solution.canFinish(2, new int[][]{new int[]{0, 1}});
        assert !solution.canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}});
        assert solution.canFinish(3, new int[][]{new int[]{2, 1}, new int[]{1, 0}});
        assert !solution.canFinish(3, new int[][]{new int[]{1, 0}, new int[]{1, 2}, new int[]{0, 1}});
    }
}
