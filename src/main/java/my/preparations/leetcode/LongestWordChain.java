package my.preparations.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWordChain {
    public int longestStrChain(String[] words) {
        if (words.length == 0) return 0;
        else if (words.length == 1) return 1;

        int maxLength = Integer.MIN_VALUE;

        Arrays.sort(words, Comparator.comparingInt(String::length));
        String prevWord = words[words.length - 1];
        for (int i = words.length - 2; i > -1; i--) {
            String curWord = words[i];

        }
        return -1;
    }
}
