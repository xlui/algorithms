package me.xlui.algo;

public class Assert {
	public static void assertTrue(boolean expression) {
		assert expression;
	}

	public static void assertFalse(boolean expression) {
		assert !expression;
	}

	public static void assertEquals(int n1, int n2) {
		assert n1 == n2;
	}
}
