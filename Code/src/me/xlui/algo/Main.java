package me.xlui.algo;


import me.xlui.algo.Problem303.NumArray;

public class Main {
	public static void main(String[] args) throws Exception {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		NumArray obj = new NumArray(nums);
		System.out.println(obj.sumRange(0, 2));
		System.out.println(obj.sumRange(2, 5));
		System.out.println(obj.sumRange(0, 5));
	}
}
