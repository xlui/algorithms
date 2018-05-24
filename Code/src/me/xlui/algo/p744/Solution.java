package me.xlui.algo.p744;

public class Solution {
	public char nextGreatestLetter(char[] letters, char target) {
		for (char letter : letters) {
			if (letter > target) {
				return letter;
			}
		}
		return letters[0];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[] letters = new char[]{'c', 'f', 'j'};
		assert 'c' == solution.nextGreatestLetter(letters, 'a');
		assert 'f' == solution.nextGreatestLetter(letters, 'c');
		assert 'f' == solution.nextGreatestLetter(letters, 'd');
		assert 'j' == solution.nextGreatestLetter(letters, 'g');
		assert 'c' == solution.nextGreatestLetter(letters, 'j');
		assert 'c' == solution.nextGreatestLetter(letters, 'k');
	}
}
