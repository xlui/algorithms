package app.xlui.algo.p783;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE, tmp;
        List<Integer> numbers = new LinkedList<>();
        inOrderTraversal(root, numbers);
        for (int i = 1, len = numbers.size(); i < len; i++) {
            tmp = numbers.get(i) - numbers.get(i - 1);
            if (tmp < min) {
                min = tmp;
            }
        }
        return min;
    }

    private static void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrderTraversal(root.left, list);
            list.add(root.val);
            inOrderTraversal(root.right, list);
        }
    }
}
