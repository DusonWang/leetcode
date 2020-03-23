package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个字符串 S，计算 S 的不同非空子序列的个数。
 * <p>
 * 因为结果可能很大，所以返回答案模 10^9 + 7.
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："abc"
 * 输出：7
 * 解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
 * 示例 2：
 * <p>
 * 输入："aba"
 * 输出：6
 * 解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
 * 示例 3：
 * <p>
 * 输入："aaa"
 * 输出：3
 * 解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
 *  
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * S 只包含小写字母。
 * 1 <= S.length <= 2000
 *  
 * <p>
 *  
 * <p>
 * 通过次数1,060提交次数2,577
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DistinctSubseqII {

    public int distinctSubseqII(String s) {
        int[] last = new int[26];
        int total = 1;
        for (char c : s.toCharArray()) {
            int temp = (total * 2) - last[c - 'a'];
            last[c - 'a'] = total;
            total = temp < 0 ? temp + 1_000_000_007 : temp % 1_000_000_007;
        }
        return total - 1;
    }
}
