package app.xlui.algo.LeetCode.p103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("ConstantConditions")
public class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		LinkedList<Integer> level = new LinkedList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		level.offer(0);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int lev = level.poll();
			if (result.size() <= lev) {
				result.add(new ArrayList<>());
			}
			if (lev % 2 == 0) {
				result.get(lev).add(node.val);
			} else {
				result.get(lev).add(0, node.val);
			}
			if (node.left != null) {
				queue.offer(node.left);
				level.offer(lev + 1);
			}
			if (node.right != null) {
				queue.offer(node.right);
				level.offer(lev + 1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(solution.zigzagLevelOrder(root));
	}
}
