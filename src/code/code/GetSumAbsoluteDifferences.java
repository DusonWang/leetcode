package code.code;

import java.util.Arrays;

/**
 * 给你一个 非递减?有序整数数组?nums?。
 * <p>
 * 请你建立并返回一个整数数组?result，它跟?nums?长度相同，且result[i]?等于?nums[i]?与数组中所有其他元素差的绝对值之和。
 * <p>
 * 换句话说，?result[i]?等于?sum(|nums[i]-nums[j]|) ，其中?0 <= j < nums.length 且?j != i?（下标从 0 开始）。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,5]
 * 输出：[4,3,5]
 * 解释：假设数组下标从 0 开始，那么
 * result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4，
 * result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3，
 * result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,6,8,10]
 * 输出：[24,15,13,15,21]
 * ?
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= nums[i + 1] <= 104
 * 通过次数2,841提交次数4,910
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-absolute-differences-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetSumAbsoluteDifferences {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int pNum = nums[0];
        nums[0] = sum - nums[0] * nums.length;
        for (int i = 1; i < nums.length; i++) {
            int curNum = nums[i];
            nums[i] = nums[i - 1] - (curNum - pNum) * (nums.length - i - i);
            pNum = curNum;
        }
        return nums;
    }

    public static void main(String[] args) {
        GetSumAbsoluteDifferences getSumAbsoluteDifferences = new GetSumAbsoluteDifferences();
        System.out.println(Arrays.toString(getSumAbsoluteDifferences.getSumAbsoluteDifferences(new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(getSumAbsoluteDifferences.getSumAbsoluteDifferences(new int[]{1, 4, 6, 8, 10})));
    }
}
