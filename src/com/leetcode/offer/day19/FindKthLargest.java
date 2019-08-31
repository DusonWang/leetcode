package com.leetcode.offer.day19;

import java.util.PriorityQueue;

/**
 * @author duson
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
//      PriorityQueue<Integer> pq = new PriorityQueue();
//        for(int i : nums){
//            pq.add(i);
//
//            if(pq.size() > k){
//                pq.poll();
//            }
//        }
//        return pq.peek();

        return findK(nums, k - 1, 0, nums.length - 1);

    }

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

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 3));
    }
}
