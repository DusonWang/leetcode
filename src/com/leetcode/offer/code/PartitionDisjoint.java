package com.leetcode.offer.code;

/**
 * @author duson
 * 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
 * <p>
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 要尽可能小。
 * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * 示例 2：
 * <p>
 * 输入：[1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 30000
 * 0 <= A[i] <= 10^6
 * 可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionDisjoint {

    public int partitionDisjoint(int[] a) {
        int n = a.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];

        int m = a[0];
        for (int i = 0; i < n; ++i) {
            m = Math.max(m, a[i]);
            maxLeft[i] = m;
        }

        m = a[n - 1];
        for (int i = n - 1; i >= 0; --i) {
            m = Math.min(m, a[i]);
            minRight[i] = m;
        }

        for (int i = 1; i < n; ++i) {
            if (maxLeft[i - 1] <= minRight[i]) {
                return i;
            }
        }
        return -1;
    }
}
