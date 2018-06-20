package app.xlui.algo.p076;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) {
			return "";
		}
		Map<Character, Integer> map = new HashMap<>();
		int match = 0, min = Integer.MAX_VALUE, left = 0, minLeft = 0;
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (int right = 0; right < s.length(); right++) {
			char r = s.charAt(right);
			if (map.containsKey(r)) {
				map.put(r, map.get(r) - 1);
				if (map.get(r) >= 0) {
					match++;
				}
				while (match == t.length()) {
					if (min > right - left + 1) {
						min = right - left + 1;
						minLeft = left;
					}
					char l = s.charAt(left++);
					if (map.containsKey(l)) {
						map.put(l, map.get(l) + 1);
						if (map.get(l) > 0) {
							match--;
						}
					}
				}
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + min);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
	}
}
