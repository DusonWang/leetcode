package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
 * <p>
 * 在此过程之后，我们得到一些数组 B。
 * <p>
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1], K = 0
 * 输出：0
 * 解释：B = [1]
 * 示例 2：
 * <p>
 * 输入：A = [0,10], K = 2
 * 输出：6
 * 解释：B = [2,8]
 * 示例 3：
 * <p>
 * 输入：A = [1,3,6], K = 3
 * 输出：3
 * 解释：B = [4,6,3]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-range-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestRangeII {

    public int smallestRangeII(int[] a, int k) {
        int n = a.length;
        Arrays.sort(a);
        int ans = a[n - 1] - a[0];
        for (int i = 0; i < a.length - 1; ++i) {
            int a1 = a[i], b = a[i + 1];
            int high = Math.max(a[n - 1] - k, a1 + k);
            int low = Math.min(a[0] + k, b - k);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }
}
