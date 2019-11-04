package com.leetcode.offer.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trie {

//    private static class TrieNode {
//        boolean isExist;
//        TrieNode[] nodes;
//        TrieNode() {
//            isExist = false;
//            nodes = new TrieNode[26];
//        }
//        TrieNode put(char c) {
//            if (nodes[c-'a'] == null) {
//                nodes[c-'a'] = new TrieNode();
//            }
//            return nodes[c-'a'];
//        }
//        TrieNode get(char c) {
//            return nodes[c-'a'];
//        }
//    }
//
//    private TrieNode root;
//
//
//    /** Initialize your data structure here. */
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        TrieNode curr = root;
//        for (char c : word.toCharArray()) {
//            curr = curr.put(c);
//        }
//        curr.isExist = true;
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        TrieNode curr = root;
//        for (char c : word.toCharArray()) {
//            curr = curr.get(c);
//            if (curr == null) {
//                return false;
//            }
//        }
//        return curr.isExist;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        TrieNode curr = root;
//        for (char c : prefix.toCharArray()) {
//            curr = curr.get(c);
//            if (curr == null) {
//                return false;
//            }
//        }
//        return true;
//    }

    private Node node;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        node = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String words) {
        insert(node, words);
    }

    private void insert(Node node, String words) {
        if (words == null || words.length() == 0) {
            return;
        }
        char[] chars = words.toLowerCase().toCharArray();
        for (int i = 0, length = chars.length; i < length; i++) {
            if (!node.getChildMap().containsKey(chars[i])) {
                node.getChildMap().put(chars[i], new Node());
            }
            if (i == length - 1) {
                node.getChildMap().get(chars[i]).setLeaf(true);
            }
            node = node.getChildMap().get(chars[i]);
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return search(node, word);
    }

    private boolean search(Node node, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] chars = word.toLowerCase().toCharArray();
        for (char aChar : chars) {
            if (!node.getChildMap().containsKey(aChar) || node.getChildMap().get(aChar) == null) {
                return false;
            }
            node = node.getChildMap().get(aChar);
        }
        return node.leaf;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toLowerCase().toCharArray();
        Node root = node;
        for (char aChar : chars) {
            if (!root.getChildMap().containsKey(aChar)) {
                return false;
            }
            root = root.getChildMap().get(aChar);
        }
        return preTraversal(root, prefix);
    }

    private boolean preTraversal(Node root, String preStr) {
        if (root != null) {
            if (root.isLeaf()) {
                return true;
            }
            for (Map.Entry<Character, Node> chr : root.getChildMap().entrySet()) {
                return preTraversal(chr.getValue(), preStr + chr.getKey());
            }
        }
        return false;
    }

    public static class Node {

        private boolean leaf;

        private Map<Character, Node> childMap;

        public Node() {
            setLeaf(false);
            setChildMap(new HashMap<>());
        }

        public boolean isLeaf() {
            return leaf;
        }

        public void setLeaf(boolean leaf) {
            this.leaf = leaf;
        }

        public Map<Character, Node> getChildMap() {
            return childMap;
        }

        public void setChildMap(Map<Character, Node> childMap) {
            this.childMap = childMap;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}
