package me.xlui.algo;

import me.xlui.algo.Problem783.Solution;
import me.xlui.algo.Problem783.TreeNode;

public class Main {
	public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(Solution.minDiffInBST(root));
	}
}
