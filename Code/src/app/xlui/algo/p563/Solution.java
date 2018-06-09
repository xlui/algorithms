package app.xlui.algo.p563;

public class Solution {
	private int sum;

	public int findTilt(TreeNode root) {
		System.out.println(helper(root));
		return sum;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		sum += Math.abs(left - right);
		return left + root.val + right;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		System.out.println(solution.findTilt(root));
	}
}
