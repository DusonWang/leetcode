package com.leetcode.offer.day51;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个字符串 S，找出 S 中不同的非空回文子序列个数，并返回该数字与 10^9 + 7 的模。
 * <p>
 * 通过从 S 中删除 0 个或多个字符来获得子字符序列。
 * <p>
 * 如果一个字符序列与它反转后的字符序列一致，那么它是回文字符序列。
 * <p>
 * 如果对于某个  i，A_i != B_i，那么 A_1, A_2, ... 和 B_1, B_2, ... 这两个字符序列是不同的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * S = 'bccb'
 * 输出：6
 * 解释：
 * 6 个不同的非空回文子字符序列分别为：'b', 'c', 'bb', 'cc', 'bcb', 'bccb'。
 * 注意：'bcb' 虽然出现两次但仅计数一次。
 * 示例 2：
 * <p>
 * 输入：
 * S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
 * 输出：104860361
 * 解释：
 * 共有 3104860382 个不同的非空回文子字符序列，对 10^9 + 7 取模为 104860361。
 *  
 * <p>
 * 提示：
 * <p>
 * 字符串 S 的长度将在[1, 1000]范围内。
 * 每个字符 S[i] 将会是集合 {'a', 'b', 'c', 'd'} 中的某一个。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-different-palindromic-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountPalindromicSubsequences {

    private static final int MOD = 1000000007;

    public int countPalindromicSubsequences(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] counts = new int[n];
        Arrays.fill(counts, 1);

        for (int i = 0; i < n; i++) {
            long sum = 0;
            int[] tmp = new int[26];
            for (int j = i - 1; j >= 0; j--) {
                int count = counts[j];
                if (chars[i] == chars[j]) {
                    counts[j] = (int) ((sum + 2) % MOD);
                }
                sum += count - tmp[chars[j] - 'a'];
                tmp[chars[j] - 'a'] = count;
            }
        }
        int[] nums = new int[26];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[chars[i] - 'a'] == 0) {
                nums[chars[i] - 'a'] = counts[i];
                sum += counts[i];
            }
        }
        return (int) (sum % MOD);
    }
}
