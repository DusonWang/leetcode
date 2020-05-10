package com.leetcode.offer.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * ?
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 * ?
 * <p>
 * 通过次数31,272提交次数45,744
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int i = 1;
        while (target > 0) {
            target -= i++;
            if (target > 0 && target % i == 0) {
                int[] arr = new int[i];
                for (int j = target / i, k = 0; j < target / i + i; j++, k++) {
                    arr[k] = j;
                }
                list.add(arr);
            }
        }
        Collections.reverse(list);
        int[][] res = new int[0][];
        return list.toArray(res);
    }
}
