package my.preparations.educative.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int start = 0, end = 0, totalMatch = 0, minLength = Integer.MAX_VALUE, startR = 0;
        while (end < str.length()) {
            char current = str.charAt(end);
            if (map.containsKey(current)) {
                map.put(current, map.get(current) - 1);
                if (map.get(current) >= 0)
                    totalMatch++;
            }

            while (totalMatch == pattern.length()) {
                if (minLength > end - start + 1) {
                    minLength = end - start + 1;
                    startR = start;
                }

                char ch = str.charAt(start++);
                if (map.containsKey(ch)) {
                    if (map.get(ch) == 0)
                        totalMatch--;
                    map.put(ch, map.get(ch) + 1);
                }
            }
            end++;
        }

        return minLength <= str.length() ? str.substring(startR, startR + minLength) : "";
    }
}
