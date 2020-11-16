package code.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author duson
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * <p>
 * 提示:
 * <p>
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindWords {

    private final int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0 || board == null || board.length == 0) {
            return list;
        }
        for (String word : words) {
            if (findWord(word, board)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean findWord(String word, char[][] board) {
        final int row = board.length;
        final int col = board[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(word, 0, flag, i, j, board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(String word, int index, boolean[][] flag, int i, int j, char[][] board) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || flag[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        flag[i][j] = true;
        for (int[] d : dir) {
            if (dfs(word, index + 1, flag, i + d[0], j + d[1], board)) {
                return true;
            }
        }
        flag[i][j] = false;
        return false;
    }

    public List<String> findWords2(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0 || board == null || board.length == 0) {
            return list;
        }
        TrieNode root = new TrieNode();
        Set<String> result = new HashSet<>();
        for (String word : words) {
            add(root, word);
        }

        final int row = board.length;
        final int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                find(board, i, j, root, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void find(char[][] board, int row, int column, TrieNode node, Set<String> result) {
        if (row < 0 || row >= board.length || column < 0 || column >= board[row].length || board[row][column] == '#') {
            return;
        }

        TrieNode current = node.child[board[row][column] - 'a'];
        if (current != null) {
            if (current.word != null) {
                result.add(current.word);
            }
            char ch = board[row][column];
            board[row][column] = '#';
            find(board, row - 1, column, current, result);
            find(board, row + 1, column, current, result);
            find(board, row, column - 1, current, result);
            find(board, row, column + 1, current, result);
            board[row][column] = ch;
        }
    }

    private void add(TrieNode root, String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            if (node.child[c - 'a'] == null) {
                node.child[c - 'a'] = new TrieNode();
            }
            node = node.child[c - 'a'];
        }
        node.word = word;
    }

    static class TrieNode {
        String word;
        TrieNode[] child;

        public TrieNode() {
            child = new TrieNode[26];
        }
    }

    public static void main(String[] args) {
        FindWords findWords = new FindWords();
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(findWords.findWords2(board, words));
    }
}
