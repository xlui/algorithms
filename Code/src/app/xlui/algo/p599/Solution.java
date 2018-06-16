package app.xlui.algo.p599;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public String[] findRestaurant(String[] list1, String[] list2) {
		int min = Integer.MAX_VALUE;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < list2.length; i++) {
			map.put(list2[i], i);
		}

		int another;
		Map<Integer, List<Integer>> res = new HashMap<>();
		for (int i = 0; i < list1.length; i++) {
			if ((another = map.getOrDefault(list1[i], -1)) != -1) {
				if (min >= i + another) {
					min = i + another;
					List<Integer> list = res.getOrDefault(min, new ArrayList<>());
					list.add(i);
					res.put(min, list);
				}
			}
		}

		List<Integer> list = res.get(min);
		String[] result = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list1[list.get(i)];
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		String[] l1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] l2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		System.out.println(Arrays.toString(solution.findRestaurant(l1, l2)));

		String[] l3 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] l4 = {"KFC", "Shogun", "Burger King"};
		System.out.println(Arrays.toString(solution.findRestaurant(l3, l4)));

		String[] l5 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] l6 = {"KFC", "Burger King", "Tapioca Express", "Shogun"};
		System.out.println(Arrays.toString(solution.findRestaurant(l5, l6)));
	}
}
