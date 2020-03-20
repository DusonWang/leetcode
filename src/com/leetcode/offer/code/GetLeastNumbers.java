package com.leetcode.offer.code;

import java.util.Arrays;

/**
 * @author duson
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * 通过次数19,470提交次数31,726
 * 在真实的面试中遇到过这道题？
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] kk = new int[k];
        System.arraycopy(arr, 0, kk, 0, k);
        return kk;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        quickSelect(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    private void quickSelect(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = nums[(left + right) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if (right >= k) {
            quickSelect(nums, start, right, k);
        } else {
            quickSelect(nums, left, end, k);
        }
    }
}
