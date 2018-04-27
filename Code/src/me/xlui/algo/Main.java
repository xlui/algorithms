package me.xlui.algo;

import me.xlui.algo.Problem605.Solution;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		int flowerbed1[] = {1, 0, 0, 0, 1};
		int n1 = 1;
		System.out.println("Except: " + true);
		System.out.println(Solution.canPlaceFlowers(flowerbed1, n1));

		int flowerbed2[] = {1, 0, 0, 0, 1};
		int n2 = 2;
		System.out.println("Except: " + false);
		System.out.println(Solution.canPlaceFlowers(flowerbed2, n2));

		int f3[] = {1, 0, 0, 0, 0, 1};
		System.out.println("Except: " + false);
		System.out.println(Solution.canPlaceFlowers(f3, n2));

		int f4[] = {0, 0, 1, 0, 1};
		System.out.println("Except: " + true);
		System.out.println(Solution.canPlaceFlowers(f4, 1));

		int f5[] = {1, 0, 0, 0, 1, 0, 0};
		System.out.println("Except: " + true);
		System.out.println(Solution.canPlaceFlowers(f5, 2));
		System.out.println(Arrays.toString(f5));
	}
}
