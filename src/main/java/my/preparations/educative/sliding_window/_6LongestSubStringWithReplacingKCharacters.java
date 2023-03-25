package my.preparations.educative.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 * <p>
 * Example 1:
 * <p>
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 * Example 2:
 * <p>
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 * Example 3:
 * <p>
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class _6LongestSubStringWithReplacingKCharacters {
    public static void main(String[] args) {
        System.out.println(findLongestSubStringAfterReplacingKChars("aabccbb", 2));
        System.out.println(findLongestSubStringAfterReplacingKChars("abbcb", 1));
        System.out.println(findLongestSubStringAfterReplacingKChars("abccde", 1));

        System.out.println(anotherWay("aabccbb", 2));
        System.out.println(anotherWay("abbcb", 1));
        System.out.println(anotherWay("abccde", 1));
    }

    public static int findLongestSubStringAfterReplacingKChars(String str, int k) {
        int windowStart = 0, maxLength = Integer.MIN_VALUE, swaps = k;
        char fromChar = str.charAt(windowStart);
        Set<Character> unique = new HashSet<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char current = str.charAt(windowEnd);
            unique.add(current);
            if (current != fromChar && swaps > 0) {
                swaps--;
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            } else if (current == fromChar) {
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            } else {
                // swaps is 0, move to the first unique char
                while (fromChar == str.charAt(windowStart)) {
                    windowStart++;
                }
                unique.remove(fromChar);
                fromChar = str.charAt(windowStart);
                swaps = unique.size() == 1 ? k : k - unique.size();
            }
        }
        return maxLength;
    }

    public static int anotherWay(String str, int k) {
        int windowStart = 0, maxLength = Integer.MIN_VALUE, maxFreq = 0;
        HashMap<Character, Integer> charWiseFreq = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char current = str.charAt(windowEnd);
            charWiseFreq.put(current, charWiseFreq.getOrDefault(current, 0) + 1);
            maxFreq = Math.max(maxFreq, charWiseFreq.get(current));

            int windowSize = windowEnd - windowStart + 1;
            while (windowSize - maxFreq > k) {
                char fromChar = str.charAt(windowStart);
                charWiseFreq.put(fromChar, charWiseFreq.get(fromChar) - 1);
                windowStart++;
                windowSize = windowEnd - windowStart + 1;
            }
            maxLength = Math.max(maxLength, windowSize);
        }
        return maxLength;
    }
}
