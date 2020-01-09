package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 * <p>
 * 注意:
 * <p>
 * 输入只包含小写英文字母。
 * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
 * 输入字符串的长度小于 50,000。
 * 示例 1:
 * <p>
 * 输入: "owoztneoer"
 * <p>
 * 输出: "012" (zeroonetwo)
 * 示例 2:
 * <p>
 * 输入: "fviefuro"
 * <p>
 * 输出: "45" (fourfive)
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OriginalDigits {

    public String originalDigits(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'z') {
                count[0]++;
            }
            if (c == 'w') {
                count[2]++;
            }
            if (c == 'x') {
                count[6]++;
            }
            if (c == 's') {
                count[7]++;
            }
            if (c == 'g') {
                count[8]++;
            }
            if (c == 'u') {
                count[4]++;
            }
            if (c == 'f') {
                count[5]++;
            }
            if (c == 'h') {
                count[3]++;
            }
            if (c == 'i') {
                count[9]++;
            }
            if (c == 'o') {
                count[1]++;
            }
        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
