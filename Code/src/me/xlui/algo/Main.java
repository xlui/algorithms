package me.xlui.algo;

import me.xlui.algo.Problem515.Solution;
import me.xlui.algo.Problem515.TreeNode;

public class Main {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(Solution.largestValues(root));
    }
}
