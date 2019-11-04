package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："leetcodeisacommunityforcoders"
 * 输出："ltcdscmmntyfrcdrs"
 * 示例 2：
 * <p>
 * 输入："aeiou"
 * 输出：""
 *  
 * <p>
 * 提示：
 * <p>
 * S 仅由小写英文字母组成。
 * 1 <= S.length <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-vowels-from-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveVowels {

    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
