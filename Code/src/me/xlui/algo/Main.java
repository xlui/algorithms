package me.xlui.algo;

import me.xlui.algo.Problem284.PeekingIteratorOptimize;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3);
		PeekingIteratorOptimize iterator = new PeekingIteratorOptimize(list.iterator());
		System.out.println(iterator.peek());
		System.out.println(iterator.next());

		System.out.println(iterator.peek());
		System.out.println(iterator.next());

		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
	}
}
