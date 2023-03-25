package my.preparations.educative.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat".
 */
public class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        int start = 0, end = 0, wordLen = words[0].length(), totalMatch = 0;
        while (end < str.length()) {
            String current = str.substring(end, end + wordLen);
            if (wordMap.containsKey(current)) {
                wordMap.put(current, wordMap.get(current) - 1);
                if (wordMap.get(current) >= 0)
                    totalMatch++;
            }

            if (totalMatch == words.length) {
                resultIndices.add(start);
            }

            while (end + wordLen - start + 1 >= words.length * wordLen) {
                String left = str.substring(start, start + wordLen);
                if (wordMap.containsKey(left)) {
                    if (wordMap.get(left) == 0)
                        totalMatch--;
                    wordMap.put(left, wordMap.get(left) + 1);
                }
                start += wordLen;
            }
            end += wordLen;
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
        System.out.println(findWordConcatenation("catcatfoxfox", new String[]{"cat", "fox"}));
        System.out.println(findWordConcatenation("catfoxfox", new String[]{"cat", "fox", "fox"}));
    }
}
