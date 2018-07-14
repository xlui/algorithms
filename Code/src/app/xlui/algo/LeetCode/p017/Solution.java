package app.xlui.algo.LeetCode.p017;

import java.util.*;

public class Solution {
	private static Map<Integer, List<String>> map = new HashMap<Integer, List<String>>() {{
		put(2, Arrays.asList("a", "b", "c"));
		put(3, Arrays.asList("d", "e", "f"));
		put(4, Arrays.asList("g", "h", "i"));
		put(5, Arrays.asList("j", "k", "l"));
		put(6, Arrays.asList("m", "n", "o"));
		put(7, Arrays.asList("p", "q", "r", "s"));
		put(8, Arrays.asList("t", "u", "v"));
		put(9, Arrays.asList("w", "x", "y", "z"));
	}};

	public List<String> letterCombinations(String digits) {
		List<String> list = new LinkedList<>();
		if (digits.length() == 0) return list;
		helper(digits, 0, "", list);
		return list;
	}

	private void helper(String digits, int current, String builder, List<String> result) {
		if (current == digits.length()) {
			result.add(builder);
			return;
		}
		int digit = digits.charAt(current) - '0';
		for (String s : map.get(digit)) {
			helper(digits, current + 1, builder + s, result);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.letterCombinations("23"));
	}
}
