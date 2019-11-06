package com.leetcode.offer.code;

/**
 * @author duson
 * 给一个 非空 字符串 s 和一个单词缩写 abbr ，判断这个缩写是否可以是给定单词的缩写。
 * <p>
 * 字符串 "word" 的所有有效缩写为：
 * <p>
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 注意单词 "word" 的所有有效缩写仅包含以上这些。任何其他的字符串都不是 "word" 的有效缩写。
 * <p>
 * 注意:
 * 假设字符串 s 仅包含小写字母且 abbr 只包含小写字母和数字。
 * <p>
 * 示例 1:
 * <p>
 * 给定 s = "internationalization", abbr = "i12iz4n":
 * <p>
 * 函数返回 true.
 *  
 * <p>
 * 示例 2:
 * <p>
 * 给定 s = "apple", abbr = "a2e":
 * <p>
 * 函数返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-word-abbreviation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        int j = 0;
        int i = 0;
        int len1 = word.length();
        int len2 = abbr.length();
        while (i < len1 && j < len2) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else if (abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                if (abbr.charAt(j) == '0') {
                    return false;
                }
                int num = 0;
                while (j < len2 && abbr.charAt(j) < 65) {
                    num = num * 10 + (abbr.charAt(j++) - '0');
                }
                i += num;
            } else {
                return false;
            }
        }
        return i == len1 && j == len2;
    }
}
