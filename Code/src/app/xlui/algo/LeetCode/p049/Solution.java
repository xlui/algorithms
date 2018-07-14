package app.xlui.algo.LeetCode.p049;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	// 26 prime numbers
	private static int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<Integer, List<String>> map = new HashMap<>();
		for (String str : strs) {
			int hash = hash(str);
			List<String> list = map.getOrDefault(hash, new ArrayList<>());
			list.add(str);
			map.put(hash, list);
		}
		return new ArrayList<>(map.values());
	}

	private int hash(String str) {
		int hash = 1;
		char[] chars = str.toCharArray();
		for (char aChar : chars) {
			hash *= prime[aChar - 'a'];
		}
		return hash;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
}
