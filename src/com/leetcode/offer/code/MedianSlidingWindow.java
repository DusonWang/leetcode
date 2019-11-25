package com.leetcode.offer.code;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author duson
 * <p>
 * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * <p>
 * 例如：
 * <p>
 * [2,3,4]，中位数是 3
 * <p>
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 给出一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * <p>
 * 例如：
 * <p>
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 * <p>
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7       -1
 * 1  3 [-1  -3  5] 3  6  7       -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 * <p>
 * 提示：
 * 假设k是合法的，即：k 始终小于输入的非空数组的元素个数.
 * <p>
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-median
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianSlidingWindow {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int j = 0;
        PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> hi = new PriorityQueue<>();
        for (int num : nums) {
            lo.add(num);
            hi.add(lo.poll());
            if (hi.size() > lo.size()) {
                lo.add(hi.poll());
            }
            if (lo.size() + hi.size() == k) {
                result[j++] = lo.size() == hi.size() ? (double) ((long) lo.peek() + (long) hi.peek()) / 2 : (double) lo.peek();
                if (!lo.remove(nums[j])) {
                    hi.remove(nums[j]);
                }
            }
        }
        return result;
    }

}
