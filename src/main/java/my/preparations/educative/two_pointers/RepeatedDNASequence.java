package my.preparations.educative.two_pointers;

import java.util.*;

/**
 * Statement
 * Given a string s that represents a DNA sequence, and a number k, return all the contiguous sequences (substrings) of
 * length k that occur more than once in the string. The order of the returned subsequences does not matter.
 * If no repeated subsequence is found, the function should return an empty set.
 * <p>
 * Example 1:
 * Str = "CCATATGTATGGATAT"
 * k = 4
 * Output:
 * ["ATAT","TATG"]
 */
public class RepeatedDNASequence {
    public static List<String> findRepeatedSequences(String s, int k) {
        if (s.length() < k)
            return Collections.emptyList();
        Set<String> res = new HashSet<>();
        Set<String> subsequences = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            String currWindow = s.substring(i, i + k);
            if (subsequences.contains(currWindow))
                res.add(currWindow);
            else
                subsequences.add(currWindow);
        }
        return new ArrayList<>(res);
    }
}
