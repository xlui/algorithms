package app.xlui.algo.LeetCode.p671;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int findSecondMinimumValue(TreeNode root) {
		Set<Integer> set = new HashSet<>();
		dfs(root, set);
		set.remove(root.val);
		int result = Integer.MAX_VALUE;
		for (Integer integer : set) {
			if (result > integer) {
				result = integer;
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}

	private void dfs(TreeNode root, Set<Integer> set) {
		if (root != null) {
			set.add(root.val);
			dfs(root.left, set);
			dfs(root.right, set);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		TreeNode node1 = new TreeNode(2);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(5);
		node1.right.left = new TreeNode(5);
		node1.right.right = new TreeNode(7);
		System.out.println(solution.findSecondMinimumValue(node1));

		TreeNode node2 = new TreeNode(2);
		node2.left = new TreeNode(2);
		node2.right = new TreeNode(2);
		System.out.println(solution.findSecondMinimumValue(node2));
	}
}
