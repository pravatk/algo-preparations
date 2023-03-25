package my.preparations.dp;

import java.util.*;

public class Wordchain {
    private static boolean canWordchainRecursive(String word, String[] wordBank) {
        return canWordchainRecursiveUtil(word, wordBank, "");
    }

    private static boolean canWordchainRecursiveUtil(String word, String[] wordBank, String start) {
        if (wordBank.length == 0) return false;
        if (word.length() == 0 || word.equals(start)) return true;
        if (!word.startsWith(start) || word.length() < start.length()) return false;
        for (String str : wordBank) {
            boolean res = canWordchainRecursiveUtil(word, wordBank, start.concat(str));
            if (res) return true;
        }
        return false;
    }

    private static boolean canConstructRecur(String word, String[] wordBank) {
        if (word.length() == 0) return true;

        for (String aWord : wordBank) {
            if (word.startsWith(aWord)) {
                boolean res = canConstructRecur(word.substring(aWord.length()), wordBank);
                if (res) return true;
            }
        }
        return false;
    }

    private static boolean canConstructMemoized(String word, String[] wordBank) {
        Map<String, Boolean> dp = new HashMap<>();
        return canConstructMemoizedUtil(word, wordBank, dp);
    }

    private static boolean canConstructMemoizedUtil(String word, String[] wordBank, Map<String, Boolean> dp) {
        if (dp.containsKey(word)) return dp.get(word);
        if (word.length() == 0) return true;

        for (String aWord : wordBank) {
            if (word.startsWith(aWord)) {
                boolean res = canConstructMemoizedUtil(word.substring(aWord.length()), wordBank, dp);
                dp.put(word, res);
                if (res) return true;
            }
        }
        dp.put(word, false);
        return dp.get(word);
    }

    private static int countConstructRecur(String word, String[] wordBank) {
        if (word.length() == 0) return 1;
        int res = 0;
        for (String aWord : wordBank) {
            if (word.startsWith(aWord)) {
                res += countConstructRecur(word.substring(aWord.length()), wordBank);
            }
        }
        return res;
    }

    private static int countConstructDP(String word, String[] wordBank) {
        Map<String, Integer> dp = new HashMap<>();
        return countConstructDPUtil(word, wordBank, dp);
    }

    private static int countConstructDPUtil(String word, String[] wordBank, Map<String, Integer> dp) {
        if (dp.containsKey(word)) return dp.get(word);
        if (word.length() == 0) return 1;
        int res = 0;
        for (String aWord : wordBank) {
            if (word.startsWith(aWord)) {
                res += countConstructDPUtil(word.substring(aWord.length()), wordBank, dp);
            }
        }
        dp.put(word, res);
        return res;
    }

    private static List<LinkedList<String>> allConstructRecur(String word, String[] wordBank) {
        List<LinkedList<String>> result = new ArrayList<>();
        if (word.length() == 0) {
            LinkedList<String> comb = new LinkedList<>();
            result.add(comb);
            return result;
        }

        for (String aWord : wordBank) {
            if (word.startsWith(aWord)) {
                List<LinkedList<String>> res = allConstructRecur(word.substring(aWord.length()), wordBank);
                if (res != null) {
                    res.forEach(l -> l.addFirst(aWord));
                    result.addAll(res);
                }
            }
        }
        return result;
    }

    private static List<LinkedList<String>> allConstructDP(String word, String[] wordBank, Map<String, List<LinkedList<String>>> dp) {
        if (dp == null) dp = new HashMap<>();
        if (dp.containsKey(word)) return dp.get(word);

        List<LinkedList<String>> result = null;
        if (word.length() == 0) {
            result = new ArrayList<>();
            LinkedList<String> comb = new LinkedList<>();
            result.add(comb);
            return result;
        }

        for (String aWord : wordBank) {
            if (word.startsWith(aWord)) {
                List<LinkedList<String>> res = allConstructDP(word.substring(aWord.length()), wordBank, dp);
                if (res != null) {
                    if (result == null) result = new ArrayList<>();
                    res.forEach(l -> l.addFirst(aWord));
                    result.addAll(res);
                }
            }
        }

        dp.put(word, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(canWordchainRecursive("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canWordchainRecursive("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "board"}));
        System.out.println(canWordchainRecursive("", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));

        System.out.println(canConstructRecur("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canConstructRecur("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "board"}));
        System.out.println(canConstructRecur("", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
//        System.out.println(canConstructRecur("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee"}));

        System.out.println(canConstructMemoized("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canConstructMemoized("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "board"}));
        System.out.println(canConstructMemoized("", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(canConstructMemoized("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee"}));

        System.out.println(countConstructRecur("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(countConstructRecur("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "board"}));
        System.out.println(countConstructRecur("", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(countConstructRecur("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
//        System.out.println(countConstructRecur("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "ef"}));

        System.out.println(countConstructDP("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(countConstructDP("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "board"}));
        System.out.println(countConstructDP("", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(countConstructDP("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        System.out.println(countConstructDP("eeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "ef"}));

        System.out.println(allConstructRecur("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(allConstructRecur("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "board"}));
        System.out.println(allConstructRecur("", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));
        System.out.println(allConstructRecur("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        System.out.println(allConstructRecur("eeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "ef"}));

        System.out.println(allConstructDP("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, null));
        System.out.println(allConstructDP("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "board"}, null));
        System.out.println(allConstructDP("", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, null));
        System.out.println(allConstructDP("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, null));
        System.out.println(allConstructDP("eeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "ef"}, null));
    }
}
