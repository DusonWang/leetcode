package com.leetcode.offer.code;

/**
 * @author duson
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * <p>
 * 返回字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 * <p>
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GcdOfStrings {

    public String gcdOfStrings(String s1, String s2) {
        if (s1.length() < s2.length()) {
            return gcdOfStrings(s2, s1);
        }
        if (s2.length() == 0) {
            return s1;
        }
        if (s1.startsWith(s2)) {
            while (s1.startsWith(s2)) {
                s1 = s1.substring(s2.length());
            }
            return gcdOfStrings(s2, s1);
        } else {
            return "";
        }
    }

}
