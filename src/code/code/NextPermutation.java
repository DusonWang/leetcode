package code.code;

import java.util.Arrays;

/**
 * @author duson
 * <p>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        final int len = nums.length;
        int i = len - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);

        }
        reverse(nums, i + 1, len - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();

        int[] nums1 = new int[]{1, 3, 2, 0};
        nextPermutation.nextPermutation(nums1);
        System.out.println("case1 " + Arrays.toString(nums1));

        int[] nums2 = new int[]{3, 2, 1};
        nextPermutation.nextPermutation(nums2);
        System.out.println("case2 " + Arrays.toString(nums2));

        int[] nums3 = new int[]{1, 1, 5};
        nextPermutation.nextPermutation(nums1);
        System.out.println("case3 " + Arrays.toString(nums3));


    }
}
