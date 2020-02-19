package com.leetcode.offer.code;

/**
 * @author duson
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 * 通过次数1,516提交次数2,034
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsUnique2 {

    public boolean isUnique(String astr) {
        int[] cnt = new int[255];
        char[] ch = astr.toCharArray();
        for (char c : ch) {
            cnt[(int) c]++;
            if (cnt[(int) c] > 1) {
                return false;
            }
        }
        return true;
    }
}
