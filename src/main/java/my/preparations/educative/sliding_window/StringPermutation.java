package my.preparations.educative.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 */
public class StringPermutation {
    public static boolean findPermutation(String s1, String s2) {
        Map<Character, Integer> charFreq = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
        }

        int start = 0, end = 0, totalMatched = 0;
        while (end < s2.length()) {
            char current = s2.charAt(end);
            if (charFreq.containsKey(current)) {
                charFreq.put(current, charFreq.get(current) - 1);
                if (charFreq.get(current) == 0)
                    totalMatched++;
            }

            if (totalMatched == charFreq.size()) {
                return true;
            }

            if (end >= s1.length() - 1) {
                char ch = s2.charAt(start++);
                if (charFreq.containsKey(ch)) {
                    if (charFreq.get(ch) == 0)
                        totalMatched--;
                    charFreq.put(ch, charFreq.get(ch) + 1);
                }
            }
            end++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("abc", "aaaacb"));
    }

}
