package app.xlui.algo.p083;

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode node = head;
		while (node.next != null) {
			if (node.val == node.next.val) {
				node.next = node.next.next;
			} else {
				node = node.next;
			}
		}
		return head;
	}

	public ListNode deleteDuplicates1(ListNode head) {
		if (head == null) {
			return head;
		}
		while (head.next != null && head.val == head.next.val) {
			head.next = head.next.next;
		}
		head.next = deleteDuplicates1(head.next);
		return head;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(1);
		node1.next.next = new ListNode(2);
		out(solution.deleteDuplicates(node1));

		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(1);
		node2.next.next = new ListNode(2);
		node2.next.next.next = new ListNode(3);
		node2.next.next.next.next = new ListNode(3);
		out(solution.deleteDuplicates(node2));
	}

	private static void out(ListNode node) {
		while (node != null) {
			System.out.print(node.val);
			node = node.next;
		}
		System.out.println();
	}
}
