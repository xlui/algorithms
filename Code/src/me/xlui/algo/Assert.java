package me.xlui.algo;

public class Assert {
	public static void assertTrue(boolean expression) {
		assert expression;
	}

	public static void assertFalse(boolean expression) {
		assert !expression;
	}
}
