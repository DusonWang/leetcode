package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
 * <p>
 * 示例:
 * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
 * <p>
 * 输入: word1 = “coding”, word2 = “practice”
 * 输出: 3
 * 输入: word1 = "makes", word2 = "coding"
 * 输出: 1
 * 注意:
 * 你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-word-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        int i = -1, j = -1;
        int len = words.length;
        int min = len;
        for (int m = 0; m < len; m++) {
            if (words[m].equals(word1)) {
                i = m;
            } else if (words[m].equals(word2)) {
                j = m;
            }
            if (i != -1 && j != -1) {
                min = Math.min(min, Math.abs(i - j));
            }

        }
        return min;
    }
}
