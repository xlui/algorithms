package me.xlui.algo;

import me.xlui.algo.Problem748.Solution;

public class Main {
	public static void main(String[] args) {
//		String licensePlate = "1s3 PSt";
//		String[] words = new String[]{"step", "steps", "stripe", "stepple"};
//		String licensePlate = "1s3 456";
//		String[] words = new String[]{"looks", "pest", "stew", "show"};
		String licensePlate = "Ah71752";
		String[] words = new String[]{"suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"};
		System.out.println(Solution.shortestCompletingWord(licensePlate, words));
	}
}
