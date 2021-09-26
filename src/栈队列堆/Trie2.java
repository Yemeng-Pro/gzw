package 栈队列堆;

import java.util.HashMap;
import java.util.Map;

public class Trie2 {
    private class TrieNode {
        char data;
        boolean isEnding = false;
        Map<Character, TrieNode> children = new HashMap<>();
        public TrieNode(char data) {
            this.data = data;
        }
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie2() {
        root = new TrieNode('/');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!p.children.containsKey(c)) {
                p.children.put(c, new TrieNode(c));
            }
            p = p.children.get(c);
        }
        p.isEnding = true;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (!p.children.containsKey(c)) {
                return false;
            }
            p = p.children.get(c);
        }
        return p.isEnding;
    }
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); ++i) {
            char c = prefix.charAt(i);
            if (!p.children.containsKey(c)) {
                return false;
            }
            p = p.children.get(c);
        }
        return true;
    }
}
