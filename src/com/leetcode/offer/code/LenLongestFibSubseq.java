package com.leetcode.offer.code;

/**
 * @author duson
 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 * <p>
 * n >= 3
 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 * <p>
 * （回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,2,3,4,5,6,7,8]
 * 输出: 5
 * 解释:
 * 最长的斐波那契式子序列为：[1,2,3,5,8] 。
 * 示例 2：
 * <p>
 * 输入: [1,3,7,11,12,14,18]
 * 输出: 3
 * 解释:
 * 最长的斐波那契式子序列有：
 * [1,11,12]，[3,11,14] 以及 [7,11,18] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 1000
 * 1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
 * （对于以 Java，C，C++，以及 C# 的提交，时间限制被减少了 50%）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LenLongestFibSubseq {

    public int lenLongestFibSubseq(int[] a) {
        int n = a.length;
        int[][] dp = new int[n][n];
        int max = 0;
        for(int i = 2; i < n; i++) {
            int l = 0, r = i - 1;
            while(l < r) {
                int sum = a[l] + a[r];
                if(sum > a[i]) {
                    r--;
                } else if(sum < a[i]) {
                    l++;
                } else {
                    dp[r][i] = dp[l][r] == 0 ? 3 : dp[l][r] + 1;
                    max = Math.max(max, dp[r][i]);
                    r--;
                    l++;
                }
            }
        }
        return max;
    }
}
