package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组nums，数组中只包含非负整数。定义rev(x)的值为将整数x各个数字位反转得到的结果。比方说rev(123) = 321，rev(120) = 21。我们称满足下面条件的下标对(i, j) 是好的：
 * <p>
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对109 + 7取余后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [42,11,1,97]
 * 输出：2
 * 解释：两个坐标对为：
 * - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 * - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 * 示例 2：
 * <p>
 * 输入：nums = [13,10,35,24,76]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 通过次数3,077提交次数9,176
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-nice-pairs-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountNicePairs {

    public int rev(int num) {
        int res = 0;
        while (num > 0) {
            int mod = num % 10;
            num /= 10;
            res = res * 10 + mod;
        }
        return res;
    }

    public int countNicePairs(int[] nums) {
        int mod = (int) 1e9 + 7;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            int key = num - rev(num);
            count.put(key, count.getOrDefault(key, 0) + 1);
        }
        long result = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            long times = entry.getValue();
            result = (result + times * (times - 1) / 2) % mod;
        }
        return (int) (result % mod);
    }

    public static void main(String[] args) {
        CountNicePairs countNicePairs = new CountNicePairs();
        System.out.println(countNicePairs.countNicePairs(new int[]{42, 11, 1, 97}));
        System.out.println(countNicePairs.countNicePairs(new int[]{13, 10, 35, 24, 76}));

    }
}
