package com.leetcode.offer.day49;

import java.util.HashMap;
import java.util.Map;

/**
 * @author duson
 * <p>
 * 给你一个整数数组 arr 和一个整数 difference，请你找出 arr 中所有相邻元素之间的差等于给定 difference 的等差子序列，并返回其中最长的等差子序列的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4], difference = 1
 * 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,5,7], difference = 1
 * 输出：1
 * 解释：最长的等差子序列是任意单个元素。
 * 示例 3：
 * <p>
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
 * 输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i], difference <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubsequence {

    public int longestSubsequence(int[] arr, int difference) {
        final int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            map.put(value, map.getOrDefault(value - difference, 0) + 1);
            max = Math.max(max, map.get(value));
        }
        return max;
    }
}
