package code.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组?nums?。数组中唯一元素是那些只出现?恰好一次?的元素。
 * <p>
 * 请你返回 nums?中唯一元素的 和?。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,2]
 * 输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：没有唯一元素，和为 0 。
 * 示例 3 ：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：15
 * 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 通过次数6,322提交次数8,259
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-unique-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumOfUnique {

    public int sumOfUnique(int[] nums) {
        int[] tag = new int[101];
        int sum = 0;
        for (int num : nums) {
            tag[num]++;
        }
        for (int i = 1; i < 101; i++) {
            if (tag[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}
