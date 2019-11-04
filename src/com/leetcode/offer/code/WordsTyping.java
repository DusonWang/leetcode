package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个 rows x cols 的屏幕和一个用 非空 的单词列表组成的句子，请你计算出给定句子可以在屏幕上完整显示的次数。
 * <p>
 * 注意：
 * <p>
 * 一个单词不能拆分成两行。
 * 单词在句子中的顺序必须保持不变。
 * 在一行中 的两个连续单词必须用一个空格符分隔。
 * 句子中的单词总量不会超过 100。
 * 每个单词的长度大于 0 且不会超过 10。
 * 1 ≤ rows, cols ≤ 20,000.
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * rows = 2, cols = 8, 句子 sentence = ["hello", "world"]
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * hello---
 * world---
 * <p>
 * 字符 '-' 表示屏幕上的一个空白位置。
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * rows = 3, cols = 6, 句子 sentence = ["a", "bcd", "e"]
 * <p>
 * 输出：
 * 2
 * <p>
 * 解释：
 * a-bcd-
 * e-a---
 * bcd-e-
 * <p>
 * 字符 '-' 表示屏幕上的一个空白位置。
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入：
 * rows = 4, cols = 5, 句子 sentence = ["I", "had", "apple", "pie"]
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * I-had
 * apple
 * pie-I
 * had--
 * <p>
 * 字符 '-' 表示屏幕上的一个空白位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sentence-screen-fitting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordsTyping {

    public int wordsTyping2(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, len = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % len) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % len) != ' ') {
                    start--;
                }
            }
        }
        return start / len;
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int n = sentence.length;
        int ans = 0;
        int curr;
        int idx = 0;
        int l = 0;
        for (String s : sentence) {
            l += s.length() + 1;
        }
        for (int i = 0; i < rows; ++i) {
            curr = cols;
            while (curr > 0 && curr >= sentence[idx].length()) {
                curr = curr - sentence[idx].length();
                idx++;
                if (curr > 0) {
                    curr--;
                }
                if (idx == n) {
                    ans += curr / l + 1;
                    curr = curr % l;
                    idx = 0;
                }
            }
        }
        return ans;
    }
}
