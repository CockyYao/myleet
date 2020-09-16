package com.atsyc.tire;

/**
 * 针对于我当前的这个节点来说的，所有的put ,get 这些个方法
 */
public class TrieNode {

    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    // 插入一个word
    public void insert(String word) {
        TrieNode node = this;
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if (node.links[c - 'a'] == null) {
                node.links[c - 'a'] = new TrieNode();
            }
            node = node.links[c - 'a'];
        }
    }

    // 前缀匹配
    public boolean startsWith(String word) {
        char[] arr = word.toCharArray();
        TrieNode node = this;
        for (char c : arr) {
            if (node.links[c - 'a'] == null) {
                return false;
            }
            node = node.links[c - 'a'];
        }
        return true;
    }

    // 查找
    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode search(String word) {
        TrieNode node = this;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }



    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }


    public static void main(String[] args) {
        TrieNode trie = new TrieNode();
        trie.insert("apple");
        System.out.println(trie.search("apple"));// 返回 true
        System.out.println(trie.search("app"));// 返回 false
        System.out.println(trie.startsWith("app")); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true
    }



}
