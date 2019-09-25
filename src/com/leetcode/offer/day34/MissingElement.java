package com.leetcode.offer.day34;

/**
 * @author duson
 * 给出一个有序数组 A，数组中的每个数字都是 独一无二的，找出从数组最左边开始的第 K 个缺失数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [4,7,9,10], K = 1
 * 输出：5
 * 解释：
 * 第一个缺失数字为 5 。
 * 示例 2：
 * <p>
 * 输入：A = [4,7,9,10], K = 3
 * 输出：8
 * 解释：
 * 缺失数字有 [5,6,8,...]，因此第三个缺失数字为 8 。
 * 示例 3：
 * <p>
 * 输入：A = [1,2,4], K = 3
 * 输出：6
 * 解释：
 * 缺失数字有 [3,5,6,7,...]，因此第三个缺失数字为 6 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 50000
 * 1 <= A[i] <= 1e7
 * 1 <= K <= 1e8
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MissingElement {

    public int missingElement(int[] nums, int k) {
        int left = nums[0], right = nums[nums.length - 1] + k, min = nums[0];
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                } else {
                    break;
                }
            }
            int noMissingCount = mid - min + 1;
            if (noMissingCount - count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MissingElement missingElement = new MissingElement();
        System.out.println(missingElement.missingElement(new int[]{1, 2, 4}, 3));
    }
}
