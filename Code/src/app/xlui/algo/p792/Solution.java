package app.xlui.algo.p792;

import java.util.*;

public class Solution {
	public int _numMatchingSubseq(String S, String[] words) {
		int match = 0;
		for (String word : words) {
			int iS = 0, iW = 0;
			while (iS < S.length() && iW < word.length()) {
				if (S.charAt(iS) == word.charAt(iW)) {
					iS++;
					iW++;
				} else {
					iS++;
				}
			}
			if (iW == word.length()) {
				match++;
			}
		}
		return match;
	}

	public int numMatchingSubseq(String S, String[] words) {
		int match = 0;
		Map<Character, Deque<String>> map = new HashMap<>();
		for (char i = 'a'; i <= 'z'; i++) {
			map.put(i, new LinkedList<>());
		}
		for (String word : words) {
			map.get(word.charAt(0)).add(word);
		}
		for (char c : S.toCharArray()) {
			Deque<String> strings = map.get(c);
			int size = strings.size();
			for (int i = 0; i < size; i++) {
				String word = strings.removeFirst();
				if (1 == word.length()) {
					match++;
				} else {
					map.get(word.charAt(1)).add(word.substring(1));
				}
			}
		}
		return match;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
	}
}
