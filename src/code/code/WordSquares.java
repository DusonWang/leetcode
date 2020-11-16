package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author duson给定一个单词集合 （没有重复），找出其中所有的 单词方块 。
 * <p>
 * 一个单词序列形成了一个有效的单词方块的意思是指从第 k 行和第 k 列 (0 ≤ k < max(行数, 列数)) 来看都是相同的字符串。
 * <p>
 * 例如，单词序列 ["ball","area","lead","lady"] 形成了一个单词方块，因为每个单词从水平方向看和从竖直方向看都是相同的。
 * <p>
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 * 注意：
 * <p>
 * 单词个数大于等于 1 且不超过 500。
 * 所有的单词长度都相同。
 * 单词长度大于等于 1 且不超过 5。
 * 每个单词只包含小写英文字母 a-z。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["area","lead","wall","lady","ball"]
 * <p>
 * 输出：
 * [
 * [ "wall",
 * "area",
 * "lead",
 * "lady"
 * ],
 * [ "ball",
 * "area",
 * "lead",
 * "lady"
 * ]
 * ]
 * <p>
 * 解释：
 * 输出包含两个单词方块，输出的顺序不重要，只需要保证每个单词方块内的单词顺序正确即可。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * ["abat","baba","atan","atal"]
 * <p>
 * 输出：
 * [
 * [ "baba",
 * "abat",
 * "baba",
 * "atan"
 * ],
 * [ "baba",
 * "abat",
 * "baba",
 * "atal"
 * ]
 * ]
 * <p>
 * 解释：
 * 输出包含两个单词方块，输出的顺序不重要，只需要保证每个单词方块内的单词顺序正确即可。
 *  
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordSquares {

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0 || words[0].length() == 0) {
            return res;
        }
        Trie trie = new Trie();
        int n = words[0].length();
        for (String w : words) {
            trie.insert(w);
        }
        getSquares(trie.root, trie.root, 0, 0, n, new int[n][n], new String[n], res);
        return res;
    }

    private void getSquares(TrieNode root, TrieNode cur, int i, int j,
                            int n, int[][] board, String[] filled,
                            List<List<String>> res) {
        if (i == n) {
            res.add(new ArrayList<>(Arrays.asList(filled)));
            return;
        }

        if (j == n) {
            filled[i] = cur.word;
            getSquares(root, root, i + 1, 0, n, board, filled, res);
            return;
        }

        if (j < i) {
            TrieNode child = cur.children[board[i][j]];
            if (child != null) {
                getSquares(root, child, i, j + 1, n, board, filled, res);
            }
            return;
        }

        for (int c = 0; c < 26; c++) {
            if (cur.children[c] != null) {
                board[j][i] = board[i][j] = c;
                getSquares(root, cur.children[c], i, j + 1, n, board, filled, res);
            }

        }
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public void insert(String w) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = w;
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        public String word = null;
    }
}
