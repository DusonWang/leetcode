package com.leetcode.offer.day35;

/**
 * @author duson
 * 给定已经按升序排列、由不同整数组成的数组 A，返回满足 A[i] == i 的最小索引 i。如果不存在这样的 i，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-10,-5,0,3,7]
 * 输出：3
 * 解释：
 * 对于给定的数组，A[0] = -10，A[1] = -5，A[2] = 0，A[3] = 3，因此输出为 3 。
 * 示例 2：
 * <p>
 * 输入：[0,2,5,8,17]
 * 输出：0
 * 示例：
 * A[0] = 0，因此输出为 0 。
 * 示例 3：
 * <p>
 * 输入：[-10,-5,3,4,7,9]
 * 输出：-1
 * 解释：
 * 不存在这样的 i 满足 A[i] = i，因此输出为 -1 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length < 10^4
 * -10^9 <= A[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fixed-point
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FixedPoint {

    public int fixedPoint(int[] a) {
        int i = 0;
        int j = a.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (a[mid] >= mid) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return a[i] == i ? i : -1;
    }
}
