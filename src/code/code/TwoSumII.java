package code.code;

import java.util.Arrays;

/**
 * @author duson
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            int s = numbers[i] + numbers[j];
            if (s == target) {
                return new int[]{i + 1, j + 1};
            } else if (s > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        //[2,3,4]
        //6
        TwoSumII twoSumII = new TwoSumII();
        int[] nums = new int[]{2, 3, 4};
        System.out.println(Arrays.toString(twoSumII.twoSum(nums, 6)));
    }
}
