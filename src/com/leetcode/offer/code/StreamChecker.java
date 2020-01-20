package com.leetcode.offer.code;

/**
 * @author duson
 * 按下述要求实现 StreamChecker 类：
 * <p>
 * StreamChecker(words)：构造函数，用给定的字词初始化数据结构。
 * query(letter)：如果存在某些 k >= 1，可以用查询的最后 k个字符（按从旧到新顺序，包括刚刚查询的字母）拼写出给定字词表中的某一字词时，返回 true。否则，返回 false。
 *  
 * <p>
 * 示例：
 * <p>
 * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // 初始化字典
 * streamChecker.query('a');          // 返回 false
 * streamChecker.query('b');          // 返回 false
 * streamChecker.query('c');          // 返回 false
 * streamChecker.query('d');          // 返回 true，因为 'cd' 在字词表中
 * streamChecker.query('e');          // 返回 false
 * streamChecker.query('f');          // 返回 true，因为 'f' 在字词表中
 * streamChecker.query('g');          // 返回 false
 * streamChecker.query('h');          // 返回 false
 * streamChecker.query('i');          // 返回 false
 * streamChecker.query('j');          // 返回 false
 * streamChecker.query('k');          // 返回 false
 * streamChecker.query('l');          // 返回 true，因为 'kl' 在字词表中。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 2000
 * 字词只包含小写英文字母。
 * 待查项只包含小写英文字母。
 * 待查项最多 40000 个。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/stream-of-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StreamChecker {

    static class TrieNode {
        boolean isWord;
        TrieNode[] next = new TrieNode[26];
    }

    private TrieNode root = new TrieNode();
    private StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        createTrie(words);
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
            char c = sb.charAt(i);
            node = node.next[c - 'a'];
            if (node != null && node.isWord) {
                return true;
            }
        }
        return false;
    }

    private void createTrie(String[] words) {
        for (String s : words) {
            TrieNode node = root;
            int len = s.length();
            for (int i = len - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isWord = true;
        }
    }
}
