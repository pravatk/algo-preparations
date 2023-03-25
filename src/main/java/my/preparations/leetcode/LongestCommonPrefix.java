package my.preparations.leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (prefix.length() > 0 && !strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
        Trie t = new Trie();
        t.insert("flower");
        System.out.println(t.getLongestPrefix("flow"));
        t.insert("flow");
        System.out.println(t.getLongestPrefix("flight"));
    }


}
