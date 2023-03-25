package my.preparations.educative.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<Character, Integer> charFreq = new HashMap<>();

        for (char ch : pattern.toCharArray()) {
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
        }

        int start = 0, end = 0, totalMatched = 0;

        while (end < str.length()) {
            char current = str.charAt(end);
            if (charFreq.containsKey(current) && charFreq.get(current) > 0) {
                totalMatched++;
                charFreq.put(current, charFreq.get(current) - 1);
            } else {
                while (start < end) {
                    char ch = str.charAt(start++);
                    if (charFreq.containsKey(ch)) {
                        charFreq.put(ch, charFreq.get(ch) + 1);
                        totalMatched--;
                    }
                }
                char ch = str.charAt(start);
                if (charFreq.containsKey(ch)) {
                    charFreq.put(ch, charFreq.get(ch) + 1);
                    totalMatched++;
                } else start++;
            }

            if (totalMatched == pattern.length()) {
                resultIndices.add(start);
                char ch = str.charAt(start++);
                if (charFreq.containsKey(ch)) {
                    charFreq.put(ch, charFreq.get(ch) + 1);
                    totalMatched--;
                }
            }
            end++;
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(findStringAnagrams("ppqp", "pq"));
        System.out.println(findStringAnagrams("abbcabc", "abc"));
        System.out.println(findStringAnagrams("abxcabc", "abc"));
    }
}
