package code.code;

/**
 * @author duson
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThirdMax {

    public int thirdMax(int[] nums) {
        int a = nums[0];
        long b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (int num : nums) {
            if (num == a || num == b || num == c) {
                continue;
            }
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (num > b) {
                c = b;
                b = num;
            } else if (num > c) {
                c = num;
            }
        }
        if (c == Long.MIN_VALUE) {
            return a;
        }
        return (int) c;
    }
}
