package com.leetcode.offer.code;

/**
 * @author duson
 * 现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。
 * <p>
 * 假设，您并不知道其中字母之间的先后顺序。但是，会收到词典中获得一个 不为空的 单词列表。因为是从词典中获得的，所以该单词列表内的单词已经 按这门新语言的字母顺序进行了排序。
 * <p>
 * 您需要根据这个输入的列表，还原出此语言中已知的字母顺序。
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * [
 * "wrt",
 * "wrf",
 * "er",
 * "ett",
 * "rftt"
 * ]
 * <p>
 * 输出: "wertf"
 * 示例 2：
 * <p>
 * 输入:
 * [
 * "z",
 * "x"
 * ]
 * <p>
 * 输出: "zx"
 * 示例 3：
 * <p>
 * 输入:
 * [
 * "z",
 * "x",
 * "z"
 * ]
 * <p>
 * 输出: "" 
 * <p>
 * 解释: 此顺序是非法的，因此返回 ""。
 * 注意：
 * <p>
 * 你可以默认输入的全部都是小写字母
 * 假如，a 的字母排列顺序优先于 b，那么在给定的词典当中 a 定先出现在 b 前面
 * 若给定的顺序是不合法的，则返回空字符串即可
 * 若存在多种可能的合法字母顺序，请返回其中任意一种顺序即可
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/alien-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AlienOrder {

    private final int n = 26;

    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[n][n];
        int[] visited = new int[n];
        buildGraph(words, adj, visited);
        if (illegal) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i] == '0') {
                if (!dfs(adj, visited, sb, i)) {
                    return "";
                }
            }
        }
        return sb.reverse().toString();
    }

    private boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = '1';
        for (int j = 0; j < n; j++) {
            if (adj[i][j]) {
                if (visited[j] == '1') {
                    return false;
                }
                if (visited[j] == '0') {
                    if (!dfs(adj, visited, sb, j)) {
                        return false;
                    }
                }
            }
        }
        visited[i] = '2';
        sb.append((char) (i + 'a'));
        return true;
    }

    boolean illegal = false;

    private void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                visited[c - 'a'] = '0';
            }
            if (i > 0) {
                String s1 = words[i - 1];
                String s2 = words[i];

                int len = Math.min(s1.length(), s2.length());
                int same = 0;

                for (int j = 0; j < len; j++) {
                    if (s1.charAt(j) != s2.charAt(j)) {
                        adj[s1.charAt(j) - 'a'][s2.charAt(j) - 'a'] = true;
                        break;
                    }
                    same++;
                }

                for (int j = len; j < s1.length(); j++) {
                    if (same == len && same > 0) {
                        illegal = true;
                        return;
                    }
                }
            }
        }
    }
}
