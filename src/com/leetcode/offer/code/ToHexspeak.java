package com.leetcode.offer.code;

/**
 * @author duson
 * <p>
 * 你有一个十进制数字，请按照此规则将它变成「十六进制魔术数字」：首先将它变成字母大写的十六进制字符串，然后将所有的数字 0 变成字母 O ，将数字 1  变成字母 I 。
 * <p>
 * 如果一个数字在转换后只包含 {"A", "B", "C", "D", "E", "F", "I", "O"} ，那么我们就认为这个转换是有效的。
 * <p>
 * 给你一个字符串 num ，它表示一个十进制数 N，如果它的十六进制魔术数字转换是有效的，请返回转换后的结果，否则返回 "ERROR" 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "257"
 * 输出："IOI"
 * 解释：257 的十六进制表示是 101 。
 * 示例 2：
 * <p>
 * 输入：num = "3"
 * 输出："ERROR"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^12
 * 给定字符串不会有前导 0 。
 * 结果中的所有字母都应该是大写字母。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hexspeak
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ToHexspeak {

    public String toHexspeak(String num) {
        long value = Long.parseLong(num), modValue;
        String ret = "";

        while (value != 0) {
            modValue = value & 15;
            if (modValue == 0) {
                ret = "O" + ret;
            } else if (modValue == 1) {
                ret = "I" + ret;
            } else if (modValue >= 10) {
                ret = (char) ('A' + modValue - 10) + ret;
            } else {
                return "ERROR";
            }
            value >>= 4;
        }
        return ret;
    }
}
