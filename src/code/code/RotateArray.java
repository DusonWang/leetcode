package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        final int len = nums.length;
        for (int m = 0; m < k; m++) {
            int tmp = nums[len - 1];
            for (int i = 0; i < len; i++) {
                int temp = nums[i];
                nums[i] = tmp;
                tmp = temp;
            }
        }
    }

    public void rotate2(int[] nums, int k) {
        final int len = nums.length;
        k %= len;
        int[] temp = new int[k];
        System.arraycopy(nums, len - k, temp, 0, temp.length);
        System.arraycopy(nums, 0, nums, k, len - k);
        System.arraycopy(temp, 0, nums, 0, k);
    }

    private void solution2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        final int len = nums.length;
        k %= len;
        reverseArray(nums, 0, len - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, len - 1);
    }

    private void reverseArray(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        r.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

}
