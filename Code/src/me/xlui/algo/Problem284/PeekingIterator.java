package me.xlui.algo.Problem284;

import java.util.Iterator;
import java.util.Stack;

public class PeekingIterator implements Iterator<Integer> {
	private Iterator<Integer> iterator;
	private Stack<Integer> nextValue;

	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
		this.nextValue = new Stack<>();
	}

	public Integer peek() {
		if (this.nextValue.isEmpty()) {
			this.nextValue.push(this.iterator.next());
		}
		return this.nextValue.peek();
	}

	@Override
	public boolean hasNext() {
		return this.nextValue.isEmpty() ? iterator.hasNext() : true;
	}

	@Override
	public Integer next() {
		return this.nextValue.isEmpty() ? this.iterator.next() : this.nextValue.pop();
	}
}
