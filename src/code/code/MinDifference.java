package code.code;

import java.util.Arrays;

/**
 * 给你一个数组?nums?，每次操作你可以选择?nums?中的任意一个元素并将它改成任意值。
 * <p>
 * 请你返回三次操作后， nums?中最大值与最小值的差的最小值。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,3,2,4]
 * 输出：0
 * 解释：将数组 [5,3,2,4] 变成 [2,2,2,2].
 * 最大值与最小值的差为 2-2 = 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,5,0,10,14]
 * 输出：1
 * 解释：将数组 [1,5,0,10,14] 变成 [1,1,0,1,1] 。
 * 最大值与最小值的差为 1-0 = 1 。
 * 示例 3：
 * <p>
 * 输入：nums = [6,6,0,1,1,4,6]
 * 输出：2
 * 示例 4：
 * <p>
 * 输入：nums = [1,5,6,14,15]
 * 输出：1
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 通过次数4,270提交次数7,881
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDifference {

    public int minDifference(int[] a) {
        int n = a.length;
        int res = Integer.MAX_VALUE;
        if (n < 5) {
            return 0;
        }
        Arrays.sort(a);
        for (int i = 0; i < 4; ++i) {
            res = Math.min(res, a[n - 4 + i] - a[i]);
        }
        return res;
    }
}
