package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 * <p>
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：5
 * 解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：10
 * 解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
 * 示例 3：
 * <p>
 * 输入：n = 5
 * 输出：68
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 * 10^4
 * 通过次数1,893提交次数3,579
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-vowels-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountVowelPermutation {

    public int countVowelPermutation(int n) {
        int mod = 1_000_000_007;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        long aa = 1, ee = 1, ii = 1, oo = 1, uu = 1;
        for(int k = 0; k < n - 1; k++) {
            a = ee;
            e = (aa + ii) % mod;
            i = (aa + ee + oo + uu) % mod;
            o = (ii + uu) % mod;
            u = aa;
            aa = a;
            ee = e;
            ii = i;
            oo = o;
            uu = u;
        }
        long ans = ((a + e) % mod + (i + o) % mod + (u % mod))% mod;
        return (int)ans % mod;
    }
}
