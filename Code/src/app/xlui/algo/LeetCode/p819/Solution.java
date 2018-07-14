package app.xlui.algo.LeetCode.p819;

import java.util.*;

public class Solution {
    public static String mostCommonWord(String paragraph, String[] banned) {
        int count = 0;
        String out = "";
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(banned));

        StringTokenizer st = new StringTokenizer(paragraph.toLowerCase(), " \t\n\r\f,.:;?![]'");
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
                if (map.get(word) > count) {
                    count = map.get(word);
                    out = word;
                }
            }
        }
        return out;
    }
}
