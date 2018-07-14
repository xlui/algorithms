package app.xlui.algo.LeetCode.p648;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public String replaceWords(List<String> dict, String sentence) {
		String[] strings = sentence.split(" ");
		for (int i = 0; i < strings.length; i++) {
			for (String d : dict) {
				if (strings[i].startsWith(d)) {
					strings[i] = d;
				}
			}
		}
		return String.join(" ", strings);
	}

	public static void main(String[] args) {
		List<String> dict = new ArrayList<>(Arrays.asList("cat", "bat", "rat", "ba"));
		String sentence = "the cattle was rattled by the battery";
		Solution solution = new Solution();

		System.out.println(solution.replaceWords(dict, sentence));
	}
}
