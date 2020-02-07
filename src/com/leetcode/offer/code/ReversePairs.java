package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * <p>
 * 你需要返回给定数组中的重要翻转对的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 * <p>
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePairs {

    private int cnt;

    public int reversePairs(int[] nums) {
        int len = nums.length;
        sort(nums, Arrays.copyOf(nums, len), 0, len - 1);
        return cnt;
    }

    private void sort(int[] src, int[] dest, int s, int e) {
        if (s >= e) {
            return;
        }
        int mid = (s + e) >> 1;
        sort(dest, src, s, mid);
        sort(dest, src, mid + 1, e);
        merge(src, dest, s, mid, e);
    }

    private void merge(int[] src, int[] dest, int s, int mid, int e) {
        int i = s, j = mid + 1, k = s;
        while (i <= mid && j <= e) {
            if ((long) src[i] > 2 * ((long) src[j])) {
                cnt += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        i = s;
        j = mid + 1;
        while (i <= mid && j <= e) {
            if (src[i] <= src[j]) {
                dest[k++] = src[i++];
            } else {
                dest[k++] = src[j++];
            }
        }
        while (i <= mid) {
            dest[k++] = src[i++];
        }
        while (j <= e) {
            dest[k++] = src[j++];
        }
    }
}
