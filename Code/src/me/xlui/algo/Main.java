package me.xlui.algo;

import me.xlui.algo.Problem819.Solution;

public class Main {
    public static void main(String[] args) throws Exception {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(Solution.mostCommonWord(paragraph, banned));;
    }
}
