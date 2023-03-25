package my.preparations.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * <p>
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 * Example 3:
 * <p>
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 */
public class SubstringWithConcatOfAllStrings {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Long> wordCount = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i += words[0].length()) {
            slide(i, s, wordCount, result, words[0].length());
        }
        return result;
    }

    private void slide(int start, String s, Map<String, Long> wordCount, List<Integer> res, int wordLen) {
        Map<String, Long> wordsFound = new HashMap<>();
        for (int i = start; i < s.length() - wordLen; i += wordLen) {
            String curr = s.substring(start, start + wordLen);
            if (wordCount.containsKey(curr)) {
                wordsFound.put(curr, wordsFound.getOrDefault(curr, 0L) + 1);
            } else {
                wordsFound.clear();
                start = i + wordLen;
            }
        }
    }


    public static void main(String[] args) {
        SubstringWithConcatOfAllStrings s = new SubstringWithConcatOfAllStrings();
//        System.out.println(s.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
//        System.out.println(s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        System.out.println(s.findSubstring("barfoofoobarthefoobarman", new String[]{"foo", "bar", "the"}));

    }

}
