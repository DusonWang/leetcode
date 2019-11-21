package com.leetcode.offer.code;

import java.util.List;

/**
 * @author duson
 *
 * 给你一个单词序列，判断其是否形成了一个有效的单词方块。
 *
 * 有效的单词方块是指此由单词序列组成的文字方块的 第 k 行 和 第 k 列 (0 ≤ k < max(行数, 列数)) 所显示的字符串完全相同。
 *
 * 注意：
 *
 * 给定的单词数大于等于 1 且不超过 500。
 * 单词长度大于等于 1 且不超过 500。
 * 每个单词只包含小写英文字母 a-z。
 *  
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   "abcd",
 *   "bnrt",
 *   "crmy",
 *   "dtye"
 * ]
 *
 * 输出：
 * true
 *
 * 解释：
 * 第 1 行和第 1 列都是 "abcd"。
 * 第 2 行和第 2 列都是 "bnrt"。
 * 第 3 行和第 3 列都是 "crmy"。
 * 第 4 行和第 4 列都是 "dtye"。
 *
 * 因此，这是一个有效的单词方块。
 *  
 *
 * 示例 2：
 *
 * 输入：
 * [
 *   "abcd",
 *   "bnrt",
 *   "crm",
 *   "dt"
 * ]
 *
 * 输出：
 * true
 *
 * 解释：
 * 第 1 行和第 1 列都是 "abcd"。
 * 第 2 行和第 2 列都是 "bnrt"。
 * 第 3 行和第 3 列都是 "crm"。
 * 第 4 行和第 4 列都是 "dt"。
 *
 * 因此，这是一个有效的单词方块。
 *  
 *
 * 示例 3：
 *
 * 输入：
 * [
 *   "ball",
 *   "area",
 *   "read",
 *   "lady"
 * ]
 *
 * 输出：
 * false
 *
 * 解释：
 * 第 3 行是 "read" ，然而第 3 列是 "lead"。
 *
 * 因此，这 不是 一个有效的单词方块。
 *  
 *
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-word-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidWordSquare {

    public boolean validWordSquare(List<String> words) {
        int maxLen = 0;
        for (String s : words) {
            if (s.length() > maxLen) {
                maxLen = s.length();
            }
        }
        int max = Math.max(maxLen, words.size());
        char[][] format = new char[max][max];
        for (int i = 0; i < words.size(); i++) {
            char[] word = words.get(i).toCharArray();
            System.arraycopy(word, 0, format[i], 0, word.length);
        }
        for (int m = 0; m < format.length; m++) {
            for (int n = 0; n < format[m].length; n++) {
                if (format[m][n] != format[n][m]) {
                    return false;
                }
            }
        }
        return true;
    }

}
