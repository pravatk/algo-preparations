package my.preparations.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    protected Map<Character, TrieNode> children;
    protected boolean isWordEnd = false;
    protected char value;

    public TrieNode(char ch) {
        this.value = ch;
        this.children = new HashMap<>();
        this.isWordEnd = false;
    }

    public char getValue() {
        return this.value;
    }

    public void setWordEnd(boolean isWordEnd) {
        this.isWordEnd = isWordEnd;
    }

    public boolean isWordEnd() {
        return this.isWordEnd;
    }

    public TrieNode getChild(char ch) {
        return children.get(ch);
    }

    public void setChild(char ch, TrieNode node) {
        this.children.put(ch, node);
    }

    public Map<Character, TrieNode> getChildren() {
        return Collections.unmodifiableMap(this.children);
    }
}
