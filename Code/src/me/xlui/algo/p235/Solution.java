package me.xlui.algo.p235;

public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			if (root.val < p.val && root.val < q.val) {
				root = root.right;
			} else if (root.val > p.val && root.val > q.val) {
				root = root.left;
			} else {
				break;
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		Solution solution = new Solution();

		System.out.println(solution.lowestCommonAncestor(root, root.left, root.left.right).val);
	}
}
