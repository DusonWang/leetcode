package com.leetcode.offer.code;

/**
 * @author duson
 * 给出非负整数数组 A ，返回两个非重叠（连续）子数组中元素的最大和，子数组的长度分别为 L 和 M。（这里需要澄清的是，长为 L 的子数组可以出现在长为 M 的子数组之前或之后。）
 * <p>
 * 从形式上看，返回最大的 V，而 V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) 并满足下列条件之一：
 * <p>
 *  
 * <p>
 * 0 <= i < i + L - 1 < j < j + M - 1 < A.length, 或
 * 0 <= j < j + M - 1 < i < i + L - 1 < A.length.
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
 * 输出：20
 * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 * 示例 2：
 * <p>
 * 输入：A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
 * 输出：29
 * 解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
 * 输出：31
 * 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
 *  
 * <p>
 * 提示：
 * <p>
 * L >= 1
 * M >= 1
 * L + M <= A.length <= 1000
 * 0 <= A[i] <= 1000
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-sum-of-two-non-overlapping-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSumTwoNoOverlap {

    public int maxSumTwoNoOverlap(int[] a, int l, int m) {
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i - 1] + a[i];
        }
        int res = a[l + m - 1], maxL = a[l - 1], maxM = a[m - 1];
        for (int i = l + m; i < a.length; i++) {
            maxL = Math.max(maxL, a[i - m] - a[i - m - l]);
            maxM = Math.max(maxM, a[i - l] - a[i - l - m]);
            res = Math.max(res, Math.max(maxL + (a[i] - a[i - m]), maxM + (a[i] - a[i - l])));
        }
        return res;
    }
}
