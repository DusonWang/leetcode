package com.leetcode.offer.code;

/**
 * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。
 * <p>
 * 如果数组中不存在满足题意的整数，则返回 0 。
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [21,4,7]
 * 输出：32
 * 解释：
 * 21 有 4 个因数：1, 3, 7, 21
 * 4 有 3 个因数：1, 2, 4
 * 7 有 2 个因数：1, 7
 * 答案仅为 21 的所有因数的和。
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^5
 * 通过次数4,171提交次数12,850
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/four-divisors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumFourDivisors {

    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int count = 0;
            int temp = 0;
            for (int k = 1; k * k <= num; k++) {
                if (num % k == 0) {
                    temp += k;
                    count++;
                    if (k * k != num) {
                        temp += num / k;
                        count++;
                    }
                    if (count > 4) {
                        break;
                    }
                }
            }
            if (count == 4) {
                res += temp;
            }

        }
        return res;
    }
}
