package com.leetcode.offer.day21;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * <p>
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * <p>
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WiggleSort {

    public int findK(int[] nums, int k, int start, int end) {
        int low = start;
        int high = end;
        int pivot = nums[(low + high) / 2];
        while (low <= high) {
            while (nums[high] < pivot) {
                high--;
            }

            while (nums[low] > pivot) {
                low++;
            }

            if (low <= high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }

        }

        if (start < high && k <= high) {
            return findK(nums, k, start, high);
        }
        if (low < end && k >= low) {
            return findK(nums, k, low, end);
        }
        return nums[k];
    }

    public int findKthLargest(int[] nums, int k) {
        return findK(nums, k - 1, 0, nums.length - 1);
    }

    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    public void wiggleSort2(int[] nums) {
        final int len = nums.length;
        final int[] copy = Arrays.copyOf(nums, len);
        Arrays.sort(copy);
        int mid = len / 2;
        if ((len & 1) == 0) {
            mid--;
        }
        for (int i = len - 1; i > mid; i--) {
            nums[2 * (len - i - 1) + 1] = copy[i];
        }
        for (int i = mid; i >= 0; i--) {
            nums[2 * (mid - i)] = copy[i];
        }
    }

    public static void main(String[] args) {
        WiggleSort wiggleSort = new WiggleSort();
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        wiggleSort.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
