package app.xlui.algo.p728;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new LinkedList<>();
		List<Integer> digits = new LinkedList<>();
		for (int i = left; i <= right; i++) {
			int n = i;
			while (n != 0) {
				digits.add(n % 10);
				n /= 10;
			}
			int count = 0;
			for (Integer digit : digits) {
				if (digit == 0 || i % digit != 0) {
					break;
				} else {
					count++;
				}
			}
			if (count == digits.size()) {
				list.add(i);
			}
			digits.clear();
		}
		return list;
	}

	public List<Integer> selfDividingNumbers1(int left, int right) {
		List<Integer> list = new LinkedList<>();
		for (int i = left; i <= right; i++) {
			int n = i;
			boolean meet = true;
			while (n != 0) {
				int digit = n % 10;
				if (digit == 0 || i % digit != 0) {
					meet = false;
				}
				n /= 10;
			}
			if (meet) {
				list.add(i);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.selfDividingNumbers(1, 22));
	}
}
