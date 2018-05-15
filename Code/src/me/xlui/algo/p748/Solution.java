package me.xlui.algo.p748;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 整体的思路是：使用 Map 存储 word 和 licensePlate 中各个字符的数量，然后通过比较判断 word 是否合法。之后再寻找合法的 word 中最短的。
 */
public class Solution {
	public static String shortestCompletingWord(String licensePlate, String[] words) {
		// 对 licensePlate 去重、小写化、排序后，存储为字符列表
		List<String> plate = Arrays.stream(licensePlate.split(""))
				.filter(c -> c.matches("[a-zA-Z]"))
				.map(String::toLowerCase)
				.sorted()
				.collect(Collectors.toList());
		Map<String, Integer> licenseMap = new HashMap<>();
		int min = Integer.MAX_VALUE;
		String ret = "";

		for (String s : plate) {
			licenseMap.put(s, licenseMap.getOrDefault(s, 0) + 1);
		}
		for (String word : words) {
			if (isValid(licenseMap, word)) {
				if (word.length() < min) {
					min = word.length();
					ret = word;
				}
			}
		}
		return ret;
	}

	// 判断 word 是否合法
	private static boolean isValid(Map<String, Integer> licenseMap, String word) {
		Map<String, Integer> wordMap = new HashMap<>();
		for (String s : word.split("")) {
			wordMap.put(s, wordMap.getOrDefault(s, 0) + 1);
		}
		for (String key : licenseMap.keySet()) {
			if (wordMap.getOrDefault(key, 0).compareTo(licenseMap.get(key)) < 0) {
				// 如果 licensePlate 对应的 Map 里有 key，且 key 的数量大于 word 中相应 key 的数量，则返回 false
				return false;
			}
		}
		return true;
	}
}
