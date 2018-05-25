package me.xlui.algo.p445;

import com.sun.org.apache.bcel.internal.generic.LNEG;

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 = reverse(l1);
		l2 = reverse(l2);

		ListNode node = new ListNode(-1), cur = node;
		boolean carry = false;
		while ((l1 != null && l2 != null) || carry) {
			int sum;
			if (carry) {
				sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + 1;
				l1 = l1 == null ? null : l1.next;
				l2 = l2 == null ? null : l2.next;
			} else {
				sum = l1.val + l2.val;
				l1 = l1.next;
				l2 = l2.next;
			}
			if (sum >= 10) {
				cur.next = new ListNode(sum % 10);
				carry = true;
			} else {
				cur.next = new ListNode(sum);
				carry = false;
			}
			cur = cur.next;
		}
		while (l1 != null) {
			cur.next = new ListNode(l1.val);
			l1 = l1.next;
			cur = cur.next;
		}
		while (l2 != null) {
			cur.next = new ListNode(l2.val);
			l2 = l2.next;
			cur = cur.next;
		}

		return reverse(node.next);
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode ret = null, next = null;
		while (head != null) {
			next = head.next;
			head.next = ret;
			ret = head;
			head = next;
		}
		return ret;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		Solution solution = new Solution();
		ListNode node = solution.addTwoNumbers(l1, l2);

		out(node);

		l1 = new ListNode(5);
		l2 = new ListNode(5);
		out(solution.addTwoNumbers(l1, l2));
	}

	private static void out(ListNode node) {
		while (node != null) {
			if (node.next != null) {
				System.out.print(node.val + " -> ");
			} else {
				System.out.println(node.val);
			}
			node = node.next;
		}
	}
}
