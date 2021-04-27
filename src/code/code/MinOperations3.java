package code.code;

/**
 * 给你一个与 nums?大小相同且初始值全为 0 的数组 arr ，请你调用以上函数得到整数数组 nums?。
 * <p>
 * 请你返回将 arr?变成 nums?的最少函数调用次数。
 * <p>
 * 答案保证在 32 位有符号整数以内。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5]
 * 输出：5
 * 解释：给第二个数加 1 ：[0, 0] 变成 [0, 1] （1 次操作）。
 * 将所有数字乘以 2 ：[0, 1] -> [0, 2] -> [0, 4] （2 次操作）。
 * 给两个数字都加 1 ：[0, 4] -> [1, 4] -> [1, 5] （2 次操作）。
 * 总操作次数为：1 + 2 + 2 = 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2]
 * 输出：3
 * 解释：给两个数字都加 1 ：[0, 0] -> [0, 1] -> [1, 1] （2 次操作）。
 * 将所有数字乘以 2 ： [1, 1] -> [2, 2] （1 次操作）。
 * 总操作次数为： 2 + 1 = 3 。
 * 示例 3：
 * <p>
 * 输入：nums = [4,2,5]
 * 输出：6
 * 解释：（初始）[0,0,0] -> [1,0,0] -> [1,0,1] -> [2,0,2] -> [2,1,2] -> [4,2,4] -> [4,2,5] （nums 数组）。
 * 示例 4：
 * <p>
 * 输入：nums = [3,2,2,4]
 * 输出：7
 * 示例 5：
 * <p>
 * 输入：nums = [2,4,8,16]
 * 输出：8
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 通过次数3,928提交次数6,361
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-numbers-of-function-calls-to-make-target-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinOperations3 {

    public int minOperations(int[] nums) {
        int ret = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            while (num != 0) {
                if ((num & 1) != 0) {
                    ret++;
                }
                num >>= 1;
            }
        }
        if (max != 0) {
            while (max != 0) {
                ret++;
                max >>= 1;
            }
            ret--;
        }
        return ret;
    }

    public int minOperations2(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            count += Integer.bitCount(num);
        }
        count += Integer.toBinaryString(max).length() - 1;
        return count;
    }
}
