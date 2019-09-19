package com.leetcode.offer.day32;

/**
 * @author duson
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * <p>
 * 示例:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 * <p>
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordDictionary {

    private static class TrieNode {
        boolean exist;
        TrieNode[] nodes;

        public TrieNode() {
            exist = false;
            nodes = new TrieNode[26];
        }

        TrieNode put(char c) {
            if (nodes[c - 'a'] == null) {
                nodes[c - 'a'] = new TrieNode();
            }
            return nodes[c - 'a'];
        }

        TrieNode get(char c) {
            return nodes[c - 'a'];
        }
    }

    private TrieNode root;


    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.put(c);
        }
        curr.exist = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode node = root;
        return search(word, 0, node);
    }

    private boolean search(String word, int pos, TrieNode node) {
        if (pos == word.length()) {
            return node.exist;
        }
        if (word.charAt(pos) == '.') {
            for (TrieNode tmp : node.nodes) {
                if (tmp != null && search(word, pos + 1, tmp)) {
                    return true;
                }
            }
        } else {
            if (node.get(word.charAt(pos)) == null) {
                return false;
            }
            return search(word, pos + 1, node.get(word.charAt(pos)));
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("d.."));

    }
}
