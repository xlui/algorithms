package app.xlui.algo.p492;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static int[] constructRectangle(int area) {
        int div;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });

        for (int i = (int) Math.sqrt(area); i > 0; i--) {
            if (area % i == 0) {
                div = area / i;
                if (div > i) {
                    priorityQueue.add(new int[]{div, i});
                } else {
                    priorityQueue.add(new int[]{i, div});
                }
            }
        }

        return priorityQueue.poll();
    }
}
