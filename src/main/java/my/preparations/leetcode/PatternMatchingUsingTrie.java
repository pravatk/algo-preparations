package my.preparations.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PatternMatchingUsingTrie {
    public List<Integer> match(String text, String pattern) {
        Trie t = new Trie();
        for (int i = 0; i < text.length(); i++) {
            t.insert(text.substring(i));
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        PatternMatchingUsingTrie p = new PatternMatchingUsingTrie();
        System.out.println(p.match("geeksforgeeks", "ee"));
    }

    class SuffixTree {
        private final SuffixNode root;

        public SuffixTree() {
            this.root = new SuffixNode((char) 0);
        }

        public void insert(String word) {

        }
    }

    class SuffixNode extends TrieNode {
        private LinkedList<Integer> indexes;

        public SuffixNode(char ch) {
            super(ch);
            this.indexes = new LinkedList<>();
        }
    }
}
