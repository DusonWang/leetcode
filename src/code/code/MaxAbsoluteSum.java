package code.code;

/**
 * 给你一个整数数组nums。一个子数组[numsl, numsl+1, ..., numsr-1, numsr]的 和的绝对值为abs(numsl + numsl+1 + ... + numsr-1 + numsr)。
 * <p>
 * 请你找出 nums中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值。
 * <p>
 * abs(x)定义如下：
 * <p>
 * 如果x是负整数，那么abs(x) = -x。
 * 如果x是非负整数，那么abs(x) = x。
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-3,2,3,-4]
 * 输出：5
 * 解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,-5,1,-4,3,-2]
 * 输出：8
 * 解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 通过次数2,959提交次数5,587
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-absolute-sum-of-any-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAbsoluteSum {

    public int maxAbsoluteSum(int[] nums) {
        int s = 0;
        int min = 0;
        int max = 0;
        for (int a : nums) {
            s += a;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        return max - min;
    }

    public static void main(String[] args) {
        MaxAbsoluteSum maxAbsoluteSum = new MaxAbsoluteSum();
        System.out.println(maxAbsoluteSum.maxAbsoluteSum(new int[]{1, -3, 2, 3, -4}));
    }
}
