package app.xlui.algo.LeetCode.p706;

import java.util.HashMap;

public class MyHashMap {
	private HashMap<Integer, Integer> map = new HashMap<>();
	/**
	 * Initialize your data structure here.
	 */
	public MyHashMap() {
	}

	/**
	 * value will always be non-negative.
	 */
	public void put(int key, int value) {
		map.put(key, value);
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
	 */
	public int get(int key) {
		return map.getOrDefault(key, -1);
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping for the key
	 */
	public void remove(int key) {
		map.remove(key);
	}
}
