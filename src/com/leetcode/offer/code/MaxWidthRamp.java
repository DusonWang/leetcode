package com.leetcode.offer.code;

import java.util.Stack;

/**
 * @author duson
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * <p>
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 * <p>
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-ramp
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxWidthRamp {

    public int maxWidthRamp(int[] a) {
        Stack<Integer> s = new Stack<>();
        int res = 0, n = a.length;
        for (int i = 0; i < n; ++i) {
            if (s.empty() || a[s.peek()] > a[i]) {
                s.add(i);
            }
        }
        for (int i = n - 1; i > res; --i) {
            while (!s.empty() && a[s.peek()] <= a[i]) {
                res = Math.max(res, i - s.pop());
            }
        }
        return res;
    }
}
