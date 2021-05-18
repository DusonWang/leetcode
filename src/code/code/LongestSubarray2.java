package code.code;

import java.util.Arrays;

/**
 * 给你一个二进制数组?nums?，你需要从中删掉一个元素。
 * <p>
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * <p>
 * 如果不存在这样的子数组，请返回 0 。
 * <p>
 * ?
 * <p>
 * 提示 1：
 * <p>
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * 示例 4：
 * <p>
 * 输入：nums = [1,1,0,0,1,1,1,0,1]
 * 输出：4
 * 示例 5：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：0
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * nums[i]?要么是?0?要么是?1 。
 * 通过次数5,953提交次数10,647
 * 请问您在哪类招聘中遇到此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-subarray-of-1s-after-deleting-one-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubarray2 {

    public int longestSubarray(int[] nums) {
        int a = 0;
        int b = 0;
        int result = 0;
        for (int num : nums) {
            if (num == 0) {
                result = Math.max(result, a + b);
                a = b;
                b = 0;
            } else {
                b++;
            }
        }
        result = Math.max(result, a + b);
        return result == nums.length ? result - 1 : result;
    }

    public static void main(String[] args) {
        LongestSubarray2 longestSubarray2 = new LongestSubarray2();
        System.out.println(longestSubarray2.longestSubarray(new int[]{1, 1, 0, 1}));
    }
}
