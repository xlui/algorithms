package app.xlui.algo.p450;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		} else if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left != null && root.right != null) {
				TreeNode rightMin = root.right;
				while (rightMin.left != null) {
					rightMin = rightMin.left;
				}
				root.val = rightMin.val;
				root.right = deleteNode(root.right, root.val);
			} else {
				root = (root.left != null) ? root.left : root.right;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);

		TreeNode node = solution.deleteNode(root, 5);

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			if (tmp == null) {
				System.out.print("null ");
			} else {
				System.out.print(tmp.val + " ");
				queue.add(tmp.left);
				queue.add(tmp.right);
			}
		}
	}
}
