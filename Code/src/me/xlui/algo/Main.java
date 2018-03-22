package me.xlui.algo;

import me.xlui.algo.Problem101.Solution;
import me.xlui.algo.Problem101.TreeNode;

public class Main {
	public static void main(String[] args) throws Exception {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(2);
		treeNode.left.left = new TreeNode(3);
		treeNode.left.right = new TreeNode(4);
		treeNode.right.left = new TreeNode(4);
		treeNode.right.right = new TreeNode(3);
		System.out.println(Solution.deque(treeNode));
	}
}
