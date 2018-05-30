package app.xlui.algo.p515;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // 直接将最大值设置在 list 相应位置上
        getMax(root, list, 0);
        return list;
    }

    private static void getMax(TreeNode root, List<Integer> list, int depth) {
        if (root == null) {
            return;
        }
        if (depth == list.size()) {
            list.add(root.val);
        } else {
            list.set(depth, Math.max(list.get(depth), root.val));
        }
        getMax(root.left, list, depth + 1);
        getMax(root.right, list, depth + 1);
    }
}
