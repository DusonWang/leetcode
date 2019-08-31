package com.leetcode.offer.day21;

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

    public String alienOrder(String[] words) {
        final boolean[][] graph = new boolean[26][26];
        final int[] inDegrees = new int[26];
        final boolean[] alphabets = new boolean[26];
        int alphabetsCount = 0;
        char[] word = new char[0];
        for (String s : words) {
            char[] prev = word;
            word = s.toCharArray();
            for (char c : word) {
                if (!alphabets[c - 'a']) {
                    alphabets[c - 'a'] = true;
                    alphabetsCount++;
                }
            }
            for (int j = 0; j < Math.min(prev.length, word.length); j++) {
                if (prev[j] != word[j]) {
                    if (!graph[prev[j] - 'a'][word[j] - 'a']) {
                        graph[prev[j] - 'a'][word[j] - 'a'] = true;
                        inDegrees[word[j] - 'a']++;
                    }
                    break;
                }
            }
        }
        char[] result = new char[alphabetsCount];
        int pos = 0;
        do {
            boolean changed = false;
            for (int i = 0; i < alphabets.length; i++) {
                if (alphabets[i]) {
                    if (inDegrees[i] == 0) {
                        result[pos++] = (char) (i + 'a');
                        changed = true;
                        for (int j = 0; j < graph[i].length; j++) {
                            if (graph[i][j]) {
                                inDegrees[j]--;
                            }
                        }
                        alphabets[i] = false;
                    }
                }
            }
            if (!changed) {
                break;
            }
        } while (pos < result.length);
        return pos == result.length ? new String(result) : "";
    }

    private void find(boolean[] alphabets, boolean[][] graph, int tail, int[] visited, StringBuilder sb) {
        if (!alphabets[tail] || visited[tail] != 0) {
            return;
        }
        visited[tail] = 1;
        for (int i = 0; i < graph[tail].length; i++) {
            if (graph[tail][i] && alphabets[i] && visited[i] == 1) {
                return;
            }
            if (graph[tail][i] && alphabets[i] && visited[i] == 0) {
                find(alphabets, graph, i, visited, sb);
            }
        }
        visited[tail] = 2;
        sb.append((char) (tail + 'a'));
    }

    public String alienOrder2(String[] words) {
        char[][] ws = new char[words.length][];
        boolean[] alphabets = new boolean[26];
        int letters = 0;
        for (int i = 0; i < words.length; i++) {
            ws[i] = words[i].toCharArray();
            for (int j = 0; j < ws[i].length; j++) {
                if (!alphabets[ws[i][j] - 'a']) {
                    alphabets[ws[i][j] - 'a'] = true;
                    letters++;
                }
            }
        }
        boolean[][] graph = new boolean[26][26];
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                if (ws[i + 1][j] != ws[i][j]) {
                    graph[ws[i + 1][j] - 'a'][ws[i][j] - 'a'] = true;
                    break;
                }
            }
        }
        int[] visited = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabets.length; i++) {
            if (!alphabets[i] || visited[i] != 0) {
                continue;
            }
            find(alphabets, graph, i, visited, sb);
        }
        if (sb.length() == letters) {
            return sb.toString();
        } else {
            return "";
        }
    }
}
