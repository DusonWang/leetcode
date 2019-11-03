package com.leetcode.offer.day56;

/**
 * @author duson
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 * <p>
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 * <p>
 * 例如 :
 * 输入:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 * 注意:
 * <p>
 * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
 * 数组 A 的长度范围在[1, 50000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumSubarrayBoundedMax {

    public int numSubarrayBoundedMax(int[] a, int l, int r) {
        int start = -1, last = -1, res = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > r) {
                start = last = i;
                continue;
            }
            if (a[i] >= l) {
                last = i;
            }
            res += last - start;
        }
        return res;
    }
}
