package app.xlui.algo.p617;

public class Solution {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;

		t1.val += t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);

		return t1;
	}

	public TreeNode sacrificeSpaceToOptimize(TreeNode t1, TreeNode t2) {
		if (t1 == null)
			return t2;
		if (t2 == null)
			return t1;

		TreeNode node = new TreeNode(t1.val + t2.val);
		node.left = mergeTrees(t1.left, t2.left);
		node.right = mergeTrees(t1.right, t2.right);
		return node;
	}
}
