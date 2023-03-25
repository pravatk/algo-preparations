package my.preparations.educative.sliding_window;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring, which has no repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: String="aabccbb"
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 * Example 2:
 * <p>
 * Input: String="abbbb"
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 * Example 3:
 * <p>
 * Input: String="abccde"
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 */
public class _5LongestSubStringWithNonRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(findLongestSubStringWithNonRepeat("aabccbb"));
        System.out.println(findLongestSubStringWithNonRepeat("abbbb"));
        System.out.println(findLongestSubStringWithNonRepeat("abccde"));
        System.out.println(findLongestSubStringWithNonRepeat("abcade"));
    }
    public static int findLongestSubStringWithNonRepeat(String s) {
        int windowStart = 0, maxLength = Integer.MIN_VALUE;
        HashMap<Character, Integer> uniqueCharWithIndices = new HashMap<>();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char current = s.charAt(windowEnd);
            if (uniqueCharWithIndices.containsKey(current)) {
                int prevIndex = uniqueCharWithIndices.get(current);
                while (windowStart <= prevIndex) {
                    uniqueCharWithIndices.remove(s.charAt(windowStart));
                    windowStart++;
                }
            }
            uniqueCharWithIndices.put(current, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
