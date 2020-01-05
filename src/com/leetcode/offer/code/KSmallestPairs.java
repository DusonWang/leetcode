package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author duson
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * <p>
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 * <p>
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 * <p>
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KSmallestPairs {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> (nums1[o[0]] + nums2[o[1]])));
        List<List<Integer>> result = new ArrayList<>();
        if (n1 == 0 || n2 == 0 || k == 0) {
            return result;
        }
        for (int i = 0; i < n1; i++) {
            pq.offer(new int[]{i, 0});
        }
        while (pq.size() > 0 && k > 0) {
            int[] pair = pq.poll();
            if (pair[1] + 1 < n2) {
                pq.offer(new int[]{pair[0], pair[1] + 1});
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[pair[0]]);
            temp.add(nums2[pair[1]]);
            result.add(temp);
            k--;
        }
        return result;
    }
}
