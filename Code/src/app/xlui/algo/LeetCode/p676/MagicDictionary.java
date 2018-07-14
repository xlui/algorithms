package app.xlui.algo.LeetCode.p676;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class MagicDictionary {
	private Set<String> dictSet = new HashSet<>();

	/**
	 * Initialize your data structure here.
	 */
	public MagicDictionary() {

	}

	/**
	 * Build a dictionary through a list of words
	 */
	public void buildDict(String[] dict) {
		Collections.addAll(dictSet, dict);
	}

	/**
	 * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
	 */
	public boolean search(String word) {
		char[] words = word.toCharArray();
		for (int i = 0, len = words.length; i < len; i++) {
			char w = words[i];
			for (char j = 'a'; j <= 'z'; j++) {
				if (j == w) {
					continue;
				}
				words[i] = j;
				if (dictSet.contains(String.valueOf(words))) {
					return true;
				}
			}
			words[i] = w;
		}
		return false;
	}

	public static void main(String[] args) {
		MagicDictionary magicDictionary = new MagicDictionary();
		magicDictionary.buildDict(new String[]{"hello", "leetcode"});
		assert !magicDictionary.search("hello");
		assert magicDictionary.search("hhllo");
		assert !magicDictionary.search("hell");
		assert !magicDictionary.search("leetcoded");
		assert !magicDictionary.search("leetcode");
	}
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */