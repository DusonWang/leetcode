package com.leetcode.offer.code;

import java.util.List;

/**
 * @author duson
 * <p>
 * 给定 m 个数组，每个数组都已经按照升序排好序了。现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。你的任务就是去找到最大距离
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [[1,2,3],
 * [4,5],
 * [1,2,3]]
 * 输出： 4
 * 解释：
 * 一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
 *  
 * <p>
 * 注意：
 * <p>
 * 每个给定数组至少会有 1 个数字。列表中至少有两个非空数组。
 * 所有 m 个数组中的数字总数目在范围 [2, 10000] 内。
 * m 个数组中所有整数的范围在 [-10000, 10000] 内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-distance-in-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDistance2 {

    public int maxDistance(List<List<Integer>> list) {
        int res = 0, minVal = list.get(0).get(0), maxVal = list.get(0).get(list.get(0).size() - 1);
        for (int i = 1; i < list.size(); i++) {
            res = Math.max(res, Math.max(Math.abs(list.get(i).get(list.get(i).size() - 1) - minVal), Math.abs(maxVal - list.get(i).get(0))));
            minVal = Math.min(minVal, list.get(i).get(0));
            maxVal = Math.max(maxVal, list.get(i).get(list.get(i).size() - 1));
        }
        return res;
    }
}
