package com.leetcode.offer.code;

/**
 * @author duson
 * 给你一个整数 n?。请你先求出从 1?到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
 * <p>
 * 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * 输出：4
 * 解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
 * [1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：总共有 2 个大小为 1 的组 [1]，[2]。
 * 示例 3：
 * <p>
 * 输入：n = 15
 * 输出：6
 * 示例 4：
 * <p>
 * 输入：n = 24
 * 输出：5
 * ?
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^4
 * 通过次数2,880提交次数4,520
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-largest-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountLargestGroup {

    public int countLargestGroup(int n) {
        int[] arr = new int[37];
        int maxSize = 0;
        for (int i = 1; i <= n; i++) {
            int curr = digitSum(i);
            arr[curr]++;
            maxSize = Math.max(maxSize, arr[curr]);
        }
        int res = 0;
        for (int value : arr) {
            if (value == maxSize) {
                res++;
            }
        }
        return res;
    }

    private int digitSum(int n) {
        int res = 0;
        while (n > 0) {
            res += (n % 10);
            n /= 10;
        }
        return res;
    }
}
