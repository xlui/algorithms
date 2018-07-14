package app.xlui.algo.LeetCode.p641;

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

public class MyCircularDeque {
	private final int len;
	private Node front;
	private Node rear;
	private int size;

	/**
	 * Initialize your data structure here. Set the size of the deque to be k.
	 */
	public MyCircularDeque(int k) {
		len = k;
		size = 0;
		front = new Node(-1);
		rear = new Node(-1);
		front.prev = rear;
		rear.next = front;
	}

	/**
	 * Adds an item at the front of Deque. Return true if the operation is successful.
	 */
	public boolean insertFront(int value) {
		if (isFull()) {
			return false;
		}
		Node node = new Node(value);
		node.next = front;
		node.prev = front.prev;
		front.prev.next = node;
		front.prev = node;
		size++;
		return true;
	}

	/**
	 * Adds an item at the rear of Deque. Return true if the operation is successful.
	 */
	public boolean insertLast(int value) {
		if (isFull()) {
			return false;
		}
		Node node = new Node(value);
		node.next = rear.next;
		node.next.prev = node;
		rear.next = node;
		node.prev = rear;
		size++;
		return true;
	}

	/**
	 * Deletes an item from the front of Deque. Return true if the operation is successful.
	 */
	public boolean deleteFront() {
		if (isEmpty()) {
			return false;
		}
		front.prev.prev.next = front;
		front.prev = front.prev.prev;
		size--;
		return true;
	}

	/**
	 * Deletes an item from the rear of Deque. Return true if the operation is successful.
	 */
	public boolean deleteLast() {
		if (isEmpty()) {
			return false;
		}
		rear.next.next.prev = rear;
		rear.next = rear.next.next;
		size--;
		return true;
	}

	/**
	 * Get the front item from the deque.
	 */
	public int getFront() {
		return front.prev.val;
	}

	/**
	 * Get the last item from the deque.
	 */
	public int getRear() {
		return rear.next.val;
	}

	/**
	 * Checks whether the circular deque is empty or not.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Checks whether the circular deque is full or not.
	 */
	public boolean isFull() {
		return size == len;
	}

	private static final class Node {
		int val;
		Node prev, next;

		Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		MyCircularDeque deque = new MyCircularDeque(3);
		assert deque.insertLast(1);
		assert deque.insertLast(2);
		assert deque.insertFront(3);
		assert !deque.insertFront(4);
		assert 2 == deque.getRear();
		assert deque.isFull();
		assert deque.deleteLast();
		assert deque.insertFront(4);
		assert 4 == deque.getFront();
	}
}
