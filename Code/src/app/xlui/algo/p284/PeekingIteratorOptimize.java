package app.xlui.algo.p284;

import java.util.Iterator;

public class PeekingIteratorOptimize implements Iterator<Integer> {
	private Iterator<Integer> iterator;
	private Integer next;

	public PeekingIteratorOptimize(Iterator<Integer> iterator) {
		this.iterator = iterator;
		if (this.iterator.hasNext()) {
			this.next = this.iterator.next();
		}
	}

	public Integer peek() {
		return this.next;
	}

	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public Integer next() {
		int t = this.next;
		this.next = this.iterator.hasNext() ? this.iterator.next() : null;
		return t;
	}
}
