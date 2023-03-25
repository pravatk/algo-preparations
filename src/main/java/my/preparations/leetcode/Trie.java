package my.preparations.leetcode;

public class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode((char) 0);
    }

    public void insert(String word) {
        TrieNode prevNode = root;
        for (int i = 0; i < word.length(); i++) {
            final char curr = word.charAt(i);
            if (prevNode.getChild(curr) == null) {
                TrieNode n = new TrieNode(curr);
                prevNode.setChild(curr, n);
                prevNode = n;
            } else {
                prevNode = prevNode.getChild(curr);
            }
        }
        prevNode.setWordEnd(true);
    }

    public String getLongestPrefix(String word) {
        TrieNode prev = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (prev.getChild(ch) != null && prev.getChildren().size() == 1) {
                sb.append(ch);
                prev = prev.getChild(ch);
            }
        }
        return sb.toString();
    }
}
