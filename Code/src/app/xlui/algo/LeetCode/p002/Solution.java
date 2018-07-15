package app.xlui.algo.LeetCode.p002;

public class Solution {
	private int carry = 0;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode node = new ListNode(-1);
		ListNode head = node;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + carry;
			if (sum >= 10) {
				sum -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			node.next = new ListNode(sum);
			l1 = l1.next;
			l2 = l2.next;
			node = node.next;
		}
		if (l1 != null) node = helper(l1, node);
		if (l2 != null) node = helper(l2, node);
		if (carry != 0) node.next = new ListNode(1);
		carry = 0;
		return head.next;
	}

	private ListNode helper(ListNode l, ListNode node) {
		while (l != null) {
			int sum = l.val + carry;
			if (sum >= 10) {
				sum -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			node.next = new ListNode(sum);
			l = l.next;
			node = node.next;
		}
		return node;
	}

	public ListNode _addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode node = head;
		int sum = 0;

		while (l1 != null || l2 != null) {
			sum /= 10;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			node.next = new ListNode(sum % 10);
			node = node.next;
		}

		if (sum / 10 == 1) {
			node.next = new ListNode(1);
		}
		return head.next;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(8);
//		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(1);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
//		l2.next.next.next = new ListNode(1);

		ListNode node = solution._addTwoNumbers(l1, l2);
		out(node);
	}

	private static void out(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
}
