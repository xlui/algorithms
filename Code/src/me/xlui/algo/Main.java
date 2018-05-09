package me.xlui.algo;

import me.xlui.algo.Problem100.Solution;
import me.xlui.algo.Problem100.TreeNode;

public class Main {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(1);
        node2.right = new TreeNode(2);
        System.out.println(solution.isSameTree(node1, node2));
    }
}
