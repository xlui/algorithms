package app.xlui.algo.p101;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
	public static boolean isSymmetrix(TreeNode root) {
		if (root == null) {
			return true;
		}
		return treeEqual(root.left, root.right);
	}

	private static boolean treeEqual(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null) {
			return true;
		}
		if (tree1 == null || tree2 == null) {
			return false;
		}
		if (tree1.val != tree2.val) {
			return false;
		} else {
			return treeEqual(tree1.left, tree2.right) && treeEqual(tree1.right, tree2.left);
		}
	}

	public static boolean deque(TreeNode root) {
		if (root == null) {
			return true;
		}

		TreeNode preNode = null, postNode = null;
		Deque<TreeNode> deque = new LinkedList<>();
		deque.addFirst(root.left);
		deque.addLast(root.right);

		while (!deque.isEmpty()) {
			preNode = deque.pollFirst();
			postNode = deque.pollLast();
			if (preNode == null && postNode == null) {
				continue;
			}
			if (preNode == null || postNode == null) {
				return false;
			}
			if (preNode.val != postNode.val) {
				return false;
			} else {
				deque.addFirst(preNode.right);
				deque.addFirst(preNode.left);
				deque.addLast(postNode.left);
				deque.addLast(postNode.right);
			}
		}
		return true;
	}
}
