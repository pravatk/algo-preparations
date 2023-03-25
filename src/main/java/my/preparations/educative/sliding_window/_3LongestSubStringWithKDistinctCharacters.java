package my.preparations.educative.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * You can assume that K is less than or equal to the length of the given string.
 * <p>
 * Example 1:
 * <p>
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Example 2:
 * <p>
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 */
public class _3LongestSubStringWithKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(findLengthOfLongestSubString("araaci", 2));
        System.out.println(findLengthOfLongestSubString("araaci", 3));
        System.out.println(findLengthOfLongestSubString("araaci", 4));
        System.out.println(findLengthOfLongestSubString("araaci", 1));
        System.out.println(findLengthOfLongestSubString("cbbebi", 3));
    }

    private static int findLengthOfLongestSubString(String str, int k) {
        if (str == null || str.trim().isEmpty() || str.length() < k)
            throw new IllegalArgumentException();
        int windowStart = 0, maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            final char ch = str.charAt(windowEnd);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.keySet().size() == k) {
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            } else if (map.keySet().size() > k) {
                while (map.keySet().size() > k) {
                    char start = str.charAt(windowStart);
                    int count = map.get(start);
                    if (count > 1)
                        map.put(start, count - 1);
                    else
                        map.remove(start);
                    windowStart++;
                }
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            }
        }
        return maxLength;
    }


}
