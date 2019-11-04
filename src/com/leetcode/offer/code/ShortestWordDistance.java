package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
 * <p>
 * word1 和 word2 是有可能相同的，并且它们将分别表示为列表中两个独立的单词。
 * <p>
 * 示例:
 * 假设 words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * 输入: word1 = “makes”, word2 = “coding”
 * 输出: 1
 * 输入: word1 = "makes", word2 = "makes"
 * 输出: 3
 * 注意:
 * 你可以假设 word1 和 word2 都在列表里。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-word-distance-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestWordDistance {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        boolean s = word1.equals(word2);
        int i = -1, j = -1;
        final int len = words.length;
        int min = len;
        int count = 0;
        for (int m = 0; m < len; m++) {
            if (s) {
                if (words[m].equals(word1)) {
                    if (count % 2 == 0) {
                        i = m;
                    } else {
                        j = m;
                    }
                    count++;
                }
            } else {
                if (words[m].equals(word1)) {
                    i = m;
                } else if (words[m].equals(word2)) {
                    j = m;
                }
            }
            if (i != -1 && j != -1) {
                min = Math.min(min, Math.abs(i - j));
            }
        }
        return min;
    }
}
