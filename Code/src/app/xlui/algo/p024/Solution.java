package app.xlui.algo.p024;

public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode node = head.next;
		head.next = swapPairs(node.next);
		node.next=head;
		return node;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		out(solution.swapPairs(head));
	}

	private static void out(ListNode root ) {
		while (root != null) {
			System.out.print(root.val + " ");
			root = root.next;
		}
	}
}
