package app.xlui.algo.p232;

import java.util.LinkedList;

public class MyQueue {
	private LinkedList<Integer> pushStack;
	private LinkedList<Integer> popStack;

	/**
	 * Initialize your data structure here.
	 */
	public MyQueue() {
		pushStack = new LinkedList<>();
		popStack = new LinkedList<>();
	}

	/**
	 * Push element x to the back of queue.
	 */
	public void push(int x) {
		pushStack.push(x);
	}

	/**
	 * Removes the element from in front of queue and returns that element.
	 */
	public int pop() {
		if (popStack.isEmpty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
		return popStack.pop();
	}

	/**
	 * Get the front element.
	 */
	public int peek() {
		if (popStack.isEmpty()) {
			while (!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
		return popStack.peek();
	}

	/**
	 * Returns whether the queue is empty.
	 */
	public boolean empty() {
		return pushStack.isEmpty() && popStack.isEmpty();
	}
}
