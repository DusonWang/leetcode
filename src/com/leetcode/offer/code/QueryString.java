package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个二进制字符串 S（一个仅由若干 '0' 和 '1' 构成的字符串）和一个正整数 N，如果对于从 1 到 N 的每个整数 X，其二进制表示都是 S 的子串，就返回 true，否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "0110", N = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：S = "0110", N = 4
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 1000
 * 1 <= N <= 10^9
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-string-with-substrings-representing-1-to-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class QueryString {

    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
