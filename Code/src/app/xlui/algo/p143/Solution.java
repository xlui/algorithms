package app.xlui.algo.p143;

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode
                n1 = head,
                n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        ListNode nodeMiddle = n1, current = nodeMiddle.next, tmp;
        while (current.next != null) {
            tmp = current.next;
            current.next = tmp.next;
            tmp.next = nodeMiddle.next;
            nodeMiddle.next = tmp;
        }

        n1 = head;
        n2 = nodeMiddle.next;
        while (n1 != nodeMiddle) {
            nodeMiddle.next = n2.next;
            n2.next = n1.next;
            n1.next = n2;
            n1 = n2.next;
            n2 = nodeMiddle.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        solution.reorderList(root);
        solution.output(root);
    }

    private void output(ListNode root) {
        ListNode tmp = root;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
    }
}
