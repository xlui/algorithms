package me.xlui.algo.p406;

import java.util.*;

public class Solution {
	public static int[][] reconstructQueue(int[][] people) {
		// 按身高倒序排列，身高相同的按 k 排列
		Arrays.sort(people, (c1, c2) -> {
			if (c1[0] != c2[0]) {
				return c2[0] - c1[0];
			} else {
				return c1[1] - c2[1];
			}
		});
		List<int[]> ret = new ArrayList<>();
		// 然后将排序好的元素一一插入 List
		for (int[] person : people) {
			ret.add(person[1], person);
		}
		return ret.toArray(new int[people.length][]);
	}
}
