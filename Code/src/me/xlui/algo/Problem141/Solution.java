package me.xlui.algo.Problem141;

public class Solution {
	public static boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}

		ListNode slow = head.next;
		if (slow == null) {
			return false;
		}
		ListNode fast = slow.next;
		while (fast != null && slow != null) {
			if (fast == slow) {
				return true;
			}
			slow = slow.next;
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
			}
		}
		return false;
	}
}
